package com.taikang.jkx.tools;

import org.springframework.util.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

public class PinYinTools {

	//
	private final static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

	static {
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
	}

	public static void main(String[] args) {
		String str = "ω-3鱼油脂肪乳(C14-24)";
		String str2Pinyin = strFirst2Pinyin(str);
		System.out.println(str2Pinyin);
	}

	// 输入拼音进行判断其中文
	public static String str2Pinyin(String str, String fill) {
		try {
			StringBuffer sb = new StringBuffer();
			// 判断是中文
			boolean isCn = true;
			if (fill == null) {
				fill = " ";
			}
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == ' ') {
					sb.append(",");
				}
				// 1.判断是不是中文
//				if (i > 0 && isCn) {
//					sb.append(fill);
//				}
				if (c >= '\u4e00' && c <= '\u9fa5') {
					isCn = true;
					String string = PinyinHelper.toHanyuPinyinStringArray(c, format)[0];
					if (!StringUtils.isEmpty(string)) {
						// 如果是中文,取首字母
//						sb.append(string.charAt(0));
						//取全拼
						sb.append(string);
					}
					// sb.append(PinyinHelper.toHanyuPinyinStringArray(c,
					// format)[0]);
				} else {
					// 不是中文
					if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
						sb.append(c);
					isCn = false;
				}
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String strFirst2Pinyin(String str) {
		try {
			StringBuffer sb = new StringBuffer();
			// 判断是中文
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				// 1.判断是不是中文
				if (c >= '\u4e00' && c <= '\u9fa5') {
					sb.append(PinyinHelper.toHanyuPinyinStringArray(c, format)[0].charAt(0));
				} else {
					// 不是中文
					if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
						sb.append(c);
				}
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

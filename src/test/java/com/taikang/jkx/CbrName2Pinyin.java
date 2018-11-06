package com.taikang.jkx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.taikang.jkx.tools.PinYinTools;

public class CbrName2Pinyin {

	@Test
	public void fun1() throws IOException {

		FileReader reader = new FileReader(new File("E:\\work\\source.txt"));
		BufferedReader bfr = new BufferedReader(reader);
		FileWriter writer = new FileWriter(new File("E:\\work\\dest.txt"));
		BufferedWriter bfw = new BufferedWriter(writer);
		String str = null;
		while ((str = bfr.readLine()) != null) {
			String str2Pinyin = PinYinTools.str2Pinyin(str, null);
			bfw.write(str + "," + str2Pinyin);
			bfw.newLine();
		}
		bfw.close();
		bfr.close();

	}

	@Test
	public void fun2() throws IOException {
		
		FileReader reader = new FileReader(new File("E:\\study\\技术\\vba\\2017级全.txt"));
		BufferedReader bfr = new BufferedReader(reader);
//		FileReader reader_ryfl = new FileReader(new File("E:\\study\\技术\\vba\\2018-benyuan.txt"));
//		FileReader reader_ryfl = new FileReader(new File("E:\\study\\技术\\vba\\2018-waiyuan.txt"));
//		FileReader reader_ryfl = new FileReader(new File("E:\\study\\技术\\vba\\2018-dingxiangsheng.txt"));
//		FileReader reader_ryfl = new FileReader(new File("E:\\study\\技术\\vba\\2018-shehuiren.txt"));
		FileReader reader_ryfl = new FileReader(new File("E:\\study\\技术\\vba\\非研究生名单.txt"));
		BufferedReader bfr_ryfl = new BufferedReader(reader_ryfl);
		String readLine = bfr_ryfl.readLine();
		String[] names = readLine.split(",");
		FileWriter writer = new FileWriter(new File("E:\\study\\技术\\vba\\dest-2017-yanjiusheng.txt"));
		BufferedWriter bfw = new BufferedWriter(writer);
		String str = null;
		List<String> name_match = new ArrayList<String>();
		for (String string : names) {
			name_match.add(string);
		}
		

		
		while ((str = bfr.readLine()) != null) {

			String[] split = str.split("0");
			if (split != null && split.length != 0) {
				for (String string : split) {
					String replace = string.replace("+", "");
					String[] split2 = replace.split("-");
					System.out.println(replace);
					System.out.println(split2.length);
					if (split2 != null && split2.length != 0) {
						
						for (String string2 : split2) {
							System.out.print(string2);
							if(name_match.indexOf(string2)<0){
								bfw.write(string2+"-");
							}
						}
					}
					bfw.write("0");
				}
			}

			bfw.newLine();
		}
		bfw.close();
		bfr.close();
		bfr_ryfl.close();
	}

	@Test
	public void fun3() {
		String str = "+0+0+0";
		String[] split = str.split("0");
		System.out.println(split.length);
	}

	@Test
	public void fun4() throws IOException{
		
		
		
		FileReader reader_ryfl = new FileReader(new File("E:\\study\\技术\\vba\\非研究生名单.txt"));
		BufferedReader bfr_ryfl = new BufferedReader(reader_ryfl);
		String readLine = null;
		int m = 0;
		while((readLine = bfr_ryfl.readLine())!=null){
			String[] names = readLine.split(",");
			String str = null;
			List<String> name_match = new ArrayList<String>();
			for (String string : names) {
				name_match.add(string);
				System.out.print(string);
			}
			System.out.println();
			FileWriter writer = new FileWriter(new File("E:\\study\\技术\\vba\\dest-2017-"+m+".txt"));
			BufferedWriter bfw = new BufferedWriter(writer);
			
			FileReader reader = new FileReader(new File("E:\\study\\技术\\vba\\2017级全.txt"));
			BufferedReader bfr = new BufferedReader(reader);
			while ((str = bfr.readLine()) != null) {
				
				String[] split = str.split("0");
				if (split != null && split.length != 0) {
					for (String string : split) {
						String replace = string.replace("+", "");
						String[] split2 = replace.split("-");
						if (split2 != null && split2.length != 0) {
							for (String string2 : split2) {
								if(name_match.indexOf(string2)>=0){
									bfw.write(string2+"-");
								}
							}
						}
						bfw.write("0");
					}
				}
				
				bfw.newLine();
			}
			bfw.close();
			bfr.close();
			m++;
		}
		
		bfr_ryfl.close();
	}
}

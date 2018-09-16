package com.taikang.jkx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import com.taikang.jkx.tools.PinYinTools;

public class CbrName2Pinyin {
	
	@Test
	public void fun1() throws IOException{
		
		FileReader reader = new FileReader(new File("E:\\work\\source.txt"));
		BufferedReader bfr = new BufferedReader(reader);
		FileWriter writer = new FileWriter(new File("E:\\work\\dest.txt"));
		BufferedWriter bfw = new BufferedWriter(writer);
		String str = null;
		while((str = bfr.readLine())!=null){
			String str2Pinyin = PinYinTools.str2Pinyin(str, null);
			bfw.write(str+","+str2Pinyin);
			bfw.newLine();
		}
		bfw.close();
		bfr.close();
		
	}

}

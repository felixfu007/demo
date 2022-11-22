package com.felix.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.felix.vo.ExcelVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InvokeTestService {
	public void runInvoke() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ExcelVo excelVo = new ExcelVo();
		excelVo.setFileName("File1");
		excelVo.setFileSize(1024);
		excelVo.setColume1("第一欄");
		excelVo.setColume2("第二欄");
		excelVo.setColume3("第三欄");
		excelVo.setColume4("第四欄");
		excelVo.setColume5("第五欄");
		excelVo.setColume6("第六欄");
		excelVo.setColume7("第七欄");
		excelVo.setColume8("第八欄");
		excelVo.setColume9("第九欄");
		excelVo.setColume10("第十欄");
		
		Class<?> voClazz = Class.forName("com.felix.vo.ExcelVo");
		System.out.println("檔名 : "+excelVo.getFileName());
		System.out.println("檔案大小 : "+excelVo.getFileSize()+"byte");
		StringBuilder csvString = new StringBuilder();
		for(int i=1;i<=10;i++) {
			Method bMethod = voClazz.getDeclaredMethod("getColume"+i);
			String currentColume = (String) bMethod.invoke(excelVo);
			System.out.println("第"+i+"欄 : "+currentColume);
			csvString.append(currentColume);
			csvString.append(",");
		}
		csvString.deleteCharAt(csvString.lastIndexOf(","));
		System.out.println("csv輸出 : "+csvString);
		
	}
}

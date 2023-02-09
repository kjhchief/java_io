package ezen.io.character;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 바이트스트림으로 문자(텍스트) 파일 읽기
 * @Author 김재훈
 * @Date 2023. 1. 30.
 */
public class CharacterInputExample {

	public static void main(String[] args) throws IOException {
		String fileName ="./src/ezen/io/BufferedInputStreamExample.java";
		File file = new File(fileName);
		if(!file.exists()) {
			System.out.println("읽고자 하는 파일이 없습니다.");
			return;
		}
		InputStream is = new FileInputStream(file);
		// 브릿지. 바이트와 문자의 중간에서 다리 역할. 인코딩 문자셋 설정 안 하면 OS디폴트 문자셋 사용
		Reader reader = new InputStreamReader(is, "utf-8");
//		int data = reader.read();
//		System.out.println((char)data);
		/*
		int data=0;
		while ((data = reader.read()) != -1) {
			System.out.print((char)data);
		}
		*/
		
		char[] buffer = new char[1024];
		int count = 0;
		while ((count = reader.read(buffer)) != -1) {
			// 문자 디코딩
			String txt = new String(buffer, 0, count);
			System.out.println(txt);
		}
		
		reader.close();
		
		String message = "오늘은 피곤한 월요일 입니다. 퉷퀙걃";
		char c = '뱜'; 
		char[] chars = {'김','재','훈'};
		
		String saveFile = "diary.txt";
		OutputStream os = new FileOutputStream(saveFile); // File() 권장
		Writer writer = new OutputStreamWriter(os, "utf-8");
		writer.write(message);
		writer.write(c);
		writer.write(chars);
		writer.close();
		
		char[] cc= {'x', 'y', 'z'};
		
		// 내가 작성중인 코드 영역
		String title = "오늘 수업 끝~~~";
		// 문자 인코딩
		byte[] bytes = title.getBytes();
		someTask(bytes);
		
	}
	
	// 다른 개발자 코드
	public static void someTask(byte[] chars) {
		System.out.println("어떤 기능 수행");
	}
	

}

package ezen.io.character;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Calendar;

/**
 * 바이트스트림으로 문자(텍스트) 파일 읽기
 * @Author 김재훈
 * @Date 2023. 1. 30.
 */
public class CharacterInputExample2 {

	public static void main(String[] args) throws IOException {
		String fileName ="./src/ezen/io/BufferedInputStreamExample.java";
		File file = new File(fileName);
		if(!file.exists()) {
			System.out.println("읽고자 하는 파일이 없습니다.");
			return;
		}
		Reader reader = new FileReader(file); // 바로 파일 객체를 받거나 직접 경로 써줄 수 있음. 브릿지가 굳이 필요 없다.
		char[] buffer = new char[1024];
		int count = 0;
		while ((count = reader.read(buffer)) != -1) {
			// 문자 디코딩
			String txt = new String(buffer, 0, count);
			System.out.println(txt);
		}
		
		reader.close();
		
		String message = "오늘은 즐거운 화요일 입니다. 퉷퀙걃";
		char c = '뱜'; 
		char[] chars = {'김','재','훈'};
		Calendar today = Calendar.getInstance();
		String ymd = String.format("%1$tF", today);
		
		String saveFile = "diary_"+ymd+".txt";
		File f = new File(saveFile);
		Writer writer = null;
		if(f.exists()) {
			writer = new FileWriter(saveFile, true);
		}else {
			writer = new FileWriter(saveFile);
		}
		
		
		writer.write(message);
		writer.write(c);
		writer.write(chars);
		writer.close();
		
	}
		

}

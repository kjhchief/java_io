package ezen.io.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class CharacterInputExample3 {

	public static void main(String[] args) throws IOException {
		String fileName ="./src/ezen/io/BufferedInputStreamExample.java";
		File file = new File(fileName);
		if(!file.exists()) {
			System.out.println("읽고자 하는 파일이 없습니다.");
			return;
		}
		
		BufferedReader reader= new BufferedReader(new FileReader(file));
		// String txt = reader.readLine();
		// System.out.println(txt);
		String txt = null;
		// readLine()은 파일의 끝을 만나면 null을 리턴한다.
		while ((txt = reader.readLine()) != null) {
			System.out.println(txt);
		}
		
		reader.close();
		
//		BufferedWriter out = new BufferedWriter(new FileWriter("some.txt"));
//		out.write("이것이 버퍼드 라이터다! ");
//		out.close();
				
	}
		

}

package ezen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

	public static void main(String[] args) throws IOException { // 어차피 연습용이니 throws해버려
		String fileName = "example1.dat"; 
		
		InputStream in = new FileInputStream(fileName);
		/*
		int data = in.read(); //읽을 때는 4바이트로 읽기에
		System.out.println(data);
		data = in.read();
		System.out.println(data);
		data = in.read();
		System.out.println(data);
		data = in.read();
		System.out.println(data); // -1은? 파일의 끝이라는 뜻
		data = in.read();
		System.out.println(data);
		*/
		
		byte[] buffer = new byte[3];
		int count = in.read(buffer); // 위에 코드를 이거 한방으로 뿅
		System.out.println(count);
		for (byte b : buffer) {
			System.out.println(b);
		}
		
		in.close();
		

	}

}

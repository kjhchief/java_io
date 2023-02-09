package ezen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample2 {

	public static void main(String[] args) throws IOException { // 어차피 연습용이니 throws해버려
		String fileName = "IO Programming.pdf"; 
		InputStream in = new FileInputStream(fileName);
		/*
		while (true) {
			int data = in.read();
			System.out.println(data);
			if (data == -1) {
				break;
			}
		}
		*/
		long begin = System.currentTimeMillis();
		int data = 0;
		while ((data= in.read()) != -1) {
//			System.out.println(data);
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간: "+(end-begin));
		System.out.println("파일 다 읽었음");
		in.close();
		

	}

}

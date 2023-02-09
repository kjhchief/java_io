package ezen.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExample {

	public static void main(String[] args) throws IOException {
		String fileName ="example2.dat";
		// Node Stream
		InputStream in = new FileInputStream(fileName); // 물 끌어오는 파이프
		// Filter Stream
		// 내부 버퍼 기본사이즈 (512byte)
//		BufferedInputStream bis = new BufferedInputStream(out); // 512짜리 임시저장 물탱크
		BufferedInputStream bis = new BufferedInputStream(in, 1024); // 1024짜리 임시저장 물탱크
		// 하드디스크에서 바로 읽어드리는 것이 아니라 메모리상의 버퍼(byte[])에 읽어들이는 것임.
		int data = bis.read();
		System.out.println(data);
		data = bis.read();
		System.out.println(data);
		data = bis.read();
		System.out.println(data);
		data = bis.read();
		System.out.println(data);
		
		byte[] buffer = new byte[500];
		int count = 0;
		while((count = bis.read(buffer)) != -1) {
			for (byte b : buffer) {
				System.out.println(b);
			}
		}
		bis.close();

	}

}

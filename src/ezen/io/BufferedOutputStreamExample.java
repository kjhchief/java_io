package ezen.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStreamExample {

	public static void main(String[] args) throws IOException {
		String fileName ="example2.dat";
		// Node Stream
		OutputStream out = new FileOutputStream(fileName); // 물 끌어오는 파이프
		// Filter Stream
		// 내부 버퍼 기본사이즈 (512byte)
//		BufferedOutputStream bos = new BufferedOutputStream(out); // 512짜리 임시저장 물탱크
		BufferedOutputStream bos = new BufferedOutputStream(out, 1024); // 1024짜리 임시저장 물탱크
		// 하드디스크에 출력이 아니라 메모리상의 버퍼(byte[])에 출력하는 것임.
		bos.write(10);
		bos.write(20);
		bos.write(30);
		bos.write(40);
		
		byte[] buffer = new byte[500];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte) i;
		}
		
		bos.write(buffer, 0 , buffer.length);
		
		// 버퍼에 있는 데이터를 디스크에 출력. 
		bos.flush();
		bos.close();
		System.out.println("파일 저장 완료");

	}

}

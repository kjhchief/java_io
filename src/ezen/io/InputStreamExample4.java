package ezen.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample4 {

	public static void main(String[] args) throws IOException { // 어차피 연습용이니 throws해버려
		String fileName = "example1.dat";
		File file = new File(fileName);
		if(!file.exists()) {
			System.out.println("읽고자 하는 파일이 존재하지 않습니다.");
			return;
		}
		
//		InputStream in = new FileInputStream(fileName);
		InputStream in = new FileInputStream(file);

		long begin = System.currentTimeMillis();

		byte[] buffer = new byte[(int) file.length()];
		int count= in.read(buffer);
		System.out.println("읽은 바이트 수: "+count);
		long end = System.currentTimeMillis();
		System.out.println("소요시간: "+(end-begin));
		System.out.println("파일 다 읽었음");
		in.close();
		
		// 루프 안 돌고 바로 읽으려면? 파일의 사이즈만 알면 되지 않을까?
	}

}

package ezen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample3 {

	public static void main(String[] args) throws IOException { // 어차피 연습용이니 throws해버려
		String fileName = "IO Programming.pdf"; 
		InputStream in = new FileInputStream(fileName);
		int readableSize= in.available(); // 파일 사이즈 보기
		System.out.println(readableSize);

		long begin = System.currentTimeMillis();

		byte[] buffer = new byte[4*1024];
		int count = 0;
		while ((count = in.read(buffer)) != -1) { //여기서 in.read는 계란의 수를 말함. 배열 칸의 수. 그래서 수니까 count 변수에 담음.
//			System.out.println(count); // 한 번에 4096씩 읽는다. 2에서는 아예 데이터 자체를 읽어온 것이고.
//			for (byte b : buffer) {
//				System.out.println(b);
//			}
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간: "+(end-begin));
		System.out.println("파일 다 읽었음");
		in.close();
		
		// 루프 안 돌고 바로 읽으려면? 파일의 사이즈만 알면 되지 않을까?
	}

}

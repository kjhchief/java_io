package ezen.io;

import java.io.File;
import java.io.IOException;

public class FileExample {

	public static void main(String[] args) throws IOException {
		String path = "c:/a/b/c/some.txt";
//		File someFile = new File(path);
//		File someFile = new File("c:/a/b/c", "some.txt");
		File someFile = new File(new File("c:/a/b/c"), "some.txt");
		// File이 제공하는 대표적인 정보 제공 메소드
		boolean exist= someFile.exists();
		System.out.println(exist);
		
		// 파일과 관련 조작 기능
		// 물리적 파일 생성
//		boolean created = someFile.createNewFile();
//		someFile.mkdir();
		File directory = new File("c:/ezen-academy/temp");
		boolean created = directory.mkdir();
		System.out.println(created);
		
		File file = new File(directory, "some.txt");
		created = file.createNewFile();
		System.out.println(created);
		System.out.println("파일 생성 완료..");
		
		
		
//		System.out.println(created);

	}

}

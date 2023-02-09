package ezen.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {

	public static void main(String[] args) throws IOException {
		String fileName = "C:/Users/i7A-56/Downloads/StarUML Setup 5.1.0.exe";
		Path srcPath = Paths.get(fileName); // 원본 위치
		Path targetPath = Paths.get("StarUML_copy.exe"); // 저장 위치
		
		Path copyPath = Files.copy(srcPath, targetPath); // 내부적으로 쓰레드로 동작함. 아주 친절함.
		System.out.println(copyPath +" 에 복사 완료.");
	}

}

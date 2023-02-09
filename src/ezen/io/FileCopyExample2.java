package ezen.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

/**
 * FileInputStream과 FileOutputStream을 이용한 파일 복사
 * 
 * @Author 김재훈
 * @Date 2023. 1. 27.
 */
public class FileCopyExample2 {

	public static void main(String[] args) {
		System.out.println("메인스레드 실행");

		// 파일 복사 기능을 쓰레드로 구현
		Thread thread = new Thread() {
			@Override
			public void run() {
				String originalFile = "IO Programming.pdf";
				String targetFile = "IO Programming_copy.pdf";

				InputStream in = null;
				OutputStream out = null;
				int fileSize = 0;
				try {
					File file = new File(originalFile);
					if(!file.exists()) {
						System.out.println("복사할 파일이 존재하지 않습니다.");
						return;
					}
					
					in = new FileInputStream(originalFile);
					out = new FileOutputStream(targetFile);
					fileSize = in.available();

					byte[] buffer = new byte[4 * 1024];
					int count = 0;
					while ((count = in.read(buffer)) != -1) { // count 없어도 똑같이 작동. 왜?-> 작동하는게 아니라 껍데기만 만들어지고 내용은 복사가 안
																// 됨. 내용은 count 만큼의 용량이 써지는거니까
						out.write(buffer, 0, count);
					}
					System.out.println((fileSize / 1024) + "KB 복사 완료~");

				} catch (IOException e) {
//					System.out.println("복사하고자 하는 파일이 존재하지 않습니다.");
					JOptionPane.showMessageDialog(null, "복사하고자 하는 파일이 존재하지 않습니다.");
				} finally {
					try {
						if (in != null)
							in.close();
						if (out != null)
							out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();

		System.out.println("메인스레드 종료");

	}

}

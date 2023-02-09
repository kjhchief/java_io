package ezen.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

	public static void main(String[] args) {
		String fileName = "example1.dat";
//		String fileName ="C:/ezen-academy/example1.dat";
		byte a = 10, b = 20, c = 30;
		byte[] array = {10, 20, 30, 40, 50};
		// 파일에 저장
		OutputStream out = null;
		try {
			// 바이트 출력을 위한 출력스트림 생성
//			out = new FileOutputStream(fileName); 새로운 데이터로 덮어버림.
			out = new FileOutputStream(fileName, true); // 기존파일에 추가.
//			out.write(a);
//			out.write(b);
//			out.write(c);
			// 배열단위로 효율적 출력
//			out.write(array);
			out.write(array, 1, 3); //배열, 시작 위치, 위치부터 몇 개 =>20,30,49 저장됨
			// 사용중인 리소스 해제
//			out.close(); //많은 리소스를 사용하기에 스트림 출력 끝나면 꼭 닫아주자. 문제는 예외처리 되어버리면 이거 넘어가서 catch로 넘어가서 문제임. 그래서 써야할 것은?
			System.out.println("파일 출력 완료다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //예외가 발생 하든 안하든 항상 사용되는 영역
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

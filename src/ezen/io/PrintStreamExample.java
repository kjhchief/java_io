package ezen.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 자바 기본데이터타입을 문자열로 변환하여 출력
 * 
 * @Author 김재훈
 * @Date 2023. 1. 30.
 */

public class PrintStreamExample {

	public static void main(String[] args) throws IOException {
		String fileName = "printExample.txt";
		// 기본 데이터 타입
		boolean flag = true;
		byte score = 99;
		int age = 30;
		double weight = 67.89;
		// 참조(객체) 타입
		String comment = "참 잘했어요"; // String은 객체
		Student student = new Student(10, "김재훈", 50);

		// 데이터를 문자열로 저장하기 위해 PrintStream 생성
		PrintStream out = new PrintStream(new FileOutputStream(fileName));
		out.print(flag);
		out.println(score);
		out.println(age);
		out.println(weight);
		out.println(comment);
		// | 학번 | 이름 | 점수
		out.printf("| %5d | %-10s | %5d |", student.getNo(), student.getName(), student.getScore());
		out.close();
		System.out.println("출력 완료");
		
		// System.out은 미리 생성되어 있는 PrintStream 객체이다.
		// 표준 입출력
		System.out.println(System.in);
		System.out.println(System.out);
//		System.out.print("");
//		System.out.println("");
//		System.out.printf("");
	}

}

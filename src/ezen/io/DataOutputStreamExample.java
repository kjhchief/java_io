package ezen.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 자바 기본데이터타입별로 출력
 * 
 * @Author 김재훈
 * @Date 2023. 1. 27.
 */

class Student {
	private int no;
	private String name;
	private int score;

	public Student(int no, String name, int score) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", score=" + score + "]";
	}

}

public class DataOutputStreamExample {

	public static void main(String[] args) throws IOException {
		String fileName = "myInfo.dat";
		// 기본 데이터 타입
		boolean flag = true;
		byte score = 99;
		int age = 30;
		double weight = 67.89;
		// 참조(객체) 타입
		String comment = "참 잘했어요"; // String은 객체
		Student student = new Student(10, "김재훈", 50);

		// Node 스트림
//		OutputStream out = new FileOutputStream(fileName);
		// Filter 스트림
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
		dos.writeBoolean(flag);
//		dos.write(score); // FileOutputStream의 메소드 재사용
		dos.writeByte(score);
		dos.writeInt(age);
		dos.writeDouble(weight);
		// 문자인코딩 기능이 추가된 메소드(인코딩 문자셋: utf-8)
		dos.writeUTF(comment);

		dos.writeInt(student.getNo()); // 학번
		dos.writeUTF(student.getName()); // 이름
		dos.writeInt(student.getScore()); // 점수
		// 한 방에 학생 모든 정보를 문자열로 저장. toString 오버라이드를 통하여
		// 단점: 보안에 취약
		dos.writeUTF(student.toString());

		dos.close();
//		out.close(); 

		System.out.println("내 정보 저장 완료");

	}

}

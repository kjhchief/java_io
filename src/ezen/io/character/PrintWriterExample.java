package ezen.io.character;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class PrintWriterExample {

	public static void main(String[] args) throws IOException {
//		String path = "some2.txt";
//		File file = new File(path);
		System.out.println("저장할 단 입력: ");
		Scanner scanner = new Scanner(System.in);
		int dan = scanner.nextInt();
		String fileName = "gugudan_"+dan+".txt";
		File file = new File(fileName); // 굳이 파일객체 안 만들어도 됨. 밑에서 바로 할 수 있음.
		
		FileOutputStream fos = new FileOutputStream(file); // 바이트 스트림으로도 만든다.
		// 다양한 생성자 제공
		FileWriter fw = new FileWriter(file);
//		PrintWriter out = new PrintWriter(path);
//		PrintWriter out = new PrintWriter(file);
//		PrintWriter out = new PrintWriter(fos);
//		PrintWriter out = new PrintWriter(fw);
		PrintWriter out = new PrintWriter(file, Charset.forName("utf-8"));
		
		// 다양한 출력 메소드 제공
//		out.write(null);
//		out.print();
//		out.println();
//		out.printf();
		
		
		// 임시 메모리
		StringBuilder sb = new StringBuilder();
		
		
		for(int i =1; i<=9; i++) {
			// 표준 출력
//			System.out.printf("%2d * %2d = %2d\n", dan, i, (dan*i));
			
			// 파일에 출력
//			out.printf("%2d * %2d = %2d\n", dan, i, (dan*i));
			// GUI 출력
			String txt= String.format("%2d * %2d = %2d\n", dan, i, (dan*i));
			sb.append(txt);
		}
		System.out.println(sb.toString());
		out.close();
		
		Frame frame = new Frame("구구단");
		TextArea ta = new TextArea();
		ta.append(sb.toString());
		frame.add(ta);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

}

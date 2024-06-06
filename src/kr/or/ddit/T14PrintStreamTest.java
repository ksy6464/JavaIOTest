package kr.or.ddit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException {
		///코드의 가독성을 위해서 throws IOException 하겠다
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		
		// PrintStream은 모든 자료형(데이터)를 출력할 수 있는 기능을 제공하는 OutputStream의 서브클래스이다.
		// FileOutputStream가 기반스트림이고 그거의 보조 스트림이 PrintStream이다 
		PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream입니다.\n");
		out.println("안녕하세요. PrintStream입니다.2");
		out.println("안녕하세요. PrintStream입니다.3"); ///여기까지는 문자열 데이터 출력
		out.println(out); // 객체 출력
		out.println(3.14); // double 데이터 출력
		
		
		out.close();
		
		System.out.println(); ///PrintStream 클래스에 있는데 콜솔로 나오게 하는...
		
		
		///////////////////////////////////////////////////////////////////
		
		/*
		  	PrintWriter는 데이터를 문자로 출력하는 기능을 제공한다.
		  	PrintStream보다 향상된 기능을 제공하지만 계속 PrintStream이 사용된고 있음.
		  	PrintWriter는 다양한 인코딩 처리를 하는데 적합한 스트림 클래스이다.
		 */
		
		///이게 PrintStream보다 나중에 나왔다
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos2, "CP949");  
//		PrintWriter pw = new PrintWriter(fos2); ///이렇게 하면 UTF-8로 저장
		PrintWriter pw = new PrintWriter(osw); ///ANSI로 저장
		
		pw.print("안녕하세요. PrintStream입니다.\n");
		pw.println("안녕하세요. PrintStream입니다.2");
		pw.println("안녕하세요. PrintStream입니다.3"); ///여기까지는 문자열 데이터 출력
		pw.println(pw); // 객체 출력
		pw.println(3.14); // double 데이터 출력
		
		pw.close();
		
		System.out.println("작업 끝....");
	}
}

package kr.or.ddit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 문자기반의 Buffered스트림 객체
 * @author 10
 *
 */

public class T12BufferedIOTest {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("./src/kr/or/ddit/T11BufferedIOTest.java");
//		FileReader fr = new FileReader("\"D:\\A_TeachingMaterial\\03_HighJava\\workspace\\JavaIOTest\\src\\kr\\or\\ddit\\T11BufferedIOTest.java\"");
		///에러가 계속 나는...
		
		BufferedReader br = new BufferedReader(fr);
		
		
//		int data = 0;
		String readStr = ""; 
		int cnt = 1; ///줄번호 표현
//		while ((data = fr.read()) !=-1 ) {
		while ((readStr = br.readLine()) !=null ) {
//			System.out.print((char)data);
			System.out.printf("%4d : %s\n",cnt++, readStr);
		}
//		fr.close();
		br.close();
	}
}

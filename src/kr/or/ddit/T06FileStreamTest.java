package kr.or.ddit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T06FileStreamTest {
	public static void main(String[] args) throws Exception {
		
		// 파일 출력하기
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("d:/D_Other/out.txt");
			
			for (char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}
			
			System.out.println("파일에 쓰기 작업 완료...");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
		///////////////////////////////////////////////////////////
		///파일에 있는 데이터들을 1바이트씩 읽어오는 작업
		FileInputStream fis = new FileInputStream("d:/D_Other/out.txt");
		
		int data = 0;
		while ((data = fis.read()) != -1) {
//			System.out.print(data);///숫자로 나온다
			System.out.print((char)data);
		}
		
		System.out.println();
		System.out.println("파일 읽기 작업 완료...");
		
	}
}

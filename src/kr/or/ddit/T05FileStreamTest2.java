package kr.or.ddit;

import java.io.FileInputStream;
import java.io.IOException;

public class T05FileStreamTest2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("d:/D_Other/test2.txt");
			
			int data = 0;
			
			
			while ((data=fis.read()) !=-1) {
				System.out.print((char)data);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close(); ///파일관련된것들은 close처리 해주는게 좋다
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

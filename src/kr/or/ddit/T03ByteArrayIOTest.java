package kr.or.ddit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T03ByteArrayIOTest {

	public static void main(String[] args) {
		///지금 inSrc라는 원본데이터가 있는데 outSrc로 복사하고 싶다
		/// 바이트 데이터를 복사해보고 싶다
		/// 스트림 클래스에서 하는거 하기 전에 없다는 전제로 해보겠다
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		// 직접 복사하는 방법
//		outSrc = new byte[inSrc.length];
//		for (int i = 0; i < inSrc.length; i++) {
//			outSrc[i] = inSrc[i];
//		}
//		
//		System.out.println("직접복사 후 outSrc => "+ Arrays.toString(outSrc));
		
		// arraycopy를 이용한 방법
		///util 기능 사용
		
//		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);
//		
//		System.out.println("arraycopy 복사 후 outSrc => "+ Arrays.toString(outSrc));
		
		// 스트림 클래스를 이용하는 방법

		ByteArrayInputStream bias = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data = 0;
		
		while ((data = bias.read()) != -1) {
			///10번째까지 읽고 11번은 더이상 가져올 데이터가 없다, 더이상 읽을 바이트가 없다는 뜻이 -1이 나와서 while문이 멈추게 된다
			/// 바이트 데이터는 0부터 225를 말한다. int타입으로 데이터(int data)를 리턴 받으면 byte든 아니든 마이너스 값까지 처리 가능
			
			baos.write(data); ///baos여기에 데이턱 들어갔고 이제 outSrc 여기에 넣어보자
		}///IO작업 끝남
		
		outSrc = baos.toByteArray();
		
		System.out.println("스트림 클래스이용하여 복사 후 outSrc => "+ Arrays.toString(outSrc));
		
		
		
		
		
		
		
		
		
		
	}

}

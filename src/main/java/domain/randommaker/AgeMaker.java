package domain.randommaker;

import java.util.Random;

public class AgeMaker {

	private static int MAX_AGE=100;

	private static Random random= new Random(); // 객체 생성 비용을 줄이기 위해 static으로 한번만 생성함

	public static int makeRandomAge(){
		return random.nextInt(MAX_AGE)+1;
	}
}

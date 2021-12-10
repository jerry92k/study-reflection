package domain.randommaker;

import java.util.Random;
import java.util.stream.IntStream;

public class NameMaker {

	private static int START_LOWERCASE=97;
	private static int NUM_OF_LOWERCASE=26;
	private static int NAME_LENGTH=5;

	private static Random random= new Random(); // 객체 생성 비용을 줄이기 위해 static으로 한번만 생성함

	//ascii 97(a) ~ 122(z)
	public static String makeRandomName(){
		return IntStream.range(0,NAME_LENGTH)
			.map((index) -> random.nextInt(NUM_OF_LOWERCASE) + START_LOWERCASE)
			.collect(StringBuilder::new,
				(sb, i) -> sb.append((char)i),
				(sb1, sb2) -> sb1.append(sb2))
			.toString();

	}
}

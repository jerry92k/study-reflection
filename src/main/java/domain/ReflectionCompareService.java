package domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import domain.randommaker.PersonMaker;

public class ReflectionCompareService {

	public static void main(String[] args) throws Exception {
		ReflectionCompareService reflectionCompareService = new ReflectionCompareService();
		reflectionCompareService.compareCalculations();
	}

	public void compareCalculations() throws Exception {

		long sumWholeExecTimes=0;
		for(int i=0; i<10; i++){
		long startTime = System.currentTimeMillis();
			compareCalculation();
			sumWholeExecTimes+=System.currentTimeMillis()-startTime;
		}
		double avgWholeExecTime = (double)sumWholeExecTimes/10;
		System.out.println(String.format("10번 평균 수행시간: %f milliseconds",avgWholeExecTime));
	}

	private void compareCalculation() throws Exception {
		//1) persons 객체 생성
		Person[] persons = PersonMaker.createRandomPersons();

		//2) field reflection 적용하여 계산
		System.out.println("---- field reflection ----");
		double avgFieldReflection = calculateAvgAge(persons, (person)->{
			Class personClass = Class.forName("domain.Person");
			Field age = personClass.getDeclaredField("age");
			return age.getInt(person);
		});

		//3) method reflection 적용하여 계산
		System.out.println("---- method reflection ----");
		double avgMethodReflection = calculateAvgAge(persons,(person)->{
			Class personClass = Class.forName("domain.Person");
			Method getAge = personClass.getDeclaredMethod("getAge");
			return (int)getAge.invoke(person);
		});

		//4) reflection 없이 필드 직접 참조하여 계산
		System.out.println("---- no reflection ----");
		double avgNoReflection = calculateAvgAge(persons, (person)-> person.age);

		//5) 계산값 비교
		if(avgFieldReflection == avgMethodReflection && avgMethodReflection == avgNoReflection){
			System.out.println("세 방식 모두 계산 값이 동일합니다.");
		}else{
			System.out.println("계산 값이 다릅니다.");
		}
	}

	public double calculateAvgAge(Person[] persons, AgeSupplier ageSupplier) throws Exception {
		long startTime = System.nanoTime();
		int sum = 0;
		for (Person person : persons) {
			sum+= ageSupplier.getAge(person);
		}
		double avg = (double)sum/100;
		long endTime = System.nanoTime();
		long time = endTime - startTime;
		//6) 소요시간 출력
		System.out.println(String.format("time taken : %d nanoseconds\n",+time));
		return avg;
	}
}

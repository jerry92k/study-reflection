# 리플렉션 학습 프로젝트
> flab 멘토링 과제

## 프로그램 요구사항 정의
### domain.Person 클래스 정의
- 필드 : String name, int age
- 생성자: name과 age를 받아서 name과 age 필드 초기화
- 메서드 
  - getAge(): age 반환

### 프로그램 실행 흐름 정의
1) 리플랙션을 사용해 domain.Person 객체를 100개 생성하여 일반 배열에 저장
   - (name, age는 난수로 생성함)
2) 1에서 만든 배열에 있는 100개의 person에 대해 일반 루프를 돌면서 리플렉션을 사용해 age 필드를 읽어와서 평균을 계산
   - 필드에 리플렉션 사용
3) 1에서 만든 배열에 있는 100개의 person에 대해 루프를 돌면서 리플렉션을 사용해 getAge()를 읽어와서 평균을 계산
    - 메서드에 리플렉션 사용
4) 1에서 만든 배열에 대해 루프를 돌면서 객체의 필드에 직접 접근해 평균을 계산
    - 리플렉션 사용하지 않음
5) 이 세가지 평균이 서로 같은지 비교
6) 2,3,4단계를 시작하기 전과 후의 시간을 비교해서 각각의 작업에 걸린 시간 비교
7) 1~6단계를 10번 반복해 평균 시간을 구해보기
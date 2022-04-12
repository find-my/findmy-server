# findmy-server
분실물을 찾아주는 서비스의 코드 저장소입니다.


## 기술 스택
* Spring boot
* MariaDB(DBeaver)

## 개발 순서
### 1. DB 연동(MariaDB)
* JDBC(Java DataBase Connectivity)
    * 자바 프로그램이 DBMS 일관된 방식으로 접근할 수 있도록 API 제공
    * 데이터베이스에 연결 및 작업 하기 위한 JAVA 표준 인터페이스

* 3-tier
    * 자바 애플릿이나 애플리케이션이 DBMS 직접 접근하지 않고, 미들웨어를 거쳐 접근
    * Presentation Layer 데이터 저장 방법에 신경 x
    * 2-tier 보다 훨씬 안정적


* MariaDB
    1. DB 설치 및 테스트 데이터베이스 생성
    2. 테이블 생성
    3. Spring JDBC 연결

### 2. Entity(domain)
* JPA Auditing
  * createdAt, updatedAt 자동화
  * 단순, 반복적인 코드 해결
  * `@ToString(callsuper = true)` : superclass 구현의 출력을 포함
  * `@EqualsAndHashCode(callsuper = true)` : 부모 클래스 필드 값도 동일한지 체크
  

* `@Builder` 패턴
  * `setter`, `생성자` 말고 빌더 패턴 사용이 용이


* 연관관계 매핑
  * N : 1
    * `@JoinColumn(name = "mapping 이름"` 
    * 양방향은 외래 키가 있는 쪽이 연관관계 주인(N)
    * 양방향은 항상 서로를 참조(무한루프 빠지지 않게 관리)

  * 1 : N
    * 단방향 매핑의 단점
      * 매핑한 객체가 관리하는 외래 키가 다른 테이블에 있음
      * 이는 update query 추가 실행 요구
    * 매핑 시 `new ArrayList<>()` 추가 -> NPE 방지
  

* CASCADE 종류
  ```java
  public enum CascadeType{
    ALL, // 모두 적용
    PERSIST, // 영속
    MERGE, // 병합
    REMOVE, // 삭제
    REFRESH,
    DETACH
  }
  ```
  
* `orphanRemoval=true` vs `CascadeType.REMOVE`
  * Parent - Child 값을 null 주면,
  * `orphanRemoval=true` : 자동 제거 o
  * `CascadeType.REMOVE` : 자동 제거 x


### 3. JpaRepository


## 추가적인 부분
* User Table PK `email`로 지정하지 않는 이유
  * 사용자가 탈퇴 시, 정보를 삭제할 것인지 보관할 것인지 취급 문제
  * 보통 겹치지 않는 난수를 사용하기도 함


* Test 코드
  * given, when, then 절
  * 어떻게 하는거지..
## 추가 링크
* [참고 자료 폴더](https://github.com/find-my/findmy-server/tree/main/artifacts/docs_supports)
* [프로젝트 관리 문서](https://github.com/find-my/findmy-server/tree/main/artifacts/docs_managements)

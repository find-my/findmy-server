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

### 2. Entity 생성
* JPA Auditing
  * createdAt, updatedAt 자동화
  * 단순, 반복적인 코드 해결
## 추가 링크
* [참고 자료 폴더](https://github.com/find-my/findmy-server/tree/main/artifacts/docs_supports)
* [프로젝트 관리 문서](https://github.com/find-my/findmy-server/tree/main/artifacts/docs_managements)

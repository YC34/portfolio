# JAVA+SPRINGBOOT(api 로 데이터 제공 및 auth구현.)
## skill stack
* spring boot
* mariadb
* mybatis
* spring security
* jsp

### 패키지 구조
    com -
        backend - 
            formlogin : form방식 로그인 구현 및 서비스
            jwtlogin : 토큰 방식 로그인 구현 및 서비스
    resouces -
        mapper : 쿼리문 xml 파일
        application.yml : 메인 yml
        application-dev.yml : 개발용 yml
        application-prod.yml : 운영용 yml
        mybatis.xml : mybatis용 config 

* 요구사항
    * (영찬 part)
    * SPRING SECURITY + mybatis + form login을 활용하여
* 회원 가입 및 로그인 로그 아웃.
    * action 				|| 전송 방식 	|| URL
    * 로그인 화면 			|| GET	   	|| /login
    * 로그인 처리    		|| POST    	|| /login
    * 로그아웃 처리   		|| POST    	|| /logout
    * 회원가입 화면   		|| GET     	|| /signUp
    * 회원가입 처리   		|| POST    	|| /signUp
    * 회원정보 수정 화면   	|| GET     	|| /modify
    * 회원정보 전체 수정 처리  	|| PUT     	|| /modify (모든 테이블의 데이터를 보내줘야 한다. )
    * 회원정보 부분 수정 처리 	|| PATCH	|| /modify (원하는 값만 골라서 update)
    * 이메일 중복 체크 		|| GET		|| /getEmail


* DB(user_table) INFO
  * (영찬 part)
  * uid (유저 id - 다른 테이블과 연관관계 맵핑해야한다. )
  * username (유저 이름)
  * password (비밀번호)
  * role (권한)
  * create_at ( 생성 일 (회원 가입 날짜 ))
  * delete_yn ( 회원 탈퇴 여부 : default 'N' -> 탈퇴하여도 회원의 정보는 유지하고 가지고 있는다.)
  * email ( 로그인시 사용할 id - 중복이 없어야 한다. )
 
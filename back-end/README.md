# JAVA+SPRINGBOOT(api 로 데이터 제공 및 auth구현.)
## skill stack
* spring boot
* mariadb
* mybatis
* spring security
* thymeleaf(test용 추후에 삭제)

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

      
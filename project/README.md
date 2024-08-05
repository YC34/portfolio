# JSP+SPRING BOOT
## skill stack
* spring boot
* JSP
* jstl
* mariadb
* tomcat
* js


### 패키지 구조
    com -
        example -
                demo -
                    controller 
                            : controller (화면을 이동해주는 역할)
                            : restcontroller (실질적인 action을 하는 역할)
                    dao : DB에 query를 던져주는 역할
                    dto : DATA를 이동해주는 객체
                    service : restcontroller에서 받은 요청값을 원하는 데이터로 변환 및 비즈니스 로직을 실행
                mainmethod(DemoApplication)    
    
    resouce -
        static : 화면 랜더링에 필요한 js 및 bootstrap파일들. 
        application.yml : spring boot config 및 정보들
    webapp -
        WEB-INF -
            views : 각각의 해당하는 서비스에 대한 jsp파일
            home.jsp : 첫 화면에 대한 jsp

      
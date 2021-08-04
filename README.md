# dev-server-app
if you want to see this code, check out master branch
## 프로젝트 설명
`Spring boot` `JPA` 를 사용하여 RESTful API 구현 프로젝트 입니다.   
등록 수정 기능 로직에서는 Dto > Model 매핑을 위해 `mapstruct` 라이브러리를 사용하여 작성하였습니다.   
검색 기능은 JpaSpecificationExecutor 를 사용하여 Jpa Repository의 사용자 정의 메소드의   
무분별한 반복 코드량을 줄이고 유지보수가 용이할 수 있도록 작성하였습니다.

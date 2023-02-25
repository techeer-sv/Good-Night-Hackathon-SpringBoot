## 프로젝트 초기 세팅
- [x] jpa 연결 - mySQL 사용
- [x] 프로젝트 디렉터리 구조 설계 - 도메인형
  - domain, global로 나누고, domain안에 domain별로 생성
  - Restaurant, Review - 각각 Controller, Entity, Service
  - global엔 BaseEntity, SwaggerConfig 생성

## 기능 요구 사항
- [x] BaseEntity 세팅
  - 모든 Entity에 공통적으로 들어가는 속성 - 생성일, 수정일
- [x] Restaurant, Review entity 설계
  - RestaurantCategory은 enum으로 생성
  - 1:N 관계로 join
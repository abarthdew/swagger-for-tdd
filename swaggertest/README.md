# swaggertest

## *의존성 추가

### TODO (1)

```
id 'org.springframework.boot' version '2.2.1.RELEASE'
id 'io.spring.dependency-management' version '1.0.8.RELEASE'
```

### TODO 1

```gradle
compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'
compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
```

## *SwaggerConfig.java

### TODO 2

```java
@EnableSwagger2 //swagger를 사용할 수 있게 해 주는 어노테이션
---
  .title("Banapresso APIs") // 문서 제목
  .description("바나프레소 api 문서입니다") // 문서 설명
  .version("1.2") // 문서 버전
// new ApiInfoBuilder() 안에 더 많은 메서드 사용가능
```

### TODO 3

```java
.apiInfo(apiInfo()) //ApiInfo 클래스의 apiInfo() 메서드 주입
  .select() //스웨거에 의해 노출되는 끝단endpoint (url) 을 제어
  .apis(RequestHandlerSelectors.basePackage("my.project.swaggerstd"))
  //  .apis(RequestHandlerSelectors.any()) // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
  .paths(PathSelectors.ant("/api/**")) // 그중 /api/** 인 URL들만 필터링
  //  .paths(PathSelectors.any())
  .build()
```

## *Api : 문서 타이틀에 대한 설명 추가

### TODO 4

```java
@Api(tags = {"01. Beverage List"}, description = "음료 목록 관리")
```

## *ApiOperation : 메서드에 대한 설명 추가

### TODO 5

```java
@ApiOperation(value = "특정 음료목록 불러오기", notes = "특정 음료목록을 불러옵니다")
```

## *ApiImplicitParams : 파라미터에 대한 설명 추가

### TODO 6

```java
@ApiImplicitParams({
  @ApiImplicitParam(name = "id", value = "특정 음료 조회에 필요한 파라미터", required = true, dataType = "String", paramType = "path", defaultValue = "1001"),
})
```

## *ApiResponses : 응답에 대한 설명 추가

### TODO 7

```java
@ApiResponses({
  @ApiResponse(code = 200, message = "성공"),
  @ApiResponse(code = 400, message = "잘못된 접근"),
  @ApiResponse(code = 500, message = "서버에러")
})
```

# `Smilegate BackEnd`

> 주제: 블로그 개발 (Database, Front-end)

<br> <br>

## `구현 결과물`

### 메인 페이지

<img width="1059" alt="스크린샷 2021-11-04 오후 10 16 52" src="https://user-images.githubusercontent.com/45676906/140319944-7f22bb71-11d9-442c-af7c-603a9e694946.png">

- 메인페이지에서 게시글을 7개씩 보여주도록 `페이징` 기능을 만들었습니다.
- 게시글을 `검색`할 수 있는 기능을 만들었습니다. 
- 게시글의 `조회수` 기능을 만들었습니다. 

<br> <br>

### `게시글 작성`

<img width="524" alt="스크린샷 2021-11-04 오후 10 17 25" src="https://user-images.githubusercontent.com/45676906/140320031-83afdd76-b238-44e9-8d0a-3ed211f9e90c.png">

게시글을 작성할 때 `글 제목`, `글 내용`, `글 카테고리`, `파일 업로드`를 할 수 있도록 구현하였습니다. 

<br>

<img width="512" alt="스크린샷 2021-11-04 오후 10 18 26" src="https://user-images.githubusercontent.com/45676906/140320185-e90011e0-094d-4bae-98ae-df7c012878c6.png">

글을 입력하지 않고 `등록` 버튼을 누르면 위와 같이 `입력란을 작성`하라는 문구가 나오도록 구현하였습니다.  

<br>

<img width="1477" alt="스크린샷 2021-11-04 오후 10 24 40" src="https://user-images.githubusercontent.com/45676906/140321075-3c66ec88-4c00-4389-901a-6612dcffb9c0.png">

`파일 업로드`는 `AWS S3`로 업로드 하도록 구현하였습니다.

<br> <br>

## `게시글 상세 조회`

<img width="545" alt="스크린샷 2021-11-04 오후 10 19 44" src="https://user-images.githubusercontent.com/45676906/140320349-2dd67943-0322-4b8c-9ce2-91219e093c7a.png">

게시글 상세조회를 하면 위와 같이 작성했던 대로 볼 수 있습니다. 그리고 `게시글 수정`, `댓글보기`, `게시글 삭제` 버튼이 존재합니다. 

<br> <br>

## `게시글 수정`

<img width="504" alt="스크린샷 2021-11-04 오후 10 26 47" src="https://user-images.githubusercontent.com/45676906/140321368-215be72e-e932-479d-9367-340211a9aad6.png">

`게시글 수정` 버튼을 누르면 위와 같이 제목, 내용을 수정할 수 있도록 활성화됩니다. 그리고 파일 업로드도 다시 할 수 있습니다.  

<br> <br>

## `게시글 삭제`

<img width="1024" alt="스크린샷 2021-11-04 오후 10 28 46" src="https://user-images.githubusercontent.com/45676906/140321658-65d982c6-3422-4b76-81ac-7ca84701aea9.png">

25번 게시글을 삭제했는데 위와 같이 잘 삭제가 된 것을 볼 수 있습니다. 

<br> <br>

## `댓글 작성`

<img width="564" alt="스크린샷 2021-11-04 오후 10 29 55" src="https://user-images.githubusercontent.com/45676906/140321846-c8c161ad-b67a-46bc-a4be-f7bf95493a00.png">

`댓글 등록`에서 댓글을 등록하면 위에 바로 댓글이 추가 됩니다.

<br> <br>

## `댓글 수정`

<img width="517" alt="스크린샷 2021-11-04 오후 10 32 50" src="https://user-images.githubusercontent.com/45676906/140322427-840168ad-1909-43bf-a9ee-728c15a319f5.png">

`수정 버튼`을 누른 후에 댓글 수정도 가능합니다.

<br> <br>

## `댓글 삭제`

<img width="539" alt="스크린샷 2021-11-04 오후 10 34 46" src="https://user-images.githubusercontent.com/45676906/140322697-4641aeb0-f26e-4a60-ad15-99667ba5e13d.png">

수정한 댓글을 삭제했는데 삭제가 잘 된 것을 볼 수 있습니다. 

<br> <br>

## `게시글 검색`

<img width="1081" alt="스크린샷 2021-11-04 오후 10 37 40" src="https://user-images.githubusercontent.com/45676906/140323166-592532c1-3f8e-412a-8ef3-b3b936a58131.png">

검색 키워드로 `제목1` 이라고 입력했는데, `제목1`이 들어간 게시글들이 전부 나온 것을 확인할 수 있습니다. 

<br> <br>

## `마이 페이지`

<img width="341" alt="스크린샷 2021-11-04 오후 10 36 02" src="https://user-images.githubusercontent.com/45676906/140322910-72992f3d-4167-4c3c-899b-9e5c7626aab7.png">

마이페이지에서는 `내가 작성한 게시글 수`, `게시글 누적 조회 수`를 볼 수 있도록 구현하였습니다.

<br> <br>

## `구현된 기능 정리`

- 메인 페이지 조회 (Paging 버튼 추가)
- 게시글 작성 (파일 업로드 가능)
- 게시글 단건 조회
- 게시글 조회수
- 게시글 삭제
- 게시글 수정
- 게시글 검색
- 마이페이지 조회
- 댓글 조회
- 댓글 수정
- 댓글 삭제

<br> <br>

## `Directory Tree`

```
├───main/
    ├───java/
        ├───controllers/
        │   ├───CommentController.java
        │   ├───PostController.java
        │   ├───UserController.java
        ├───dto/
        │   └───auth.js
        ├───models/
        │   ├───request
        │   │   │   ├───PostSaveRequestDTO.java
        │   │   │   ├───PostUpdateRequestDTO.java
        │   ├───response
        │   │   │   ├───CommentResponseDTO.java
        │   │   │   ├───PostCommentResponseDTO.java
        │   │   │   ├───PostResponseDTO.java
        │   │   │   ├───UserMyPageResponseDTO.java
        └───entity/
        │   ├───BaseEntity.java
        │   ├───Category.java
        │   ├───Comment.java
        │   ├───Post.java
        │   ├───User.java
        └───repository/
        │   ├───CommentRepository.java
        │   ├───PostRepository.java
        │   |───UserRepository.java
        └───service/
        │   ├───CommentService.java
        │   ├───FileUploadService.java
        │   ├───PostService.java
        │   ├───UserService.java    
        └───util/
            ├───LocalDateTimeToStringUtil.java
    ├───resources/
        ├───application.yml
    ├───webapp/
        ├───WEB-INF
            ├───commentUpdate.jsp
            ├───create.jsp
            ├───error.jsp
            ├───header.jsp
            ├───main.jsp
            ├───myPage.jsp
            ├───postComment.jsp
            ├───update.jsp
            ├───view.jsp
├───test/
    ├───java/
        ├───com.smile/
            ├───service/
                ├───CommentServiceTest/
                ├───PostServiceTest/
                ├───UserServiceTest/
```

<br> <br>

## `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:smile-db
    username: sa
    password:
  mvc:
    view:
      prefix: /WEB-INF/
      suffix: .jsp
    hiddenmethod:
      filter:
        enabled: true
  h2:
    console:
      enabled: true
      path: /h2-console

  jpa:
    show-sql: true
    properties:
      hibernate:
        format_sql: true
      javax:
        persistence:
          sharedcache:
            mode: ENABLE_SELECTIVE

    generate-ddl: true
    hibernate:
      ddl-auto: create

cloud:
  aws:
    credentials:
      accessKey: ${ACCESS_KEY}
      secretKey: ${SECRET_KEY}
    s3:
      bucket: ${BUCKET_NAME}
      dir: Gyunny/
    region:
      static: ${AWS_REGION}
    stack:
      auto: false
```

<br>

![스크린샷 2021-11-04 오후 10 54 38](https://user-images.githubusercontent.com/45676906/140326348-c61ae24a-74a3-455a-93c5-0c3bd43a8960.png)

`IAM` 값들은 `Intellij` 환경 변수로 설정하였습니다. 

<br> <br>

## `테스트 코드 작성`

![스크린샷 2021-11-04 오후 11 04 19](https://user-images.githubusercontent.com/45676906/140328250-05da9926-6a16-4f7e-9cf8-b0a85a21edce.png)

<br>

![스크린샷 2021-11-04 오후 11 05 19](https://user-images.githubusercontent.com/45676906/140328260-a6d2a7d8-737c-4d03-8c0f-3e8ddd3cad53.png)

<br>


![스크린샷 2021-11-04 오후 11 05 50](https://user-images.githubusercontent.com/45676906/140328261-cfd9d42e-0537-471b-8395-a19039ed212c.png)

`User`, `Comment`, `Post`에 대해서 단위 테스트를 적용하였습니다. ([테스트 코드 보러가기](https://github.com/wjdrbs96/Smile_Backend/tree/develop/src/test/java/com/smile/service))

<br> <br>

## `아쉬운 점`

### `디자인을 고려하지 못함`

평소에 프론트엔드, 디자인에 대해서 다루어 본 경험이 거의 없다보니 고려하지 못했습니다.



- @RequestBody를 사용하지 못한 부분 -> 작성 예정

<br> <br>

## `사용된 기술`

- `Java 11`
- `Spring Boot`
- `Spring Data JPA`
- `Java Server Page(JSP)`
- `H2 DataBase`
- `AWS S3`
- `JUnit5`

<br> <br>

## `Author`

- [Gyunny](https://github.com/wjdrbs96)
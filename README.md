# 개요
커뮤니티 게시판 API 명세를 제공하고 있습니다.

# 게시판 목록 조회
---
게시판 목록을 가져오는 API 입니다.
```
GET http://localhost:8080/api/article?
    page={page}&
    size={size}
```
요청 데이터 항목입니다.
* page: 페이지 번호(기본값: 0)
* size: 페이지 사이즈(기본값: 10)

응답 데이터 샘플입니다.
```
{
    "resultCode": "S",
    "resultMessage": "성공하였습니다.",
    "data": {
        "content": [
            {
                "seq": 50,
                "subject": "subject50",
                "content": "content50",
                "name": "test50",
                "createdDate": "2020-02-19T00:17:21.622912",
                "modifiedDate": "2020-02-19T00:17:21.622912"
            },
            {
                "seq": 49,
                "subject": "subject49",
                "content": "content49",
                "name": "test49",
                "createdDate": "2020-02-19T00:17:21.620912",
                "modifiedDate": "2020-02-19T00:17:21.620912"
            },
            {
                "seq": 48,
                "subject": "subject48",
                "content": "content48",
                "name": "test48",
                "createdDate": "2020-02-19T00:17:21.618912",
                "modifiedDate": "2020-02-19T00:17:21.618912"
            },
            {
                "seq": 47,
                "subject": "subject47",
                "content": "content47",
                "name": "test47",
                "createdDate": "2020-02-19T00:17:21.616913",
                "modifiedDate": "2020-02-19T00:17:21.616913"
            },
            {
                "seq": 46,
                "subject": "subject46",
                "content": "content46",
                "name": "test46",
                "createdDate": "2020-02-19T00:17:21.614911",
                "modifiedDate": "2020-02-19T00:17:21.614911"
            },
            {
                "seq": 45,
                "subject": "subject45",
                "content": "content45",
                "name": "test45",
                "createdDate": "2020-02-19T00:17:21.612912",
                "modifiedDate": "2020-02-19T00:17:21.612912"
            },
            {
                "seq": 44,
                "subject": "subject44",
                "content": "content44",
                "name": "test44",
                "createdDate": "2020-02-19T00:17:21.610911",
                "modifiedDate": "2020-02-19T00:17:21.610911"
            },
            {
                "seq": 43,
                "subject": "subject43",
                "content": "content43",
                "name": "test43",
                "createdDate": "2020-02-19T00:17:21.607911",
                "modifiedDate": "2020-02-19T00:17:21.607911"
            },
            {
                "seq": 42,
                "subject": "subject42",
                "content": "content42",
                "name": "test42",
                "createdDate": "2020-02-19T00:17:21.604911",
                "modifiedDate": "2020-02-19T00:17:21.604911"
            },
            {
                "seq": 41,
                "subject": "subject41",
                "content": "content41",
                "name": "test41",
                "createdDate": "2020-02-19T00:17:21.601914",
                "modifiedDate": "2020-02-19T00:17:21.601914"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": true,
                "unsorted": false,
                "empty": false
            },
            "offset": 0,
            "pageSize": 10,
            "pageNumber": 0,
            "paged": true,
            "unpaged": false
        },
        "totalPages": 5,
        "last": false,
        "totalElements": 50,
        "size": 10,
        "number": 0,
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "numberOfElements": 10,
        "first": true,
        "empty": false
    }
}
```

응답 데이터 항목입니다.
* resultCode: 결과 코드(S: 성공, E: 에러)
* resultMessage: 결과 메시지
* data: 데이터 영역
    * content: 데이터 목록
        * seq: 일련번호
        * subject: 제목
        * content: 내용
        * name: 작성자 이름
        * createdDate: 등록일
        * modifiedDate: 수정일
* pageable: 페이지 기준 정보
    * sort: 정렬 기준 정보
        * sorted: 정렬 여부
        * unsorted: 정렬 안됨 여부
        * empty: 정렬 기준 정보 없음 여부
    * offset: 기본 페이지 및 페이지 크기에 따라 가져올 오프셋 반환
    * pageSize: 페이지 사이즈
    * pageNumber: 현재 페이지 번호
    * paged: 현재 페이징이 포함 여부
    * unpaged: 현재 페이징이 포함 안됐는지 여부
* totalPages: 전체 페이지
* last: 마지막 페이지 여부
* totalElements: 모든 요소
* size: 한 페이지에서 보여줄 사이즈
* number: 현재 페이지 번호
* sort: 정렬 기준 정보
    * sorted: 정렬 여부
    * unsorted: 정렬 안됨 여부
    * empty: 정렬 기준 정보 없음 여부
* numberOfElements: 현재 페이지 요소
* first: 첫 페이지 여부
* empty: 목록이 비어있는지 여부

# 게시판 상세 조회
---
게시판 상세를 가져오는 API 입니다.
```
GET http://localhost:8080/api/article/{seq}
```
요청 데이터 항목입니다.
* seq: 게시판 일련번호(필수)

응답 데이터 샘플입니다.
```
{
    "resultCode": "S",
    "resultMessage": "성공하였습니다.",
    "data": {
        "seq": 10,
        "name": "test10",
        "content": "content10",
        "subject": "subject10",
        "useYn": "Y",
        "createdDate": "2020-02-19T00:40:25.738577",
        "modifiedDate": "2020-02-19T00:40:25.738577"
    }
}
```
* resultCode: 결과 코드(S: 성공, E: 에러)
* resultMessage: 결과 메시지
* data: 데이터 영역
    * seq: 일련번호
    * subject: 제목
    * content: 내용
    * name: 작성자 이름
    * createdDate: 등록일
    * modifiedDate: 수정일
    
# 게시판 등록
---
게시판을 추가 하는 API 입니다.
```
POST http://localhost:8080/api/article
```
요청 데이터 샘플입니다.
```
{
	"subject" : "1234",
	"content" : "1234",
	"name" : "test10",
	"password" : "12qw"
}
```
요청 데이터 항목입니다.
* subject: 제목(필수, 50자 이내 입력)
* content: 내용(필수, 200자 이내 입력)
* name: 작성자(필수, 50자 이내 입력)
* password: 비밀번호(필수, 영어 & 숫자 조합 4자 이상)

응답 데이터 샘플입니다.
```
{
    "resultCode": "S",
    "resultMessage": "성공하였습니다."
}
```
* resultCode: 결과 코드(S: 성공, E: 에러)
* resultMessage: 결과 메시지

# 게시판 수정
---
게시판을 수정 하는 API 입니다.
```
PUT http://localhost:8080/api/article/{seq}
```
요청 데이터 샘플입니다.
```
{
	"subject" : "1234",
	"content" : "1234",
	"name" : "test10",
	"password" : "12qw"
}
```
요청 데이터 항목입니다.
* seq: 게시판 일련번호(필수)
* subject: 제목(필수, 50자 이내 입력)
* content: 내용(필수, 200자 이내 입력)
* name: 작성자(필수, 50자 이내 입력)
* password: 비밀번호(필수, 영어 & 숫자 조합 4자 이상)

응답 데이터 샘플입니다.
```
{
    "resultCode": "S",
    "resultMessage": "성공하였습니다."
}
```
* resultCode: 결과 코드(S: 성공, E: 에러)
* resultMessage: 결과 메시지

# 게시판 삭제
---
게시판을 삭제 하는 API 입니다.
```
DELETE http://localhost:8080/api/article/{seq}
```
요청 데이터 항목입니다.
* seq: 게시판 일련번호(필수)

응답 데이터 샘플입니다.
```
{
    "resultCode": "S",
    "resultMessage": "성공하였습니다."
}
```
* resultCode: 결과 코드(S: 성공, E: 에러)
* resultMessage: 결과 메시지
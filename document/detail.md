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
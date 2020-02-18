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
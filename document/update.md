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
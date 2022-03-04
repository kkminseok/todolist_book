# todolist_book
React.js 스프링부트, AWS로 배우는 웹 개발 101 책에 대한 내용. aws에 관해 궁금해서 샀다.

3일 컷 할거임.

1일차(2월7일)

2일차(2월19일)

250p 라이브러리 디펜더시 부분 틀림.

```bash
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt
	compile group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1'

    이부분은 gradle 버전이 올라감에 따라 지원하지 않음.

    implementation 'io.jsonwebtoken:jjwt-api:0.11.2'
	implementation 'io.jsonwebtoken:jjwt-impl:0.11.2'
	implementation 'io.jsonwebtoken:jjwt-jackson:0.11.2'

    로 수정
```

```
289p

Switch가 react-router-dom버전의 올라감에 따라 routes로 바뀜.

npm install reaact-router-dom@5

으로 설치
```

```
P348 오타

pip install awscli --upgrade --user임.
pip install awscli --upgrade -user아님
```

이 프로젝트는 끝났다.

다 배움,
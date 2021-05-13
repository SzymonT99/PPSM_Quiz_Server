# Quiz - REST API
Server for the quiz application.
<br/>

<img src="https://github.com/SzymonT99/PPSM_Quiz_Server/blob/master/docs/spring-logo.png" width="60" height="60">

## Technologies
- Java
- Apache Maven
- Spring Boot
- Spring Data JPA
- Spring Security

## Database
The MySQL database is used
<br />
- Database structure
<br />
<img src="https://github.com/SzymonT99/PPSM_Quiz_Server/blob/master/docs/database-structure.png">

## Endpoints

#### Register
```
POST http://localhost:8080/quiz/create-user
Content-Type: application/json

Request
{
    "login": "user123",
    "email": "user123@gmail.com",
    "password": "pass"
}
```

#### Login
```
POST http://localhost:8080/quiz/user/login
Content-Type: application/json

Request
{
    "login": "user123",
    "password": "pass"
}

Response: 
Role
```

#### Login update
```
PUT http://localhost:8080/quiz/user-update/login
Content-Type: application/json

Request
{
    "oldLogin": "user123",
    "newLogin": "user987",
    "password": "pass"
}
```

#### Password update
```
PUT http://localhost:8080/quiz/user-update/password
Content-Type: application/json

Request
{
    "login": "user123",
    "oldPassword": "pass",
    "newPassword": "newPass"
}
```

#### Delete account
```
DELETE http://localhost:8080/quiz/delete-user

Request
{
    "login": "user123",
    "password": "pass",
}
```


#### Get all users
```
GET http://localhost:8080/quiz/users

Response
[
    {
        "id": 1,
        "stats": {
            "id": 1,
            "gamesNumber": 0,
            "correctAnswer": 0,
            "incorrectAnswer": 0,
            "addedQuestions": 34,
            "currentRank": 0
        },
        "login": "asdf",
        "email": "asdf@gmail.com",
        "password": "$2a$10$4tOW0SpBf53b1fkNfhYBqeiEvY9pZyud1MJDeB.pHAtKxhapXO53e",
        "role": "ROLE_ADMIN",
        "active": true,
        "incorrectLoginCounter": 0
    },
    {
        "id": 2,
        "stats": {
            "id": 2,
            "gamesNumber": 9,
            "correctAnswer": 20,
            "incorrectAnswer": 9,
            "addedQuestions": 12,
            "currentRank": 5
        },
        "login": "cfty",
        "email": "cfty62@o2.pl",
        "password": "$2a$10$uYubSlwVQewuRQ7kpIBXdeUnJT9GST/MC/CHp/Ft.MMl4WsnLxqQO",
        "role": "ROLE_USER",
        "active": true,
        "incorrectLoginCounter": 0
    },
    ...
]
```

#### Get all active/inactive questions
```
GET http://localhost:8080/quiz/questions/{state}

Response
[
    {
        "id": 2,
        "content": "W którym roku naszej ery nastąpił ostateczny upadek Cesarstwa Zachodniorzymskiego?",
        "category": "Historia",
        "answers": [
            {
                "answer": "483",
                "correct": false
            },
            {
                "answer": "476",
                "correct": true
            },
            {
                "answer": "485",
                "correct": false
            },
            {
                "answer": "466",
                "correct": false
            }
        ],
        "seconds": 15,
        "available": true,
        "points": 1,
        "author": null
    },
    {
        "id": 6,
        "content": "W którym roku Marcin Luter przybił swoje 95 tez na drzwiach kościoła w Wittenberdze i rozpoczął Reformację religijną?",
        "category": "Historia",
        "answers": [
            {
                "answer": "1523",
                "correct": false
            },
            {
                "answer": "1530",
                "correct": false
            },
            {
                "answer": "1509",
                "correct": false
            },
            {
                "answer": "1517",
                "correct": true
            }
        ],
        "seconds": 20,
        "available": true,
        "points": 1,
        "author": null
    },
    ...
]
```

#### Save the proposed user question 
```
POST http://localhost:8080/quiz/add-question
Content-Type: application/json

Request
{
    "login": "user123",
    "content": "Ile zasad efektywnego programowania określa SOLID?",
    "answerA": "4",
    "answerB": "5",
    "answerC": "3",
    "answerD": "1",
    "seconds": 10,
    "correctAnswer": 2
}
```

#### Administrator accepts the user's question
```
PUT http://localhost:8080/quiz/question-accepted/{id}
Content-Type: application/json

Request
{
    "content": "Ile zasad efektywnego programowania określa SOLID?",
    "answerA": "4",
    "answerB": "5",
    "answerC": "3",
    "answerD": "1",
    "seconds": 10,
    "points": 6,
    "category": "Programowanie"
}
```

#### Administrator deletes question
```
DELETE http://localhost:8080/quiz/delete-question/{id}

Response
{
    "id": 1,
    "content": "Które z poniższych miast było jednym ze starożytnych greckich państw-miast (polis)?",
    "category": "Historia",
    "answers": [
        {
            "answer": "Bablos",
            "correct": false
        },
        {
            "answer": "Antiochia",
            "correct": false
        },
        {
            "answer": "Korynt",
            "correct": true
        },
        {
            "answer": "Larnaka",
            "correct": false
        }
    ],
    "seconds": 20,
    "available": true,
    "points": 2,
    "author": null
}
```

#### Get statistics of all users
```
GET http://localhost:8080/quiz/statistics

Response
[
    {
        "id": 1,
        "gamesNumber": 0,
        "correctAnswer": 0,
        "incorrectAnswer": 0,
        "addedQuestions": 34,
        "currentRank": 0
    },
    {
        "id": 2,
        "gamesNumber": 9,
        "correctAnswer": 20,
        "incorrectAnswer": 9,
        "addedQuestions": 12,
        "currentRank": 5
    },
    ...
]
```
#### Get user stats
```
GET http://localhost:8080/quiz/statistics/{name}

Response
{
    "id": 1,
    "gamesNumber": 0,
    "correctAnswer": 0,
    "incorrectAnswer": 0,
    "addedQuestions": 34,
    "currentRank": 0
}
```

#### Get quiz ranking
```
GET http://localhost:8080/quiz/ranking

Response
[
    {
        "userName": "dwq123",
        "points": 19,
        "date": "2021-01-14T16:43:37.000+00:00"
    },
    {
        "userName": "Grzegorz",
        "points": 15,
        "date": "2020-12-20T12:56:21.000+00:00"
    },
    {
        "userName": "franek",
        "points": 11,
        "date": "2020-12-20T12:48:26.000+00:00"
    },
    ...
]
```

#### Get user results
```
GET http://localhost:8080/quiz/results

Response
[
    {
        "id": 1,
        "user": {
            "id": 2,
            "stats": {
                "id": 2,
                "gamesNumber": 9,
                "correctAnswer": 20,
                "incorrectAnswer": 9,
                "addedQuestions": 12,
                "currentRank": 5
            },
            "login": "cfty",
            "email": "cfty62@o2.pl",
            "password": "$2a$10$uYubSlwVQewuRQ7kpIBXdeUnJT9GST/MC/CHp/Ft.MMl4WsnLxqQO",
            "role": "ROLE_USER",
            "active": true,
            "incorrectLoginCounter": 0
        },
        "points": 2,
        "date": "2020-12-20T11:49:25.000+00:00"
    },
    {
        "id": 2,
        "user": {
            "id": 2,
            "stats": {
                "id": 2,
                "gamesNumber": 9,
                "correctAnswer": 20,
                "incorrectAnswer": 9,
                "addedQuestions": 12,
                "currentRank": 5
            },
            "login": "cfty",
            "email": "cfty62@o2.pl",
            "password": "$2a$10$uYubSlwVQewuRQ7kpIBXdeUnJT9GST/MC/CHp/Ft.MMl4WsnLxqQO",
            "role": "ROLE_USER",
            "active": true,
            "incorrectLoginCounter": 0
        },
        "points": 1,
        "date": "2020-12-20T12:31:37.000+00:00"
    },
    ...
]
```

#### Save single user result
```
POST http://localhost:8080/quiz/save-result
Content-Type: application/json

Request
{
    "login": "user123",
    "points": 21,
    "correctAnswer": 17,
    "incorrectAnswer": 1
}
```

#### Get app rates
```
GET http://localhost:8080/quiz/rates
Content-Type: application/json

Response
{
    "goodRates": 9,
    "badRates": 1
}
```

#### Save user rate
```
POST http://localhost:8080/quiz/add-rate
Content-Type: application/json

Request
{
    "userName": "user123",
    "opinion": true
}
```

# WordsCounter--Java

## Po uruchomieniu
Po uruchomieniu backendu należy wykonać dla bazy danych:
``` sql
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

Następnie będzie można dodać usera za pomocą `/api/auth/signup`
``` json
{
    "username": "admin",
    "email": "test@test.local",
    "password": "Password123",
    "role": ["mod", "user", "admin"]
}
```
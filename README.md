# spring-microservices-oauth my

### BUILD:

```
./gradlew build
```

### RUN:
1. Clone config_repository and change bootstrap.yaml to local instance or point to git repo
2. Run:
    - config-service
    - discovery-service
    and then rest


To get user token(for admin change username to admin):

```
curl -X POST -H "Authorization: Basic d2ViYXBwOnNlY3JldA==" -H "Content-Type: application/x-www-form-urlencoded"  -d "client_id=webapp&grant_type=password&username=user&password=password" http://localhost:9000/oauth/token
```

This is clientId and secret(webapp:secret) Base64  

```
d2ViYXBwOnNlY3JldA==
```




To try init feeder: 
```
curl -H "Authorization: Bearer your_token" http://localhost:8091/feeder/initFeed
```



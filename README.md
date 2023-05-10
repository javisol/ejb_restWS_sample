# EJB Sample Application

## Test
### Rest
```bash
curl openliberty01:9080/ejb-app/hello
```

### Singleton
Use remote interface from `ejb-appclient` client app
```bash
curl -v openliberty01:9080/ejb-appclient/singleton
curl -v openliberty01:9080/ejb-appclient/singleton2
```

### Stateful
```bash
curl openliberty01:9080/ejb-app/statefullocal
curl openliberty01:9080/ejb-app/statefulremote #remote interface but locally called
```
Use remote interface from `ejb-appclient` client app
```bash
curl openliberty01:9080/ejb-appclient/stateful
```

### Stateless
```bash
curl openliberty01:9080/ejb-app/statelesslocal
```
Use remote interface from `ejb-appclient` client app
```bash
curl openliberty01:9080/ejb-appclient/stateful
```

### Entity
#### Read
```bash
curl -v openliberty01:9080/ejb-app/pets?id=1
```
#### Write
```bash
curl -v -XPOST openliberty01:9080/ejb-app/pets?name=Rafael
```

### JMS
#### Send Message
```bash
curl -v openliberty01:9080/ejb-app/send?msg="hola%20gatito"
```

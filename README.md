## Spring Cloud Gateway MVC / Examples by SACAViX Tech

This project show how you can use SCG.


For load routes from DB you can star docker/mysql

```docker run -d --name mysql-server -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -v mysql_data:/var/lib/mysql --restart unless-stopped mysql:latest```

Also you need httpbin API in your docker environment
```docker run -p 8081:80 kennethreitz/httpbin```

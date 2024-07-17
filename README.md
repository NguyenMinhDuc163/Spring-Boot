# Spring-Boot


http://localhost:8080/api/building?districtid=1

http://localhost:8080/api/building?name=abc


docker run ^
-e MYSQL_ROOT_PASSWORD=NguyenDuc@163 ^
--name mysql18-container ^
-p 3308:3306 ^
-v mysql18-volume:/var/lib/mysql ^
-d mysql:8.0.28

// connect
mysql -protocol=tcp -h localhost -P 3308 -u root -pNguyenDuc@163





mysql -u root -pNguyenDuc@163

// tao network
docker network create spring-boot-network


// tao chung network
docker run -d \
--name mysql18-container \
--network spring-boot-network \
--network-alias spring-app-network \
-v spring-mysql-database:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=NguyenDuc@163 \
-e MYSQL_DATABASE=estatebasic \
-d mysql:8.0.28


// test bang netshoot

docker run -it \
--network spring-boot-network \
--name netshoot-container \
nicolaka/netshoot

// vao trong may netshoot
docker exec -it netshoot-container /bin/bash

// kiem tra ket noi
dig spring-app-network
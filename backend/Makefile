##########################################################################################
##### GRADLE
##########################################################################################
gradle		:=	./gradlew

installDistDev:
	${gradle} clean installDist -Dio.ktor.development=true

installDist:
	${gradle} clean installDist

installDist:
	${gradle} clean buildFatJar


##########################################################################################
##### DOCKER
##########################################################################################
container-db:
	docker compose -f docker-compose-db.yml up

container:
	docker compose -f docker-compose.yml up

image:
	docker build -t mindfullconnect .

container-prod:
	docker run
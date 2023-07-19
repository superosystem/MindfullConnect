##########################################################################################
##### GRADLE
##########################################################################################
gradle		:=	./gradlew

run:
	${gradle} clean bootRun


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
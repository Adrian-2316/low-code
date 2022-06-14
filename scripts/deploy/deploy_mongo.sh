docker volume create mongo; docker run -p 27018:27018 --restart always  --network spring -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=2a788139-e37b-41ef-8747-e8d9df6db983 --volume mongo:/data/db --name mongo -d mongo:4.2


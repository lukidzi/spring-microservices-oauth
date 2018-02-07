cd discovery-service
./gradlew build
cd ..
cd oauth-service
./gradlew build
cd ..
cd config-service
./gradlew build
cd ../
cd movie-service
./gradlew build
cd ../
cd feeder-service
./gradlew build

echo "DONE!!"

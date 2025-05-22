#! /bin/sh

cd jwt-util
mvn clean install -DskipTests
cd ..

cd user-api
mvn clean install -DskipTests
cd ..

cd config
mvn clean install -DskipTests
cd ..

cd discovery
mvn clean install -DskipTests
cd ..

cd gateway
mvn clean install -DskipTests
cd ..

cd user
mvn clean install -DskipTests
cd ..

cd chat-api
mvn clean install -DskipTests
cd ..

cd chat
mvn clean install -DskipTests
cd ..

cd order-api
mvn clean install -DskipTests
cd ..

cd order
mvn clean install -DskipTests
cd ..

cd map-api
mvn clean install -DskipTests
cd ..

cd map
mvn clean install -DskipTests
cd ..

cd user-api
mvn clean install -DskipTests
cd ..
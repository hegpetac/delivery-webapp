#docker network create delivery-cloud

cd config
docker build -t delivery-webapp/config .
cd ..

cd discovery
docker build -t delivery-webapp/discovery .
cd ..

cd gateway
docker build -t delivery-webapp/gateway .
cd ..

cd user
docker build -t delivery-webapp/user .
cd ..

cd chat
docker build -t delivery-webapp/chat .
cd ..

cd order
docker build -t delivery-webapp/order .
cd ..

cd map
docker build -t delivery-webapp/map .
cd ..

cd delivery-webapp-client
docker build -t delivery-webapp/frontend .
cd ..
# Use node alpine as base image
FROM node:alpine as build

# Set working directory
WORKDIR /app

RUN npm install -g @angular/cli@14

# Copy package.json and package-lock.json
COPY package.json /app/package.json
COPY package-lock.json /app/package-lock.json

# Install dependencies
RUN npm install

# Copy source files
COPY . .

# Build Angular app
RUN ng build --output-path=dist

# Use Nginx as base image for serving static files
FROM nginx:alpine

# Copy built files from previous stage
COPY --from=build /app/dist/* /usr/share/nginx/html/

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]

# Expose port 80
EXPOSE 80



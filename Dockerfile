# Use a Java base image
FROM openjdk:11

# Set the working directory
WORKDIR /usr/src/myapp/src

# Copy the Java application JAR file to the container
COPY . /usr/src/myapp

# Define the entry point and command to run the application
CMD ["java", "Main"]

# Mount the batch data folder
VOLUME /app/data/batch

RUN javac Main.java

# Build the Docker image:
# docker build -t admin-view .
#  docker run -v "F:\MARWAN FCAI\4th Year\8th SEMESTER\Cloud Computing\Tasks\Assignment2\StudentRegister\Main-DB.txt:/app/data/Main-DB.txt" -v "F:\MARWAN FCAI\4th Year\8th SEMESTER\Cloud Computing\Tasks\Assignment2\StudentRegister\batch:/app/data/batch" admin-view

# For Docker compose run
#  docker-compose run --rm student-register
#  docker-compose run --rm admin-view
# docker-compose up

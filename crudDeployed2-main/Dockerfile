FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Maven wrapper copy karo
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Saara code copy karo aur build karo
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Jar ko app.jar naam do
RUN mv target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

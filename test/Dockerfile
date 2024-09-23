# 1. JDK 이미지 사용
FROM eclipse-temurin:17-jre-jammy

# 2. 작업 디렉토리 생성
WORKDIR /app

# 3. Gradle 빌드로 생성된 JAR 파일 복사
COPY build/libs/test-0.0.1-SNAPSHOT.jar /app/kopring-app.jar

# 4. 애플리케이션 실행 명령어
ENTRYPOINT ["java", "-jar", "/app/kopring-app.jar"]
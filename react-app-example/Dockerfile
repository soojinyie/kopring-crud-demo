# 1. Node.js 이미지로 React 애플리케이션 빌드
FROM node:16 AS build

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 패키지 설치 및 빌드 실행
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# 4. Nginx를 사용하여 정적 파일 제공
FROM nginx:alpine

# 5. Nginx 설정 파일을 복사
COPY --from=build /app/build /usr/share/nginx/html
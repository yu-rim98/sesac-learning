# 해당 도커 파일을 기반으로 이미지를 생성함
# 즉, 해당 파일의 설정 값을 가진 컨테이너를 생성하기 위한 작업

# 기본 형식
# FROM <이미지>:<태그>
# FROM mysql:latest
# FROM mysql:8
FROM alpine:3.19


# WORKDIR <폴더이름>
# WORKDIR /app
# WORKDIR /home/test/myapp
# 컨테이너 실행 시 작업 폴더 지정함
# app 폴더를 생성하고 그 위치에서 실행함
WORKDIR /app


# RUN <리눅스 커맨드>
RUN apk add --no-cache curl


# COPY <타겟파일> <복사할위치>
# /app 내부에 해당 파일을 복사함 (WORKDIR을 /app으로 지정했기 때문)
COPY hello.txt .

# CMD ["ARG1", "ARG2", ...]
# hello.txt 파일을 출력해달라는 명령어
CMD ["cat", "hello.txt"]

# ENV key=value
ENV MY_NAME=KIM
ENV MY_ENV=LOCAL

# 빌드 명령어
# 실행할 Dockerfile이 존재하는 폴더 안에서 명령어를 실행해야 함
# docker build -t <이미지명>:<태그> <빌드컨텍스트>
# <이미지명>:<태그> -> 도커 파일을 기반으로 생성할 이미지의 이름과 태그 이름을 작성해야 함

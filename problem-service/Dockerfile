# 使用 Maven 镜像构建阶段
FROM maven:3.8.4-openjdk-17 AS build

# 设置工作目录
WORKDIR /app

# 将项目的 pom.xml 文件复制到容器中
COPY pom.xml .

# 下载 Maven 依赖
RUN mvn dependency:go-offline -B

# 将项目源代码复制到容器中
COPY src ./src

# 使用 Maven 打包项目
RUN mvn clean package -DskipTests

# 使用 OpenJDK 作为运行时环境
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 从构建阶段复制打包好的 JAR 文件到运行时环境
COPY --from=build /app/target/problem-service-0.0.1-SNAPSHOT.jar ./app.jar

# 暴露应用程序运行的端口
EXPOSE 8080

# 设置容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]

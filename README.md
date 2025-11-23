# Java Starter Template

这是一个基于 Maven 的多模块 Java 项目模板，展示了如何组织和管理 Java 项目的核心模块和业务模块。

## 项目结构

```
starter-java/
├── pom.xml                    # 父 POM，管理整个项目
├── apps/
│   ├── _example/              # 业务示例模块
│   │   ├── pom.xml
│   │   └── src/main/java/<groupId>/example/
│   │       └── ...
│   └── ...
│
├── packages/
│   ├── core/                  # 核心模块 - 通用功能封装
│   │   ├── pom.xml
│   │   └── src/main/java/<groupId>/core/
│   │       └── ...
│   └── ...
│
└── README.md                  # 本文档
```

## 模块说明

### Core 模块 (starter-java-core)
- **作用**: 提供通用的工具类、基础功能和共享组件
- **包名**: `<groupId>.core`
- **其他模块如何引用**: 在 POM 中添加依赖
```xml
<dependency>
    <groupId>${project.groupId}</groupId>
    <artifactId>starter-java-core</artifactId>
</dependency>
```

### Web 模块 (starter-java-web)
- **作用**: 示例业务模块，展示如何引用 core 模块
- **包名**: `<groupId>.web`
- **依赖**: 自动引用 core 模块

## 如何使用此模板

### 1. 克隆或下载模板
```bash
git clone <template-repo-url>
cd starter-java
```

### 2. 自定义项目信息
修改根目录下的 `pom.xml` 文件：
```xml
<project>
    <groupId>com.yourcompany</groupId>  <!-- 修改为你的公司或组织标识 -->
    <artifactId>your-project-parent</artifactId>  <!-- 修改为你的项目名称 -->
    <version>1.0.0</version>  <!-- 修改为你的项目版本 -->
</project>
```

### 3. 更新包名
如果你修改了 `groupId`，需要相应更新 Java 包名：
- 将 `cn.vanisper` 替换为你的 `groupId`
- 更新所有 Java 文件中的 package 声明
- 重命名相应的目录结构

### 4. 构建项目
```bash
# 清理并编译整个项目
mvn clean compile

# 运行测试
mvn test

# 打包项目
mvn package

# 安装到本地仓库
mvn install
```

### 5. 运行示例
```bash
# 运行 core 模块
mvn exec:java -pl packages/core -Dexec.mainClass="cn.vanisper.core.Test"

# 运行 web 模块
mvn exec:java -pl packages/web -Dexec.mainClass="cn.vanisper.web.WebService"
```

## 添加新模块

### 1. 创建模块目录
```bash
mkdir -p packages/your-module/src/main/java/<groupId>/yourmodule
```

### 2. 创建模块 POM
在 `packages/your-module/` 下创建 `pom.xml`：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>__project.groupId__</groupId>
        <artifactId>starter-java-parent</artifactId>
        <version>__project.version__</version>
        <relativePath>../../pom.xml</relativePath>
    </parent>

    <artifactId>starter-java-your-module</artifactId>

    <dependencies>
        <!-- 引用 core 模块（如果需要） -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>starter-java-core</artifactId>
        </dependency>
    </dependencies>
</project>
```

### 3. 添加到父 POM
在根目录的 `pom.xml` 中添加模块：
```xml
<modules>
    <module>packages/core</module>
    <module>packages/web</module>
    <module>packages/your-module</module>  <!-- 新增 -->
</modules>
```

## 最佳实践

1. **依赖管理**: 在父 POM 的 `<dependencyManagement>` 中统一管理依赖版本
2. **版本管理**: 使用相关配置变量，确保所有模块版本一致
3. **包命名**: 遵循反向域名约定，保持与 `groupId` 一致
4. **模块职责**: 
   - core 模块：通用功能，不应依赖其他业务模块
   - 业务模块：可以依赖 core 模块，避免模块间循环依赖

## 常见问题

### Q: 如何修改 Java 版本？
A: 在父 POM 的 `<properties>` 中修改：
```xml
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
</properties>
```

### Q: 如何添加外部依赖？
A: 在父 POM 的 `<dependencyManagement>` 中添加版本管理，然后在具体模块中引用：
```xml
<!-- 父 POM 中 -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>2.7.0</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

```xml
<!-- 子模块中 -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```

## 技术栈

- Java 17
- Maven 3+
- 多模块项目结构

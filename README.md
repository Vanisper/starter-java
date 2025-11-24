# Java Starter Template

这是一个基于 Maven 的多模块 Java 项目模板，展示了如何组织和管理 Java 项目的核心模块和业务模块。

## 项目结构

```
starter-java/
├── pom.xml                    # 父 POM，管理整个项目
├── apps/
│   ├── _example/              # 业务示例模块
│   │   ├── pom.xml
│   │   └── src/main/java/<apps-groupId>/example/
│   │       └── ...
│   └── pom.xml
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

## 如何使用此模板

### 1. 克隆或下载模板
```bash
git clone <template-repo-url>
cd starter-java
```

### 2. 构建项目
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

### 3. 运行示例
```bash
# 运行 core 模块
mvn exec:java -pl packages/core -Dexec.mainClass=cn.vanisper.core.Test

# 运行示例应用
mvn exec:java -pl apps/_example -Dexec.mainClass=cn.vanisper.apps.example.Main
```

## 添加新公共模块

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
        <!-- 引用其他模块（如果需要，需要注意避免循环引用） -->
        <dependency>
            <groupId>${root.groupId}</groupId>
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
    <module>packages/your-module</module>  <!-- 新增 -->
</modules>
```

### 4. 配置公用引用依赖版本
如果需要将此模块作为当前项目中的公共库，可以选择配置到根 POM 的 dependencyManagement 中：
```xml
<dependencyManagement>
    <dependencies>
        <!-- TODO: 新增这部分 -->
        <dependency>
            <groupId>${root.groupId}</groupId>
            <artifactId>starter-java-your-module</artifactId>
            <version>${root.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

这样之后只要是继承自当前根 POM 的模块，都可享用此配置，相当于 BOM 的角色。

## 最佳实践

1. **依赖管理**: 在父 POM 的 `<dependencyManagement>` 中统一管理依赖版本
2. **版本管理**: 使用相关配置变量，确保所有模块版本一致
3. **包命名**: 遵循反向域名约定，保持与 `groupId` 一致

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

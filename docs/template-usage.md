# 模板使用指南

## 快速开始

### 1. 项目定制
修改根目录 `pom.xml` 中的项目信息：

```xml
<project>
    <groupId>com.yourcompany</groupId>
    <artifactId>your-project-parent</artifactId>
    <version>1.0.0</version>
</project>
```

### 2. 包名更新
批量替换包名：
```bash
# 查找需要替换的文件
find . -name "*.java" -type f

# 替换包名（示例）
find . -name "*.java" -type f -exec sed -i '' 's/cn\.vanisper/com\.yourcompany/g' {} \;
```

### 3. 目录重命名
```bash
# 重命名核心目录
mv packages/core/src/main/java/cn/vanisper packages/core/src/main/java/com/yourcompany

# 重命名其他模块目录...
```

## 模块引用示例

### 引用 Core 模块
在你的模块 POM 中添加：
```xml
<dependencies>
    <dependency>
        <groupId>${project.groupId}</groupId>
        <artifactId>starter-java-core</artifactId>
    </dependency>
</dependencies>
```

### Java 代码中使用
```java
import com.yourcompany.core.SomeUtility;

public class YourClass {
    public void yourMethod() {
        SomeUtility.doSomething();
    }
}
```

## 构建命令

```bash
# 完整构建
mvn clean install

# 单独构建模块
mvn clean install -pl packages/core

# 跳过测试构建
mvn clean install -DskipTests
```

## 注意事项

1. 确保所有模块的 `groupId` 与父项目一致
2. 使用相关配置变量，保证版本一致性
3. Core 模块不应依赖其他业务模块
4. 业务模块可以依赖 Core 模块，但避免循环依赖

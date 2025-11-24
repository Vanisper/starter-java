# 模板使用指南

## 模块引用示例

### 引用 Core 模块
在你的模块 POM 中添加（确保继承自根 POM）：
```xml
<dependencies>
    <dependency>
        <groupId>${root.groupId}</groupId>
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

## init maven wrapper

> https://maven.apache.org/tools/wrapper/
> 
> 默认 distributionType 可能是 only-script 模式
> 
> 如果要内置 wrapper 的 jar 包，则需要指定 `-Dtype=bin` 参数
> 
> `-Dtype=source` 会添加 `.mvn/wrapper/MavenWrapperDownloader.java` 文件
> 
> 可以先用 `-Dtype=source` 执行，之后手动下载 maven-wrapper jar 包放在项目内
> 

```shell
mvn -N wrapper:wrapper -Dtype=source
```

> https://juejin.cn/post/7358704845736525835
> 
> 选项 -N 参数表示非递归，因此 Maven Wrapper 只会在项目的当前目录生成，如果项目中有子模块，那么则不会作用到子模块中。
> 

指定版本号
```shell
mvn -N wrapper:wrapper -Dtype=source -Dmaven=3.9.5
```

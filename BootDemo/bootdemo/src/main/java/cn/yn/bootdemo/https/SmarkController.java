package cn.yn.bootdemo.https;
/*
1. 进入到jdk\bin目录下执行命令
C:\Program Files\Java\jdk1.8.0_191\bin>
keytool -genkey -alias springboot -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -keystore E:/springboot.keystore -storepass 123456

alias : 别名
keyalg : 加密算法
validity : 有效期 单位为天
keysize : 秘钥长度
2. 将springboot.keystore放置在resources下
3. 配置
server.ssl.key-password=123456
server.ssl.key-store=classpath:springboot.keystore
server.ssl.key-alias=springboot

 */
public class SmarkController {
}

# Yivesmirror
A Library for using the Yivesmirror API
https://yivesmirror.com/apis
# Info
Java 11 is required !

# How to use
## Add to maven
### Add the repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
     	<url>https://jitpack.io</url>
    </repository>
</repositories>
```
### Add the dependency
```xml
<dependency>
    <groupId>com.github.Open-Cloud-Services</groupId>
    <artifactId>Yivesmirror</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```
## use
```java
//create an instance
Yivesmirror yivesmirror = new Yivesmirror();
//get server softwares; select the first
ServerSoftwareName name = yivesmirror.getServerSoftwareNames().get(0);
//get versions of the server softwares; select the first; get Serversoftware
ServerSoftware software = name.getVersions().get(0).getServerSoftware();
//get a input stream / download
software.download();
```

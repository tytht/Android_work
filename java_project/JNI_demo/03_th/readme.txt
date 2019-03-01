javac JNIDemo.java
gcc -I/usr/lib/jvm/java-1.7.0-openjdk-amd64/include/ -fPIC -shared -o libnative.so native.c
export LD_LIBRARY_PATH=.
java JNIDemo 

注意：
1.编译成C库的操作中若没有加-fPIC会报错“Couldn't read symbols”.
2.需要设置环境变量LD_LIBRARY_PATH，否则“no native in java.library.path”
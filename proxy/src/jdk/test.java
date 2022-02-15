package jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class test {
    public static void main(String[] args) throws Exception {
        Person jdkProxy = (Person) new JDKProxy().getInstance(new QYQ());
        jdkProxy.eat();

        /**
         * 字节码重组
         * 1、拿到代理对象的引用，并获取到他的所有接口，反射获取
         * 2、JDKProxy重新生成新的类、同时新的类要实现代理类所实现的所有接口
         * 3、动态生成Java代码，在把自己新加的业务逻辑方法由一定的而逻辑代码调用（代码体现）
         * 4、编译成.class
         * 5、重新加载到JVM运行
         */
        /**
         * JDK规范，一般$开头的类都是自动生成
         *
         * 通过反编译查看源代码
         */
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}

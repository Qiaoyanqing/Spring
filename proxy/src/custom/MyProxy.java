package custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

public class MyProxy {

    public static final String HH = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) throws Exception {
        //1、动态生成源代码.java
        String javaFile = generateSrc(interfaces);
        //2、将源代码输出到磁盘
        File file = new File(Objects.requireNonNull(MyProxy.class.getResource("")).getPath() + "$Proxy0.java");
        System.out.println(Objects.requireNonNull(MyProxy.class.getResource("")).getPath());
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(javaFile);
        fileWriter.flush();
        fileWriter.close();
        //3、编译源代码
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        manager.close();
        //4、将.class文件加载到JVM
        Class<?> proxyClass = classLoader.findClass("$Proxy0");
        Constructor<?> constructor = proxyClass.getConstructor(MyInvocationHandler.class);
        //删除Java文件
        file.delete();
        //5、返回字节码重组后的新的代理对象
        return constructor.newInstance(h);
    }

    private static String generateSrc (Class<?>[] interfaces) {
        //源代码实际上就是拼接字符串
        StringBuilder sb = new StringBuilder();
        //拼代码
        sb.append("package proxy.src.custom;" + HH);
        //import，省略
        sb.append("public class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(HH);
        //生成方法
        for (Method method : interfaces[0].getMethods()) {
            sb.append("public ").append(method.getReturnType().getName()).append(" ").append(method.getName()).append("() {").append(HH);
            sb.append("}" + HH);
        }
        sb.append("}" + HH);
        return sb.toString();
    }
}

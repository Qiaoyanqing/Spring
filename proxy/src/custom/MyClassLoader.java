package custom;

import java.io.*;

public class MyClassLoader extends ClassLoader{

    private File classFile;

    public MyClassLoader () {
        String path = MyClassLoader.class.getResource("").getPath();
        this.classFile = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classFile != null) {
            File file = new File(classFile, name.replaceAll("\\.", "/" + ".class"));
            if (file.exists()) {
                FileInputStream inputStream = null;
                ByteArrayOutputStream outputStream = null;

                try {
                    inputStream = new FileInputStream(file);
                    outputStream = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, len);
                    }
                    return defineClass(className, outputStream.toByteArray(), 0, outputStream.size());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != inputStream) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != outputStream) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

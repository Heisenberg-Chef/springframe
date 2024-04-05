package org.heisenberg.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource{

    private final String path;

    public ClassPathResource(String path)
    {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // 通过我们定义类型的类加载器，可以获得文件读取的路径信息
        // maven项目的打包过程，会把resources中定义的文件放入根目录中
        // 在这里如果我们需要获取一些xml文件，直接写根目录相对坐标就行。
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if(is == null)
        {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}

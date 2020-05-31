package lesson2;

import org.junit.Test;

import java.io.InputStream;

public class ClassLoaderTest {
    @Test
    public void t1() {
        //通过class获取资源/或流对象
        InputStream inputStream = this.getClass().getResourceAsStream("data/随便.txt");
        System.out.println(inputStream);
        //通过classLoader获取io流:以整个项目编译的根路径作为相对位置
        InputStream inputStream2 = this.getClass().getClassLoader().getResourceAsStream("data/随便.txt");
        System.out.println(inputStream2);

    }
}

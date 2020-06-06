package practice0601;

import org.junit.Test;
import sun.util.locale.provider.JRELocaleProviderAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOTest {
    @Test
    public void t1() throws IOException {
        //第一种方式: 使用FileInputStream + 绝对路径
        FileInputStream fis = new FileInputStream(new File("D:\\JavaWeb\\io-study\\data\\随便.txt"));
        //第二种方式: 使用ClassLoader + 相对路径
        //abcdefg
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);

        }
    }
}

package lesson2;

import org.junit.Test;

import java.io.*;

public class FileIoTest {
    @Test
    public void t1() throws IOException {
        FileInputStream fis = null;
        try {
            //第一种方式:使用FileInputStream + 绝对路径
            //fis = new FileInputStream(new File("D:\\JavaWeb\\io-study\\data\\随便.txt"));
            //第二种方式:使用ClassLoader + 相对路径(推荐)
            fis = (FileInputStream) this.getClass().getClassLoader().getResourceAsStream("随便.txt");
            //abcdefg
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

    }

    @Test
    public void t2() throws IOException {
        FileReader reader = new FileReader("D:\\JavaWeb\\io-study\\data\\随便.txt");
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            System.out.println(s);
        }

    }

    @Test
    public void t3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\JavaWeb\\io-study\\data\\随便.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}

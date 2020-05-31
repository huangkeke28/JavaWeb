package pratice0531;

import org.junit.Test;

import java.io.*;

public class FileIOTest {

    @Test
    public void t1() throws IOException {
        FileInputStream fis = null;
        //使用fileInputStream + 绝对路径
        try {
            fis = new FileInputStream(new File("D:\\JavaWeb\\io-study\\data\\随便.txt"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes,0,len);
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
        //覆盖的方式
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaWeb\\io-study\\data\\随便.txt");
        //追加到文件末尾
       //FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaWeb\\io-study\\data\\随便.txt",true);
//        PrintWriter printWriter = new PrintWriter(fileOutputStream,true);//自动刷新缓冲区
//        printWriter.println("追加1");
//        printWriter.println("追加2");
//        printWriter.println("追加3");
        //printWriter.flush();//手动刷新缓冲区
        OutputStreamWriter ows = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter  = new BufferedWriter(ows);
        bufferedWriter.write("追加1");
        bufferedWriter.newLine();
        bufferedWriter.write("追加2");
        bufferedWriter.flush();
    }

}

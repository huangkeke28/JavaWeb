package lesson2;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.junit.Test;

import java.awt.*;
import java.io.File;

public class FileTest {
    @Test
    public void t1() {
        //文件的相对路径和绝对路径?
        //绝对路径: 全路径. 相对路径: ./ (当前目录) ../ (上一级目录)
        //java项目再idea中的编译路径?
        File file = new File("D:\\JavaWeb\\io-study\\data\\随便.txt");
        System.out.println(file.exists());
        File f2 = new File("../data/随便.txt");
        System.out.println(f2.exists());
        File f3 = new File("data/随便.txt");//file类写相对路径不建议在真是的项目中使用
        //怎么查看当前代码的全部路径
        System.out.println(f3.getAbsolutePath());//获取绝对路径
        System.out.println(f3.exists());//文件是否存在
        System.out.println(f3.getPath());//获取路径
        System.out.println(f3.lastModified());//上次修改时间

    }

    @Test
    public void t2() {
        File f5 = new File("D:\\JavaWeb\\io-study");
        File[] children = f5.listFiles();//返回目录下一级的子文件/子文件夹数组
        for (File child : children) {
            System.out.println(child.getName());
        }
    }



}

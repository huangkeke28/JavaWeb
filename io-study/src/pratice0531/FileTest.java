package pratice0531;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    @Test
    public void t1() {
        File f1 = new File("D:\\JavaWeb\\io-study");
        File[] children = f1.listFiles();
        for (File child : children) {
            System.out.println(child.getName());
        }
    }

    @Test
    public void t2() {
        File file = new File("D:\\JavaWeb\\io-study");
        List<File> children = list(file);
        for (File child : children) {
            System.out.println(child.getName());
        }
    }

    public static List<File> list(File f) {
        List<File> files = new ArrayList<>();
        if (f.isFile()) {
            files.add(f);
        } else {
            //下一级子文件和子文件夹
            File[] children  = f.listFiles();
            for (File child : children) {
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;

    }
}

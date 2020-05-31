package lesson2;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintWriterTest {

    @Test
    public void t1() {
        try {
            int i = 1 / 0;
            System.out.println(1);
        } catch (ClassCastException e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            System.out.println(stringWriter.toString());
        }
        System.out.println(4);

    }
}

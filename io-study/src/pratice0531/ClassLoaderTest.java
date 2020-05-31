package pratice0531;

import org.junit.Test;

import java.io.InputStream;

public class ClassLoaderTest {
    @Test
    public void t1() {
        InputStream inputSteam =  this.getClass().getResourceAsStream("data/随便.txt");
        System.out.println(inputSteam);
        InputStream inputSteam2 =  this.getClass().getClassLoader().getResourceAsStream("data/随便.txt");
        System.out.println(inputSteam2);
    }
}

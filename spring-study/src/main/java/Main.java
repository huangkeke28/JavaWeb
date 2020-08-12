import frank.Duck3;
import frank.DuckShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /**
         * spring开启容器的方式:applicationContext 应用上下文(可以配置并管理bean对象,及其他的工作)
         *ClassPathXmlApplicationContext根据classpath路径,指定一个xml文件(配置文件),并根据配置文件完成配置工作(如bean实例化对象)
         */
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
       //通过bean的名称获取bean对象,bean的名称就是xml中bean的id
        //String bit = (String)context.getBean("bit");
       // String bit2 = (String)context.getBean("string");
       // System.out.println(bit);
       // System.out.println(bit2);

        //通过类型获取bean对象,如果该类型有多个对象就会报错,只支持一个该类型的对象
        //context.getBean(String.class);

        Duck3 duck1 = (Duck3)context.getBean("duck1");
        System.out.println(duck1);

        DuckShop ds = (DuckShop)context.getBean("shop");
        System.out.println(ds);
        //Spring Boot
        //作用:减少配置性的工作
        //如web项目传统开发步骤
        //(1)创建web项目结构,包括web资源文件夹和web.xml
        //(2)使用spring FrameWork配置很多xml文件 文件中配置很多内容
        //(3)部署到tomcat
    }
}
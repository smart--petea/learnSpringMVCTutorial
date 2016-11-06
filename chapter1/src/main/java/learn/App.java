package learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.bean.Product;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Product product1 = context.getBean("product", Product.class);
        product1.setName("Excellent snake oil");
        System.out.println("prodct1: " + product1.getName());

        System.out.println("");

        LocalDate localDate = context.getBean("localDate", LocalDate.class);
        System.out.println(localDate);
    }
}

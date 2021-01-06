package ma.ensa;

import ma.ensa.aspects.LoggingHandler;
import ma.ensa.beans.Compte;
import ma.ensa.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

@ComponentScan(value = {"ma.ensa"})
public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("SpringContext.xml");
        IMetier iMetier= (IMetier) applicationContext.getBean("compteProxy");
        iMetier.retirer(100);
        iMetier.verser(300);
    }
}

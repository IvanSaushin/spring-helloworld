import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean1 = (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");

        Cat cat1 = (Cat) applicationContext.getBean("cat");
        Cat cat2 = (Cat) applicationContext.getBean("cat");

        // was
//        boolean beanComparion = bean1.equals(bean2);
//        boolean catComparion = cat1.equals(cat2);

        // correct
        boolean beanComparion = bean1 == bean2;
        boolean catComparion = cat1 == cat2;

        System.out.println(beanComparion);
        System.out.println(catComparion);

        System.out.println(bean1.getMessage());
    }

    /*
    boolean beanComparion = bean1.equals(bean2); - в задании написано проверить
    являются ли бины одними и теме же объектами, то есть проверить ссылки,
    это делается оператором сравнения ==. Не переопределенный equals делает
    тоже самое, но если кто-то в дальнейшем переопределит equals в классе бина,
     то логика работы приложения изменится.
     */
}
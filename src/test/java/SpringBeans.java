import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangfan on 2015/8/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringBeans {

    @Test
    public void getBeans() {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }

    }
}

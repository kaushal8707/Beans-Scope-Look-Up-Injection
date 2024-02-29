package usecase_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class Application1 implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private A1 a;

	@GetMapping("/scope")
	public List<String> getBData() throws InterruptedException {
		String response1 = a.access();
		Thread.sleep(1000);
		String response2 = a.access();
		return Arrays.asList(response1,response2);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application1.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//SingletonBeanScopeTest
		A1 a1 = context.getBean("a", A1.class);
		A1 a2 = context.getBean("a", A1.class);
		System.out.println(a1.hashCode()+"===="+a2.hashCode());
		System.out.println(a1.hashCode()==a2.hashCode());

		//PrototypeTypeBeanScopeTest
		B1 b1 = context.getBean("b", B1.class);
		B1 b2 = context.getBean("b", B1.class);
		System.out.println(b1.hashCode()+"===="+b2.hashCode());
		System.out.println(b1.hashCode()==b2.hashCode());	}
}

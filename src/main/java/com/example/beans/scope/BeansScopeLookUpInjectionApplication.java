package com.example.beans.scope;

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
public class BeansScopeLookUpInjectionApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationContext context;

	@GetMapping("/scope")
	public List<String> getWeatherForecast() throws InterruptedException {
		String response1 = userService.getCurrentTempFromWeatherAPI();//2022-07-29T13:42:25.982->57
		Thread.sleep(1000);
		String response2 = userService.getCurrentTempFromWeatherAPI();//2022-07-29T13:43:25.982->57
		return Arrays.asList(response1,response2);
	}

	public static void main(String[] args) {
		SpringApplication.run(BeansScopeLookUpInjectionApplication.class, args);
	}
	//----------------------------------------------------------------------------
	@Override
	public void run(String... args) throws Exception {
		//SingletonBeanScopeTest
		UserService userService1 = context.getBean("userService", UserService.class);
		UserService userService2 = context.getBean("userService", UserService.class);
		System.out.println(userService1.hashCode()==userService2.hashCode());

		//ProtoTypeBeanScopeTest
		WeatherService weatherService1 = context.getBean("weatherService", WeatherService.class);
		WeatherService weatherService2 = context.getBean("weatherService", WeatherService.class);
		System.out.println(weatherService1.hashCode()==weatherService2.hashCode());

	}

	//----------------------------------------------------------------------------


}

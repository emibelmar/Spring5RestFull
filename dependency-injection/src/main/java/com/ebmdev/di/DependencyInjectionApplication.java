package com.ebmdev.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.ebmdev.di.attribute.Coche;
import com.ebmdev.di.autowire.CalculadoraAreaService;
import com.ebmdev.di.constructor.Coche1;
import com.ebmdev.di.lifecycle.ExplicitBean;
import com.ebmdev.di.lifecycle.LifeCycleBean;
import com.ebmdev.di.profiles.EnvironmentService;
import com.ebmdev.di.qualifiers.Animal;
import com.ebmdev.di.qualifiers.Nido;
import com.ebmdev.di.qualifiers.Perro;
import com.ebmdev.di.setter.Coche2;

@SpringBootApplication
public class DependencyInjectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

		// Uso de inyección de dependencias por atributo.
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);

		// Uso de inyección de dependencias por constructor
		Coche1 coche1 = context.getBean(Coche1.class);
		System.out.println(coche1);

		// Usuario de inyección de dependencias por setter
		Coche2 coche2 = context.getBean(Coche2.class);
		System.out.println(coche2);

		Perro perro = context.getBean(Perro.class);
		log.info("Objeto perro {}", perro.getNombre());

		// Uso de @Qualifier por contexto
		Animal animal = context.getBean("pajaro", Animal.class);
		log.info("Animal nombre = {}, edad = {}", animal.getNombre(), animal.getEdad());

		// Uso de @Qualifier a partir de @Autowired
		Nido nido = context.getBean(Nido.class);
		nido.imprimir();

		// Uso de @Primary en la clase Perro.
		Animal animal1 = context.getBean(Animal.class);
		log.info("Animal nombre = {}, edad = {}", animal1.getNombre(), animal.getEdad());

		// Perfil activo mediante spring.profiles.active en application.properties,
		// también se puede incluir en los arguments de la VM.
		EnvironmentService environmentService = context.getBean(EnvironmentService.class);
		log.info("Active environment {}", environmentService.getEnvironment());

		// Uso de la declaración explícita @Bean
		String nombreAplicacion = context.getBean(String.class);
		log.info("Nombre aplicación = {}", nombreAplicacion);

		// Uso de @Autowired en listas + usando areas.properties para los valores de los
		// lados y radio del cuadrado y círculo respectivamente.
		CalculadoraAreaService calculadoraAreaService = context.getBean(CalculadoraAreaService.class);
		log.info("Area total = {}", calculadoraAreaService.calcAreas());

		// Uso de SpelExpressionParser
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("10 eq 20");
		log.info("Resultado = {}", expression.getValue());
		
		
		LifeCycleBean bean = context.getBean(LifeCycleBean.class);
		
	}

	@Bean
	public String getApplicationName() {
		return "ebmdevapp";
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ExplicitBean getBean() {
		return new ExplicitBean();
	}

}

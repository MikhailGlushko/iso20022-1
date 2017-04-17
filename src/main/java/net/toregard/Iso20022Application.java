package net.toregard;


import net.toregard.config.SpringApplicationContextInitializer;
import net.toregard.entities.Product;
import net.toregard.persistence.ProductRepository;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Iso20022Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Iso20022Application.class).
				initializers(new SpringApplicationContextInitializer())
				.application()
				.run(args);
	}

	@Bean
	public ServletRegistrationBean cxfServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}



	/**
	 * Add Account data for dev.db memory running scenarie
	 * @param
	 *
	 * @return
	 */
	//@Profile({"in-memory"})
	@Bean
	@Profile("dev")
	CommandLineRunner init(final  ProductRepository productRepository
						   ) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				productRepository.saveAndFlush(Product.builder().price(100).name("P1").description("D1").build());
				productRepository.saveAndFlush(Product.builder().price(200).name("P2").description("D2").build());
				productRepository.saveAndFlush(Product.builder().price(300).name("P3").description("D3").build());
//				roleRepository.saveAndFlush(Role.builder().role("admin").build());
//				roleRepository.saveAndFlush(Role.builder().role("anybody").build());
//				roleRepository.saveAndFlush(Role.builder().role("loggedin").build());
//				Account aa =Account.builder().username("test").password("rest").build();
//				List<Role> roles = new ArrayList<Role>();
//				roles.add(roleRepository.findByRole("anybody"));
//				aa.setRoles(roles);
//				accountRepository.save(aa);

//				List<Account> a =accountRepository.findAll();
//				for(Account item : a){
//					System.out.println(item);
//				}

					}
		};
	}
}



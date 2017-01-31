package net.toregard;

import net.toregard.config.SpringApplicationContextInitializer;
import net.toregard.entities.Account;
import net.toregard.entities.Role;
import net.toregard.persistence.AccountRepository;
import net.toregard.persistence.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
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

	/**
	 * Add Account data for db memory running scenarie
	 * @param accountRepository
	 * @return
	 */
	@Profile({"in-memory"})
	@Bean
	CommandLineRunner init(final AccountRepository accountRepository,
						   final RoleRepository roleRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {

				roleRepository.saveAndFlush(Role.builder().role("admin").build());
				roleRepository.saveAndFlush(Role.builder().role("anybody").build());
				roleRepository.saveAndFlush(Role.builder().role("loggedin").build());

				Account aa =Account.builder().username("test").password("rest").build();

				List<Role> roles = new ArrayList<Role>();
				roles.add(roleRepository.findByRole("anybody"));
				aa.setRoles(roles);
				accountRepository.save(aa);



//				List<Account> a =accountRepository.findAll();
//				for(Account item : a){
//					System.out.println(item);
//				}
			}
		};
	}
}



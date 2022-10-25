package com.bilalachraf.webservicetp2;

import com.bilalachraf.webservicetp2.entities.BankAccount;
import com.bilalachraf.webservicetp2.enums.AccountType;
import com.bilalachraf.webservicetp2.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class WebserviceTp2Application {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceTp2Application.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository)
	{
		return args-> {
			for (int i = 0; i <10; i++) {
				bankAccountRepository.
					save(
						BankAccount.
							builder().
							id(
								UUID.randomUUID().toString()
							).
							balance((1+Math.random()*10)*1000).
							dateCreated(new Date()).
							currency("MAD").
							type(
								Math.random() > 0.5 ?
									AccountType.CURRENT_ACCOUNT:
									AccountType.SAVING_ACCOUNT
							).
							build()
					);
			}
		};
	}

}

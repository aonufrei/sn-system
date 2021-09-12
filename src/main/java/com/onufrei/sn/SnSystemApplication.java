package com.onufrei.sn;

import com.onufrei.sn.dto.AccountDto;
import com.onufrei.sn.model.Account;
import com.onufrei.sn.service.impl.AccountServiceImpl;
import com.onufrei.sn.service.intf.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SnSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SnSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}

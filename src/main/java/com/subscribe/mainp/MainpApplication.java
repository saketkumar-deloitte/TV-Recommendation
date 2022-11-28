package com.subscribe.mainp;

import com.subscribe.mainp.entity.History;
import com.subscribe.mainp.entity.Ott;
import com.subscribe.mainp.entity.User;
import com.subscribe.mainp.repository.HistoryRepository;
import com.subscribe.mainp.repository.OttRepo;
import com.subscribe.mainp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class MainpApplication {
	//Parv


	public static void main(String[] args) {
		SpringApplication.run(MainpApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

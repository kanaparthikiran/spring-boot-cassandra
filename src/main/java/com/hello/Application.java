package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.config.EnableCassandraAuditing;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.hello.service.HotelService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableCassandraAuditing
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableCassandraRepositories
@ComponentScan({"com.hello"})
@Slf4j
public class Application implements ApplicationRunner {

	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) throws Exception {
		log.info("Started Executing the Application");
		SpringApplication.run(Application.class, args);
		log.info("Completed Executing the Application");
	}
	
	   @Override
	   public void run(ApplicationArguments arg0) throws Exception {
		   hotelService.testAllOperations();
	    	log.info("Completed updating the data in to the database ");
	   }

}

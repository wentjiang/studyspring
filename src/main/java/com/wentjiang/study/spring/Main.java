package com.wentjiang.study.spring;

import com.wentjiang.study.spring.dao.CustomerRepository;
import com.wentjiang.study.spring.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jiangwentao on 2017/5/10 10:24.
 */
@Slf4j
@EnableScheduling
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @Bean
    public CommandLineRunner demo(final CustomerRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                repository.save(new Customer("Jack", "Bauer"));
                repository.save(new Customer("Chloe", "O'Brian"));
                repository.save(new Customer("Kim", "Bauer"));
                repository.save(new Customer("David", "Palmer"));
                repository.save(new Customer("Michelle", "Dessler"));

                // fetch all customers
                log.info("Customers found with findAll():");
                log.info("-------------------------------");
                for (Customer customer : repository.findAll()) {
                    log.info(customer.toString());
                }
                log.info("");

                // fetch an individual customer by ID
                Customer customer = repository.findOne(1L);
                log.info("Customer found with findOne(1L):");
                log.info("--------------------------------");
                log.info(customer.toString());
                log.info("");

                // fetch customers by last name
                log.info("Customer found with findByLastName('Bauer'):");
                log.info("--------------------------------------------");
                for (Customer bauer : repository.findByLastName("Bauer")) {
                    log.info(bauer.toString());
                }
                log.info("");
            }
        };
    }

}

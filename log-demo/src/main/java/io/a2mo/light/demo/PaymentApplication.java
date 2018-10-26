package io.a2mo.light.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
@EnableJpaRepositories(considerNestedRepositories = true)
public class PaymentApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentApplication.class);

    @Autowired
    private PaymentJPA paymentJPA;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        LOGGER.info("Debuging Hello...");
        return UUID.randomUUID().toString();
    }

    @GetMapping("/payment")
    public Payments getPayment() {
        Payments payments = paymentJPA.save(new Payments(UUID.randomUUID().toString(), 233d));
        LOGGER.info("GET Payments... {} ", payments.toString());
        return payments;
    }


    @Repository
    interface PaymentJPA extends CrudRepository<Payments, Long> {

    }


}



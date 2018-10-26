package io.a2mo.light.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AccountDetailEndpoints {


    @GetMapping("/account")
    public String getAccountNumber() {
        return UUID.randomUUID().toString();
    }

}

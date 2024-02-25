package com.customerintelligence.mcg.pruebatecnica.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages={"com.customerintelligence.mcg.pruebatecnica"})
@EnableFeignClients(basePackages = "com.customerintelligence.mcg.pruebatecnica") // Specify the package where your Feign client is located
public class PruebaTecnicaCustomerIntelligenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaCustomerIntelligenceApplication.class, args);
    }
}

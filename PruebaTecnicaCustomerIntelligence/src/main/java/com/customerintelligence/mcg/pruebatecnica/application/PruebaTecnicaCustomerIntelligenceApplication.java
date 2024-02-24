package com.customerintelligence.mcg.pruebatecnica.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Clase principal de la aplicación que inicia el contexto de Spring Boot para la Prueba Técnica de Customer Intelligence.
 * Esta clase es responsable de iniciar la aplicación Spring Boot y configurar los componentes necesarios, como el escaneo de paquetes y la habilitación de clientes Feign.
 * El escaneo de paquetes se configura para incluir todos los componentes de la aplicación bajo el paquete base 'com.customerintelligence.mcg.pruebatecnica'.
 * Se habilita la funcionalidad de Feign para consumir servicios REST de manera declarativa, especificando el paquete donde se encuentran los clientes Feign.
 * Esta aplicación proporciona un punto de entrada para iniciar el servidor web y ejecutar la Prueba Técnica de Customer Intelligence.
 *
 * Main class of the application that starts the Spring Boot context for the Customer Intelligence Technical Test.
 * This class is responsible for initiating the Spring Boot application and configuring necessary components, such as package scanning and enabling Feign clients.
 * Package scanning is configured to include all application components under the base package 'com.customerintelligence.mcg.pruebatecnica'.
 * Feign functionality is enabled to consume REST services in a declarative manner by specifying the package where Feign clients are located.
 * This application provides an entry point to start the web server and run the Customer Intelligence Technical Test.
 *
 * @author Manuel Cortés Granados (manuelcortesgranados@gmail.com)
 * @since 24 Febrero 2024 8:00 AM -5:00 GMT Bogotá D.C. Colombia
 */


@SpringBootApplication(scanBasePackages={"com.customerintelligence.mcg.pruebatecnica"})
@EnableFeignClients(basePackages = "com.customerintelligence.mcg.pruebatecnica") // Specify the package where your Feign client is located
public class PruebaTecnicaCustomerIntelligenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaCustomerIntelligenceApplication.class, args);
    }

}

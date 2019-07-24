package com.servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Representa a aplicacao servidor.
 *
 */
@SpringBootApplication
public class ServerApplication {

  /**
   * Funcao principal utilizada para iniciar a aplicacao.
   *
   * @param args
   */
    public static void main(String[] args) {
        // inicializa a aplicacao Spring Boot
        SpringApplication.run(ServerApplication.class, args);
    }
}
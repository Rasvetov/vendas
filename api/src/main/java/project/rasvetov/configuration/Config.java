package project.rasvetov.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

//Classe responsável pela configuração do projeto
@Development
public class Config {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }

}

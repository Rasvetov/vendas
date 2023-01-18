package project.rasvetov;



// classe responsável pela aplicação do projeto

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.rasvetov.model.Cliente;
import project.rasvetov.repositories.ClientesRepository;

import java.util.List;

@SpringBootApplication
public class VendasApllication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository){
        return args -> {
            System.out.println("salvando clientes ");
            clientesRepository.salvar(new Cliente(1,"Ivan"));
            clientesRepository.salvar(new Cliente(2,"outro cliente"));

            List<Cliente> todosClientes = clientesRepository.oberTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("atualizando clientes ");
            todosClientes.forEach(c ->{
                c.setNome(c.getNome() + " atualizado.");
                clientesRepository.atualizar(c);
            });

            todosClientes = clientesRepository.oberTodos();
            todosClientes.forEach(System.out::println);


            System.out.println("buscando clientes");
            clientesRepository.buscarPorNome("Cli").forEach(System.out::println);

            System.out.println("deletando clientes ");
            clientesRepository.oberTodos().forEach(c ->{
                clientesRepository.deletar(c);
            });

            todosClientes = clientesRepository.oberTodos();
            if(todosClientes.isEmpty()){
                System.out.println("nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
            }
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApllication.class, args);
    }
}

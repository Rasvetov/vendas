package project.rasvetov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rasvetov.model.Cliente;
import project.rasvetov.repositories.ClientesRepository;

// Classe responsável pela regra de negócio, validações, geração de relatórios e acesso a base de dados.
@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        clientesRepository.salvar(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}

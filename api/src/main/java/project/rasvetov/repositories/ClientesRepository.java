package project.rasvetov.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.rasvetov.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


// Classe responsável por acessar o banco de dados diretamente para fazer operações para o cliente
@Repository
public class ClientesRepository {

    private String INSERT = "insert into cliente (nome) values (?) ";
    private String SELECT_ALL = "SELECT * FROM CLIENTE ";
    private static String UPDATE = "update cliente set nome = ? where id = ? ";
    private static String DELETE = "delete from cliente where id = ? ";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update( INSERT, new Object[]{cliente.getNome()} );
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente){
        deletar(cliente.getId());
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Cliente> buscarPorNome(String nome){
        return jdbcTemplate.query(
                SELECT_ALL.concat("where nome like ? "),
                new Object[]{"%" + nome + "%"},
                ObterClienteMapper());
    }

    public List<Cliente> oberTodos(){
        return jdbcTemplate.query(SELECT_ALL, ObterClienteMapper());
    }

    private static RowMapper<Cliente> ObterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }
}

package project.rasvetov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//Classe responsável por criar os atributos e variáveis do usuário
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String login;
    @Column
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;
    @Column
    private boolean admin;
}

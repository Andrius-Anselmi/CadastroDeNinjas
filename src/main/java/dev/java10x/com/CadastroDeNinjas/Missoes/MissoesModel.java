package dev.java10x.com.CadastroDeNinjas.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.com.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity // As anotations elas vão ler ou até fechar as chaves ou até o ;

@Table(name = "tb_missoes") // A anotation table transforma isso em uma tabela
// tudo que esta dentro da classe MissoesModel é uma entidade


@NoArgsConstructor // construtor sem argumentos
@AllArgsConstructor // construtor com argumentos
@Data // criar os getter e setters
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;

    //@OneToMany Uma missao pode ter varios ninja
    // Toda vez que usarmos um relacionamento de tabelas usaremos o mappedBy para mapear as tabelas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninja;

}




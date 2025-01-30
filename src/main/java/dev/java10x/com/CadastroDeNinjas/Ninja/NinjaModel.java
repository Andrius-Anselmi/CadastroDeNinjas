package dev.java10x.com.CadastroDeNinjas.Ninja;
import dev.java10x.com.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // TRANSFORMA A CLASSE EM ENTIDADE no BD(Banco de Dados)
//JPA = Java Persistence API
@Table(name = "tb_cadastro")
@NoArgsConstructor // criamos um construtor sem argumentos
@AllArgsConstructor// criamos um construtor com todos os argumentos
@Data // cria os getter e os setters
public class NinjaModel{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true) // essa coluna de email é unica, não aceita itens repetidos
    private String email;

    @Column(name = "img")
    private String imgUrl;

    @Column(name = "idade")
    private  int idade ;


    // @ManyToOne Um ninja só pode ter uma unica missao ou muitos ninjas podem ter uma unica missao
    @ManyToOne
    //JoinColumn serve pra gente unir as tabelas de cadastro ninja e cadastro de missoes
    @JoinColumn(name = "missoes_id") // foreing key ou chave estrangeira
    // chave estrangeira sempre vai aparecer quando tivermos duas ou mais tabelas se relacionando

    private MissoesModel missoes;

}

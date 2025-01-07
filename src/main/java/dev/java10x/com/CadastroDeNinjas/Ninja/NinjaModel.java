package dev.java10x.com.CadastroDeNinjas.Ninja;

import dev.java10x.com.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

@Entity // TRANSFORMA A CLASSE EM ENTIDADE no BD(Banco de Dados)
//JPA = Java Persistence API
@Table(name = "tb_cadastro")

public class NinjaModel{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    private String email;

    private  int idade ;


    // @ManyToOne Um ninja só pode ter uma unica missao
    @ManyToOne
    //JoinColumn serve pra gente unir as tabelas de cadastro ninja e cadastro de missoes
    @JoinColumn(name = "missoes_id") // foreing key ou chave estrangeira

    // chave estrangeira sempre vai aparecer quando tivermos duas ou mais tabelas se relacionando
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

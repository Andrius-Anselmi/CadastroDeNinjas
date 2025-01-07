package dev.java10x.com.CadastroDeNinjas.Missoes;

import dev.java10x.com.CadastroDeNinjas.Ninja.NinjaModel;

import jakarta.persistence.*;

import java.util.List;


@Entity // As anotations elas vão ler ou até fechar as chaves ou até o ;

@Table(name = "tb_missoes") // A anotation table transforma isso em uma tabela
// tudo que esta dentro da classe MissoesModel é uma entidade
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificulade;

    //@OneToMany Uma missao pode ter varios ninja
    // Toda vez que usarmos um relacionamento de tabelas usaremos o mappedBy para mapear as tabelas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

    public MissoesModel(String nome, String dificulade) {
        this.nome = nome;
        this.dificulade = dificulade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificulade() {
        return dificulade;
    }

    public void setDificulade(String dificulade) {
        this.dificulade = dificulade;
    }



}




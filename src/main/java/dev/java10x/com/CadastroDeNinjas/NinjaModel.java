package dev.java10x.com.CadastroDeNinjas;

import jakarta.persistence.*;

//Para usar a Anottation @Entity precisamos baixar a dependencia JPA = Java Persistence API
@Entity // transforma a classe numa entidade do BD (Banco de Dados)
@Table(name = "tb_cadastro") // Criar tabela
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nome;
    int idade;
    String email;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

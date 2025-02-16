package dev.java10x.com.CadastroDeNinjas.Missoes;

import dev.java10x.com.CadastroDeNinjas.Ninja.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {

    private long id;
    private String nome;
    private String dificuldade;
    private List ninja;
}

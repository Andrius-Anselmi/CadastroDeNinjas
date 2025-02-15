package dev.java10x.com.CadastroDeNinjas.Ninja;

import dev.java10x.com.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private  int idade ;
    private String rank;
    private MissoesModel missoes;
}

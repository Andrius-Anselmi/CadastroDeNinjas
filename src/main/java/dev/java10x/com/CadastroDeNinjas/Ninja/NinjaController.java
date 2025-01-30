package dev.java10x.com.CadastroDeNinjas.Ninja;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PutMapping;
import  org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController // avisar ao java que essa classe é do tipo controller
@RequestMapping("/ninjas") // define as rotas


public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }
    //Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public String mostratTodosOsNinja() {
        return "Mostrar Ninja";
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostratTodosOsNinjaPorId() {
        return "Mostrar Ninja por ID";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Ninja alterado";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "ninja criado";
    }

}

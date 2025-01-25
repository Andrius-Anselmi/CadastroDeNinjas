package dev.java10x.com.CadastroDeNinjas.Ninja;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PutMapping;
import  org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController // avisar ao java que essa classe é do tipo controller
@RequestMapping("/ninja") // define as rotas


public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String AdicionarNinja() {

        return "Ninja criado";
    }

    //Mostrar todos os Ninjas ( READ)
    @GetMapping("/todos")
    public String MostrarTodosOsNinja() {

        return "Exibindo ninjas";
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/todosID")
    public String MostrarTodosOsNinjasPorID() {

        return "Exibindo ninjas por ID";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar")
    public String AlterarNinjaPorId() {

        return "Alterar ninja por ID";
    }

    //Deletar NINJA (DELETE)
    @DeleteMapping("/deletar")
    public String DeletarNinjaPorid() {

        return "Deletar ninja por ID";
    }
}

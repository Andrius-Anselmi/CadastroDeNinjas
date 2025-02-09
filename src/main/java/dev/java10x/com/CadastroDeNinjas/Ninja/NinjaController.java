package dev.java10x.com.CadastroDeNinjas.Ninja;
import jakarta.annotation.PreDestroy;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PutMapping;
import  org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // avisar ao java que essa classe é do tipo controller
@RequestMapping("/ninjas") // define as rotas


public class NinjaController {

    private NinjaService ninjaService; //

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }
    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel mostratTodosOsNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorID(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Ninja alterado";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "ninja deletado";
    }

}

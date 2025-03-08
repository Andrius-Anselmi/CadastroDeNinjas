package dev.java10x.com.CadastroDeNinjas.Ninja;
import jakarta.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PutMapping;
import  org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // avisar ao java que essa classe é do tipo controller
@RequestMapping("/ninjas") // define as rotas


public class NinjaController {

    private final NinjaService ninjaService; //

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira nessa rota";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaCriado = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja " + ninjaCriado.getNome() + " criado com sucesso");
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<?> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        if (ninjas.isEmpty())
            return ResponseEntity.ok(ninjas);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> ListarNinjasPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorID(id) != null) {
            NinjaDTO ninjaAchado = ninjaService.listarNinjasPorID(id);
            return ResponseEntity.status(HttpStatus.OK).body(ninjaAchado);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de id: " + id + " não encontrado em nossos registros");
    }
    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.alterarNinja(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja de (ID): " + id + " foi atualizado com sucesso");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não foi atualizado pois o ID é inexistente");
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if(ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja com o (ID): " + id + " deletado com sucesso");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }

}

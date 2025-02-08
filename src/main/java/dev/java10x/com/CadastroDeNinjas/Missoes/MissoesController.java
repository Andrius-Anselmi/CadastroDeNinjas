package dev.java10x.com.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listarid/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {

        return missoesService.listarMissoesPorId(id);
    }

    //POST -- Mandar uma requisaicao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){

        return "missoes criada";
    }

    //PUT -- Mandar uma requisicao para alterar missoes
    @PutMapping("/alterar")
    public String alterarMissao() {

        return "missoes alteradas";
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissoes() {

        return "missoes deletadas com sucesso";
    }


}

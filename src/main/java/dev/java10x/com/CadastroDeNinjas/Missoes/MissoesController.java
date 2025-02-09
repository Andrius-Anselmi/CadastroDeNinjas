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

    //POST -- Mandar uma requisaicao para criar as missoes (CREATE)
    @PostMapping("/criar")
    public String criarMissao(){

        return "missoes criada";
    }

    // GET -- Mandar uma requisicao para mostrar as missoes (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    //Mostrar Missoes por ID (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {

        return missoesService.listarMissoesPorId(id);
    }

    //PUT -- Mandar uma requisicao para alterar missoes (UPDATE)
    @PutMapping("/alterar")
    public String alterarMissaoPorId() {

        return "missoes alteradas";
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes (DELETE)
    @DeleteMapping("/deletar")
    public String deletarMissoesPorId() {

        return "missoes deletadas com sucesso";
    }

}

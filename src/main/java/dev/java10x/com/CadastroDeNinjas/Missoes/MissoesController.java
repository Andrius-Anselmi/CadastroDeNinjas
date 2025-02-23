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
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoes){
        return missoesService.criarMissao(missoes);
    }

    // GET -- Mandar uma requisicao para mostrar as missoes (READ)
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // GET -- Mandar uma requisicao para mostrar as missoes por ID (READ)
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissoesPorId(@PathVariable Long id) {

        return missoesService.listarMissoesPorId(id);
    }

    //PUT -- Mandar uma requisicao para alterar missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@RequestBody MissoesDTO missoesDTO, @PathVariable Long id) {
        return missoesService.alterarMissao(id,missoesDTO);
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorId(@PathVariable Long id) {
        missoesService.deletarMissoes(id);
    }

}

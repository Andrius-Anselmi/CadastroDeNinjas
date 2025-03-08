package dev.java10x.com.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //POST -- Mandar uma requisaicao para criar as missoes (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
        missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão: " + missoes.getNome() + " criado com sucesso");
    }

    // GET -- Mandar uma requisicao para mostrar as missoes (READ)
    @GetMapping("/listar")
    public ResponseEntity<?> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        if (missoes.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista de missões vazia");
        else
            return ResponseEntity.ok(missoes);
    }

    // GET -- Mandar uma requisicao para mostrar as missoes por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarMissoesPorId(id);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de id: " + id + " não encontrada em nossos registros");
    }

    //PUT -- Mandar uma requisicao para alterar missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissaoPorId(@RequestBody MissoesDTO missoesDTO, @PathVariable Long id) {
        MissoesDTO missoesAchada = missoesService.listarMissoesPorId(id);
        if (missoesAchada != null) {
            missoesService.alterarMissao(id, missoesDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Missão de id: " + id + " alterada com sucesso");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de id: " + id + " não encontrada em nossos registros");
    }

    //DELETE -- Mandar uma requisicao para deletar as missoes por ID (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoesPorId(@PathVariable Long id) {
        MissoesDTO missoesDeletada = missoesService.listarMissoesPorId(id);
        if (missoesDeletada != null) {
            missoesService.deletarMissoes(id);
            return ResponseEntity.status(HttpStatus.OK).body("Missão: " + missoesDeletada.getNome() + " deletada com sucesso");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de id: " + id + " não encontrada em nossos registros");

    }
}

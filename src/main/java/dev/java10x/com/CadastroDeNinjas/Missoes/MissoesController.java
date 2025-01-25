package dev.java10x.com.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")

public class MissoesController {


    // GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissoes() {

        return "Missoes listada com sucesso";
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

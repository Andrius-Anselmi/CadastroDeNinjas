package dev.java10x.com.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar Missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar Missoes por ID
    public MissoesDTO listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        MissoesDTO missoesDTO = missoesPorId.map(missoesMapper::map).orElse(null);
        return missoesDTO;
    }

    //Criar Missão
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    //Alterar Missão
    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missoesExistente = missoesRepository.findById(id);
        if(missoesExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }

        return  null;
    }

    //Deletar Missão por ID
    public void deletarMissoes(Long id) {
        missoesRepository.deleteById(id);
    }


}

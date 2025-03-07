package dev.java10x.com.CadastroDeNinjas.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll(); // vamos criar uma Lista do tipo NinjaModel, pq o banco de dados só conhece a entidade NinjaModel
        return ninjas.stream()// transforma a lista em uma Stream
                .map(ninjaMapper::map) // converte NinjaModel para NinjaDTO
                .collect(Collectors.toList()); //pega os novos valores e coloca em uma nova lista, de forma automatica
    }

    //Listar ninja por ID
    public NinjaDTO  listarNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        NinjaDTO ninjaDTO = ninjaPorId.map(ninjaMapper::map).orElse(null);
        return ninjaDTO;

    }
    //Criar ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO); // converto o ninjaDTO para um tipo de NinjaModel
        ninja = ninjaRepository.save(ninja); //salvo o ninja --> objeto de NinjaModel
        return ninjaMapper.map(ninja); // converto ninja para objeto de NinjaDTO, e retorno


    }
    //Deletar Ninja por ID
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Alterar Ninja por ID
    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id); // Optional --> retorna ou um objeto ou nada , junto com o findById, que faz essa busca
        // se o id existir o optional vai retornar algo, caso contrario não retorna nada
        if(ninjaExistente.isPresent()) { // verifica se o Optional retornou alguma coisa
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id); // SOBREESCREVER O ID
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);

        }

        return null;
    }

}

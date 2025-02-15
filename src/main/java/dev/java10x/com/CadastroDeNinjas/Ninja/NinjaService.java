package dev.java10x.com.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar ninja por ID
    public NinjaModel  listarNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
       NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
      ninja =  ninjaRepository.save(ninja);
      return ninjaMapper.map(ninja);

    }

    //Deletar Ninja por ID
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Alterar Ninja por ID
    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado) {
        if(ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}

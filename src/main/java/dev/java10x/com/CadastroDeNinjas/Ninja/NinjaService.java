package dev.java10x.com.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    private NinjaModel ninja;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os meus ninjas

    public List<NinjaModel> listarNinjas() {

        return ninjaRepository.findAll();
    }

}

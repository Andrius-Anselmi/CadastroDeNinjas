package dev.java10x.com.CadastroDeNinjas.Ninja;

import org.springframework.data.jpa.repository.JpaRepository;

interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}

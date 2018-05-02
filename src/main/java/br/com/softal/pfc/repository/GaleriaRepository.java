package br.com.softal.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softal.pfc.model.Galeria;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Integer> {

}

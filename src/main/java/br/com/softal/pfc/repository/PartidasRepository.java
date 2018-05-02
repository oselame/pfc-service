package br.com.softal.pfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softal.pfc.model.Partida;

public interface PartidasRepository extends JpaRepository<Partida, Integer> {

}

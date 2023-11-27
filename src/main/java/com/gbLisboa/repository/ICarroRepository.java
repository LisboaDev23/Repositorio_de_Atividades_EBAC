package com.gbLisboa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gbLisboa.dominio.Carro;

@Repository
public interface ICarroRepository extends CrudRepository<Carro, Long> {

}

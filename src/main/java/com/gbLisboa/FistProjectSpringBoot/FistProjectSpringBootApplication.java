package com.gbLisboa.FistProjectSpringBoot;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gbLisboa.dominio.Carro;
import com.gbLisboa.repository.ICarroRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.gbLisboa.repository")
@EntityScan("com.gbLisboa.*")
public class FistProjectSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FistProjectSpringBootApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(FistProjectSpringBootApplication.class); 
	
	@Autowired
	private ICarroRepository repository;

	@Override
	public void run(String... args) throws Exception {
		log.info("Iniciando a aplicação ...");
		Carro carro = criarCarro();
		repository.save(carro);
	}
	
	private Carro criarCarro() {
		return Carro.builder()
				.modelo("Camaro")
				.ano(2022)
				.paisFabricacao("Italia")
				.codigo("56445258822")
				.valor(500000)
				.build();
	}

}

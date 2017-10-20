package com.compucom.proyecto;

import com.compucom.proyecto.utils.storage.StorageProperties;
import com.compucom.proyecto.utils.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { ProyectodbApplication.class, Jsr310JpaConverters.class }
)

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ProyectodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectodbApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
//			storageService.deleteAll();
			storageService.init();
		};
	}
}



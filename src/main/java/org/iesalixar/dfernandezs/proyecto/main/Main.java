package org.iesalixar.dfernandezs.proyecto.main;

import org.iesalixar.dfernandezs.proyecto.ProyectoApplication;
import org.iesalixar.dfernandezs.proyecto.model.Category;
import org.iesalixar.dfernandezs.proyecto.model.Province;
import org.iesalixar.dfernandezs.proyecto.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.iesalixar.dfernandezs.proyecto.repository.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext context = SpringApplication.run(ProyectoApplication.class);
		ProvinceRepository provinceRepository = context.getBean(ProvinceRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

		
		// Provinces
		Province sevilla = new Province();
		Province malaga = new Province();
		Province jaen = new Province();
		Province granada = new Province();
		Province cordoba = new Province();
		Province almeria = new Province();
		Province huelva = new Province();
		Province cadiz = new Province();

		sevilla.setName("Sevilla");
		malaga.setName("Málaga");
		jaen.setName("Jaén");
		granada.setName("Granada");
		cordoba.setName("Córdoba");
		almeria.setName("Almeria");
		huelva.setName("Huelva");
		cadiz.setName("Cádiz");

		// Users
		User daniel = new User();
		User marina = new User();
		
		daniel.setName("Daniel");
		daniel.setLastName("Fernández Sánchez-Palencia");
		daniel.setUser("dani");
		daniel.setPassword("1234");
		daniel.setRol("admin");
		daniel.setEmail("daniel@iesalixar.org");
		
		marina.setName("Marina");
		marina.setLastName("Carrero Granados");
		marina.setUser("marina");
		marina.setPassword("1234");
		marina.setRol("user");
		marina.setEmail("marina@iesalixar.org");
		
		// Categories
		Category musica = new Category();
		Category baile = new Category();
		Category pintura = new Category();
		Category teatro = new Category();
		Category cultural = new Category();
		Category religioso = new Category();
		Category culinario = new Category();
		Category nocturno = new Category();
		Category enBarco = new Category();
		Category aireLibre = new Category();
		Category paraNinios = new Category();
		Category desfile = new Category();
		Category benefico = new Category();

		
		musica.setName("Música");
		baile.setName("Baile");
		pintura.setName("Pintura");
		teatro.setName("Teatro");
		cultural.setName("Cultural");
		religioso.setName("Religioso");
		culinario.setName("Culinario");
		nocturno.setName("nocturno");
		enBarco.setName("En barco");
		aireLibre.setName("Al aire libre");
		paraNinios.setName("Para niños");
		desfile.setName("Desfiles");
		benefico.setName("Benéficos");


		// Save Provinces
		provinceRepository.save(sevilla);
		provinceRepository.save(malaga);
		provinceRepository.save(jaen);
		provinceRepository.save(granada);
		provinceRepository.save(cordoba);
		provinceRepository.save(almeria);
		provinceRepository.save(huelva);
		provinceRepository.save(cadiz);

		// Save Users
		userRepository.save(daniel);
		userRepository.save(marina);

		// Save Categories
		categoryRepository.save(musica);
		categoryRepository.save(pintura);
		categoryRepository.save(teatro);
		categoryRepository.save(cultural);
		categoryRepository.save(religioso);
		categoryRepository.save(culinario);
		categoryRepository.save(nocturno);
		categoryRepository.save(enBarco);
		categoryRepository.save(aireLibre);
		categoryRepository.save(paraNinios);
		categoryRepository.save(desfile);
		categoryRepository.save(benefico);
		context.close();

	}

}

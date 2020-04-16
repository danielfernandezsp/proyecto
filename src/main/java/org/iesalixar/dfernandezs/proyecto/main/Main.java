package org.iesalixar.dfernandezs.proyecto.main;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.iesalixar.dfernandezs.proyecto.ProyectoApplication;
import org.iesalixar.dfernandezs.proyecto.model.Authority;
import org.iesalixar.dfernandezs.proyecto.model.Category;
import org.iesalixar.dfernandezs.proyecto.model.Comment;
import org.iesalixar.dfernandezs.proyecto.model.Event;
import org.iesalixar.dfernandezs.proyecto.model.Forum;
import org.iesalixar.dfernandezs.proyecto.model.Province;
import org.iesalixar.dfernandezs.proyecto.model.User;
import org.iesalixar.dfernandezs.proyecto.repository.AuthorityRepository;
import org.iesalixar.dfernandezs.proyecto.repository.CategoryRepository;
import org.iesalixar.dfernandezs.proyecto.repository.CommentRepository;
import org.iesalixar.dfernandezs.proyecto.repository.EventRepository;
import org.iesalixar.dfernandezs.proyecto.repository.ProvinceRepository;
import org.iesalixar.dfernandezs.proyecto.repository.UserRepository;
import org.iesalixar.dfernandezs.proyecto.repository.ForumRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Usamos encoder para encriptar las contraseñas 
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

		ConfigurableApplicationContext context = SpringApplication.run(ProyectoApplication.class);
		ProvinceRepository provinceRepository = context.getBean(ProvinceRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		EventRepository eventRepository = context.getBean(EventRepository.class);
		ForumRepository forumRepository = context.getBean(ForumRepository.class);
		CommentRepository commentRepository = context.getBean(CommentRepository.class);
		AuthorityRepository authorityRepository = context.getBean(AuthorityRepository.class);

		// Date creation
		Date date = new Date();
		
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

		// Authorities
		Authority admin = new Authority();
		Authority user = new Authority();
		
		admin.setAuthority("ADMIN");
		user.setAuthority("USER");
		
		// Users
		User daniel = new User();
		User marina = new User();
		
		Set<Authority> adminList = new HashSet<Authority>();
		adminList.add(admin);
		
		Set<Authority> userList = new HashSet<Authority>();
		userList.add(user);
		
		daniel.setName("Daniel");
		daniel.setLastName("Fernández Sánchez-Palencia");
		daniel.setUsername("dani");
		daniel.setBirthday(LocalDateTime.parse("1995-10-06t00:00:00"));
		daniel.setPassword(bCryptPasswordEncoder.encode("1234"));
		daniel.setEmail("daniel@iesalixar.org");
		daniel.setAuthority(adminList);
		
		marina.setName("Marina");
		marina.setLastName("Carrero Granados");
		marina.setUsername("marina");
		marina.setBirthday(LocalDateTime.parse("2000-05-24t00:00:00"));
		marina.setPassword(bCryptPasswordEncoder.encode("1234"));
		marina.setEmail("marina@iesalixar.org");
		marina.setAuthority(userList);
		
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

		// Events Forums
		Set<Category> categories = new HashSet<Category>();
		categories.add(religioso);
		categories.add(cultural);
		categories.add(nocturno);
		
		byte[] img = null;
		LocalDateTime dateStart = LocalDateTime.parse("2020-04-03t09:00:00");
		LocalDateTime dateEnd = LocalDateTime.parse("2020-04-13t21:00:00");		
		
		Event alcazar = new Event();
		Forum foroAlcazar = new Forum();

		foroAlcazar.setEvent(alcazar);
		
		alcazar.setDate(date);
		alcazar.setName("Real Alcazar");
		alcazar.setDescription("Visita este gran edificio con cientos de años de historia.");
		alcazar.setCategories(categories);
		alcazar.setUser(marina);
		alcazar.setForum(foroAlcazar);
		alcazar.setProvince(sevilla);
		alcazar.setCapacity(20);
		alcazar.setEnd_event(dateEnd);
		alcazar.setStart_event(dateStart);
		alcazar.setForum(foroAlcazar);
		alcazar.setImage(img);
		
		// Comments
		
		Comment comentario1 = new Comment();
		Comment comentario2 = new Comment();

		comentario1.setForum(foroAlcazar);
		comentario1.setUser(marina);
		comentario1.setDate(date);
		comentario1.setText("¡Me entantaria ir este sabado!");
		
		comentario2.setForum(foroAlcazar);
		comentario2.setUser(daniel);
		comentario2.setDate(date);
		comentario2.setText("Yo fui la semana pasada y mereció la pena.");
		
		// Save Provinces
		provinceRepository.save(sevilla);
		provinceRepository.save(malaga);
		provinceRepository.save(jaen);
		provinceRepository.save(granada);
		provinceRepository.save(cordoba);
		provinceRepository.save(almeria);
		provinceRepository.save(huelva);
		provinceRepository.save(cadiz);

		// Save Authority
		authorityRepository.save(admin);
		authorityRepository.save(user);
		
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

		// Save Events and Forums
		eventRepository.save(alcazar);
		forumRepository.save(foroAlcazar);

		// Save Comments
		commentRepository.save(comentario1);
		commentRepository.save(comentario2);
		
		
		context.close();

	}

}

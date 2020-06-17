package org.iesalixar.dfernandezs.proyecto.main;

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
import org.iesalixar.dfernandezs.proyecto.repository.ForumRepository;
import org.iesalixar.dfernandezs.proyecto.repository.ProvinceRepository;
import org.iesalixar.dfernandezs.proyecto.repository.UserRepository;
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
		almeria.setName("Almería");
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
		daniel.setPassword(bCryptPasswordEncoder.encode("1234"));
		daniel.setAuthority(adminList);
		
		marina.setName("Marina");
		marina.setLastName("Carrero Granados");
		marina.setUsername("marina");
		marina.setPassword(bCryptPasswordEncoder.encode("1234"));
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
		nocturno.setName("Nocturno");
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
		
		String img = null;
		Date dateStart = new Date();
		Date dateEnd = new Date();
		
		Event alcazar = new Event();
		Forum foroAlcazar = new Forum();

		foroAlcazar.setEvent(alcazar);
		
		alcazar.setAllow(false);
		alcazar.setDate(date);
		alcazar.setName("Real Alcázar");
		alcazar.setDescription("Visita este gran edificio con cientos de años de historia.");
		alcazar.setCategories(categories);
		alcazar.setUser(marina);
		alcazar.setForum(foroAlcazar);
		alcazar.setPlace("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2241.702970907218!2d-5.991249771931022!3d37.38399662944031!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x13815c8066798890!2sJardines%20alcazares!5e0!3m2!1ses!2ses!4v1590067726829!5m2!1ses!2ses\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\" aria-hidden=\"false\" tabindex=\"0\"></iframe>");
		alcazar.setProvince(sevilla);
		alcazar.setCapacity(20);
		alcazar.setWebSite("https://www.alcazarsevilla.org/");
		alcazar.setEnd_event(dateEnd);
		alcazar.setStart_event(dateStart);
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

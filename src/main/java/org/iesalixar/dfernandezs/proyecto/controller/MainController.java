package org.iesalixar.dfernandezs.proyecto.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
import org.iesalixar.dfernandezs.proyecto.service.EventService;
import org.iesalixar.dfernandezs.proyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ForumRepository forumRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;

	@GetMapping({ "/", "/index" })
	public String index() {
		return "index";
	}
	
	@GetMapping({"/about" })
	public String about() {
		return "about";
	}

	@GetMapping("/events")
	public String events(Model model) {
		List<Event> listEvent = eventRepository.findAllByOrderByDateDesc();
		List<Event> listEventReturn = new ArrayList<Event>();
		Set<Province> provinces = provinceRepository.findAll();
		Set<Category> categories = categoryRepository.findAll();
		
		for (Event event : listEvent) {
			if (event.getAllow() == true) {
				listEventReturn.add(event);
			}
		}
		
		model.addAttribute("provinces", provinces);
		model.addAttribute("categories", categories);
		model.addAttribute("events", listEventReturn);
		return "events";
	}

	// Muestra el evento seleccionado
	@GetMapping(value = "/event{id}")
	public String event(@PathParam("id") long id, 
			                             Model model) {

		String aux = "event";

		// Selecciona todos los eventos
		List<Event> events = (List<Event>) eventRepository.findAll();
		Event vnt = new Event();

		// Guarda el evento que coincida con el id del parametro
		for (Event event : events) {

			if (((Long) event.getEvent_id()).equals(id)) {
				vnt = event;
			}
		}

		List<Comment> comments = commentRepository.findAllByOrderByDateDesc();
		List<Comment> commentsResult = new ArrayList<Comment>();

		for (Comment comment : comments) {

			if (((Long) comment.getForum().getEvent().getEvent_id()).equals(id)) {
				commentsResult.add(comment);
			}
		}

		// Guarda el evento para poder mostrarlo en la vista
		model.addAttribute("event", vnt);
		model.addAttribute("comments", commentsResult);

		if (vnt.getAllow() == false) {
			return events(model);
		}

		return aux;
	}

	// Pagina de inicio de sesion
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// Cierra la sesion
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, 
			                 HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	// Pagina de registro
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	// Pagina de administracion
	@GetMapping({ "/admin/admin" })
	public String admin(Model model) {

		List<Event> events = eventRepository.findAll();

		List<Event> eventsAllow = new ArrayList<Event>();
		List<Event> eventsDisallow = new ArrayList<Event>();
		List<User> users = userRepository.findAll();

		for (Event event : events) {
			if (event.getAllow() == true) {
				eventsAllow.add(event);
			} else {
				eventsDisallow.add(event);
			}
		}

//		List<Authority> authorities = authorityRepository.findAll();
//		model.addAttribute("authorities", authorities);

		model.addAttribute("users", users);
		model.addAttribute("eventsAllow", eventsAllow);
		model.addAttribute("eventsDisallow", eventsDisallow);

		return "admin/admin";
	}

	// Pagina de creacion de eventos
	@GetMapping("/private/eventCreator")
	public String eventCreator(Model model, 
			                   HttpServletRequest request) {
		Set<Province> provinces = provinceRepository.findAll();
		Set<Category> categories = categoryRepository.findAll();

		model.addAttribute("categories", categories);
		model.addAttribute("provinces", provinces);

		return "private/eventCreator";
	}

	// Añade los eventos a la base de datos
	@PostMapping("/addEvent")
	public String addEvent(@Valid @ModelAttribute Event event, 
												  BindingResult result,
												  HttpSession session, 
												  Model model,
												  HttpServletRequest request) {

		String aux = "redirect:private/home";
		Event vnt = eventRepository.findByName(event.getName());

		if (vnt != null || result.hasErrors()) {
			session.setAttribute("eventError", "El evento "+ vnt.getName() +" ya existe");
			aux = "redirect:private/eventCreator";
		} else {
			String userName = request.getRemoteUser();
			User user = userRepository.findByUsername(userName);

			// Creamos el foro del nuevo evento
			Forum forum = new Forum();
			forum.setEvent(event);

			// Completamos las referencias con otras tablas de la base de datos
			event.setDate(new Date());
			event.setUser(user);
			event.setForum(forum);
			
			// Si el evento lo ha hecho un admin se publica automaticamente
			for (Authority auth : user.getAuthority()) {
				if(auth.getAuthority().equals("ADMIN")) {
					event.setAllow(true);
				}
			}

			// Guardamos el evento y el repositorio
			eventRepository.save(event);
			forumRepository.save(forum);
		}
		return aux;
	}

	// Pagina del usuario
	@GetMapping("/private/home")
	public String home(Model model,
					   HttpServletRequest request) {

		// Nombre de la cuenta del usuario actual
		String userName = request.getRemoteUser();
		User user = userRepository.findByUsername(userName);

		List<Event> eventList = eventRepository.findAllByOrderByDateDesc();
		List<Event> eventListUser = new ArrayList<>();

		// Para mostrar solo los eventos creados por el usuario
		for (Event event : eventList) {
			if (event.getUser().equals(user)) {
				eventListUser.add(event);
			}
		}

		model.addAttribute("image", user.getImage());
		model.addAttribute("name", user.getName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("userName", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("eventList", eventListUser);

		return "private/home";

	}

	// Añade usuarios a la base de datos
	//---------------------------------------------------------
	@PostMapping("/addUsers")
	public String addUsers(@Valid @ModelAttribute User user, 
												  HttpSession session, 
			                                      BindingResult result, 
			                                      Model model)throws FileNotFoundException {

		String aux = "";
		User usr = userRepository.findByUsername(user.getUsername());

		if (usr != null || result.hasErrors()) {
			session.setAttribute("error", "El usuario "+ usr.getUsername() +" ya existe");
			aux = "redirect:/register";
			System.out.println("Error al registrarse");
		}

		else {
			// Saca de la base de datos el objeto USER
			Authority authority = authorityRepository.findByAuthority("USER");
			Set<Authority> users = new HashSet<Authority>();

			// Guarda el objeto user en un Set
			users.add(authority);

			// Encripta la contraseña
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			// Se le da el rol de USER a todo aquel que se registra
			user.setAuthority(users);

			// Se guarda el usuario en la base de datos
			userService.addUser(user);

			// Manda al usuario al INDEX (CAMBIAR! a la pagina personal del usuario)
			aux = "redirect:/login";
		}
		return aux;
	}

	// Borrar un usuario (Pagina de administracion)
	//---------------------------------------------------------
	@RequestMapping(value = { "/user/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public String deleteUser(@RequestParam(value = "id") String id, 
													     Model model) {
		userRepository.deleteById(Long.parseLong(id));
		return "redirect:/admin/admin";
	}

	// Borra eventos (Pagina de administracion)
	//---------------------------------------------------------
	@RequestMapping(value = { "/event/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public String deleteEvent(@RequestParam(value = "event_id") String event_id, 
																Model model) {
		eventRepository.deleteById(Long.parseLong(event_id));
		return "redirect:/admin/admin";
	}

	// Edita usuarios (Pagina de administracion)
	//---------------------------------------------------------
	@PostMapping("/updateUser")
	public String userUpdate(@Valid @ModelAttribute User user, 
													BindingResult result, 	
													Model model) throws FileNotFoundException {
		String aux = "";
		User usr = userRepository.findByUsername(user.getUsername());

		if (user == null || result.hasErrors()) {
			aux = "redirect:/admin/admin";
			System.out.println("Error al modificar el usuario " + usr.getName());
		}
		else {
			try {
				userService.updateUser(user);
				aux = "redirect:/admin/admin";
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return aux;
	}

	// Añade comentarios en los eventos
	//---------------------------------------------------------
	@PostMapping("/addComment")
	public String addComment(@Valid @ModelAttribute Comment comment, 
													BindingResult result, 
													Model model,
													HttpServletRequest request) {

		long id = Long.parseLong(request.getParameter("event"));

		if (comment.getText() == "" || result.hasErrors()) {
			return event(id, model);

		} else {
			String userName = request.getRemoteUser();
			User user = userRepository.findByUsername(userName);
			comment.setUser(user);
			comment.setDate(new Date());

			commentRepository.save(comment);
		}
		return "redirect:/event?id="+id;
	}

	// Edita el perfil del usuario
	//---------------------------------------------------------
	@PostMapping("/updateProfile")
	public String updateProfile(@Valid @ModelAttribute User user, 
													   BindingResult result, 
													   Model model,
													   HttpServletRequest request) throws FileNotFoundException {
		if (result.hasErrors()) {

			System.out.println("Error al modificar el usuario " + user.getName());
		}
		else {
			try {
				userService.updateUser(user);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return "redirect:/private/home";
	}
	
	// El usuario puede borrar sus propios eventos
	//---------------------------------------------------------
	@RequestMapping(value = { "/deleteMyEvent" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public String deleteMyEvent(@RequestParam(value = "event_id") String event_id, 
			                                                      Model model) {

		eventRepository.deleteById(Long.parseLong(event_id));

		return "redirect:/private/home";
	}
	
	// Pone un evento activo
	//---------------------------------------------------------
	@RequestMapping(value = { "/event/allow" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public String eventAllow(@RequestParam(value = "event_id") String event_id, 
			                                                   Model model) {
		List<Event> events = eventRepository.findAll();

		Event eventReturn = null;
		
		for (Event event : events) {
			if (event.getEvent_id() == Long.parseLong(event_id)) {
				eventReturn = event;
				eventReturn.setAllow(true);

			}
		}

		eventService.updateEvent(eventReturn);
		
		return admin(model);
	}
	
	// Edita eventos
	//---------------------------------------------------------
	@PostMapping("/updateEvent")
	public String updateEvent(@Valid @ModelAttribute Event event, 
													 HttpServletRequest request, 
													 BindingResult result, 
													 Model model)throws FileNotFoundException {
		List<Event> events = eventRepository.findAll();
		Event evnt = null;
		
		for (Event event2 : events) {
			if(event2.getName().equals(event.getName())) {
				evnt = event2;
			}
		}
		if (result.hasErrors()) {
			System.out.println("No se pudo actualizar " +evnt.getName());
			return home(model, request);
		}
		else {
			try {
				eventService.updateEventDat(event, evnt);
				return home(model, request);
			} catch (Exception e) {
				System.out.println(e.fillInStackTrace());
			}
		}
		return home(model, request);
	}

	// Cada usuario puede borrar sus comentarios
	//---------------------------------------------------------
	@RequestMapping(value = { "/comment/remove" }, method = { RequestMethod.POST, RequestMethod.DELETE })
	public String commentRemove(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) {
		
		commentRepository.deleteById(Long.parseLong(id));
		long event = Long.parseLong(request.getParameter("event"));
	
		return "redirect:/event?id="+event;
	}
	
	// Filtra eventos en funcion de sus categorias y provincias
	//---------------------------------------------------------
	@PostMapping("/eventFilter")
	public String eventFilter(Model model,
			                  HttpServletRequest request) {
				
		String aux = "events";
		List<Event> listEvent = eventRepository.findAllByOrderByDateDesc();
		List<Event> listEventReturn = new ArrayList<Event>();
		Province province = provinceRepository.findById(Long.parseLong(request.getParameter("province")));
		Set<Province> provinces = provinceRepository.findAll();
		Set<Category> categories = categoryRepository.findAll();
		Long categoryId = Long.parseLong(request.getParameter("categories"));
		Category category = null;
		
		for (Category c : categories) {
			if(c.getCategory_id() == categoryId) {
				category = c;
			}
		}
		
		// Si no selecciona nada
		if(province == null && categoryId == 0) {
			aux = "redirect:/events";
		}else 
			
		// Si solo selecciona provincia
		if(province != null && categoryId == 0){
			for (Event event : listEvent) {
				if(province.equals(event.getProvince()) && event.getAllow() == true) {
					listEventReturn.add(event);
				}
			}
		}else 
			// Si solo selecciona categoria
			if(province == null && categoryId != 0){
			for (Event event : listEvent) {
				if(event.getCategories().contains(category) && event.getAllow() == true) {
					listEventReturn.add(event);
				}
			}
		}else {
			// Si selecciona una provincia y una categoria
			for (Event event : listEvent) {
				if(event.getCategories().contains(category) && province.equals(event.getProvince()) && event.getAllow() == true) {
					listEventReturn.add(event);
				}
			}
		}

		model.addAttribute("events", listEventReturn);
		model.addAttribute("provinces", provinces);
		model.addAttribute("categories", categories);

		return aux;
	}
}

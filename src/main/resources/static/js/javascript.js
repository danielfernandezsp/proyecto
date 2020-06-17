// Guarda el ultimo nombre que el usuario puso
function login() {
	var user = document.getElementById("userLogin").value;
	localStorage.setItem("userLocal", user);
}

 // Muestra el ultimo nombre de login de usuario
function loginStorage() {
	document.getElementById("userLogin").value = localStorage.getItem("userLocal");
}

// Guarda nombre y apellidos de usuario registrado
function register() {
	var nameUser = document.getElementById("name").value;
	localStorage.setItem("nameUser", nameUser);
	var lastNameUser = document.getElementById("lastName").value;
	localStorage.setItem("lastNameUser", lastNameUser);

}

// Muestra nombre y apellidos de usuario por si falla al registrar no tener que volver a escribirlos
function registerStorage() {
	document.getElementById("name").value = localStorage.getItem("nameUser");
	document.getElementById("lastName").value = localStorage.getItem("lastNameUser");

}


function photoSelect(params) {
	if (document.getElementById('info-image') != '<img class="d-block w-100" src="images/'
			+ params + '.jpg" alt="...">') {
		document.getElementById('info-image').innerHTML = '<img class="d-block w-100" src="images/'
				+ params + '.jpg" alt="...">';
		console.log("Done");
		console.log(document.getElementById('info-image').getElementsByTagName(
				'img'));
	}
}

// Funcion para previsualizar las imagenes
function previewFile() {
	var preview = document.querySelector('#preview');
	var file = document.querySelector('#imageFile').files[0];
	var reader = new FileReader();
	var photo = document.getElementById("imageFile");

	reader.onloadend = function() {
		preview.src = reader.result;
		file.value = reader.result;
		var base64 = document.getElementById('preview').src;
		document.getElementById('image').value = base64;
		console.log(document.getElementsByName('image').value);

	}

	if (file) {
		reader.readAsDataURL(file);
	} else {
		preview.src = "";
	}
}

// Flecha para subir arriba de la pagina 
function arrowUp(){  
    var scroll = document.documentElement.scrollTop || document.body.scrollTop;

    if(scroll > 1000){
        document.querySelector('.fa-arrow-circle-up').classList.remove("d-none");
        document.querySelector('.fa-arrow-circle-up').classList.add("d-block");
        document.querySelector('.fadeOut').classList.add("d-none");
        document.querySelector('.fadeOut').classList.remove("d-block");
        document.querySelector('.arrowUpLink').classList.add("d-block");
    }
    
    if(scroll < 1000){
        document.querySelector('.fa-arrow-circle-up').classList.add("d-none");
        document.querySelector('.fa-arrow-circle-up').classList.remove("d-block");
        document.querySelector('.fadeOut').classList.add("d-block");
    }
}

// Quita los 0 de la izquierda y no deja poner mas de 11 numeros
function capacityNum() {
	var num = document.querySelector('#eventCapacity').value;

	if (num.substring(0, 1) == 0) {
		document.querySelector('#eventCapacity').value = num.substring(1, num.length);
	}
	
	if (num.length > 11){
		document.querySelector('#eventCapacity').value = 99999999999;
	}

}

// Validación de login
// ______________________________________________________________________
function validateLogin() {
	var user = document.querySelector('#userLogin').value;
	var pass = document.querySelector('#passLogin').value;
	var btnLogin = document.querySelector('#btnLogin');
	var passError = document.querySelector('#passError');
	var userError = document.querySelector('#userError');

	var cont = 0;

	// Comprueba usuario
	if (user.length >= 4 && user.length <= 20) {
		cont = cont + 1;

		userError.classList.remove('d-block');
		userError.classList.add('d-none');
	} else {

		if (user.length > 0) {
			userError.classList.remove('d-none');
			userError.classList.add('d-block');
		}
		cont = cont - 1;
	}

	// Comprueba contraseña
	if (pass.length >= 4 && pass.length <= 20) {
		cont = cont + 1;
		passError.classList.remove('d-block');
		passError.classList.add('d-none');
	} else {

		if (pass.length > 0) {
			passError.classList.remove('d-none');
			passError.classList.add('d-block');
		}
	}

	// El boton se activa o desactiva dependiendo si lo anterior es correcto
	if (cont == 2) {
		btnLogin.disabled = false;
		btnLogin.classList.remove('btn-warning');
	} else {
		btnLogin.disabled = true;
		btnLogin.classList.add('btn-warning');
	}
}

// Validación de registro
// ______________________________________________________________________
function validateUser() {
	var username = document.querySelector('#userName').value;
	var password = document.querySelector('#password').value;
	var lastname = document.querySelector('#lastName').value;
	var name = document.querySelector('#name').value;

	var btnRegister = document.querySelector('#btnRegister');

	var usernameError = document.querySelector('#userNameError');
	var passwordError = document.querySelector('#passwordError');
	var lastnameError = document.querySelector('#lastNameError');
	var nameError = document.querySelector('#nameError');

	var cont = 0;

	// Comprueba nombre usuario
	if (username.length >= 4 && username.length <= 20) {
		cont = cont + 1;

		usernameError.classList.remove('d-block');
		usernameError.classList.add('d-none');
	} else {

		if (username.length > 0) {
			usernameError.classList.remove('d-none');
			usernameError.classList.add('d-block');
		}
		cont = cont - 1;
	}

	// Comprueba contraseña
	if (password.length >= 4 && password.length <= 20) {
		cont = cont + 1;
		passwordError.classList.remove('d-block');
		passwordError.classList.add('d-none');
	} else {

		if (password.length > 0) {
			passwordError.classList.remove('d-none');
			passwordError.classList.add('d-block');
		}
	}

	// Comprueba nombre
	if (name.length >= 4 && name.length <= 15) {
		cont = cont + 1;
		nameError.classList.remove('d-block');
		nameError.classList.add('d-none');
	} else {

		if (name.length > 0) {
			nameError.classList.remove('d-none');
			nameError.classList.add('d-block');
		}
	}

	// Comprueba apellidos
	if (lastname.length >= 6 && lastname.length <= 50) {
		cont = cont + 1;
		lastNameError.classList.remove('d-block');
		lastNameError.classList.add('d-none');
	} else {

		if (lastname.length > 0) {
			lastNameError.classList.remove('d-none');
			lastNameError.classList.add('d-block');
		}
	}

	// El boton se activa o desactiva dependiendo si lo anterior es correcto
	if (cont == 4) {
		btnRegister.disabled = false;
		btnRegister.classList.remove('btn-warning');
	} else {
		btnRegister.disabled = true;
		btnRegister.classList.add('btn-warning');
	}
}

// Validación de comentarios
// ______________________________________________________________________
function validateComment() {
	var btnComment = document.querySelector('#btnComment');
	var comment = document.querySelector('#comment').value;
	var commentError = document.querySelector('#commentError');

	var cont = 0;

	// Comprueba usuario
	if (comment.length >= 1 && comment.length <= 255) {
		cont = cont + 1;

		commentError.classList.remove('d-block');
		commentError.classList.add('d-none');
	} else {

		if (comment.length > 0) {
			commentError.classList.remove('d-none');
			commentError.classList.add('d-block');
		}
		cont = cont - 1;
	}

	// El boton se activa o desactiva dependiendo si lo anterior es correcto
	if (cont == 1) {
		btnComment.disabled = false;
		btnComment.classList.remove('btn-warning');
	} else {
		btnComment.disabled = true;
		btnComment.classList.add('btn-warning');
	}
}

// Validación de eventos
// ______________________________________________________________________
function validateEvent() {
	var eventName = document.querySelector('#eventName').value;
	var eventDescription = document.querySelector('#eventDescription').value;
	var eventPlace = document.querySelector('#eventPlace').value;
	var eventStart = document.querySelector('#eventStart').value;

	var btnSave = document.querySelector('#btnSave');

	var eventnameError = document.querySelector('#eventnameError');
	var eventDescriptionError = document
			.querySelector('#eventDescriptionError');
	var eventPlaceError = document.querySelector('#eventPlaceError');
	var eventStartError = document.querySelector('#eventStartError');
	var eventProvinceError = document.querySelector('#eventProvinceError');

	var cont = 0;

	// Comprueba nombre evento
	if (eventName.length >= 4 && eventName.length <= 50) {
		cont = cont + 1;

		eventNameError.classList.remove('d-block');
		eventNameError.classList.add('d-none');
	} else {

		if (eventName.length > 0) {
			eventNameError.classList.remove('d-none');
			eventNameError.classList.add('d-block');
		}
		cont = cont - 1;
	}

	// Comprueba descripcion evento
	if (eventDescription.length >= 10 && eventDescription.length <= 500) {
		cont = cont + 1;
		eventDescriptionError.classList.remove('d-block');
		eventDescriptionError.classList.add('d-none');
	} else {

		if (eventDescription.length > 0) {
			eventDescriptionError.classList.remove('d-none');
			eventDescriptionError.classList.add('d-block');
		}
	}

	// Comprueba lugar evento
	var str = '<iframe src="https://www.google.com/maps/embed';

	if (eventPlace.length >= 4 && eventPlace.length <= 700
			&& eventPlace.substring(0, 46) == str) {
		cont = cont + 1;
		eventPlaceError.classList.remove('d-block');
		eventPlaceError.classList.add('d-none');
	} else {

		if (eventPlace.length > 0) {
			eventPlaceError.classList.remove('d-none');
			eventPlaceError.classList.add('d-block');
		}
	}

	// Comprueba la fecha de inicio
	if (eventStart != "") {
		cont = cont + 1;
		eventStartError.classList.remove('d-block');
		eventStartError.classList.add('d-none');
	} else {
		cont = cont - 1;
		eventStartError.classList.add('d-block');
		eventStartError.classList.remove('d-none');
	}

	// Comprueba si hay provincia seleccionada
	if (document.querySelector('#provinces').value != 0) {
		cont = cont + 1;
		eventProvinceError.classList.remove('d-block');
		eventProvinceError.classList.add('d-none');
	} else {
		cont = cont - 1;
		eventProvinceError.classList.add('d-block');
		eventProvinceError.classList.remove('d-none');
	}

	// Comprueba que siempre tenga un numero
	if (document.querySelector('#eventCapacity').value == "") {
		document.querySelector('#eventCapacity').value = 0;
	}

	// El boton se activa o desactiva dependiendo si lo anterior es correcto
	if (cont == 5) {
		btnSave.disabled = false;
		btnSave.classList.remove('btn-warning');
	} else {
		btnSave.disabled = true;
		btnSave.classList.add('btn-warning');
	}
}

// Validación de usuarios modificador
// ______________________________________________________________________
function validateUserUpdate() {

	var userName = document.querySelector('#userName').value;
	var userLastName = document.querySelector('#userLastName').value;

	var userNameError = document.querySelector('#userNameError');
	var userLastNameError = document.querySelector('#userLastNameError');

	var btnUpdate = document.querySelector('#btnUpdate');

	var cont = 0;

	// Comprueba nombre
	if (userName.length >= 4 && userName.length <= 15) {
		cont = cont + 1;
		userNameError.classList.remove('d-block');
		userNameError.classList.add('d-none');
	} else {
		cont = cont - 1;
		userNameError.classList.remove('d-none');
		userNameError.classList.add('d-block');
	}

	// Comprueba apellidos
	if (userLastName.length >= 4 && userLastName.length <= 50) {
		cont = cont + 1;
		userLastNameError.classList.remove('d-block');
		userLastNameError.classList.add('d-none');
	} else {
		userLastNameError.classList.remove('d-none');
		userLastNameError.classList.add('d-block');
		cont = cont - 1;
	}

	// Comprueba imagen
	if (document.querySelector('#image').value != "") {
		cont = cont + 1;
	}

	console.log(cont);
	console.log(userName);
	console.log(userLastName);
	console.log(document.querySelector('#image').src);

	// El boton se activa o desactiva dependiendo si lo anterior es correcto
	if (cont == 3) {
		btnUpdate.disabled = false;
	} else {
		btnUpdate.disabled = true;
	}
}

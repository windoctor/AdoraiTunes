package com.adoraitunes.pages;

import com.adoraitunes.entities.Usuario;
import com.adoraitunes.services.interfaces.IUsuarioService;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.tynamo.security.services.SecurityService;

@Import(stylesheet = {"context:layout/js/jPlayer/jplayer.flat.css","context:layout/css/animate.css",
		"context:layout/css/font-awesome.min.css", "context:layout/css/simple-line-icons.css",
		"context:layout/css/font.css", "context:layout/css/app.css"},
		library = {"context:layout/js/bootstrap.js",
				"context:layout/js/app.js",
				"context:layout/js/slimscroll/jquery.slimscroll.min.js",
				"context:layout/js/app.plugin.js",
				"context:layout/js/jPlayer/jquery.jplayer.min.js",
				"context:layout/js/jPlayer/add-on/jplayer.playlist.min.js",
				"context:layout/js/jPlayer/demo.js",
				"context:layout/js/jquery.sha256.min.js"})
public class Login
{
	@Property @Validate("required")
	private String nombre,apellidos, password;

	@Property @Validate("email")
	private String correo;

	@Property
	private Boolean remember;

	@Property
	@Persist(PersistenceConstants.SESSION)
	private String nombre_usuario;

	@Component
	private Form loginForm;

	@Component
	private Form signInForm;

	@Inject
	private SecurityService securityService;

	@Inject
	private IUsuarioService iUsuarioService;
	
	Object onActivate() {
		// Si el usuario ya está autenticado redirigir a la página Index
		if (securityService.isUser()) {
			return Index.class;
		}
		return  null;
	}

	Object onValidateFromSignInForm(){
		if(signInForm.isValid()){
			System.out.println("Nombre: "+nombre);
			System.out.println("Apellidos: "+apellidos);
			System.out.println("Correo: "+correo);
			System.out.println("Password: "+password);
			System.out.println("Recuerdame: " + remember);

			Usuario usuario = iUsuarioService.findUserByName(correo);
			if(usuario!=null) {
				signInForm.recordError("El usuario ya existe");
				return Login.class;
			}
			else{
				Usuario usuario1 = new Usuario(correo, password);
				usuario1.setNombre(nombre);
				usuario1.setApellidos(apellidos);
				iUsuarioService.create(usuario1);
				return Login.class;
			}

		}

		return Login.class;

	}

	Object onValidateFromLoginForm() {
		if (loginForm.getHasErrors()) {
			return null;
		}

		Subject subject = securityService.getSubject();

		if (subject == null) {
			return null;
		}

		// Recolectar en el token los datos introducidos por el usuario
		UsernamePasswordToken token = new UsernamePasswordToken(correo, password);
		System.out.println("username: "+token.getUsername());
		token.setRememberMe(true);

		try {
			// Validar e iniciar las credenciales del usuario
			subject.login(token);
		} catch (UnknownAccountException e) {
			loginForm.recordError("Cuenta de usuario desconocida");
			return Login.class;
		} catch (IncorrectCredentialsException e) {
			loginForm.recordError("Credenciales inválidas");
			return Login.class;
		} catch (LockedAccountException e) {
			loginForm.recordError("Cuenta bloqueada");
			return Login.class;
		} catch (AuthenticationException e) {
			loginForm.recordError("Se ha producido un error");
			return Login.class;
		}

		if(securityService.isAuthenticated()) {
			Session session = securityService.getSubject().getSession();
			nombre_usuario = (String) session.getAttribute("nombreUsuario");
		}

		// Usuario autenticado, redirigir a la página Index
		return Index.class;
	}
    
}

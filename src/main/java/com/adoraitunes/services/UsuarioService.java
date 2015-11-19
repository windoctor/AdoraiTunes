package com.adoraitunes.services;

import com.adoraitunes.dao.interfaces.IUsuarioDAO;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.exceptions.UserNotFoundException;
import com.adoraitunes.security.IPasswordManager;
import com.adoraitunes.services.interfaces.IUsuarioService;
import org.apache.tapestry5.ioc.annotations.Inject;

public class UsuarioService implements IUsuarioService {

    @Inject
    private IUsuarioDAO usuarioDAO;

    @Inject
    private IPasswordManager passwordManager;

	@Override
	public Usuario findUserByName(String userName) {
		Usuario usuario = usuarioDAO.findByUsername(userName);

        if(usuario == null)
            throw new UserNotFoundException(String.format("El usuario %s no existe",userName));

        return usuario;
	}

    @Override
    public void create(Usuario usuario) {
        passwordManager.setPlainPassword(usuario.getPassword());

        String passwordHashed = passwordManager.getPasswordEncrypted();
        String salt = passwordManager.getSalt();

        usuario.setPassword(passwordHashed);
        usuario.setSalt(salt);

        usuarioDAO.create(usuario);

    }

    @Override
    public void setPasswordManager(IPasswordManager passwordManager) {
        this.passwordManager = passwordManager;
    }

    @Override
    public IPasswordManager getPasswordManager() {
        return  passwordManager;
    }


}

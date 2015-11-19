package com.adoraitunes.services.interfaces;

import com.adoraitunes.entities.Usuario;
import com.adoraitunes.security.IPasswordManager;

/**
 * Created by ascariromopedraza on 22/08/15.
 */
public interface IUsuarioService {
    Usuario findUserByName(String userName);
    void create(Usuario usuario);
    void setPasswordManager(IPasswordManager passwordManager);
    IPasswordManager getPasswordManager();
}

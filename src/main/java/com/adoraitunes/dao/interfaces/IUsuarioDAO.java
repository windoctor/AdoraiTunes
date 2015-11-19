package com.adoraitunes.dao.interfaces;

import com.adoraitunes.entities.Usuario;

/**
 * Created by ascariromopedraza on 16/11/15.
 */
public interface IUsuarioDAO {

    Usuario findByUsername(String username);
    void create(Usuario usuario);

}

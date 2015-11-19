package com.adoraitunes.dao.mongo;

import com.adoraitunes.dao.interfaces.IUsuarioDAO;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.JongoClient;
import com.mongodb.WriteResult;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.jongo.MongoCollection;

/**
 * Created by ascariromopedraza on 16/11/15.
 */
public class UsuarioDAO implements IUsuarioDAO {

    private MongoCollection mongoCollection;

    @Inject
    private JongoClient client;

    @Override
    public Usuario findByUsername(String username) {
        mongoCollection = client.getCollection("usuarios");
        Usuario usuario = mongoCollection.findOne("{username:#}", username).as(Usuario.class);
        return usuario;
    }

    @Override
    public void create(Usuario usuario) {
        mongoCollection = client.getCollection("usuarios");
        mongoCollection.insert(usuario);
    }
}

package com.adoraitunes.dao.mongo;

import com.adoraitunes.JongoClient;
import com.adoraitunes.dao.interfaces.ICancionesDAO;
import com.adoraitunes.entities.Cancion;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Created by ascariromopedraza on 17/11/15.
 */
public class CancionesDAO implements ICancionesDAO {

    private MongoCollection mongoCollection;

    @Inject
    private JongoClient client;


    @Override
    public Iterator<Cancion> obtenerPlayList(String nombre) {
        mongoCollection = client.getCollection("canciones");
        return mongoCollection.find("{inicio:#}", true)
                .sort("{prioridad:1}")
                .as(Cancion.class);

    }

    @Override
    public Iterator<Cancion> buscarCancionPorAproximacion(String name) {
        mongoCollection = client.getCollection("canciones");
        return mongoCollection.find("{nombre:#}",
                        Pattern.compile(name.concat(".*"),
                        Pattern.CASE_INSENSITIVE))
                .as(Cancion.class);
    }
}

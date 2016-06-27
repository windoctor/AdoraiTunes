package com.adoraitunes.dao.mongo;

import com.adoraitunes.JongoClient;
import com.adoraitunes.dao.interfaces.ICancionesDAO;
import com.adoraitunes.entities.Cancion;
import com.adoraitunes.enums.Inspiracion;
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
    public void crear(Cancion cancion) {
        mongoCollection = client.getCollection("canciones");
        mongoCollection.save(cancion);
    }

    @Override
    public Iterator<Cancion> obtenerPlayList(String nombre) {
        mongoCollection = client.getCollection("canciones");
        return mongoCollection.find("{playlist:#}", nombre)
                .sort("{fecha:1}")
                .as(Cancion.class);

    }

    @Override
    public Iterator<Cancion> obtenerRecienAgregadas() {
        mongoCollection = client.getCollection("canciones");
        return mongoCollection.find("{inspiracion:#, playlist:{$ne :#}}", Inspiracion.CATOLICA,"default").
                sort("{fecha:1}")
                .limit(10)
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

package com.adoraitunes.services;

import com.adoraitunes.dao.interfaces.ICancionesDAO;
import com.adoraitunes.entities.Cancion;
import com.adoraitunes.services.interfaces.ICancionesService;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by ascariromopedraza on 02/11/15.
 */
public class CancionesService implements ICancionesService {

    @Inject
    private ICancionesDAO cancionesDAO;

    @Override
    public List<Cancion> obtenerPlayList(String inspiracion) {
        Iterator<Cancion> iterator = cancionesDAO.obtenerPlayList(inspiracion);
        List<Cancion> canciones = new LinkedList<>();
        iterator.forEachRemaining(it -> canciones.add(it));
        return canciones;
    }

    @Override
    public List<Cancion> buscarCancionPorAproximacion(String name) {
        Iterator<Cancion> iterator = cancionesDAO.buscarCancionPorAproximacion(name);
        List<Cancion> canciones = new LinkedList<>();
        iterator.forEachRemaining( it -> canciones.add(it));
        return canciones;
    }

/*
    @Inject
    private MongoDB mongoDB;

    private Jongo jongo;
    private MongoCollection mongoCollection;

    @Override
    public Map<Integer, Object> obtenerCancionesPantallaInicial(String inspiracion) {
        jongo = new Jongo(mongoDB.getDefaultMongoDb());
        mongoCollection = jongo.getCollection("canciones");
        MongoCursor<Cancion> collection = mongoCollection
                .find("{inicio:#, inspiracion:#}", true,inspiracion)
                .limit(12)
                .sort("{prioridad:1}")
                .as(Cancion.class);

        List<Cancion> list = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();

        while(collection.hasNext()){
            Cancion cancion = collection.next();
            list.add(cancion);

            JSONObject json = new JSONObject();
            json.put("nombre", cancion.getNombre() );
            json.put("cantante", cancion.getCantante() );
            json.put("link", cancion.getLink() );
            json.put("portada", cancion.getPortada() );
            json.put("inicio", cancion.getInicio() );

            jsonArray.put(json);
        }

        Map<Integer,Object> map = new HashMap<>();
        map.put(1, list);
        map.put(2, jsonArray);

        return map;
    }

    @Override
    public List<String> buscarCancionPorAproximacion(String name) {
        jongo = new Jongo(mongoDB.getDefaultMongoDb());
        mongoCollection = jongo.getCollection("canciones");
        MongoCursor<Cancion> canciones = mongoCollection.find("{nombre:#}", Pattern.compile(name.concat(".*"), Pattern.CASE_INSENSITIVE)).as(Cancion.class);
        List<String> nombres = new ArrayList<>();
        Iterator<Cancion> it = canciones.iterator();
        while(it.hasNext()){
            nombres.add(it.next().getNombre());
        }

        return nombres;
    }
    */
}

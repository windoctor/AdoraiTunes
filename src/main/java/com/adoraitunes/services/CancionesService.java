package com.adoraitunes.services;

import com.adoraitunes.dao.interfaces.ICancionesDAO;
import com.adoraitunes.entities.Cancion;
import com.adoraitunes.services.interfaces.ICancionesService;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ascariromopedraza on 02/11/15.
 */
public class CancionesService implements ICancionesService {

    @Inject
    private ICancionesDAO cancionesDAO;

    @Override
    public void crear(Cancion cancion) {
        cancionesDAO.crear(cancion);
    }

    @Override
    public List<Cancion> obtenerPlayList(String inspiracion) {
        Iterator<Cancion> iterator = cancionesDAO.obtenerPlayList(inspiracion);
        List<Cancion> canciones = new LinkedList<>();
        iterator.forEachRemaining(it -> canciones.add(it));
        return canciones;
    }

    @Override
    public List<Cancion> obtenerRecienAgregadas() {
        Iterator<Cancion> iterator = cancionesDAO.obtenerRecienAgregadas();
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
}

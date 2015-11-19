package com.adoraitunes.dao.interfaces;

import com.adoraitunes.entities.Cancion;
import org.jongo.MongoCursor;

import java.util.Iterator;

/**
 * Created by ascariromopedraza on 17/11/15.
 */
public interface ICancionesDAO {

    Iterator<Cancion> obtenerPlayList(String nombre);
    Iterator<Cancion> buscarCancionPorAproximacion(String name);

}

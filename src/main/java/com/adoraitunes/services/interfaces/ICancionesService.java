package com.adoraitunes.services.interfaces;

import com.adoraitunes.entities.Cancion;
import org.apache.tapestry5.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * Created by ascariromopedraza on 02/11/15.
 */
public interface ICancionesService {
    void crear(Cancion cancion);
    List<Cancion> obtenerPlayList(String name);
    List<Cancion> obtenerRecienAgregadas();
    List<Cancion> buscarCancionPorAproximacion(String name);
}

package com.adoraitunes.managers;

import com.adoraitunes.entities.Cancion;
import com.adoraitunes.enums.Inspiracion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ascariromopedraza on 18/11/15.
 */
public class CancionManager {

    private List<Cancion> canciones;

    public CancionManager(List<Cancion> canciones){
        this.canciones = canciones;
    }

    public CancionManager(Cancion cancion){
        canciones = Arrays.asList(cancion);
    }

    public List<Cancion> filtrar(Inspiracion inspiracion){
        return canciones.stream()
                .filter(c -> c.getInspiracion()==inspiracion)
                .collect(Collectors.toList());
    }


}

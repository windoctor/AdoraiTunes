package com.adoraitunes.utils;

import com.adoraitunes.entities.Cancion;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

import java.util.List;

/**
 * Created by ascariromopedraza on 18/11/15.
 */
public class Utils {

    public static JSONArray cancionToJSONArray(List<Cancion> canciones){
        JSONArray array = new JSONArray();
        for(Cancion c : canciones){

            JSONObject json = new JSONObject();
            json.put("nombre", c.getNombre() );
            json.put("cantante", c.getCantante() );
            json.put("link", c.getLink() );
            json.put("portada", c.getPortada() );

            array.put(json);
        }

        return array;
    }

}

package com.adoraitunes.pages;


import com.adoraitunes.entities.Cancion;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.services.interfaces.IUsuarioService;
import com.adoraitunes.services.interfaces.ICancionesService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Environmental;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.tynamo.security.services.SecurityService;

import java.util.*;

/**
 * Start page of application AdoraiTunesApp.
 */

@RequiresUser
public class Index
{

    @Environmental
    private JavaScriptSupport support ;

    @Inject
    private ICancionesService cancionesService;

    @Inject
    private IUsuarioService userService;

    @Property
    private Cancion cancion;

    @Property private Integer indexCatolica;

    private Integer index;

    @Property List<Cancion> cancionesCatolicas;
    @Property List<Cancion> cancionesEvangelicas;

    @Inject private SecurityService securityService;

    @Property
    @Persist(value = PersistenceConstants.SESSION)
    private Usuario usuario;

    private List<Cancion> filtrarPorTipo(List<Cancion> canciones, String filtro){
        List<Cancion> resultado = new LinkedList<>();

        for(Cancion c : canciones){
            if(c.getInspiracion().equals(filtro))
                resultado.add(c);
        }

        return resultado;
    }

    private JSONArray filtrarPorTipo(List<Cancion> canciones){
        JSONArray array = new JSONArray();
        for(Cancion c : canciones){

            JSONObject json = new JSONObject();
            json.put("nombre", c.getNombre() );
            json.put("cantante", c.getCantante() );
            json.put("link", c.getLink() );
            json.put("portada", c.getPortada() );
            json.put("inicio", c.getInicio() );

            array.put(json);
        }
        return array;
    }

    void setupRender () {

        List<Cancion> canciones = cancionesService.obtenerPlayList("default");
        cancionesCatolicas = filtrarPorTipo(canciones, Cancion.CATOLICA);
        cancionesEvangelicas = filtrarPorTipo(canciones, Cancion.EVANGELICA);

        if(usuario == null) {
            usuario = userService.findUserByName(securityService.getSubject().getPrincipal().toString());
        }

        support.require("jPlayer/demo").invoke("init").with((JSONArray) filtrarPorTipo(cancionesCatolicas));
        support.require("jPlayer/demo").invoke("init").with((JSONArray) filtrarPorTipo(cancionesEvangelicas));

    }

    public void setIndexEvangelica(Integer index){
        this.index = index;
    }
    public Integer getIndexEvangelica(){
        return index+=cancionesCatolicas.size();
    }

    public boolean isRatingComplete(Integer value){
        if(value < 5) return false;
        else return true;
    }

    public boolean isLike(Object id){
        return Arrays.asList(usuario.getSonglikes()).contains(id);
    }

}

package com.adoraitunes.pages;


import com.adoraitunes.entities.Cancion;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.enums.Inspiracion;
import com.adoraitunes.managers.CancionManager;
import com.adoraitunes.services.interfaces.IUsuarioService;
import com.adoraitunes.services.interfaces.ICancionesService;
import com.adoraitunes.utils.Utils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Environmental;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONArray;
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

    @Property
    private Cancion cancion;

    @Property Cancion nueva;

    @Property private Integer indexCatolica;

    @Property private Integer numeroEstrella;

    @Property List<Cancion> playList;
    @Property List<Cancion> recienAgregadas;


    void setupRender () {

        recienAgregadas = cancionesService.obtenerRecienAgregadas();

        CancionManager cancionManager = new CancionManager(cancionesService.obtenerPlayList("default"));

        playList = cancionManager.filtrar(Inspiracion.CATOLICA);

        support.require("jPlayer/demo").invoke("init").with((JSONArray) Utils.cancionToJSONArray(playList));

    }

    /**
     * Utilizado en el tml para evaluar y crear las estrellas del rank de cada cancion
     * @return true si numeroEstrella es menor al ranking de la canción.
     */
    public boolean isStar(){
        return numeroEstrella <= cancion.getRank();
    }
}

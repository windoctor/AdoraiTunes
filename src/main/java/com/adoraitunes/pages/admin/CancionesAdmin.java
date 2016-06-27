package com.adoraitunes.pages.admin;


import com.adoraitunes.entities.Cancion;
import com.adoraitunes.enums.Inspiracion;
import com.adoraitunes.services.interfaces.IAdminService;
import com.adoraitunes.services.interfaces.ICancionesService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Date;

/**
 * Start page of application AdoraiTunesApp.
 */

@RequiresUser
public class CancionesAdmin
{
    @Property
    private String nombre, cantante, album, portada, link, prioridad, radioSelectedValue;

    @Property
    private Boolean playListDefault;

    @Component
    private Form cancionesForm;

    @Inject
    private ICancionesService cancionesService;

    @Inject
    private AlertManager alertManager;

    void onValidateFromCancionesForm(){
        if(cancionesForm.isValid()){
            cancionesService.crear(crearObjetoCancion());
            alertManager.alert(Duration.TRANSIENT, Severity.SUCCESS,"Cancion guardada exitosamente!!");
        }
    }

    public Cancion crearObjetoCancion(){
        Cancion cancion = new Cancion();
        cancion.setNombre(nombre);
        cancion.setCantante(cantante);
        cancion.setAlbum(album);
        cancion.setPortada(portada);
        cancion.setLink(link);
        cancion.setPrioridad(0);
        cancion.setLikes(0d);
        cancion.setPlays(0d);
        cancion.setFecha(new Date());
        cancion.setInspiracion(radioSelectedValue.equals("E") ? Inspiracion.EVANGELICA : Inspiracion.CATOLICA);
        cancion.setPlaylist(playListDefault == true ? new String[]{"default"} : new String[]{});
        return cancion;
    }
}

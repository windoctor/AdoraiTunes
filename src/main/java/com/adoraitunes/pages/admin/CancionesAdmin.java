package com.adoraitunes.pages.admin;


import com.adoraitunes.entities.Cancion;
import com.adoraitunes.services.interfaces.IAdminService;
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
    private String nombre;

    @Property
    private String cantante;

    @Property
    private String portada;

    @Property
    private String link;

    @Property
    private Boolean inicio;

    @Property
    private String radioSelectedValue;

    @Property String prioridad;

    @Component
    private Form cancionesForm;

    @Inject
    private IAdminService iAdminService;

    @Inject
    private AlertManager alertManager;

    void onValidateFromCancionesForm(){
        if(cancionesForm.isValid()){
            Cancion cancion = new Cancion(nombre,cantante,link, portada);
            cancion.setInicio(inicio);
            cancion.setInspiracion(radioSelectedValue.equals("E") ? "EVANGELICA" : "CATOLICA");
            cancion.setFecha(new Date());
            iAdminService.addCancion(cancion);

            alertManager.alert(Duration.TRANSIENT, Severity.SUCCESS,"Cancion guardada exitosamente!!");
        }
    }
}

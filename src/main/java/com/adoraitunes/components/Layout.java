package com.adoraitunes.components;

import com.adoraitunes.entities.Cancion;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.services.interfaces.IUsuarioService;
import com.adoraitunes.services.interfaces.ICancionesService;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.tynamo.security.services.SecurityService;

import java.util.List;

@Import(stylesheet = {
        "context:layout/js/jPlayer/jplayer.flat.css",
        "context:layout/css/animate.css",
        "context:layout/css/font-awesome.min.css",
        "context:layout/css/simple-line-icons.css",
        "context:layout/css/font.css",
        "context:layout/css/app.css"
    },
        library = {
                "context:layout/js/bootstrap.js",
                "context:layout/js/app.js",
                "context:layout/js/slimscroll/jquery.slimscroll.min.js",
                "context:layout/js/app.plugin.js",
                "context:layout/js/jPlayer/jquery.jplayer.min.js",
                "context:layout/js/jPlayer/add-on/jplayer.playlist.min.js"})
public class Layout
{
    @Inject
    private IUsuarioService userService;

    @Inject
    private ICancionesService cancionesService;

    @Inject
    private SecurityService securityService;

    @Property
    private String busqueda;

    public String getNombreUsuario(){
        Usuario usuario = userService.findUserByName(
                            securityService.
                            getSubject().
                            getPrincipal().
                            toString()
                        );

        return usuario.getNombre() + "." + usuario.getApellidos();

    }

    public String getFoto(){
        Usuario usuario = userService.findUserByName(
                securityService.
                        getSubject().
                        getPrincipal().
                        toString()
        );

        return usuario.getFoto();

    }

    List<Cancion> onProvideCompletionsFromBusqueda(String input){
        return cancionesService.buscarCancionPorAproximacion(input);
    }

}

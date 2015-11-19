package com.adoraitunes.pages;

import com.adoraitunes.entities.Usuario;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;

/**
 * Created by ascariromopedraza on 24/08/15.
 */
@Import(stylesheet = {"context:layout/js/jPlayer/jplayer.flat.css",
        "context:layout/css/bootstrap.css","context:layout/css/animate.css",
        "context:layout/css/font-awesome.min.css", "context:layout/css/simple-line-icons.css",
        "context:layout/css/font.css", "context:layout/css/app.css"},
        library = {"context:layout/js/jquery.min.js", "context:layout/js/bootstrap.js",
                "context:layout/js/app.js",
                "context:layout/js/slimscroll/jquery.slimscroll.min.js",
                "context:layout/js/app.plugin.js",
                "context:layout/js/jPlayer/jquery.jplayer.min.js",
                "context:layout/js/jPlayer/add-on/jplayer.playlist.min.js",
                "context:layout/js/jPlayer/demo.js",
                "context:layout/js/jquery.sha256.min.js"})
public class Registrar {
    @Property
    private Usuario usuario;

}

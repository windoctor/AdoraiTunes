package com.adoraitunes.managers;

import com.adoraitunes.entities.Cancion;
import com.adoraitunes.enums.Inspiracion;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ascariromopedraza on 18/11/15.
 */
public class TestCancionManager {

    private CancionManager cancionManager;



    @Before
    public void setUp(){

        cancionManager = new CancionManager(
                Arrays.asList(
                    new Cancion("Te Equivocas", Inspiracion.CATOLICA),
                    new Cancion("Hoja de Papel", Inspiracion.CATOLICA),
                    new Cancion("Con tu iglesia", Inspiracion.CATOLICA),
                    new Cancion("Alli quiero estar", Inspiracion.EVANGELICA),
                    new Cancion("Rey Eterno", Inspiracion.EVANGELICA)
            )
        );
    }

    @Test
    public void filtrarPorCancionesCatolicas(){
        List<Cancion> cancionList = Arrays.asList(
                new Cancion("Te Equivocas", Inspiracion.CATOLICA),
                new Cancion("Hoja de Papel", Inspiracion.CATOLICA),
                new Cancion("Con tu iglesia", Inspiracion.CATOLICA)
        );

        assertEquals(cancionList, cancionManager.filtrar(Inspiracion.CATOLICA));
    }

    @Test
    public void filtrarPorCancionesEvangelicas(){
        List<Cancion> cancionList = Arrays.asList(
                new Cancion("Alli quiero estar", Inspiracion.EVANGELICA),
                new Cancion("Rey Eterno", Inspiracion.EVANGELICA)
        );

        assertEquals(cancionList, cancionManager.filtrar(Inspiracion.EVANGELICA));
    }

}

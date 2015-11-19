package com.adoraitunes.services;

import com.adoraitunes.dao.interfaces.IUsuarioDAO;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.exceptions.UserNotFoundException;
import com.adoraitunes.security.IPasswordManager;
import com.adoraitunes.security.PasswordManager;
import com.adoraitunes.services.interfaces.IUsuarioService;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;
import org.apache.tapestry5.modules.TapestryModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.tynamo.security.services.SecurityModule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by ascariromopedraza on 16/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUsuarioServices {

    @InjectMocks
    private IUsuarioService usuarioService = new UsuarioService();

    @Mock
    private IUsuarioDAO usuarioDAO;

    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buscarUsuarioExistente(){
        String username = "molder.itp@gmail.com";
        when(usuarioDAO.findByUsername(username)).thenReturn(new Usuario(username));

        Usuario usuario = usuarioService.findUserByName(username);

        assertNotNull(usuario);
        assertEquals(username, usuario.getUsername());
    }

    @Test(expected = UserNotFoundException.class)
    public void buscarUsuarioInexistente(){
        String username = "molder.itp@gmail.com";

        when(usuarioDAO.findByUsername(username)).thenReturn(null);

        usuarioService.findUserByName(username);
    }

    @Test
    public void crearNuevoUsuario(){

        Usuario usuarioNuevo = new Usuario("hrp@gmail.com","pwd123");

        IPasswordManager passwordManager = new PasswordManager();
        usuarioService.setPasswordManager(passwordManager);

        doNothing().when(usuarioDAO).create(anyObject());

        usuarioService.create(usuarioNuevo);


        assertEquals(usuarioNuevo.getPassword(), usuarioService.getPasswordManager().getPasswordEncrypted());
        assertEquals(usuarioNuevo.getSalt(), usuarioService.getPasswordManager().getSalt());

    }

}

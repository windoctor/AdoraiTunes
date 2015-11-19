package com.adoraitunes.services;

import com.adoraitunes.dao.interfaces.IUsuarioDAO;
import com.adoraitunes.entities.Usuario;
import com.adoraitunes.exceptions.UserNotFoundException;
import com.adoraitunes.security.IPasswordManager;
import com.adoraitunes.services.interfaces.IUsuarioService;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.RegistryBuilder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.modules.TapestryModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;
import org.tynamo.security.services.SecurityModule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by ascariromopedraza on 16/11/15.
 */
public class TestUsuario{

    private Registry registry;

    private IUsuarioService usuarioService;

    private IUsuarioDAO usuarioDAO;

    public  void setUp(){
        MockitoAnnotations.initMocks(this);
        registry = RegistryBuilder.
                buildAndStartupRegistry(
                        TapestryModule.class,
                        AppModule.class,
                        SecurityModule.class
                );
        usuarioService = registry.getService(IUsuarioService.class);


    }

    public void shutdown(){
        registry.shutdown();
    }

    public void buscarUsuarioExistente(){
        String username = "molder.itp@gmail.com";
        Usuario usuario = usuarioService.findUserByName(username);
        assertNotNull(usuario);
        assertEquals(username, usuario.getUsername());
    }

    public void buscarUsuarioInexistente(){
        usuarioService.findUserByName("UsuarioInexistente");
    }

    public void crearNuevoUsuario(){

        Usuario usuarioNuevo = new Usuario("hrp@gmail.com","pwd123");
        IPasswordManager passwordManager = mock(IPasswordManager.class);

        doThrow(new RuntimeException()).when(usuarioDAO).create( anyObject());

        usuarioService.create(usuarioNuevo);

        verify(passwordManager).setPlainPassword(usuarioNuevo.getPassword());
        verify(passwordManager).getPasswordEncrypted();
        verify(passwordManager).getSalt();

    }

}

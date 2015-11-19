package com.adoraitunes.security;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ascariromopedraza on 17/11/15.
 */
public class PasswordManagerTest {

    private PasswordManager passwordManager;

    @Before
    public void setUp(){
        passwordManager = new PasswordManager();
    }

    @Test
    public void obtenerPasswordEncriptadoConSaltAleatorio(){
        String password = "ask123";

        passwordManager.setPlainPassword(password);

        String passwordHashed = new Sha256Hash(password,passwordManager.getSalt(), 1024).toHex();

        assertEquals(passwordHashed, passwordManager.getPasswordEncrypted());
    }

    @Test
    public void obtenerPasswordEncriptadoConSaltEstablecido(){
        String password = "adoraiTunes@123";

        passwordManager.setPlainPassword(password);
        passwordManager.setSalt("semilla123");

        String passwordHashed = new Sha256Hash(password, passwordManager.getSalt(), 1024).toHex();
        assertEquals(passwordHashed, passwordManager.getPasswordEncrypted());
    }

}

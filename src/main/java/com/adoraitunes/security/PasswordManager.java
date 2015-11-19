package com.adoraitunes.security;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by ascariromopedraza on 17/11/15.
 */
public class PasswordManager implements IPasswordManager{

    private String salt;
    private String plainPassword;

    public PasswordManager() {
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        salt = rng.nextBytes().toHex();
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPasswordEncrypted(){
        return new Sha256Hash(plainPassword,salt, 1024).toHex();
    }

}

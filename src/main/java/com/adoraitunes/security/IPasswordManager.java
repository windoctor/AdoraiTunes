package com.adoraitunes.security;

/**
 * Created by ascariromopedraza on 17/11/15.
 */
public interface IPasswordManager {

    String getPasswordEncrypted();
    String getPlainPassword();
    String getSalt();
    void setPlainPassword(String plainPassword);
    void setSalt(String salt);
}

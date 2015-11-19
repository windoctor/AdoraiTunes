package com.adoraitunes.security;

import com.adoraitunes.entities.Usuario;
import com.adoraitunes.services.interfaces.IUsuarioService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.tynamo.security.services.SecurityService;

/**
 * Created by ascariromopedraza on 22/08/15.
 */
public class UserAuthenticator extends AuthorizingRealm {

    @Inject
    private IUsuarioService userService;

    @Inject private SecurityService securityService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //Buscamos al usuario
        Usuario usuario = userService.findUserByName(upToken.getUsername());

        //Si no existe, devuelve null y lanzamos la excepción
        if(usuario == null)
            throw new UnknownAccountException();

            HashedCredentialsMatcher credentialsMatcher
                    = new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
            credentialsMatcher.setHashIterations(1024);

            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(usuario.getUsername(),
                            usuario.getPassword(),getName());

            simpleAuthenticationInfo.setCredentialsSalt(
                    ByteSource.Util.bytes(usuario.getSalt()));

            boolean isValidAuthentication =
                    credentialsMatcher.doCredentialsMatch(upToken, simpleAuthenticationInfo);

            System.out.println("isValidAuthentication = "+isValidAuthentication);

        if (isValidAuthentication) {
            Session session = securityService.getSubject().getSession();
            session.setAttribute("sessionUser",usuario);

            session.setAttribute("nombreUsuario",
                    usuario.getNombre()+" "+ usuario.getApellidos());
            session.setAttribute("fotoUsuario", usuario.getFoto());

            return new SimpleAuthenticationInfo(upToken.getUsername(), upToken.getPassword(), getName());
        }
        else
            throw new IncorrectCredentialsException();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}

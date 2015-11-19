package com.adoraitunes.services;

import com.adoraitunes.entities.Cancion;
import com.adoraitunes.services.interfaces.IAdminService;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

/**
 * Created by ascariromopedraza on 01/11/15.
 */
public class AdminService implements IAdminService {
    @Override
    public void addCancion(Cancion cancion) {

    }
/*
    @Inject
    private MongoDB mongoDB;

    private Jongo jongo;
    private MongoCollection mongoCollection;

    @Override
    public void addCancion(Cancion cancion) {
        jongo = new Jongo(mongoDB.getDefaultMongoDb());
        mongoCollection = jongo.getCollection("canciones");

        mongoCollection.save(cancion);
    }
    */
}

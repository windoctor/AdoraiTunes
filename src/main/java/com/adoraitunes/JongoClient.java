package com.adoraitunes;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

/**
 * Created by ascariromopedraza on 16/11/15.
 */
public class JongoClient {

    private MongoClient mongoClient;
    private DB database;
    private Jongo instance;

    public JongoClient(){
        mongoClient = new MongoClient("127.0.0.1");
        database = mongoClient.getDB("mundobyte");
        instance = new Jongo(database);

    }

    public  MongoCollection getCollection(String collection){
        return instance.getCollection(collection);
    }
}

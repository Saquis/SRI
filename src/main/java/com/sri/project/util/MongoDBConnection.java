package com.sri.project.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    // URI de conexión a MongoDB
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "SRI";

    // Objeto MongoDatabase (singleton para reutilizar la conexión)
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTION_STRING));
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }
}


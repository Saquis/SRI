package com.sri.project;

import com.mongodb.client.MongoDatabase;
import com.sri.project.util.MongoDBConnection;

public class TestMongoDB {
    public static void main(String[] args) {
        try {
            MongoDatabase database = MongoDBConnection.getDatabase();
            System.out.println("Conexión exitosa a la base de datos: " + database.getName());
        } catch (Exception e) {
            System.err.println("Error al conectar con MongoDB: " + e.getMessage());
        }
    }
}


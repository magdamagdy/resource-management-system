package com.exalt.resourcemanagementsystem.dbconfiguration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Database.
 */
// Singleton design pattern for database
public class Database {

    /**
     * The constant mapper.
     */
    public static AeroMapper mapper;

    /**
     * private constructor provides the actual connection to database server
     */
    private Database(){
        try (InputStream input = new FileInputStream("/home/magda/Sample Project/resource-management-system/src/main/resources/config.properties")){
            Properties prop = new Properties();
            prop.load(input);

            AerospikeClient client = new AerospikeClient( (prop.getProperty("aerospike.host")),
               Integer.parseInt(prop.getProperty("aerospike.port")));
            //java object mapping
            mapper = new AeroMapper.Builder(client).build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * inner class that provides thread safe
     * Bill Pugh approach
     */
    private static class databaseHolder {
        private static final Database instanceHolder = new Database();
    }

    /**
     * Get instance database.
     * The method that controls access to the singleton instance
     * @return the database
     */
    public static Database getInstance(){
        return databaseHolder.instanceHolder;
    }

}

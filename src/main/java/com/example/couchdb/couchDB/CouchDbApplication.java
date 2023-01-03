package com.example.couchdb.couchDB;

import com.cloudant.client.api.Database;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.DesignDocument;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.Session;
import org.w3c.dom.Document;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CouchDbApplication {
    public static void main(String[] args) throws MalformedURLException {
        HttpClient httpClient = new StdHttpClient.Builder().host("localhost")
                .port(5984)
                .username("admin")
                .password("couchdb")
                .build();
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        System.out.println(dbInstance);
        CouchDbConnector db = new StdCouchDbConnector("sample", dbInstance);
        db.createDatabaseIfNotExists();
        DesignDocument dd = new DesignDocument("121");
        db.create(dd);
    }
}

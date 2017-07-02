/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.services;

import com.blazzify.Util;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class ArticleService {
    String host;
    MongoClientURI uri;
    MongoDatabase db;
    MongoCollection<Document> articles;

    public ArticleService() {
        host = "mongodb://azzuwan:Reddoor74@aws-ap-southeast-1-portal.2.dblayer.com:15501/admin";
        uri = new MongoClientURI(host);
        db = new MongoClient(uri).getDatabase("news");
        articles = db.getCollection("articles");
    }

    public String search(String keywords) {
        MongoCursor<Document> all = articles.find(Filters.text(keywords)).iterator();
        return Util.json(all);
    }
}

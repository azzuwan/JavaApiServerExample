/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class Util {
    public static String json(MongoCursor<Document> cursor) {        
        boolean first = true;
        String data = "[";
        while (cursor.hasNext()) {
            if(!first){
                data += ",";
            }
            Document doc = cursor.next();            
            data += doc.toJson();
            first = false;
        }
        data += "]";        
        return data;
    }
}

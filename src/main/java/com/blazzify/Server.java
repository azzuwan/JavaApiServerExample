/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify;

import com.blazzify.services.ArticleService;
import static spark.Spark.get;
/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class Server {
    public static void main(String[] args) {
        ArticleService service = new ArticleService();
        get("/", (req, res) -> "Hello World");
        get("/articles/:keywords", (req, res) -> {
            res.type("application/json");
            String keyword = req.params(":keywords");
            return  service.search(keyword);
        });
    }
}

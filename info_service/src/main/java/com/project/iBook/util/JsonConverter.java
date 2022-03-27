package com.project.iBook.util;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonConverter {

    public static JSONObject stringToJson(String json) {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

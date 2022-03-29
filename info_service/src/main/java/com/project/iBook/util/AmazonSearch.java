package com.project.iBook.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class AmazonSearch {

    private static final String rainforestApi = "https://api.rainforestapi.com/request?api_key=" +
            "9C6577D3F1D14CE7A50A7DAF115E6F6D&type=product&amazon_domain=amazon.com&gtin=";

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    public double[] searchPrice(String isbn_13) {
        double[] res = new double[2];
        String address = rainforestApi + isbn_13;
        restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(address, String.class);

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(jsonString, JsonObject.class);

        JsonElement rating = ((JsonObject)(json.get("product"))).get("rating");
        double ratingScore = Double.parseDouble(rating.getAsString());
        res[0] = ratingScore;

        JsonElement buybox_winner = ((JsonObject)(json.get("product"))).get("buybox_winner");
        JsonElement temp = buybox_winner.getAsJsonObject().get("price");
        String price = temp.getAsJsonObject().get("value").getAsString();
        res[1] = Double.parseDouble(price);
        return res;
    }

//    public double[] searchPrice(String isbn_13) {
//        double[] res = new double[2];
//        String address = rainforestApi + isbn_13;
//
//        String jsonString = GetRequest.getRequest(address);
////        String jsonString = restTemplate.getForObject(address, String.class);
//        JSONParser parser = new JSONParser();
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = (JSONObject) parser.parse(jsonString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        double ratingScore = (double)(((JSONObject)jsonObject.get("product")).get("rating"));
//
////        JsonObject rating = ((JsonObject)(json.get("product"))).get("rating").getAsJsonObject();
////        double ratingScore = Double.parseDouble(rating.getAsString());
//        res[0] = ratingScore;
//
//        JSONObject tempJson = (JSONObject) (((JSONObject) jsonObject.get("product")).get("buybox_winner"));
//        double price = (double)(((JSONObject)(tempJson.get("price"))).get("value"));
//
////        JsonObject buybox_winner = ((JsonObject)(json.get("product"))).get("buybox_winner").getAsJsonObject();
////        String price = ((JsonObject)(buybox_winner.get("price"))).get("value").getAsString();
////        res[1] = Double.parseDouble(price);
//        res[1] = price;
//
//        return res;
//    }

}

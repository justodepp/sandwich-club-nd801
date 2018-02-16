package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject root = new JSONObject(json);
            // names
            JSONObject name = null;
            if(root.has("name"))
                name = root.getJSONObject("name");
            String mainName = "";
            if(name.has("mainName"))
                mainName = name.getString("mainName");
            JSONArray alsoKnownAs = null;
            if(name.has("alsoKnownAs"))
                alsoKnownAs = name.getJSONArray("alsoKnownAs");

            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            if(alsoKnownAs.length() > 0)
                for(int i=0; i<alsoKnownAs.length(); i++){
                    alsoKnownAsList.add(alsoKnownAs.getString(i));
                }


            String placeOfOrigin = "";
            if(root.has("placeOfOrigin"))
                placeOfOrigin = root.getString("placeOfOrigin");
            String description = "";
            if(root.has("description"))
                description = root.getString("description");
            String image = "";
            if(root.has("image"))
                image = root.getString("image");
            JSONArray ingredients = null;
            if(root.has("ingredients"))
                ingredients = root.getJSONArray("ingredients");

            ArrayList<String> ingredientsList = new ArrayList<>();
            if(ingredients.length() > 0)
                for(int i=0; i<ingredients.length(); i++){
                    ingredientsList.add(ingredients.getString(i));
                }

            // return
            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

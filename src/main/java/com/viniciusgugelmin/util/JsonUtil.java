package main.java.com.viniciusgugelmin.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtil {
    public static <T> String arrToJsonString(ArrayList<T> list) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (T item : list) {
            jsonArray.put(item);
        }
        return jsonArray.toString();
    }

    public static <T> ArrayList<T> jsonToStringArr(String json, String key) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);

        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return (ArrayList<T>) jsonArray.toList();
    }
}

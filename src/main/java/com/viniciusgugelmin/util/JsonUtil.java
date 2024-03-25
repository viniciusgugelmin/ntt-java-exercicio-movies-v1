package main.java.com.viniciusgugelmin.util;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class JsonUtil {
    public static String arrToJsonString(ArrayList<String> list) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (String item : list) {
            jsonArray.put(item);
        }
        return jsonArray.toString();
    }

    public static ArrayList<String> jsonToStringArr(String json) throws JSONException {
        ArrayList<String> arr = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            arr.add(jsonArray.getString(i));
        }
        return arr;
    }
}

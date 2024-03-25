package main.java.com.viniciusgugelmin.util;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class JsonUtil {
    public static <T> String arrToJsonString(ArrayList<T> list) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (T item : list) {
            jsonArray.put(item);
        }
        return jsonArray.toString();
    }

    public static <T> ArrayList<T> jsonToStringArr(String json) throws JSONException {
        ArrayList<T> arr = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            arr.add((T) jsonArray.getString(i));
        }
        return arr;
    }
}

package utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
    public static Object[][] getLoginData(InputStream inputStream) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray dataArray = (JSONArray) parser.parse(new InputStreamReader(inputStream));
            Object[][] loginData = new Object[dataArray.size()][2];

            for (int i = 0; i < dataArray.size(); i++) {
                JSONObject obj = (JSONObject) dataArray.get(i);
                loginData[i][0] = obj.get("username");
                loginData[i][1] = obj.get("password");
            }

            return loginData;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

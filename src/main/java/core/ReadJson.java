package core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.pmw.tinylog.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadJson {
    private static JsonParser parser = new JsonParser();

    public static String getJson(String property, String path) {
        try {
            Object obj = parser.parse(new FileReader(path));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            Logger.error(e.getMessage(), e);
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        return "";
    }
}

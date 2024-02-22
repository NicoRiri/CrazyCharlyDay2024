import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class URLToJson {
    private static String lienDuSite = "http://docketu.iutnc.univ-lorraine.fr:35652";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    /* exemple de json
    {
    "data": [
        {
            "id": 3,
            "nom": "Charlie",
            "email": "charlie@mail.com",
            "voeux": [
                {
                    "id": 2,
                    "titre": "Français",
                    "theme": "FR",
                    "ordre": 2
                }
            ]
        },
        {
            "id": 5,
            "nom": "Eve",
            "email": "eve@mail.com",
            "voeux": [
                {
                    "id": 5,
                    "titre": "Orientale",
                    "theme": "OR",
                    "ordre": 2
                }
            ]
        },
        {
            "id": 6,
            "nom": "un",
            "email": "ultranigga@mail.com",
            "voeux": [
                {
                    "id": 2,
                    "titre": "Français",
                    "theme": "FR",
                    "ordre": 3
                }
            ]
        },
        {
            "id": 7,
            "nom": "Edouard",
            "email": null,
            "voeux": [
                {
                    "id": 2,
                    "titre": "Français",
                    "theme": "FR",
                    "ordre": 1
                },
                {
                    "id": 3,
                    "titre": "Amérique du Sud",
                    "theme": "MEX",
                    "ordre": 2
                }
            ]
        }
    ]
}
     */
    public static void main(String[] args) throws IOException, JSONException {//gestion ateliers
        JSONObject jsonAtelier = readJsonFromUrl(lienDuSite + "/atelier");
        JSONArray arrayAtelier = (JSONArray) jsonAtelier.get("data");
        Atelier[] ateliers = new Atelier[arrayAtelier.length()];
        final int[] i = {0};
        arrayAtelier.forEach(atel -> {
            JSONObject atelier = (JSONObject) atel;
            ateliers[i[0]] = new Atelier((String) atelier.get("theme"), (int) atelier.get("placeDispo"));
            i[0]++;
        });

        //gestion voeux
        JSONObject jsonVoeu = readJsonFromUrl(lienDuSite + "/voeux");
        JSONArray arrayVoeu = (JSONArray) jsonVoeu.get("data");


    }
}

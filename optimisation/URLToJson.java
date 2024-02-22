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

    public static void main(String[] args) throws IOException, JSONException {
        //gestion ateliers
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

        //construire une liste de candidats et une liste d'ateliers
        List<Candidat> candidats = new ArrayList<>();
        arrayVoeu.forEach(candid -> {
            JSONObject candidat = (JSONObject) candid;
            String nom = (String) candidat.get("nom");
            JSONArray voeux = (JSONArray) candidat.get("voeux");
            Atelier[] voeuxCandidats = new Atelier[voeux.length()];
            int u = 0;
            //boucle trop compliquée pour ajouter les voeux
            for(Object vo:voeux){
                JSONObject voeu = (JSONObject) vo;

                String at = (String) voeu.get("theme");

                for (int j = 0; j< ateliers.length; j++){
                    if(at.equals(ateliers[j].getNom())){
                        voeuxCandidats[u] = ateliers[j];
                        u++;
                    }
                }

                //Ordre des voeux ici TODO
            }

            candidats.add(new Candidat(nom, voeuxCandidats, voeux.length()));
        });

        System.out.println("");
    }
}

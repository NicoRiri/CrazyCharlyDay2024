import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
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
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    public static void sendJsonToUrl(String url, String JSon) throws IOException, JSONException {
        OutputStream os = new URL(url + "/voeux/resultat").openConnection().getOutputStream();
        try {
            os.write(JSon.getBytes());
        } finally {
            os.close();
        }
    }
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
        System.out.println(Arrays.toString(ateliers));

        //gestion voeux
        JSONObject jsonVoeu = readJsonFromUrl(lienDuSite + "/voeux");
        JSONArray arrayVoeu = (JSONArray) jsonVoeu.get("data");
        System.out.println(arrayVoeu);

        List<Candidat> candidats = new ArrayList<>();
        arrayVoeu.forEach(voeu -> {
            JSONObject candidat = (JSONObject) voeu;
            JSONArray arrayVoeux = (JSONArray) candidat.get("voeux");
            Atelier[] voeux = new Atelier[arrayVoeux.length()];
            final int[] j = {0};
            arrayVoeux.forEach(v -> {
                JSONObject voeu1 = (JSONObject) v;
                voeux[j[0]] = ateliers[(int) voeu1.get("ordre") - 1];
                j[0]++;
            });
            candidats.add(new Candidat((String) candidat.get("nom"), voeux, voeux.length));
        });

        AlgoRecuitSimule algo = new AlgoRecuitSimule();
        State s = algo.algo(candidats, List.of(ateliers));

        System.out.println(s.toJson());
        sendJsonToUrl(lienDuSite, s.toJson());


    }
}

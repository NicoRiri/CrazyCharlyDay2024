import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidat {

  String nom;

  int nbVoeux;
  Atelier[] voeux;

  ArrayList<String> voeuxAccordes;

  public Candidat(String nom, Atelier[] voeux, int nbVoeux) {
    this.nom = nom;
    this.voeux = voeux;
    this.nbVoeux = nbVoeux;
    this.voeuxAccordes = new ArrayList<>();
  }

  public Atelier[] getVoeux() {
    return voeux;
  }

  public int getNbVoeux() {
    return nbVoeux;
  }

  public void ajouterVoeuAccorde(String voeu) {
    voeuxAccordes.add(voeu);
  }

  public List<String> getVoeuAccorde() {
    return voeuxAccordes;
  }

  @Override
  public String toString() {
    return "Candidat{" +
            "nom='" + nom + '\'' +
            ", nbVoeux=" + nbVoeux +
            ", voeux=" + Arrays.toString(voeux) +
            ", voeuxAccordes=" + voeuxAccordes +
            '}';
  }

  public Candidat clone() {
    Candidat res = new Candidat(nom, voeux, nbVoeux);
    res.voeuxAccordes = new ArrayList<>(voeuxAccordes);
    return res;
  }

  public String toJson() {
    String res = "{" +
            "\"nom\" : \"" + nom + '\"' +
            ", \"voeuxAccordes\" : [";
    for (int i = 0; i < voeuxAccordes.size(); i++) {
      res +="{\"theme\" : \"" + voeuxAccordes.get(i) + "\"}";
      if (i != voeuxAccordes.size() - 1) {
        res += ", ";
      }
    }
    res += "]}";
    return res;
  }
}

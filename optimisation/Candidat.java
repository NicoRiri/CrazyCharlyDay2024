import java.util.ArrayList;
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
}

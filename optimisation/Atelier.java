public class Atelier {
  String nom;
  int nbPlaces;
  int nbPlacesRestantes;

  public Atelier(String nom, int nbPlaces) {
    this.nom = nom;
    this.nbPlaces = nbPlaces;
    this.nbPlacesRestantes = nbPlaces;
  }

  public String getNom() {
    return nom;
  }
  public int getNbPlces() {
    return nbPlaces;
  }

  public void addCandidat(Candidat candidat) {
    if (nbPlacesRestantes > 0) {
      nbPlacesRestantes--;
      candidat.ajouterVoeuAccorde(nom);
    }
  }

  public int getNbPlacesRestantes() {
    return nbPlacesRestantes;
  }

  @Override
  public String toString() {
    return  nom;
  }
}

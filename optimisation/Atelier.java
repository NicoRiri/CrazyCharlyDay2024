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

    public void removeCandidat(Candidat candidat) {
        if (candidat.getVoeuAccorde().contains(nom)) {
            nbPlacesRestantes++;
            candidat.getVoeuAccorde().remove(nom);
        }
    }

    public int getNbPlacesRestantes() {
        return nbPlacesRestantes;
    }

    @Override
    public String toString() {
        return nom + " " + nbPlacesRestantes;

    }

    public Atelier clone() {
        Atelier res = new Atelier(nom, nbPlaces);
        res.nbPlacesRestantes = nbPlaces;
        return res;
    }
}

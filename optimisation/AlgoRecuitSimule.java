import java.util.List;

public class AlgoRecuitSimule {
  private int nbEtapes;
  private final int nbMaxEtapes = 1_000_000;
  private int eMax;

  public AlgoRecuitSimule() {
    //TODO
  }

  private double getTemp(int nbEtapes, int MaxEtapes) {
    return 1 - (double) nbEtapes / MaxEtapes;
  }

  private double getProba(double diffEn, double temp) {
    return Math.exp(-diffEn / temp);
  }

  public State algo(List<Candidat> candidats, List<Atelier> ateliers) {
    eMax = 20 * candidats.size();
    State etatOptimal = State.getRandomState(candidats, ateliers);
    int energieDeLEtat = -etatOptimal.getScore();
    int meilleureEnergie = energieDeLEtat;
    Candidat[] candidatsOptimaux = etatOptimal.cloneCandidats();
    State tempEtat;
    int tempEnergie;
    System.out.println("Energie initiale : " + energieDeLEtat);
    do {
      // prendre un voisin au hasard
      tempEtat = State.getNeighbourState(etatOptimal);
      //System.out.println(tempEtat.getScore());
      tempEnergie = -tempEtat.getScore();
      // si le voisin ameliore la solution ou proba=> je bascule sur le voisin
      if (tempEnergie < energieDeLEtat /*|| Math.random() < getProba(energieDeLEtat - tempEnergie, getTemp(nbEtapes, nbMaxEtapes))*/) {
        System.out.println("better");
        energieDeLEtat = tempEnergie;
        //System.out.println(etatOptimal.getScore());
      }


      if (tempEnergie < meilleureEnergie) {
        System.out.println("Nouvelle meilleure énergie : " + meilleureEnergie + " -> " + energieDeLEtat);
        System.out.println("Nouveau meilleur score : " + etatOptimal.getScore() + " -> " + tempEtat.getScore());
        etatOptimal = tempEtat;
        System.out.println(etatOptimal + "\n\n");
        meilleureEnergie = tempEnergie;
        candidatsOptimaux = etatOptimal.cloneCandidats();
      } else {
        //etatOptimal = State.reverseLastEdit(tempEtat);
      }

      nbEtapes++;
    } while (nbEtapes < nbMaxEtapes && energieDeLEtat < eMax);
    etatOptimal.setCandidats(candidatsOptimaux);
    return etatOptimal;
  }

/*

  public State algo(List<Candidat> candidats, List<Atelier> ateliers){
    // etat courant
    // tant que pas fini
      // voisin <- courant.hasard
      // si voisin ameliore (ou T) => courant <- voisin
          // si nouvel etat > maximumv => maximu vu = nouveletat
  }*/
}

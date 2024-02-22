import java.util.List;

public class AlgoRecuitSimule {
  private int nbEtapes;
  private final int nbMaxEtapes = 1_000_000;
  private int eMax;

  public AlgoRecuitSimule(){
    //TODO
  }

  private double getTemp(int nbEtapes, int MaxEtapes){
    return 1 - (double)nbEtapes/MaxEtapes;
  }

  private double getProba(double diffEn, double temp){
    return Math.exp(-diffEn/temp);
  }

  public State algo(List<Candidat> candidats, List<Atelier> ateliers){
    eMax = 20*candidats.size();
    State etatOptimal = State.getRandomState(candidats, ateliers);
    int energieDeLEtat = -etatOptimal.getScore();
    int meilleureEnergie = energieDeLEtat;

    State tempEtat;
    int tempEnergie;
    do {
      tempEtat = State.getNeighbourState(etatOptimal);
      System.out.println(tempEtat + "\n\n");
      tempEnergie = -tempEtat.getScore();
      if(tempEnergie < energieDeLEtat || Math.random() < getProba(energieDeLEtat - tempEnergie, getTemp(nbEtapes, nbMaxEtapes))){
        energieDeLEtat = tempEnergie;
        //System.out.println(etatOptimal.getScore());
      }
      if(energieDeLEtat < meilleureEnergie){
        System.out.println("Nouvelle meilleure énergie : " + meilleureEnergie + " -> " + energieDeLEtat);
        System.out.println("Nouveau meilleur score : " + etatOptimal.getScore() + " -> " + tempEtat.getScore());
        etatOptimal = tempEtat;
        meilleureEnergie = tempEnergie;
      }
      nbEtapes++;
    } while (nbEtapes < nbMaxEtapes && energieDeLEtat < eMax);
    return etatOptimal;
  }
}

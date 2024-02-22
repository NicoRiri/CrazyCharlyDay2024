import java.util.List;

public class AlgoRecuitSimule {
  private double energie;
  private int nbEtapes;
  private final int nbMaxEtapes = 100_000;
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
    State etat = State.getRandomState(candidats, ateliers);
    State etatOptimal = etat;
    int meilleureEnergie = eMax/etatOptimal.getScore();

    State tempEtat;
    int tempEnergie = eMax/etat.getScore();
    int energieDAvant;
    do {
      energieDAvant = tempEnergie;
      tempEtat = State.getNeighbourState(etatOptimal);
      tempEnergie = eMax/tempEtat.getScore();
      if(tempEnergie < meilleureEnergie || Math.random() <getProba(energieDAvant - tempEnergie, getTemp(nbEtapes, nbMaxEtapes))){
        etatOptimal = tempEtat;
        meilleureEnergie = tempEnergie;
      }
      if(tempEnergie < meilleureEnergie){
        System.out.println("Nouvelle énergie : " + tempEnergie);
        etatOptimal = tempEtat;
        meilleureEnergie = tempEnergie;
      }
      nbEtapes++;
    } while (nbEtapes < nbMaxEtapes && energie < eMax);
    return etatOptimal;
  }
}
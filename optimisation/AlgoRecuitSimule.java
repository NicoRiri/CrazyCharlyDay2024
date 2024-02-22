import java.util.List;

public class AlgoRecuitSimule {
  private double energie;
  private int nbEtapes;
  private final int nbMaxEtapes = 100_000;
  private int energieMin;

  public AlgoRecuitSimule(){
    //TODO
  }

  public State algo(List<Candidat> candidats, List<Atelier> ateliers){
    energieMin = 60*candidats.size();
    State etat = State.getRandomState(candidats, ateliers);
    State etatOptimal = etat;
    int meilleureEnergie = energieMin/etatOptimal.getScore();

    State tempEtat;
    int tempEnergie;
    while (nbEtapes < nbMaxEtapes && energie < energieMin){
      tempEtat = State.getNeighbourState(etatOptimal);
      tempEnergie = energieMin/tempEtat.getScore();
      if(tempEnergie < meilleureEnergie || Math.random() < Math.exp((meilleureEnergie - tempEnergie) / energie)){
        etatOptimal = tempEtat;
        meilleureEnergie = tempEnergie;
      }
      if(tempEnergie < meilleureEnergie){
        etatOptimal = tempEtat;
        meilleureEnergie = tempEnergie;
      }
      nbEtapes++;
    }
    return etatOptimal;
  }
}

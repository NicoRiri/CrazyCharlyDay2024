import java.util.List;

public class AlgoRecuitSimule {
  private double energie;
  private int nbEtapes;
  private final int nbMaxEtapes = 100_000;
  private final double energieMin = 100_000;

  public AlgoRecuitSimule(){
    //TODO
  }

  public void algo(List<Candidat> candidats, List<Atelier> ateliers){
    State etat = State.getRandomState(candidats, ateliers);
    State etatOptimal = etat;
    int meilleureEnergie = etatOptimal.getScore();

    State tempEtat;
    int tempEnergie;
    while (nbEtapes < nbMaxEtapes && energie < energieMin){
      tempEtat = State.getNeighbourState(etatOptimal);
      tempEnergie = tempEtat.getScore();
      if(tempEnergie < meilleureEnergie || Math.random() < Math.exp((meilleureEnergie - tempEnergie) / energie)){
        etatOptimal = tempEtat;
        meilleureEnergie = tempEnergie;
      }
    }
  }
}

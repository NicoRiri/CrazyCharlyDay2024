import java.util.ArrayList;
import java.util.List;

public class State {

  List<Candidat> candidats;
  List<Atelier> ateliers;
  private State(){}

  public int getScore(){
    return CalculateurDeScore.score(candidats);
  }

  public static State getRandomState(List<Candidat> candidats, List<Atelier> ateliers){
    State res = new State();
    res.ateliers = ateliers;
    res.candidats = candidats;
    for (Candidat candidat : res.candidats) {
      for (Atelier atelier : res.ateliers) {
        if (Math.random() > 0.5 && atelier.getNbPlacesRestantes() > 0) {
          atelier.addCandidat(candidat);
        }
      }
    }
    return res;
  }

  public static State getNeighbourState(State state){
    return new State();
  }
}

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

  //créé un nouvel état en changeant un candidat d'atelier
  public static State getNeighbourState(State state){
    State res = new State();
    res.ateliers = state.ateliers;
    res.candidats = new ArrayList<>(state.candidats);
    int i = (int) (Math.random() * res.candidats.size());
    Candidat candidat = res.candidats.get(i);
    Atelier atelier = res.ateliers.get((int) (Math.random() * res.ateliers.size()));
    if (atelier.getNbPlacesRestantes() > 0) {
      atelier.addCandidat(candidat);
    }
    return res;
  }

  @Override
  public String toString() {
    return "State{" +
      "candidats=" + candidats +
      '}';
  }
}

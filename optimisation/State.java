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
    State res = new State();
    res.ateliers = new ArrayList<>(state.ateliers);
    res.candidats = new ArrayList<>(state.candidats);
    int i = (int) (Math.random() * res.candidats.size());
    int j = (int) (Math.random() * res.ateliers.size());
    if (res.ateliers.get(j).getNbPlacesRestantes() > 0) {
      // si le candidat est déjà dans l'atelier, on le retire
      if (res.candidats.get(i).getVoeuAccorde().contains(res.ateliers.get(j).getNom())) {
        // on retire le candidat de l'atelier
        res.ateliers.get(j).removeCandidat(res.candidats.get(i));
      }
      // sinon on l'ajoute
      else {
        // on ajoute le candidat à l'atelier
        res.ateliers.get(j).addCandidat(res.candidats.get(i));
      }
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

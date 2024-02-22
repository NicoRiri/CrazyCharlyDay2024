import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class State {

  List<Candidat> candidats;
  List<Atelier> ateliers;
  private State(){}

  public int getScore(){
    return CalculateurDeScore.score(candidats);
  }
  private static int[] lastEdit;

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
    res.candidats = List.copyOf(state.candidats);
    Random random = new Random();
    int i = random.nextInt(res.candidats.size());
    int j = random.nextInt(res.ateliers.size());
    lastEdit = new int[]{i, j};
    if (res.candidats.get(i).getVoeuAccorde().contains(res.ateliers.get(j).getNom())) {
      res.ateliers.get(j).removeCandidat(res.candidats.get(i));
    } else {
      res.ateliers.get(j).addCandidat(res.candidats.get(i));
    }
    return res;
  }

  public static State reverseLastEdit(State state){
    State res = new State();
    res.ateliers = state.ateliers;
    res.candidats = List.copyOf(state.candidats);
    if (res.candidats.get(lastEdit[0]).getVoeuAccorde().contains(res.ateliers.get(lastEdit[1]).getNom())) {
      res.ateliers.get(lastEdit[1]).removeCandidat(res.candidats.get(lastEdit[0]));
    } else {
      res.ateliers.get(lastEdit[1]).addCandidat(res.candidats.get(lastEdit[0]));
    }
    return res;
  }

  public Candidat[] cloneCandidats(){
    Candidat[] res = new Candidat[candidats.size()];
    for (int i = 0; i < candidats.size(); i++) {
      res[i] =(candidats.get(i).clone());
    }
    return res;
  }

  public void setCandidats(Candidat[] candidats) {
    this.candidats = List.of(candidats);
  }

  public String toString() {
    return "State{" +
      "candidats=" + candidats +
      '}';
  }

  public String toJson(){
    return "{candidats: " + candidats + "}";
  }
}

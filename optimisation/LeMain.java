import java.util.ArrayList;

public class LeMain {
  public static void main(String args[]) {
    ArrayList<Atelier> ateliers = new ArrayList<Atelier>();
    for (int i = 0; i < 6; i++) {
      ateliers.add(new Atelier("Atelier " + i, 3));
    }
    ArrayList<Candidat> candidats = new ArrayList<Candidat>();
    for (int i = 0; i < 10; i++) {
      Atelier[] voeux = new Atelier[3];
      for (int j = 0; j < 3; j++) {
        voeux[j] = ateliers.get((int) (Math.random() * 6));
      }
      candidats.add(new Candidat("Candidat " + i, voeux, 3));
    }
    AlgoRecuitSimule algo = new AlgoRecuitSimule();
    State s = algo.algo(candidats, ateliers);
    //System.out.println(s);
    System.out.println(s.toJson());
    System.out.println(s.getScore());
  }
}

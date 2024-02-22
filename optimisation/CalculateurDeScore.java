import java.util.List;

public class CalculateurDeScore {

  public static int[] poidsVoeud = {10, 8, 6, 4, 2, 1};

  public static int score(List<Candidat> candidats) {
    //System.out.println(candidats);
    int score = 0;
    int maxVoeux = 0;
    //gain par preference
    for (Candidat candidat : candidats) {
      if (candidat.getNbVoeux() > maxVoeux) maxVoeux = candidat.getNbVoeux();
      //tout le monde est servi
      if (candidat.getVoeuAccorde().isEmpty()) {
        score -= 10;
        continue;
      }
      int nbVeux = 0;
      for (int i = 0; i < candidat.getNbVoeux(); i++) {
        if (candidat.getVoeuAccorde().contains(candidat.getVoeux()[i].getNom())) {
          //utilite degressive
          score += poidsVoeud[Math.min(i + nbVeux, poidsVoeud.length - 1)];
          nbVeux++;
        }
      }
    }
    //regle d'equite
    for (Candidat candidat : candidats) {
      if(candidat.getVoeuAccorde().size() < maxVoeux-1 && !(candidat.getVoeuAccorde().size() == candidat.nbVoeux)) score -= 10;
    }
    return score;
  }
}

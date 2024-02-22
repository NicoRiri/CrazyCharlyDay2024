public class CalculateurDeDistanceAvecVoeux {
  private static final int[] poidsVoeud = {15,12,10,8,7,6};

  public static int distance(String[] voeux1, String voeuAccorde) {
    int distance = 0;
    for (int i = 0; i < voeux1.length; i++) {
      if (voeux1[i].equals(voeuAccorde)) break;
      distance += poidsVoeud[i];
    }
    return distance;
  }
}

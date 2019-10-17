import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class PrepaProj {

    static HashMap<String, Integer> words = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        /* /home/bnp-renault-010/Bureau/premier-git/corp-bnp-renault/session1/ressource/books */

        /* nombre de lignes du fichier */
//        int nblignes = nbLignesFic("Test1.txt");

        /* nombre de mots distincts du fichier */
//        int nbmots = nbMotsDiff("Test1.txt");

        /* liste des 50 mots les plus utilisés */
//        mots50("Test1.txt");
    }


    public static int nbLignesFic(String nomFichier) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(nomFichier));
        ArrayList<String> listMots = new ArrayList<>();

        for (int i = 0; sc.hasNextLine(); ++i) {
            listMots.add(sc.nextLine());
//            System.out.println("sc nextline: " + sc.nextLine());
        }

        System.out.println("nombre de lignes du fichier : " + listMots.size());
        int taille = listMots.size();
//        System.out.println("premier mot: " + listMots.get(0));
//        System.out.println("dernier mot: " + listMots.get(listMots.size() - 1));

        sc.close();

        return taille;
    }


    public static int nbMotsDiff(String nomFichier) throws FileNotFoundException {

        /* nombre de mots distincts du fichier */

        Scanner sc2 = new Scanner(new File(nomFichier));
//        HashMap<String, Integer> words = new HashMap<>();
        String MotLu = " ";
        /*remplissage de la hashmap avec en clé les mots, et en valeur, le nombre de fois que le mot apparait */
        for (int i = 0; sc2.hasNextLine(); ++i) {
            MotLu = sc2.nextLine();
            if (words.containsKey(MotLu)) {
                int valueI = words.get(MotLu);
                words.put(MotLu, valueI + 1);

            } else {
                words.put(MotLu, 1);
            }
        }

        System.out.println("Le nombre de mots distincts est : " + words.size());
        return words.size();
    }


    public static void mots50(String nomFichier) {

        /* 50 mots les plus utilisés */


        /*crée une arraylist contenant toutes les valeurs de la hashmap */
        ArrayList<Integer> list2 = new ArrayList<>(words.values());
        /*trie l'arraylist décroissant : on a donc toutes les valeurs de la hashmap par ordre décroissant */
        Collections.sort(list2, Collections.reverseOrder());

//        System.out.println("liste2: " + list2);

//        System.out.println("entryset: " + words.entrySet());

        Set<Map.Entry<String, Integer>> set1 = words.entrySet(); /*crée juste la référence */

        for (int ind = 0; ind < 50; ind++) {
            int val = list2.get(ind);
//            System.out.println("val: " + val);
            for (Map.Entry<String, Integer> setTravail : set1) {    /*on affecte les valeurs du set */
                setTravail.getKey();
                setTravail.getValue();
                if (val == setTravail.getValue()) {
                    System.out.println("Top " + (ind + 1) + " le mot: " + setTravail.getKey() + " est utilisé: " + val + " fois");
                }
//                System.out.println(setTravail.getKey());
//                System.out.println(setTravail.getValue());
            }
        }
//        sc2.close();
//        return;
    }
}







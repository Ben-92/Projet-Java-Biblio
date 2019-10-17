import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ProjetBiblio {
    /*/home/bnp-renault-010/IdeaProjects/Projet2 */
    /* /home/bnp-renault-010/Documents/Ressources/Projet-biblio */

    /*Lister les fichiers du répertoire */

    /*création d'une référence vers un objet file */
        static File fichier = new File("/home/bnp-renault-010/Documents/Ressources/Projet-biblio/");
//    static File fichier = new File("/home/bnp-renault-010/IdeaProjects/Projet2/Ressources/ ");


    /*source : https://stackoverflow.com/questions/7301764/how-to-get-contents-of-a-folder-and-put-into-an-arraylist */
    /* on met dans une arraylist les files du répertoire */
    static ArrayList<String> noms = new ArrayList<String>(Arrays.asList(fichier.list()));


    public static void main(String[] args) throws IOException {

//        System.out.println("main");

        /*afficher le menu A (menu principal) */

        int choix = affichMenuA();
        do {
            switch(choix) {
                case 1:
//                System.out.println("case 1");

                    /*afficher la liste des fichiers*/
                    affichListfic();
                    break;
                case 2:
//                System.out.println("case 2");
                    /*Ajouter le nom du fichier saisi au répertoire et à la liste */
                    ajoutFic();

                    break;
                case 3:
//                System.out.println("case 3");

                    /*affiche la liste des fichiers avec choix possible pour suppression d'un fichier*/
                    int choix3 = affichListficChoix('S');

                    /*Suppression du fichier saisi */
                    supprimFic(choix3);
                    break;
                case 4:
//                System.out.println("case 4");

                    /*affiche la liste des fichiers avec choix possible du fichier*/
                    /*puis affiche un menu des actions possibles sur ce fichier*/
                    int choix4 = affichListficChoix('I');
                    affichMenuB(choix4);
                    break;
                case 5:
//                System.out.println("case 5");

                    /*sortie du programme */
                    break;
                default:
//                System.out.println("default case");
            }
            choix = affichMenuA();
        }
        while (choix != 5);
    }

    /* affiche le menu A et récupère le choix utilisateur */
    public static int affichMenuA(){
//        System.out.println("AffichMenuA");

        boolean valeurKo = true;
        int choix = 0;

        while (valeurKo) {
            try {
                /*afficher le menu A*/
                Scanner sc = new Scanner(System.in); // lecture depuis l'entrée standard (clavier)
                System.out.println("1 - lister les fichiers");
                System.out.println("2 - ajouter un fichier");
                System.out.println("3 - supprimer un fichier");
                System.out.println("4 - Afficher des infos sur un livre");
                System.out.println("5 - Quitter le programme");
                choix = sc.nextInt();
                valeurKo = false;
            } catch (InputMismatchException e) {
                System.out.println("valeur invalide");
            }
        }
        return choix;
    }

    /*affiche la liste des fichiers  */
    public static void affichListfic(){
//        System.out.println("AffichListfic");

        System.out.println("Liste des fichiers: ");
        for (int indice = 0; indice < noms.size(); indice++){
//            System.out.println((indice) + " " + noms.get(indice));
            System.out.println(noms.get(indice));
        }
        return;
    }

    public static void ajoutFic() throws IOException{
//        System.out.println("AjoutFic");
        System.out.println("Ajout de fichier");

        Scanner sc2 = new Scanner(System.in); // lecture depuis l'entrée standard (clavier)
        System.out.println("Veuillez saisir le nom du fichier sans l'extension .txt: ");
        String choix2 = sc2.nextLine();

        File ficAjout = new File("/home/bnp-renault-010/Documents/Ressources/Projet-biblio/", choix2+".txt");
//        File ficAjout = new File("./Ressources/", choix2+".txt");
        if (!ficAjout.exists()){
            ficAjout.createNewFile();
            /*ajouter le fichier dans la liste */
            noms.add(choix2 + ".txt");
            System.out.println("le fichier " + choix2 + " a bien été ajouté");
        }

    }

    public static void supprimFic(int choix){
//      System.out.println("supprimFic");
        System.out.println("Suppression d'un fichier");

        String nomSaisi = noms.get(choix);

        File ficDelete = new File("/home/bnp-renault-010/Documents/Ressources/Projet-biblio/", nomSaisi);
//        File ficDelete = new File("./Ressources/", nomSaisi);
        if (ficDelete.exists()){
            ficDelete.delete();
            /*supprimer le fichier dans la liste */
            noms.remove(choix);
            System.out.println("Le fichier " + nomSaisi + " a bien été supprimé");
        } else {
            System.out.println("Le fichier n existe pas");
        }
    }

    /*affiche la liste des fichiers et récupère le choix utilisateur */
    public static int affichListficChoix(char fonction){
//        System.out.println("affichListficChoix");
        if (fonction == 'S'){
            System.out.println("Suppression de fichier");

        } else {
            System.out.println("Information sur un livre");
        }

        int choix=0;

        for (int indice = 0; indice < noms.size(); indice++){
            System.out.println((indice) + " " + noms.get(indice));
        }
        boolean valeurKo = true;
        while (valeurKo) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Merci de choisir le numéro correspondant");
                choix = sc.nextInt();
                valeurKo = false;
            } catch (InputMismatchException e) {
                System.out.println("valeur invalide");
            }
        }

        return choix;
    }

    public static void affichMenuB(int choixfic) throws FileNotFoundException{
//        System.out.println("affichMenuB");

        int choix = 0;
        String nomChoisi = noms.get(choixfic);
        /*afficher le menu B*/

        boolean valeurKo = true;
        while (valeurKo) {
            try {
                Scanner sc = new Scanner(System.in); // lecture depuis l'entrée standard (clavier)
                System.out.println("Vous avez choisi le fichier: " + nomChoisi);
                System.out.println("1 - Afficher le nombre de ligne du fichier");
                System.out.println("2 - Afficher le nombre de mots distincts du fichier");

                choix = sc.nextInt();
                valeurKo = false;
            } catch (InputMismatchException e) {
                System.out.println("valeur invalide");
            }
        }


        switch(choix) {
            case 1:
//                System.out.println("case B 1");
                /*afficher le nombre de lignes du fichier */
                PrepaProj classe = new PrepaProj();
//                classe.nbLignesFic("./Ressources/" + nomChoisi);
                classe.nbLignesFic("/home/bnp-renault-010/Documents/Ressources/Projet-biblio/" + nomChoisi);

                break;
            case 2:
//                System.out.println("case B 2");
                /*afficher le nombre de mots du fichier */
                PrepaProj classe2 = new PrepaProj();
                classe2.nbMotsDiff("/home/bnp-renault-010/Documents/Ressources/Projet-biblio/" + nomChoisi);
//                classe2.nbMotsDiff("./Ressources/" + nomChoisi);

                break;

            default:
//                System.out.println("default B case");
        }
        return;
    }

}




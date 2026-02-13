package APP_GESTION_GROUPE;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        // 1. Génération aléatoire (Promotion de 100 étudiants) 
        List<Etudiant> promotion = genererPromotion(100);
        List<Groupe> groupes = genererGroupesVides(6, 18);

        AlgosRaphael r = new AlgosRaphael();
        AlgosSafwan s = new AlgosSafwan();
        AlgosHanniel h = new AlgosHanniel();
        OptimiseurGroupes monOpti = new OptimiseurGroupes();

        System.out.println("=== BENCHMARK SAE S3 (Raphaël, Safwan, Hanniel) ===");

        // 2. Comparaison des Gloutons
        long start = System.currentTimeMillis();
        r.gloutonMoyenne(promotion, groupes);
        double scoreInitial = new EvaluateurExpert().calculerScoreTotal(groupes);
        
        // 3. Optimisation Finale [cite: 29]
        monOpti.optimiser(groupes, 1000);
        double scoreFinal = new EvaluateurExpert().calculerScoreTotal(groupes);

        System.out.println("Score initial (Glouton) : " + scoreInitial);
        System.out.println("Score final (Optimisé) : " + scoreFinal);
        System.out.println("Temps de calcul : " + (System.currentTimeMillis() - start) + " ms");
    }

    private static List<Etudiant> genererPromotion(int nb) {
        List<Etudiant> list = new ArrayList<>();
        for(int i=0; i<nb; i++) {
            Etudiant e = new Etudiant();
            e.setNom("Etu"+i); e.setGenre(i%2==0 ? TypeGenre.HOMME : TypeGenre.FEMME);
            e.setApprentissage(i%3==0);
            list.add(e);
        }
        return list;
    }

    private static List<Groupe> genererGroupesVides(int nb, int cap) {
        List<Groupe> list = new ArrayList<>();
        for(int i=0; i<nb; i++) {
            Groupe g = new Groupe();
            g.setCapacite(cap);
            list.add(g);
        }
        return list;
    }
}
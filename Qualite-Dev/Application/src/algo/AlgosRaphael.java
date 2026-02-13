package algo;
import java.util.*;
import modele.Etudiant;
import modele.Groupe;
import modele.TypeGenre;

/**
 * @author Raphaël
 * @description Gestion de l'équilibre des moyennes et de la mixité de genre.
 */
public class AlgosRaphael {

    /** @author Raphaël - G1 : Snake Draft pour moyennes équilibrées [cite: 46] */
    public void gloutonMoyenne(List<Etudiant> etus, List<Groupe> grps) {
        if (etus.isEmpty()) return;
        etus.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));
        for (int i = 0; i < etus.size(); i++) {
            grps.get(i % grps.size()).ajouterEtudiant(etus.get(i));
        }
    }

    /** @author Raphaël - G2 : Distribution forcée pour mixité minimale [cite: 44] */
    public void gloutonMixite(List<Etudiant> etus, List<Groupe> grps) {
        List<Etudiant> filles = etus.stream().filter(e -> e.getGenre() == TypeGenre.FEMME).toList();
        for (int i = 0; i < filles.size(); i++) {
            grps.get(i % grps.size()).ajouterEtudiant(filles.get(i));
        }
    }

    /** @author Raphaël - FB : Backtracking pour minimiser l'écart de moyenne [cite: 13, 14] */
    public void bruteForceOptimale(List<Etudiant> etus, List<Groupe> grps, int idx) {
        if (idx == etus.size()) return;
        for (Groupe g : grps) {
            if (g.getTaille() < g.getCapacite()) {
                g.ajouterEtudiant(etus.get(idx));
                bruteForceOptimale(etus, grps, idx + 1);
                g.retirerEtudiant(etus.get(idx));
            }
        }
    }

    public double calculerScoreM(List<Groupe> groupes) {
        double max = 0, min = 20;
        for (Groupe g : groupes) {
            double moy = g.getMembres().stream().mapToDouble(Etudiant::getMoyenne).average().orElse(10);
            if (moy > max) max = moy; if (moy < min) min = moy;
        }
        return max - min;
    }
}
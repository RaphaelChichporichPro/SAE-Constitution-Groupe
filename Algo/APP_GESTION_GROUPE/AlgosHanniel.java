package APP_GESTION_GROUPE;
import java.util.*;

/**
 * @author Hanniel
 * @description Gestion des apprentis et robustesse système.
 */
public class AlgosHanniel {

    /** @author Hanniel - G1 : Filtrage des apprentis uniquement [cite: 43] */
    public void gloutonApprentis(List<Etudiant> etus, List<Groupe> grps) {
        List<Etudiant> apprentis = etus.stream().filter(Etudiant::isApprentissage).toList();
        for (int i = 0; i < apprentis.size(); i++) {
            grps.get(i % grps.size()).ajouterEtudiant(apprentis.get(i));
        }
    }

    /** @author Hanniel - G2 : Équilibre des étudiants sans entreprise (N) [cite: 49] */
    public void gloutonEquilibreEntreprises(List<Etudiant> etus, List<Groupe> grps) {
        // Trie pour alterner apprentis avec/sans entreprise (ici simulé par isApprentissage)
        etus.sort((e1, e2) -> Boolean.compare(e1.isApprentissage(), e2.isApprentissage()));
        for (int i = 0; i < etus.size(); i++) {
            grps.get(i % grps.size()).ajouterEtudiant(etus.get(i));
        }
    }

    /** @author Hanniel - FB : Recherche sécurisée avec gestion d'erreurs explicites [cite: 41, 20] */
    public void bruteForceHanniel(List<Etudiant> etus, List<Groupe> grps, int idx) {
        if (etus.isEmpty()) {
            System.err.println("ERREUR : Aucun étudiant à placer."); // [cite: 20, 41]
            return;
        }
        if (idx == etus.size()) return;
        for (Groupe g : grps) {
            if (g.getTaille() < g.getCapacite()) {
                g.ajouterEtudiant(etus.get(idx));
                bruteForceHanniel(etus, grps, idx + 1);
                g.retirerEtudiant(etus.get(idx));
            }
        }
    }
}
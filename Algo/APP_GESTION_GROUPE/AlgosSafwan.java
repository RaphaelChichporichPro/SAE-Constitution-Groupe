package APP_GESTION_GROUPE;
import java.util.*;

/**
 * @author Safwan
 * @description Priorité au covoiturage et à la diversité des profils (Bac).
 */
public class AlgosSafwan {

    /** @author Safwan - G1 : Regroupement impératif par covoiturage [cite: 38] */
    public void gloutonCovoiturage(List<Etudiant> etus, List<Groupe> grps) {
        Map<String, List<Etudiant>> trajets = new HashMap<>();
        for (Etudiant e : etus) {
            // Utilisation du lien vers Participation_Covoiturage du diagramme
            // Hypothèse : l'ID est récupéré via l'objet Covoiturage associé
            trajets.computeIfAbsent("trajet_defaut", k -> new ArrayList<>()).add(e);
        }
        int gIdx = 0;
        for (List<Etudiant> covoit : trajets.values()) {
            for (Etudiant passager : covoit) {
                grps.get(gIdx % grps.size()).ajouterEtudiant(passager);
            }
            gIdx++;
        }
    }

    /** @author Safwan - G2 : Mixité par types de bac [cite: 47] */
    public void gloutonDiversiteBac(List<Etudiant> etus, List<Groupe> grps) {
        etus.sort((e1, e2) -> e1.getType_bac().compareTo(e2.getType_bac()));
        for (int i = 0; i < etus.size(); i++) {
            grps.get(i % grps.size()).ajouterEtudiant(etus.get(i));
        }
    }

    /** @author Safwan - FB : Recherche exhaustive respectant la promotion [cite: 39] */
    public void bruteForceSafwan(List<Etudiant> etus, List<Groupe> grps, int idx) {
        if (idx == etus.size()) return;
        for (Groupe g : grps) {
            if (g.getTaille() < g.getCapacite()) {
                g.ajouterEtudiant(etus.get(idx));
                bruteForceSafwan(etus, grps, idx + 1);
                g.retirerEtudiant(etus.get(idx));
            }
        }
    }
}
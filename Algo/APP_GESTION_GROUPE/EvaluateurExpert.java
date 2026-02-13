package APP_GESTION_GROUPE;
import java.util.*;

public class EvaluateurExpert {
    public double calculerScoreTotal(List<Groupe> groupes) {
        double max = 0, min = 20;
        int maxSansEntreprise = 0;
        for (Groupe g : groupes) {
            double moy = g.getMembres().stream().mapToDouble(Etudiant::getMoyenne).average().orElse(10);
            if (moy > max) max = moy; if (moy < min) min = moy;
            // N = nombre max d'étudiants sans entreprise (ici apprentis pour l'exemple)
            int sansEnt = (int) g.getMembres().stream().filter(e -> !e.isApprentissage()).count();
            if (sansEnt > maxSansEntreprise) maxSansEntreprise = sansEnt;
        }
        return (max - min) + maxSansEntreprise; // Score M + N [cite: 13]
    }
}
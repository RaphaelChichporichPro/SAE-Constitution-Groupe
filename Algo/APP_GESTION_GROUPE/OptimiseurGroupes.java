package APP_GESTION_GROUPE;
import java.util.*;

public class OptimiseurGroupes {
    private EvaluateurExpert eval = new EvaluateurExpert();

    public void optimiser(List<Groupe> solution, int nbTentatives) {
        for (int i = 0; i < nbTentatives; i++) {
            Groupe g1 = solution.get(new Random().nextInt(solution.size()));
            Groupe g2 = solution.get(new Random().nextInt(solution.size()));
            if (g1 == g2 || g1.getTaille() == 0 || g2.getTaille() == 0) continue;

            Etudiant e1 = g1.getMembres().get(0);
            Etudiant e2 = g2.getMembres().get(0);
            double avant = eval.calculerScoreTotal(solution);

            g1.retirerEtudiant(e1); g1.ajouterEtudiant(e2);
            g2.retirerEtudiant(e2); g2.ajouterEtudiant(e1);

            if (eval.calculerScoreTotal(solution) >= avant) {
                g1.retirerEtudiant(e2); g1.ajouterEtudiant(e1);
                g2.retirerEtudiant(e1); g2.ajouterEtudiant(e2);
            }
        }
    }
}
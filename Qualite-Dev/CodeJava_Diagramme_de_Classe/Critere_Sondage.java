package APP_GESTION_GROUPE;

import java.util.*;

public class Critere_Sondage {

	private Collection<Sondage> sesSondages;
	private Collection<Reponse_Sondage> sesReponses;
	private boolean est_prioritaire;

	public boolean isEst_prioritaire() {
		return this.est_prioritaire;
	}

	public void setEst_prioritaire(boolean est_prioritaire) {
		this.est_prioritaire = est_prioritaire;
	}

}
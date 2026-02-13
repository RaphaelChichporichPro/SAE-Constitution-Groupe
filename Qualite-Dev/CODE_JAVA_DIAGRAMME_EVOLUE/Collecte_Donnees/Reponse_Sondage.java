package APP_GESTION_GROUPE.Collecte_Donnees;

import java.util.*;
import APP_GESTION_GROUPE.*;

public class Reponse_Sondage {

	private Sondage sonSondage;
	private Critere_Sondage sonCritere;
	private Choix_Activite sonChoixActivite;
	private Collection<Etudiant> sesEtudiants;
	private Date date_reponse;
	private String valeur_reponse;
	private int ordre_preference;

	public Date getDate_reponse() {
		return this.date_reponse;
	}

	public void setDate_reponse(Date date_reponse) {
		this.date_reponse = date_reponse;
	}

	public String getValeur_reponse() {
		return this.valeur_reponse;
	}

	public void setValeur_reponse(String valeur_reponse) {
		this.valeur_reponse = valeur_reponse;
	}

	public int getOrdre_preference() {
		return this.ordre_preference;
	}

	public void setOrdre_preference(int ordre_preference) {
		this.ordre_preference = ordre_preference;
	}

}
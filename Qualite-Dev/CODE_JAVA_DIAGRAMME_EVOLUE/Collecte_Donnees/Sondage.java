package APP_GESTION_GROUPE.Collecte_Donnees;

import APP_GESTION_GROUPE.*;
import java.util.*;
import APP_GESTION_GROUPE.Moteur_Repartition.*;

public class Sondage {

	private Enseignant sonEnseignant;
	private Collection<Reponse_Sondage> sesReponses;
	private Collection<Critere_Sondage> sesCriteres;
	private int id_sondage;
	private String libelle_sondage;
	private Date date_creation;

	public int getId_sondage() {
		return this.id_sondage;
	}

	public void setId_sondage(int id_sondage) {
		this.id_sondage = id_sondage;
	}

	public String getLibelle_sondage() {
		return this.libelle_sondage;
	}

	public void setLibelle_sondage(String libelle_sondage) {
		this.libelle_sondage = libelle_sondage;
	}

	public Date getDate_creation() {
		return this.date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	/**
	 * 
	 * @param c
	 */
	public void ajouterQuestion(Critere c) {
		// TODO - implement Sondage.ajouterQuestion
		throw new UnsupportedOperationException();
	}

	public void cloturerSondage() {
		// TODO - implement Sondage.cloturerSondage
		throw new UnsupportedOperationException();
	}

}
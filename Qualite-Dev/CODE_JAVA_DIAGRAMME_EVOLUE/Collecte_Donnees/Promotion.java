package APP_GESTION_GROUPE.Collecte_Donnees;

import APP_GESTION_GROUPE.*;
import java.util.*;
import APP_GESTION_GROUPE.Moteur_Repartition.*;

public class Promotion {

	private Enseignant sonEnseignant;
	private Collection<Etudiant> sesEtudiants;
	private Collection<Groupe> sesGroupes;
	private Collection<Critere> sesCriteres;
	private int id_promotion;
	private int annee;
	private String departement;
	private String parcours;

	public int getId_promotion() {
		return this.id_promotion;
	}

	public void setId_promotion(int id_promotion) {
		this.id_promotion = id_promotion;
	}

	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getParcours() {
		return this.parcours;
	}

	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public List<Groupe> listerGroupes() {
		// TODO - implement Promotion.listerGroupes
		throw new UnsupportedOperationException();
	}

	public List<Etudiant> listerEtudiants() {
		// TODO - implement Promotion.listerEtudiants
		throw new UnsupportedOperationException();
	}

}
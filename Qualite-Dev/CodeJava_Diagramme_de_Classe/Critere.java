package APP_GESTION_GROUPE;

import java.util.*;

public class Critere {

	private Collection<Groupe> sonGroupe;
	private Promotion saPromotion;
	private String id_critere;
	private String libelle_critere;
	private String type_critere;
	private int poids_critere;
	private TypeObjectif objectif_distribution;
	private boolean active;

	public String getId_critere() {
		return this.id_critere;
	}

	public void setId_critere(String id_critere) {
		this.id_critere = id_critere;
	}

	public String getLibelle_critere() {
		return this.libelle_critere;
	}

	public void setLibelle_critere(String libelle_critere) {
		this.libelle_critere = libelle_critere;
	}

	public String getType_critere() {
		return this.type_critere;
	}

	public void setType_critere(String type_critere) {
		this.type_critere = type_critere;
	}

	public int getPoids_critere() {
		return this.poids_critere;
	}

	public void setPoids_critere(int poids_critere) {
		this.poids_critere = poids_critere;
	}

	public TypeObjectif getObjectif_distribution() {
		return this.objectif_distribution;
	}

	public void setObjectif_distribution(TypeObjectif objectif_distribution) {
		this.objectif_distribution = objectif_distribution;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * 
	 * @param valeur
	 */
	public boolean estRespecte(String valeur) {
		// TODO - implement Critere.estRespecte
		throw new UnsupportedOperationException();
	}

}
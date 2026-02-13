package APP_GESTION_GROUPE.Moteur_Repartition;

import java.util.*;
import APP_GESTION_GROUPE.*;

public class Covoiturage {

	private Collection<Participation_Covoiturage> sesParticipationCov;
	private String id_covoiturage;
	private String point_depart;

	public String getId_covoiturage() {
		return this.id_covoiturage;
	}

	public void setId_covoiturage(String id_covoiturage) {
		this.id_covoiturage = id_covoiturage;
	}

	public String getPoint_depart() {
		return this.point_depart;
	}

	public void setPoint_depart(String point_depart) {
		this.point_depart = point_depart;
	}

	/**
	 * 
	 * @param e
	 * @param role
	 */
	public void ajouterParticipant(Etudiant e, String role) {
		// TODO - implement Covoiturage.ajouterParticipant
		throw new UnsupportedOperationException();
	}

}
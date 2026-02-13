package APP_GESTION_GROUPE;

public class Participation_Covoiturage {

	private Covoiturage sonCovoiturage;
	private Etudiant sonEtudiant;
	private String role_participation;
	private Date date_demande;

	public String getRole_participation() {
		return this.role_participation;
	}

	public void setRole_participation(String role_participation) {
		this.role_participation = role_participation;
	}

	public Date getDate_demande() {
		return this.date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
	}

}
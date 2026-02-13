package APP_GESTION_GROUPE;

public class Choix_Activite {

	private Activite sonActivite;
	private Etudiant sonEtudiant;
	private Reponse_Sondage saReponseSondage;
	private Date date_choix;

	public Date getDate_choix() {
		return this.date_choix;
	}

	public void setDate_choix(Date date_choix) {
		this.date_choix = date_choix;
	}

}
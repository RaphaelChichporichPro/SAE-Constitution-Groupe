package APP_GESTION_GROUPE;

public class Note {

	private Etudiant sonEtudiant;
	private int id_note;
	private String libelle;
	private int valeur;
	private Date date_note;

	public int getId_note() {
		return this.id_note;
	}

	public void setId_note(int id_note) {
		this.id_note = id_note;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Date getDate_note() {
		return this.date_note;
	}

	public void setDate_note(Date date_note) {
		this.date_note = date_note;
	}

}
package APP_GESTION_GROUPE.Gestion_Utilisateur;

public abstract class Utilisateur implements Authentifiable {

	protected String id_user;
	protected String mail_user;
	protected String password;
	protected TypeRole role;

	public String getId_user() {
		return this.id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getMail_user() {
		return this.mail_user;
	}

	public void setMail_user(String mail_user) {
		this.mail_user = mail_user;
	}

	public TypeRole getRole() {
		return this.role;
	}

	public void setRole(TypeRole role) {
		this.role = role;
	}

	/**
	 * 
	 * @param mdp
	 * @param mail
	 */
	public abstract boolean sAuthentifier(String mdp, String mail);

	public abstract void seDeconnecter();

	/**
	 * 
	 * @param mdp
	 */
	public abstract String hashPassword(String mdp);

	public abstract boolean est_Etudiant();

	public abstract boolean est_Responsable();

	public abstract boolean est_Enseignant();

}
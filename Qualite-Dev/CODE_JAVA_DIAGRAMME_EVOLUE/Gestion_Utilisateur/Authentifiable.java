package APP_GESTION_GROUPE.Gestion_Utilisateur;

public interface Authentifiable {

	/**
	 * 
	 * @param mdp
	 * @param mail
	 */
	boolean sAuthentifier(String mdp, String mail);

	void seDeconnecter();

}
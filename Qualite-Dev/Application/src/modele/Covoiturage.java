package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Covoiturage implements Serializable {

    private String id_covoiturage;
    private String point_depart;
    
    // J'ai mis ça en commentaire en attendant que tu aies la classe Participation_Covoiturage
    // private List<Participation_Covoiturage> sesParticipationCov;

    public Covoiturage() {}

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
}
package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			StringBuilder vide = new StringBuilder();
			vide.append("Le marché est vide, revenez plus tard");
			System.out.println(vide);
		} else {
			StringBuilder marche = new StringBuilder();
			marche.append(nomAcheteur + " vous trouverez au marché :\n");
			for (int i = 0; i < infosMarche.length; i++) {
				marche.append("    - " + infosMarche[i] + " qui vend ");
				i++;
				marche.append(infosMarche[i]);
				i++;
				marche.append(" " + infosMarche[i] + "\n");
			}
			System.out.println(marche);
		}

	}
}
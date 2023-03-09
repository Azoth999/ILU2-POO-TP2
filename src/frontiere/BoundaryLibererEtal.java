package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			StringBuilder exist = new StringBuilder();
			exist.append("Mais vous n'êtes pas inscrit sur notre marché !");
			System.out.println(exist);
		} else {
			String[] etal = controlLibererEtal.libererEtal(nomVendeur);
			Boolean etalOccupe = Boolean.valueOf(etal[0]);
			if (etalOccupe) {
				String produit = etal[2];
				int qtyInitial = Integer.valueOf(etal[3]);
				int qtyVendu = Integer.valueOf(etal[4]);
				StringBuilder ventes = new StringBuilder();
				ventes.append("Vous avez vendu " + qtyVendu + " sur " + qtyInitial + " " + produit + ".\n");
				ventes.append("Au revoir " + nomVendeur + ", passez une bonne journée.");
				System.out.println(ventes);
			}
		}
	}

}
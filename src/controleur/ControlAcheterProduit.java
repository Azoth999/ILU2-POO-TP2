package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Boolean existVendeur(String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}

	public String[] vendeursProduit(String produit) {
		int nbrEtals = village.donnerNbEtal();
		String[] vendeurs = new String[nbrEtals];
		int numeroVendeur = 0;
		for (int i = 0; i < village.rechercherVendeursProduit(produit).length; i++) {
			if (!village.rechercherVendeursProduit(produit)[i].getNom().equals("null")) {
				vendeurs[numeroVendeur] = village.rechercherVendeursProduit(produit)[i].getNom();
				numeroVendeur++;
			}
		}

		String[] vendeursProduit = new String[numeroVendeur];
		for (int j = 0; j < vendeursProduit.length; j++) {
			vendeursProduit[j] = vendeurs[j];
		}
		return vendeursProduit;
	}

	public int qtyVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite();
	}

	public Boolean assezProduit(int nombre, String nomVendeur) {
		return qtyVendeur(nomVendeur) >= nombre;
	}

	public void venteProduit(String nomVendeur, int qtyVendue) {
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(qtyVendue);
	}

	public Boolean isAcheteurValide(String acheteur) {
		return controlVerifierIdentite.verifierIdentite(acheteur);
	}

}
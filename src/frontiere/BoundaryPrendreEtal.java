package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder reponse = new StringBuilder();
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			reponse.append("Désolé, ");
			reponse.append(nomVendeur);
			reponse.append(" je ne vous trouve pas dans les registres.\n");
			System.out.println(reponse);
		} else {
			reponse.append("Bonjour ");
			reponse.append(nomVendeur);
			reponse.append(", je vais regarder si je peux vous trouver un étal.\n");
			System.out.println(reponse);
			StringBuilder etaldispo = new StringBuilder();
			if (!controlPrendreEtal.resteEtals()) {
				etaldispo.append("Je suis désolé ");
				etaldispo.append(nomVendeur);
				etaldispo.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
				System.out.println(etaldispo);
			} else {
				installerVendeur(nomVendeur);
			}
		}

	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder installEtProduit = new StringBuilder();
		installEtProduit.append("C'est parfait il me reste un étal pour vous !\n");
		installEtProduit.append("Il me faudrait quelques renseignements :\n");
		installEtProduit.append("Quel produit souhaitez vous vendre?\n");
		System.out.println(installEtProduit);
		String produitVendu = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien voulez vous en vendre?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produitVendu, nbProduit) + 1;
		if (numEtal != -1) {
			StringBuilder finito = new StringBuilder();
			finito.append("Le vendeur ");
			finito.append(nomVendeur);
			finito.append(" s'est installé à l'étal n°");
			finito.append(numEtal);
			System.out.println(finito);
		}
	}
}

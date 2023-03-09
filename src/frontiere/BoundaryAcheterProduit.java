package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder question = new StringBuilder();
		
		if (!controlAcheterProduit.isAcheteurValide(nomAcheteur)) {
			question.append("Désolé mais vous n'êtes pas du village.");
			System.out.println(question);
		} else {
			question.append("Quel produit voulez-vous acheter ?\n");
			System.out.println(question);
			String produit = scan.nextLine();

			StringBuilder vendeur = new StringBuilder();
			if (!controlAcheterProduit.existVendeur(produit)) {
				StringBuilder pasVendeurs = new StringBuilder();
				pasVendeurs.append("Personne ne vend de " + produit + ".\n");
				System.out.println(pasVendeurs);
			} else {
				vendeur.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				String[] vendeurs = controlAcheterProduit.vendeursProduit(produit);
				for (int i = 0; i < vendeurs.length; i++) {
					vendeur.append("     " + (i + 1) + " - " + vendeurs[i] + "\n");
				}
				int choixUtilisateur = -1;
				StringBuilder erreur = new StringBuilder();
				erreur.append("Vous devez choisir un chiffre entre 1 et " + (vendeurs.length) + ".\n");
				while (choixUtilisateur < 1 || choixUtilisateur > vendeurs.length) {
					choixUtilisateur = Clavier.entrerEntier(vendeur.toString());
					if (choixUtilisateur < 1 || choixUtilisateur > vendeurs.length) {
						System.out.println(erreur);
					}

				}

				String vendeurNom = vendeurs[choixUtilisateur - 1];
				StringBuilder deplacement = new StringBuilder();
				deplacement.append(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurNom + ".\n");
				deplacement.append("Bonjour " + nomAcheteur + " !\nCombien de " + produit + " voulez-vous acheter ?\n");
				int nbrAchat = Clavier.entrerEntier(deplacement.toString());
				StringBuilder vente = new StringBuilder();
				if (!controlAcheterProduit.assezProduit(nbrAchat, vendeurNom)) {
					vente.append("Désolé " + nomAcheteur + " mais je n'ai pas " + nbrAchat + " " + produit
							+ ", j'en ai seulement " + controlAcheterProduit.qtyVendeur(vendeurNom));
					System.out.println(vente);
				} else {

					vente.append(nomAcheteur + " a acheté " + nbrAchat + " " + produit + " à " + vendeurNom + ".\n");
					controlAcheterProduit.venteProduit(vendeurNom, nbrAchat);
					System.out.println(vente);
				}
			}
		}
	}
}
package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder accueil = new StringBuilder();
					accueil.append("Bienvenue villageois ");
					accueil.append(nomVisiteur);
					accueil.append("\nQuelle est votre force?\n");
					int force = Clavier.entrerEntier(accueil.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder bienvenue = new StringBuilder();
		bienvenue.append("Bienvenue druide ");
		bienvenue.append(nomVisiteur);
		bienvenue.append("\nQuelle est votre force?");
		int forceDruide = Clavier.entrerEntier(bienvenue.toString());
		StringBuilder potMinQuestion = new StringBuilder();
		potMinQuestion.append("Quelle est la force de la potion la plus faible que vous produisez?\n");
		StringBuilder potMaxQuestion = new StringBuilder();
		potMaxQuestion.append("Quelle est la force de la potion la plus forte que vous produisez?\n");
		int effetPotMin = 1;
		int effetPotMax = -1;
		do {
			effetPotMin = Clavier.entrerEntier(potMinQuestion.toString());
			effetPotMax = Clavier.entrerEntier(potMaxQuestion.toString());
			if (effetPotMax < effetPotMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum.");
			}
		} while (effetPotMax < effetPotMin);
		controlEmmenager.ajouterDuide(nomVisiteur, forceDruide, effetPotMin, effetPotMax);
	}
}

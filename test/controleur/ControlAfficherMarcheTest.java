package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef chef;
	private Gaulois gaulois;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village d'irreductibles", 10, 5);
		chef = new Chef("abraracourcix", 10, village);
		gaulois = new Gaulois("Albert", 5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "pomme", 5);
		village.setChef(chef);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null.");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] verif = new String[3];
		verif[0] = gaulois.getNom();
		verif[1] = "5";
		verif[2] = "pomme";
		assertArrayEquals(verif, controlAfficherMarche.donnerInfosMarche());
	}

}

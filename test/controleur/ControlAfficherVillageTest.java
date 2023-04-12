package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
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
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null.");
	}

	@Test
	void testDonnerNomsVillageois() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}

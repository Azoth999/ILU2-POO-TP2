package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] noms = new String[2];
		noms[0] = chef.getNom();
		noms[1] = gaulois.getNom();
		assertArrayEquals(noms, controlAfficherVillage.donnerNomsVillageois());
		Gaulois phil = new Gaulois("Phil", 5);
		village.ajouterHabitant(phil);
		noms = new String[3];
		noms[0] = chef.getNom();
		noms[1] = gaulois.getNom();
		noms[2]= phil.getNom();
		assertArrayEquals(noms, controlAfficherVillage.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("Village d'irreductibles", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}

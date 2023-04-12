package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef chef;
	private Gaulois gaulois;
	private Gaulois vendeur;
	private Gaulois vendeur2;
	private Gaulois vendeur3;
	private Gaulois vendeur4;
	private Gaulois acheteur;
	private Gaulois gauloisEtal;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village = new Village("Village des irréductibles", 10, 5);
		chef = new Chef("abraracourcix", 10, village);
		gauloisEtal = new Gaulois("Albert", 5);
		village.ajouterHabitant(gauloisEtal);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null.");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		gaulois = new Gaulois("Asterix", 5);
		vendeur = new Gaulois("Felix", 7);
		vendeur2 = new Gaulois("Adam", 2);
		vendeur3 = new Gaulois("Paul", 3);
		vendeur4 = new Gaulois("Max", 4);
		acheteur = new Gaulois("Obelix", 15);
		village.setChef(chef);
		village.ajouterHabitant(vendeur);
		village.ajouterHabitant(vendeur2);
		village.ajouterHabitant(vendeur3);
		village.ajouterHabitant(vendeur4);
		village.ajouterHabitant(gaulois);
		village.ajouterHabitant(acheteur);
		village.installerVendeur(gaulois, "pomme", 10);
		village.installerVendeur(vendeur, "pomme", 15);
		village.installerVendeur(vendeur2, "patate", 5);
		village.installerVendeur(vendeur3, "poire", 7);
		village.installerVendeur(vendeur4, "abricot", 9);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(1, controlPrendreEtal.prendreEtal("Albert", "pomme", 10));

	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Albert"));
	}

}

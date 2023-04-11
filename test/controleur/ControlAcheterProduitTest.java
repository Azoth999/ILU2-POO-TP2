package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.*;
import personnages.*;

class ControlAcheterProduitTest {
	private Village village;
	private Chef chef;
	private Gaulois gaulois;
	private Gaulois vendeur;
	private Gaulois acheteur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village = new Village("Village des irréductibles", 10, 5);
		chef = new Chef("abraracourcix", 10, village);
		gaulois = new Gaulois("Asterix", 5);
		vendeur = new Gaulois("Felix", 7);
		acheteur = new Gaulois("Obelix", 15);
		village.setChef(chef);
		village.ajouterHabitant(vendeur);
		village.ajouterHabitant(gaulois);
		village.ajouterHabitant(acheteur);
		village.installerVendeur(gaulois, "pomme", 10);
		village.installerVendeur(vendeur, "pomme", 15);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testExistVendeur() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.existVendeur("pomme"));
	}

	@Test
	void testVendeursProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		System.out.println(controlAcheterProduit.vendeursProduit("pomme"));
		String[] expectedVendeurs = new String[2];
		expectedVendeurs[0] = "Asterix";
		expectedVendeurs[1] = "Felix";
		assertArrayEquals(expectedVendeurs, controlAcheterProduit.vendeursProduit("pomme"));
	}

	@Test
	void testQtyVendeur() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(10, controlAcheterProduit.qtyVendeur("Asterix"));
	}

	@Test
	void testAssezProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.assezProduit(5, "Asterix"));
		assertFalse(controlAcheterProduit.assezProduit(12, "Asterix"));
	}

	@Test
	void testVenteProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlAcheterProduit.venteProduit("Asterix", 6);
		assertEquals(4, controlAcheterProduit.qtyVendeur("Asterix"));
	}

	@Test
	void testIsAcheteurValide() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.isAcheteurValide("Obelix"));
	}

}

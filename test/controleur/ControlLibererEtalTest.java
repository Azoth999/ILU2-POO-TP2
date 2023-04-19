package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Chef chef;
	private Gaulois gaulois;

	@BeforeEach
	void setUp() throws Exception {
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		village = new Village("Village d'irreductibles", 10, 5);
		chef = new Chef("abraracourcix", 10, village);
		gaulois = new Gaulois("Albert", 5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "pomme", 5);
		village.setChef(chef);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtalTest = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtalTest, "Constructeur ne renvoie pas null.");
	}

	@Test
	void testViderEtal() {
		//Pour x raison le test veut pas faire viderEtal et prétend que this.village est null
		//si je n'initialise pas les variables ici. Alors qu'il y a le BeforeEach
		//"Cannot invoke "villagegaulois.Village.trouverhabitant(String)" because "this.village" is null"
		ControlLibererEtal controlLibererEtalTest = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertEquals("Albert",village.donnerEtatMarche()[0]);
		controlLibererEtalTest.viderEtal(gaulois.getNom());
		System.out.println(village.rechercherEtal(gaulois));
		assertEquals(null, village.rechercherEtal(gaulois));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtalTest = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertEquals("Albert",village.donnerEtatMarche()[0]);
		assertEquals(null, controlLibererEtalTest.libererEtal(gaulois.getNom()));;
		
	}

	@Test
	void testIsVendeur() {
		fail("Not yet implemented");
	}

}

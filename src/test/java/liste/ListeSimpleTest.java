package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    @Test
    void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
    void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
    void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void toStringDonneTousLesNoeuds() {
        assertEquals("ListeSimple()", listeATester.toString());
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        String expected = "ListeSimple(Noeud(3), Noeud(2), Noeud(1))";
        assertEquals(expected, listeATester.toString());
    }

    @Test
    void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))", listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    void testModifiePremier_ElementAbsent() {
        ListeSimple liste = new ListeSimple();
        liste.ajout(1);
        liste.modifiePremier(2, 5);
        assertEquals("ListeSimple(Noeud(1))", liste.toString());
    }

    @Test
    void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals("ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))", listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(1))", listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(2))", listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void testSupprimePremier_ElementAbsent() {
        ListeSimple liste = new ListeSimple();
        liste.ajout(1);
        liste.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(1))", liste.toString());
    }

    @Test
    void supprimeTousListeVide() {
        listeATester.supprimeTous(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
        assertEquals("ListeSimple()", listeATester.toString());
    }

    @Test
    void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals("ListeSimple(Noeud(2))", listeATester.toString());
        assertEquals(1, listeATester.getSize());
    }

    @Test
    void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
    void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))", listeATester.toString());
    }

    @Test
    void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3))", listeATester.toString());
    }

    @Test
    void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))", listeATester.toString());
    }

    @Test
    void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))", listeATester.toString());
    }


    @Test
    void testEchanger_MemeNoeud() {
        ListeSimple liste = new ListeSimple();
        liste.ajout(1);
        Noeud noeud = liste.tete;
        liste.echanger(noeud, noeud);
        assertEquals("ListeSimple(Noeud(1))", liste.toString());
    }

    @Test
    void testEchanger_DifferentsAvecR1Tete() {
        ListeSimple liste = new ListeSimple();
        liste.ajout(1);
        liste.ajout(2);
        Noeud r1 = liste.tete;
        Noeud r2 = liste.tete.getSuivant();
        liste.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(2))", liste.toString());
    }

    @Test
    void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))", listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))", listeATester.toString());
    }
}

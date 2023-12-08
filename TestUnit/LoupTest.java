package TestUnit;

import Animal.Vivipaire.TDLoup.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoupTest {

    private Loup loup;

    @BeforeEach
    public void setUp() {
        loup = new Loup("TestLoup", 'M', 60, 70, 1, 'β');
    }

    @Test
    public void testLoseDomination() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'γ');
        loup.loseDomination(loup2);
     
        assertEquals('γ', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
        assertEquals(0, loup.getLevel());
        assertEquals(2, loup2.getLevel());
    }

  
    

    @Test
    public void testIncLevel() {
        loup.incLevel();
        assertEquals(2, loup.getLevel());
    }

    @Test
    public void testDecLevel() {
        loup.setLevel(1);
        loup.decLevel();
        assertEquals(0, loup.getLevel());
    }


    @Test
    public void testSwitchRankDominationWhenAggressorHasHigherRank() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'α');
        loup.switchRankDomination(loup2);
        assertEquals('α', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
    }

    @Test
    public void testWalk() {
        String expected = "TestLoup vagabonde !";
        assertEquals(expected, loup.walk());
    }

    @Test
    public void testGetLevel() {
        assertEquals(1, loup.getLevel());
    }

    

    @Test
    public void testGetRankDomination() {
        assertEquals('β', loup.getRankDomination());
    }

    @Test
    public void testGetWolfPack() {
        assertNull(loup.getWolfPack());
    }

    @Test
    public void testSetWolfPack() {
        Meute meute = new Meute();
        loup.setWolfPack(meute);
        assertEquals(meute, loup.getWolfPack());
    }

    @Test
    public void testGetAge() {
        assertEquals(1, loup.getAge());
    }

    @Test
    public void testSetRankDomination() {
        loup.setRankDomination('γ');
        assertEquals('γ', loup.getRankDomination());
    }

    @Test
    public void testToString() {
        String expected = "Wolf {Nom=TestLoup, age=1, force=1, domination=0, rangDomination=β, niveau=1, violence=" + loup.getViolence()+", meute=non}";
        assertEquals(expected, loup.toString());
    }
}


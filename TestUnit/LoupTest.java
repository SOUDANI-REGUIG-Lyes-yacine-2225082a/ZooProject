package TestUnit;

import Animal.Vivipaire.TDLoup.Loup;
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
    public void testSoundWithoutMeute() {
        String expected = "TestLoup hurle \"Aoouuuuuh\"";
        assertEquals(expected, loup.sound());
    }

    @Test
    public void testSoundWithMeute() {
        loup.setWolfPack(new Meute());
        loup.getWolfPack().setHowl("MeuteHowl");
        String expected = "TestLoup hurle \"MeuteHowl\"";
        assertEquals(expected, loup.sound());
    }

    @Test
    public void testHearWhenAwakeAndHealthy() {
        loup.setSleep(false);
        loup.setHealth(true);
        String expected = "TestLoup entend des hurlements (peut-Ãªtre)";
        assertEquals(expected, loup.hear());
    }

    @Test
    public void testHearWhenAsleep() {
        loup.setSleep(true);
        loup.setHealth(true);
        assertNull(loup.hear());
    }

    @Test
    public void testHearWhenUnhealthy() {
        loup.setSleep(false);
        loup.setHealth(false);
        assertNull(loup.hear());
    }

    @Test
    public void testMakeOldWhenYoung() {
        loup.makeOld();
        assertEquals(2, loup.getAge());
        assertTrue(loup.toString().contains("age=2"));
    }

    @Test
    public void testMakeOldWhenAdult() {
        loup.setAge(2);
        loup.makeOld();
        assertEquals(3, loup.getAge());
        assertTrue(loup.toString().contains("age=3"));
    }

    @Test
    public void testMakeOldWhenOld() {
        loup.setAge(3);
        loup.makeOld();
        assertEquals(3, loup.getAge());
        assertTrue(loup.toString().contains("age=3"));
        assertTrue(loup.toString().contains("meurt"));
    }

    @Test
    public void testWinDomination() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'γ');
        loup.winDomination(loup2);
        assertEquals(1, loup.getDomination());
        assertEquals(0, loup2.getDomination());
        assertEquals('γ', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
        assertEquals(2, loup.getLevel());
        assertEquals(0, loup2.getLevel());
    }

    @Test
    public void testLoseDomination() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'γ');
        loup.loseDomination(loup2);
        assertEquals(0, loup.getDomination());
        assertEquals(1, loup2.getDomination());
        assertEquals('γ', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
        assertEquals(0, loup.getLevel());
        assertEquals(2, loup2.getLevel());
    }

    @Test
    public void testDominateWhenViolenceHigherAndNotAlpha() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'γ');
        loup.setViolence(5);
        loup2.setViolence(3);
        loup.setLevel(2);
        loup2.setLevel(1);
        loup.dominate(loup2);
        assertEquals(1, loup.getDomination());
        assertEquals(0, loup2.getDomination());
        assertEquals('γ', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
        assertEquals(2, loup.getLevel());
        assertEquals(0, loup2.getLevel());
    }

    @Test
    public void testDominateWhenViolenceLower() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'γ');
        loup.setViolence(3);
        loup2.setViolence(5);
        loup.setLevel(1);
        loup2.setLevel(2);
        loup.dominate(loup2);
        assertEquals(0, loup.getDomination());
        assertEquals(1, loup2.getDomination());
        assertEquals('γ', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
        assertEquals(0, loup.getLevel());
        assertEquals(2, loup2.getLevel());
    }

    @Test
    public void testDominateWhenViolenceHigherAndAlpha() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'α');
        loup.setViolence(5);
        loup2.setViolence(3);
        loup.setLevel(2);
        loup2.setLevel(1);
        loup.dominate(loup2);
        assertEquals(0, loup.getDomination());
        assertEquals(1, loup2.getDomination());
        assertEquals('γ', loup.getRankDomination());
        assertEquals('α', loup2.getRankDomination());
        assertEquals(0, loup.getLevel());
        assertEquals(2, loup2.getLevel());
    }

    @Test
    public void testIncDomination() {
        loup.incDomination();
        assertEquals(1, loup.getDomination());
    }

    @Test
    public void testDecDomination() {
        loup.setDomination(1);
        loup.decDomination();
        assertEquals(0, loup.getDomination());
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
    public void testSwitchRankDominationWhenAggressorHasLowerRank() {
        Loup loup2 = new Loup("TestLoup2", 'F', 50, 60, 1, 'γ');
        loup.switchRankDomination(loup2);
        assertEquals('γ', loup.getRankDomination());
        assertEquals('β', loup2.getRankDomination());
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
    public void testGetViolence() {
        assertEquals(1, loup.getViolence());
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
        String expected = "Wolf {Nom=TestLoup, age=1, force=1, domination=0, rangDomination=β, niveau=1, violence=1, meute=non}";
        assertEquals(expected, loup.toString());
    }
}
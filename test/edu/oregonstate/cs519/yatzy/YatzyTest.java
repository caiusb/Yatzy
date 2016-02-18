package edu.oregonstate.cs519.yatzy;

import static org.junit.Assert.*;
import static edu.oregonstate.cs519.yatzy.Bet.*;

import org.junit.Before;
import org.junit.Test;

public class YatzyTest {
	
	private Yatzy yatzy;

	@Before
	public void before() {
		yatzy = new Yatzy();
	}
	
	@Test
	public void testChanceForZero() throws InvalidRollException {
		assertEquals(0, yatzy.score(CHANCE, new int[]{0, 0, 0, 0, 0}));
	}

	@Test
	public void testChanceForOneDieNotZero() throws Exception {
		assertEquals(1, yatzy.score(CHANCE, new int[]{1, 0, 0, 0, 0}));
	}
	
	@Test
	public void testForAllDiceNotZero() throws Exception {
		assertEquals(5, yatzy.score(CHANCE, new int[]{1, 1, 1, 1, 1}));
	}
	
	@Test
	public void testForSomeOtherCombination() throws Exception {
		assertEquals(15, yatzy.score(CHANCE, new int[]{1, 2, 3, 4, 5}));
	}
	
	@Test(expected=InvalidRollException.class)
	public void testWithSmallerRoll() throws Exception {
		yatzy.score(CHANCE, new int[]{1, 2});
	}
	
	@Test(expected=InvalidRollException.class)
	public void testWithLargerRoll() throws Exception {
		yatzy.score(CHANCE, new int[]{1, 2, 3, 4, 5, 6});
	}
	
	@Test
	public void testForPair() throws Exception {
		assertEquals(2, yatzy.score(PAIR, new int[]{1, 1, 3, 4, 5}));
	}
	
	@Test
	public void testForOutOfOrderPair() throws Exception {
		assertEquals(2, yatzy.score(PAIR, new int[]{1, 3, 4, 1, 5}));
	}
	
	@Test
	public void testPairForMoreThanTwo() throws Exception {
		assertEquals(0, yatzy.score(PAIR, new int[]{1, 3, 4, 1, 1}));
	}
}

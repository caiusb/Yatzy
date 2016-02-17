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
	public void testChanceForZero() {
		assertEquals(0, yatzy.score(CHANCE, new int[]{0, 0, 0, 0, 0}));
	}

	@Test
	public void testChanceForOneDieNotZero() {
		assertEquals(1, yatzy.score(CHANCE, new int[]{1, 0, 0, 0, 0}));
	}
	
	@Test
	public void testForAllDiceNotZero() {
		assertEquals(5, yatzy.score(CHANCE, new int[]{1, 1, 1, 1, 1}));
	}
	
	@Test
	public void testForSomeOtherCombination() {
		assertEquals(21, yatzy.score(CHANCE, new int[]{1, 2, 3, 4, 5, 6}));
	}
}

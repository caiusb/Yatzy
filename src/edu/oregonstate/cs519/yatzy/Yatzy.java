package edu.oregonstate.cs519.yatzy;

public class Yatzy {

	public int score(int[] roll) {
		int sum = 0;
		for (int die : roll)
			sum += die;
		return sum;
	}
}

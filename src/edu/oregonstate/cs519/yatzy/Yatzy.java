package edu.oregonstate.cs519.yatzy;

public class Yatzy {

	public int score(Bet bet, int[] roll) {
		switch(bet) {
		case CHANCE:
			int sum = 0;
			for (int die : roll)
				sum += die;
			return sum;
		}
		
		return -1;
	}
}

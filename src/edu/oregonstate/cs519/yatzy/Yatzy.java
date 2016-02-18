package edu.oregonstate.cs519.yatzy;

import java.util.Arrays;

public class Yatzy {

	public int score(Bet bet, int[] roll) throws InvalidRollException {
		if (roll.length - 5 != 0)
			throw new InvalidRollException();
		switch(bet) {
		case CHANCE:
			int sum = 0;
			for (int die : roll)
				sum += die;
			return sum;
		case PAIR:
			Arrays.sort(roll);
			int last = 0;
			int value = 0;
			boolean pair = false;
			for (int die : roll)
				if (last == 0)
					last = die;
				else
					if (last == die)
						if (!pair) {
							pair = true;
							value = die;
						}
						else
							pair = false;
			
			if (pair)
				return value*2;
			
			return 0;
		}
		
		return -1;
	}
}

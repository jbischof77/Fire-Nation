import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Shuffle
{

	public String[] riffleShuffle(String[] cards, double n)
	{

		String[] shuffleCards = new String[52];
		int[] places = new int[52];

		for(int i = 0; i < cards.length; i++)
		{
			places[i] = i;
			shuffleCards[i] = cards[i];
		}

		double shannon = shannonEntropy(places);

		while(shannon < n)
		{
			Random rand = new Random();
			int randNum = rand.nextInt(5);
			int deck1 = 22 + randNum;
			int deck2 = 52 - deck1;

			String[] right = new String[deck2];
			String[] left = new String[deck1];
			int[] rightPlaces = new int[deck2];
			int[] leftPlaces = new int[deck1];

			for(int j = 0; j < deck1; j++)
			{
				left[j] = shuffleCards[j];
				leftPlaces[j] = places[j];
			}

			for(int j = 0; j < deck2; j++)
			{
				right[j] = shuffleCards[j + deck1];
				rightPlaces[j] = places[j + deck1];
			}
			
			int count = 0;
			int countLeft = 0;
			int countRight = 0; 
			
			while(count < 52)
			{
				randNum = rand.nextInt(4);
				
				if(countRight + randNum < right.length)
				{
					for(int j = 0; j < randNum; j++)
					{
						shuffleCards[count] = right[countRight];
						places[count] = rightPlaces[countRight];
						count++;
						countRight++;
					}
				}
				else
				{
					for(int j = countRight; j < right.length; j++)
					{
						shuffleCards[count] = right[countRight];
						places[count] = rightPlaces[countRight];
						count++;
						countRight++;
					}
				}
				
				randNum = rand.nextInt(4);
				
				if(countLeft + randNum < left.length)
				{
					for(int j = 0; j < randNum; j++)
					{
						shuffleCards[count] = left[countLeft];
						places[count] = leftPlaces[countLeft];
						count++;
						countLeft++;
					}
				}
				else
				{
					for(int j = countLeft; j < left.length; j++)
					{
						shuffleCards[count] = left[countLeft];
						places[count] = leftPlaces[countLeft];
						count++;
						countLeft++;
					}
				}
			}
			
			shannon = shannonEntropy(places);	
		}

		return shuffleCards;

	}

	public String[] fisherYates(String[] cards, int n)
	{
		
		String[] shuffleCards = new String[52];
		int[] places = new int[52];

		for(int i = 0; i < cards.length; i++)
		{
			places[i] = i;
			shuffleCards[i] = cards[i];
		}

		for(int k = 0; k < n; k++)
		{
			Random rand = new Random();
			int maxRand = 52;
			int randNum = 0;
				
			for(int i = 0; i < shuffleCards.length; i++)
			{
				randNum = rand.nextInt(maxRand);
				String temp = shuffleCards[randNum];
				int tempInt = places[randNum];

				for(int j = randNum; j < maxRand - 1; j++)
				{
					places[j] = places[j + 1];
					shuffleCards[j] = shuffleCards[j + 1];
				}

				places[maxRand - 1] = tempInt;
				shuffleCards[maxRand - 1] = temp;
				maxRand--;
			
			}
		}

		return shuffleCards;

	}

	public static double shannonEntropy(int[] places)
	{

		int[] bins = new int[52];
		double shannon = 0.0;

		for(int i = 0; i < 51; i++)
		{
			int diff = places[i] - places[(i + 1) % 52];

			if(diff < 0)
			{
				diff = diff + 52;
			}

			bins[diff]++;
		}

		for(int i = 0; i < 51; i++)
		{
			double p = (double)bins[i] / 52.0;

			if(p > 0.0)
			{
				shannon -= p * Math.log(p) / Math.log(2.0);
			}
		}

		return shannon;

	}

}
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

public class Shithead
{

	private static Scanner s = new Scanner(System.in);
	private static LinkedList<String> deck  = new LinkedList<String>();
	private static String[] cards = new String[52];
	private static LinkedList<String> discardPile = new LinkedList<String>();
	
	public static void setCards()
	{
	
		String[] suits = {"H", "C", "S", "D"};
		String[] types = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		int count = 0;

		for(int i = 0; i < suits.length; i++)
		{
			for(int j = 0; j < types.length; j++)
			{
				cards[count] = types[j] + suits[i];
				count++;
			}
		}
	
	}
	
	public static void emptyDiscardPile()
	{
		
		for(int i = 0; i < discardPile.size(); i++)
		{
			discardPile.remove();
		}
		
	}
	
	public static int getCardValue(String card)
	{
		
		if(card.equals("2H") || card.equals("2C") || card.equals("2S") || card.equals("2D"))
		{
			return 2;
		}
		else if(card.equals("3H") || card.equals("3C") || card.equals("3S") || card.equals("3D"))
		{
			return 3;
		}
		else if(card.equals("4H") || card.equals("4C") || card.equals("4S") || card.equals("4D"))
		{
			return 4;
		}
		else if(card.equals("5H") || card.equals("5C") || card.equals("5S") || card.equals("5D"))
		{
			return 5;
		}
		else if(card.equals("6H") || card.equals("6C") || card.equals("6S") || card.equals("6D"))
		{
			return 6;
		}
		else if(card.equals("7H") || card.equals("7C") || card.equals("7S") || card.equals("7D"))
		{
			return 7;
		}
		else if(card.equals("8H") || card.equals("8C") || card.equals("8S") || card.equals("8D"))
		{
			return 8;
		}
		else if(card.equals("9H") || card.equals("9C") || card.equals("9S") || card.equals("9D"))
		{
			return 9;
		}
		else if(card.equals("10H") || card.equals("10C") || card.equals("10S") || card.equals("10D"))
		{
			return 10;
		}
		else if(card.equals("JH") || card.equals("JC") || card.equals("JS") || card.equals("JD"))
		{
			return 11;
		}
		else if(card.equals("QH") || card.equals("QC") || card.equals("QS") || card.equals("QD"))
		{
			return 12;
		}
		else if(card.equals("KH") || card.equals("KC") || card.equals("KS") || card.equals("KD"))
		{
			return 13;
		}
		else
		{
			return 1;
		}
		
	}
	
	public static void main(String[] args)
	{
		
		setCards();
		
		Shuffle shuf = new Shuffle();
		
		System.out.println("What would you like to do:\n[1] Play new game\n[2] Shuffle cards\n[3] View deck\n[4] Quit");
		int choice = s.nextInt();
		
		while(choice != 4)
		{
			if(choice == 1)
			{
				System.out.println("Enter the number of players(can be between 2 and 6): ");
				int noPlayers = s.nextInt();
				s.nextLine();
				
				LinkedList<Player> players = new LinkedList<Player>();
				
				for(int i = 0; i < noPlayers; i++)
				{
					System.out.println("Enter the name of player " + (i + 1) + ": ");
					players.add(new Player(s.nextLine()));
				}
				
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < noPlayers; j++)
					{
						players.get(j).addFaceDown(deck.get(0));
						deck.remove();
					}
				}
				
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < noPlayers; j++)
					{
						players.get(j).addFaceUp(deck.get(0));
						deck.remove();
					}
				}
				
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < noPlayers; j++)
					{
						players.get(j).addHand(deck.get(0));
						deck.remove();
					}
				}
				
				while(players.size() > 1)
				{
					s.nextLine();
					for(int i = 0; i < noPlayers; i++)
					{
						if(discardPile.size() > 0)
						{
							System.out.println("Top of Discard Pile: " + discardPile.get(discardPile.size() - 1));
						}
						System.out.println(players.get(i));
						
						if(players.get(i).getHand().size() > 0)
						{
							System.out.println("Choose the card you will play: ");
							String playedCard = s.nextLine();
							
							if(discardPile.size() >= 1)
							{
								if (getCardValue(playedCard) == 2 || getCardValue(playedCard) == 1)
								{
									discardPile.add(playedCard);
									players.get(i).removeHand(playedCard);
									if(deck.size() > 0)
									{
										players.get(i).addHand(deck.get(0));
										deck.remove();
									}
								}
								else if(getCardValue(discardPile.get(discardPile.size() - 1)) == 7)
								{
									boolean check = true;
									while(check)
									{
										System.out.println("Please choose a card that is smaller in value than the one on top of the discard pile. If you can not then enter 'pick up'.");
										playedCard = s.nextLine();
										
										if(discardPile.size() > 0)
										{
											System.out.println("Top of Discard Pile: " + discardPile.get(discardPile.size() - 1));
										}
										System.out.println(players.get(i));
										
										if(playedCard.equals("pick up"))
										{
											for(int j = 0; j < discardPile.size(); j++)
											{
												players.get(i).addHand(discardPile.get(0));
												discardPile.remove();
											}
											check = false;
										}
										else if(getCardValue(playedCard) < getCardValue(discardPile.get(discardPile.size() - 1)))
										{
											discardPile.add(playedCard);
											players.get(i).removeHand(playedCard);
											if(deck.size() > 0)
											{
												players.get(i).addHand(deck.get(0));
												deck.remove();
											}
											check = false;
										}
									}
								}
								else if(getCardValue(playedCard) >= getCardValue(discardPile.get(discardPile.size() - 1)))
								{
									discardPile.add(playedCard);
									players.get(i).removeHand(playedCard);
									if(deck.size() > 0)
									{
										players.get(i).addHand(deck.get(0));
										deck.remove();
									}
								}
								else
								{
									boolean check = true;
									while(check)
									{
										System.out.println("Please choose a card that is larger or equal in value to the one on top of the discard pile. If you can not then enter 'pick up'.");
										playedCard = s.nextLine();
										
										if(discardPile.size() > 0)
										{
											System.out.println("Top of Discard Pile: " + discardPile.get(discardPile.size() - 1));
										}
										System.out.println(players.get(i));
										
										if(playedCard.equals("pick up"))
										{
											for(int j = 0; j < discardPile.size(); j++)
											{
												players.get(i).addHand(discardPile.get(discardPile.size() - 1));
												discardPile.remove();
											}
											check = false;
										}
										else if(getCardValue(playedCard) >= getCardValue(discardPile.get(discardPile.size() - 1)))
										{
											discardPile.add(playedCard);
											players.get(i).removeHand(playedCard);
											if(deck.size() > 0)
											{
												players.get(i).addHand(deck.get(0));
												deck.remove();
											}
											check = false;
										}
									}
								}
							}
							else
							{
								discardPile.add(playedCard);
								players.get(i).removeHand(playedCard);
								if(deck.size() > 0)
								{
									players.get(i).addHand(deck.get(0));
									deck.remove();
								}
							}
						}
						else if(players.get(i).getHand().size() == 0 && players.get(i).getFaceUp().size() > 0)
						{
							System.out.println("Choose the card you will play: ");
							String playedCard = s.nextLine();
							
							if(discardPile.size() >= 1)
							{
								if (getCardValue(playedCard) == 2 || getCardValue(playedCard) == 1)
								{
									discardPile.add(playedCard);
									players.get(i).removeFaceUp(playedCard);
								}
								else if(getCardValue(discardPile.get(discardPile.size() - 1)) == 7)
								{
									boolean check = true;
									while(check)
									{
										System.out.println("Please choose a card that is smaller in value than the one on top of the discard pile. If you can not then enter 'pick up'.");
										playedCard = s.nextLine();
										
										if(discardPile.size() > 0)
										{
											System.out.println("Top of Discard Pile: " + discardPile.get(discardPile.size() - 1));
										}
										System.out.println(players.get(i));
										
										if(playedCard.equals("pick up"))
										{
											for(int j = 0; j < discardPile.size(); j++)
											{
												players.get(i).addHand(discardPile.get(discardPile.size() - 1));
												discardPile.remove();
											}
											check = false;
										}
										else if(getCardValue(playedCard) < getCardValue(discardPile.get(discardPile.size() - 1)))
										{
											discardPile.add(playedCard);
											players.get(i).removeFaceUp(playedCard);
											check = false;
										}
									}
								}
								else if(getCardValue(playedCard) >= getCardValue(discardPile.get(discardPile.size() - 1)))
								{
									discardPile.add(playedCard);
									players.get(i).removeFaceUp(playedCard);
								}
								else
								{
									boolean check = true;
									while(check)
									{
										System.out.println("Please choose a card that is larger or equal in value to the one on top of the discard pile. If you can not then enter 'pick up'.");
										playedCard = s.nextLine();
										
										if(discardPile.size() > 0)
										{
											System.out.println("Top of Discard Pile: " + discardPile.get(discardPile.size() - 1));
										}
										System.out.println(players.get(i));
										
										if(playedCard.equals("pick up"))
										{
											for(int j = 0; j < discardPile.size(); j++)
											{
												players.get(i).addHand(discardPile.get(0));
												discardPile.remove();
											}
											check = false;
										}
										else if(getCardValue(playedCard) >= getCardValue(discardPile.get(discardPile.size() - 1)))
										{
											discardPile.add(playedCard);
											players.get(i).removeFaceUp(playedCard);
											check = false;
										}
									}
								}
							}
							else
							{
								discardPile.add(playedCard);
								players.get(i).removeFaceUp(playedCard);
							}
						}
						else
						{
							System.out.println("Choose the card you will play (Enter [1], [2] or [3]): ");
							int chooseFaceDown = s.nextInt();
							String playedCard = players.get(i).getFaceDown().get(chooseFaceDown - 1);
							
							if(discardPile.size() >= 1)
							{
								if (getCardValue(players.get(i).getFaceDown().get(chooseFaceDown - 1)) == 2 || getCardValue(players.get(i).getFaceDown().get(chooseFaceDown - 1)) == 1)
								{
									discardPile.add(playedCard);
									players.get(i).removeFaceDown(chooseFaceDown - 1);
								}
								else if(getCardValue(discardPile.get(0)) == 7)
								{		
									if(getCardValue(players.get(i).getFaceDown().get(chooseFaceDown - 1)) < getCardValue(discardPile.get(discardPile.size() - 1)))
									{
										discardPile.add(playedCard);
										players.get(i).removeFaceDown(chooseFaceDown);
									}
									else
									{
										for(int j = 0; j < discardPile.size(); j++)
										{
											players.get(i).addHand(discardPile.get(discardPile.size() - 1));
											discardPile.remove();
										}
									}
								}
								else if(getCardValue(playedCard) >= getCardValue(discardPile.get(discardPile.size() - 1)))
								{
									discardPile.add(playedCard);
									players.get(i).removeFaceDown(chooseFaceDown);
								}
								else
								{	
									if(getCardValue(playedCard) >= getCardValue(discardPile.get(discardPile.size() - 1)))
									{
										discardPile.add(playedCard);
										players.get(i).removeFaceDown(chooseFaceDown);
									}
									else
									{
										for(int j = 0; j < discardPile.size(); j++)
										{
											players.get(i).addHand(discardPile.get(discardPile.size() - 1));
											discardPile.remove();
										}
									}
								}
							}
							else
							{
								discardPile.add(playedCard);
								players.get(i).removeFaceDown(chooseFaceDown);
							}
						}
						
						if(players.get(i).getFaceDown().size() < 1)
						{
							players.remove(i);
						}
						
						if(getCardValue(discardPile.get(0)) == 10)
						{
							emptyDiscardPile();
						}
						else if(getCardValue(discardPile.get(0)) == 4)
						{
							i++;
						}
					}
				}
			}
			else if(choice == 2)
			{
				System.out.println("Choose your Shuffle:\n[1] Riffle Shuffle\n[2] Fisher Yates Shuffle");
				choice = s.nextInt();
				
				if(choice == 1)
				{
					cards = shuf.riffleShuffle(cards, 5);
			
					for(int i = 0; i < 52; i++)
					{
						deck.add(cards[i]);
					}
				}
				else
				{
					System.out.println("How many shuffles would you like to do: ");
					choice = s.nextInt();
					cards = shuf.fisherYates(cards, choice);
			
					for(int i = 0; i < 52; i++)
					{
						deck.add(cards[i]);
					}
				}
			}
			else if(choice == 3)
			{
				System.out.println(deck);
			}
			else
			{
				System.out.println("Enter a valid ooption");
			}
			
			System.out.println("What would you like to do:\n[1] Play new game\n[2] Shuffle cards\n[3] View deck\n[4] Quit");
			choice = s.nextInt();
		}
		
		emptyDiscardPile();
		
	}
	
}
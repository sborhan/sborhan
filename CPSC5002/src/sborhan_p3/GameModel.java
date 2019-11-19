

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_p3;

import java.util.ArrayList;
import java.util.Random;

/*
 * class GameModel
 * 
 * All of the game logic should be in this class
 */
public class GameModel {

	//private fields
	private Stack<Integer>  dealStack;
	private Stack<Integer>  discardPileStack ;
	private Queue<Integer>  player1Cards ;
	private Queue<Integer>  player2Cards ;	
	private ArrayList<Integer> deckOfCards;
	private int playerTurn;
	int playerCard;

	
	/*
	 * Constructor
	 * 
	 */
	public GameModel() {
		
		playerCard =0;
		dealStack= new Stack<>();
		discardPileStack  = new Stack<>();
		player1Cards = new Queue<>();
		player2Cards = new Queue<>();
		deckOfCards = new ArrayList<Integer>();
		playerTurn =1;
		//initiating deck of cards
		for(int i=1;i<=13;i++) {
			for(int j=1;j<=4;j++) {
				deckOfCards.add(i);
			}
		}		
	}
	
	
	/*
	 * method playerTurnStart
	 * saving and displaying first card value in each player hand
	 * 
	 * @return : void
	 */
	public void playerTurnStart()
	{		
		if (playerTurn==1)
		{
		printPlayersCards(1);
		System.out.println("\ndiscard pile card:" + discardPileStack.peek());
	    playerCard = player1Cards.getHead();
		System.out.println("your current card:" + player1Cards.getHead());
		}
		else
		{
			printPlayersCards(2);
			System.out.println("\ndiscard pile card:" + discardPileStack.peek());
			System.out.println("your current card:" + player2Cards.getHead());
			
		}
		System.out.println("Press RETURN to take a turn.");
	}
	
	/*
	 * method playerPlay
	 * 
	 * Execute game rules
	 * check the status of the game 
	 * check if a user wins
	 * 
	 * @return : boolean
	 */
	public boolean playerPlay()
	{
		boolean isGameFinished = false;
		
		if (playerTurn==1)
		{
			if(player1Cards.getHead() > discardPileStack.peek())  
			{
				discardPileStack.push(player1Cards.dequeue());
				System.out.println("Your card is HIGHER, turn is over.");
				
				if(player1Cards.empty())
				{
					System.out.println("You have won the game!");
				    System.out.println("The game has finished.");
				    isGameFinished = true;
				}
			}
			else if(player1Cards.getHead() == discardPileStack.peek())
			{

				System.out.println("Your card is equal, pick one card.");
				player1Cards.enqueue(takeCard());
				discardPileStack.push(player1Cards.dequeue());
				
			}
			
			else
			{

				System.out.println("Your card is LOWER, pick up 2 cards.");
				player1Cards.enqueue(takeCard());
				player1Cards.enqueue(takeCard());
				discardPileStack.push(player1Cards.dequeue());
			}
		
		}
		else 
		{
			if(player2Cards.getHead() > discardPileStack.peek())
			{
				discardPileStack.push(player2Cards.dequeue());
				System.out.println("Your card is HIGHER, turn is over.");
				
				
				if(player2Cards.empty())
				{
					System.out.println("You have won the game!");
				    System.out.println("The game has finished.");
				    isGameFinished=true;
				}
			}
			else if(player2Cards.getHead() == discardPileStack.peek())
			{
				
				System.out.println("Your card is equal, pick one card.");
				player2Cards.enqueue(takeCard());
				discardPileStack.push(player2Cards.dequeue());
				
			}
			
			else
			{

				System.out.println("Your card is LOWER, pick up 2 cards.");
				player2Cards.enqueue(takeCard());
				player2Cards.enqueue(takeCard());
				discardPileStack.push(player2Cards.dequeue());
			}
	
		}
		
		playerTurn = (playerTurn==1)?2:1;
		
	 return isGameFinished;
		
	}
	
	
	/*
	 * method takeCard
	 * 
	 * return the top DealStack card value
	 * 
	 * check if the deal stack empty and 
	 * using fillEmptyDealStack and fillDiscardPileStack to
	 * fill pile stack and deal stack again
	 * 
	 * @return : integer
	 * 
	 */
	private int takeCard()
	{
			if(dealStack.empty()) {
				fillEmptyDealStack();
				fillDiscardPileStack();
			}
				return dealStack.pop();			
		
	}
	
	
	/*
	 * method fillDiscardPileStack
	 * 
	 * filing Discard Pile Stack with
	 * the top card value of deal Stack
	 * @return : void
	 */
	public void fillDiscardPileStack() {
		discardPileStack.push(dealStack.pop());
	}
	
	/*
	 * method fillEmptyDealStack
	 * filling out the deal stack with
	 * discardPileStack values and 
	 * emptying out the discardPileStack
	 * 
	 * @return : void
	 */
	public void fillEmptyDealStack()
	{
		Stack<Integer> temp = discardPileStack.reverseCopy(); 
		
		
		
		while(!temp.empty()) {
			
			dealStack.push(temp.pop());
			
		}
		
		
		while(!discardPileStack.empty())
		{
			discardPileStack.pop();
		}
	}
	
	/*
	 * method printDealStack
	 * 
	 * printing DealStack cards values
	 * @ return : void 
	 */
	public void printDealStack() {
		Stack<Integer > dealStackCOpy = dealStack.copy();
		System.out.print("\ndeal Stack: ");
		while(!dealStackCOpy.empty()) {
	      	  System.out.print(dealStackCOpy.pop()+"|");
		
		}
	}
	
	
	/*
	 * method redRobinDealing
	 * 
	 * dealing cards from deckOfCard in a red robin style
	 * each user get 7 card
	 * @return : void
	 */
	public void redRobinDealing()
	{
		for(int i=1;i<=14;i++) {
			if(i%2 == 0) {
				player1Cards.enqueue(dealStack.pop());
				
			}else {
				player2Cards.enqueue(dealStack.pop());
			}
		}	
	}
	
	/*
	 * method getPlayer1Cards
	 * getting Queue of player1 cards
	 * @return : Queue<Integer>
	 */
	public Queue<Integer> getPlayer1Cards(){
		return player1Cards;
	}
	
	/*
	 * method getPlayer2Cards
	 * getting Queue of player2 cards
	 * @return : Queue<Integer>
	 */
	public Queue<Integer> getPlayer2Cards(){
		return player2Cards;
	}
	
	
	
	/**
	 * Shuffles the cards using the
	 * <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">
	 * Fisher-Yates algorithm</a>
	 * using createDealStack method to create deal stack
	 * @param cards deck to shuffle
	 */
	public void shuffleDeck() {
		
	    Random rand = new Random();
	    for (int i = deckOfCards.size(); i > 1; i--) {
	        int j = rand.nextInt(i);
	        int temp = deckOfCards.get(i - 1);
	        deckOfCards.set(i - 1, deckOfCards.get(j));
	        deckOfCards.set(j, temp);
	    }
	    
	    //always shuffle before creating the deal stack
	    createDealStack();
	}
	
	/*
	 * method createDealStack
	 * 
	 * filing DealStack with deckOfCards Array list values
	 * and filling Discard Pile Stack with fillDiscardPileStack method
	 * with top card of dealStack
	 * @return : void
	 */
	private void createDealStack()
	{
		for(int i: deckOfCards) {
			dealStack.push(i);
		}
	    fillDiscardPileStack();

	}
	 
	/*
	 * method printDiscardPileStack
	 * 
	 * printing DiscardPileStack values
	 * @return :void
	 */
	public void printDiscardPileStack() {
		Stack <Integer> DiscardPileStackCopy  = discardPileStack.copy();
		System.out.print("\nDiscard Pile Stack: ");
		while(!DiscardPileStackCopy.empty()) {
			System.out.print(DiscardPileStackCopy.pop()+"|");
		}
		System.out.print("\n");

	}
	
	
	/*
	 * method printPlayersCards
	 * printing PlayersCards values
	 * @return : void
	 * 
	 */
  public void printPlayersCards(int player)
  {
	 System.out.println();
     System.out.print("Player's "+player+ " ,cards: ");
	if(player==1)
	{
		Queue<Integer> player1CardCopy = player1Cards.copy();
       

        while(!player1CardCopy.empty())
        {        	  
      	  System.out.print(player1CardCopy.dequeue()+"|");
        }
	}
	else 
	{
		Queue<Integer> player2CardCopy = player2Cards.copy();
	       

        while(!player2CardCopy.empty())
        {        	  
      	  System.out.print(player2CardCopy.dequeue()+"|");
		
        }
	}

   }
  
  /*
   * method printDeckOfCards
   * printing Deck Of Cards by using dealStack values
   * @return : void
   */
  
   public void printDeckOfCards()
   {
	 
		  System.out.print("Shuffled cards: ");
		  Stack <Integer> stackCopy = dealStack.copy();
		  while(!stackCopy.empty()) {
		     	 System.out.print(stackCopy.pop()+"|");
		      }
	  
   }
   
  }

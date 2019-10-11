import java.util.LinkedList;

public class Player {

	private String name;

	private LinkedList<String> faceDown;
	private LinkedList<String> faceUp;
	private LinkedList<String> hand;
	
	public Player(String name) {
		this.name = name;
		this.faceDown = new LinkedList<String>();
		this.faceUp = new LinkedList<String>();
		this.hand = new LinkedList<String>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public LinkedList<String> getFaceDown(){
		return this.faceDown;
	}
	
	public LinkedList<String> getFaceUp(){
		return this.faceUp;
	}
	
	public LinkedList<String> getHand(){
		return this.hand;
	}
	
	public void addFaceDown(String card){
		faceDown.add(card);
	}
	
	public void addFaceUp(String card){
		faceUp.add(card);
	}
	
	public void addHand(String card){
		hand.add(card);
	}
	
	public void removeFaceDown(int card){
		faceDown.remove(card);
	}
	
	public void removeFaceUp(String card){
		faceUp.remove(faceUp.indexOf(card));
	}
	
	public void removeHand(String card){
		hand.remove(hand.indexOf(card));
	}
	
	public String toString(){
		return getName() + "\nFace Up Cards: " + getFaceUp() + "\nHand Cards: " + getHand();
	}
}
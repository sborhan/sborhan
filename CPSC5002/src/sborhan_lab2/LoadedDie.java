
package sborhan_lab2;
import java.lang.Math;


public class LoadedDie {
	
	// private fields
	private int dieValue;
	private int loadedNumber;
	private int moreTimesPerHundred;
	
	// constructor with two arguments
	public LoadedDie(int loadedNumber,int moreTimesPerHundred) {
		
		this.loadedNumber = loadedNumber;
		this.moreTimesPerHundred = moreTimesPerHundred;		
	}
	
	public LoadedDie(LoadedDie object2) {
		loadedNumber =object2.loadedNumber;
     	moreTimesPerHundred=object2.moreTimesPerHundred;
	}
	
	//this method returns dice values
	public   int roll() {
		//create random between 1 to 100
		int val = (int) (Math.random()*100+1);
		
		// check if random number(1-100) less than moreTimesPerHundred(30%)
		//if so return the favored face (1 or 6)
		if(val <= moreTimesPerHundred ) {
			dieValue = loadedNumber;
			// if random number(1-100) more than 30%,
			// regular random number between 1 to 6 will be returned
		}else {
			dieValue = (int) (Math.random()*6+1);
		}	
		return dieValue;
	}
}

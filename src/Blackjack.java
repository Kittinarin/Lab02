import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

//Attribute
public class Blackjack{
    private int[] cardYou = new int[5];
    private int[] cardComputer = new int[2];
    private int sumYou = 0;
    private int sumComputer =0;
    private String winner;
    private int numYourCard = 2; // have 2 card
    
    
    public Blackjack(){
        //Initialize game data
        Random rand = new Random();//Object of class
        //Player
        cardYou[0] = rand.nextInt(11)+1;    //random 0-10    
        cardYou[1] = rand.nextInt(11)+1;
        
        //Dealer
        cardComputer[0] = rand.nextInt(11)+1;
        cardComputer[1] = rand.nextInt(11)+1;
        
        //Sum
        sumYou = cardYou[0]+cardYou[1]; //total score
        sumComputer = cardComputer[0]+cardComputer[1];
        
        //Check both card is 11 or not --> 11+11=22
        if(sumYou==22){
           cardYou[1]=1; 
           //sumYou=cardYou[0]+cardYou[1]
           if (sumYou==22) {
        	   cardYou[1]=1;//22-->1
        		sumYou=12;   //11+1
           }		
        }
        if(sumComputer==22){// 11+11
            cardComputer[1] = 1;
            sumComputer=12;//11+1
        }
        
    }    
    
    public void showPlayerCard(){
        System.out.print("You: ");
        for(int value:cardYou) {// go to line 31
        	System.out.print(value+" ");
        }
        System.out.println();
    }
    
    public void showComputerCard(){
    	System.out.print("Computer: ");
    	for(int value:cardComputer) { //enhanced for
    		System.out.print(value+" ");
    	}
    	System.out.println();
    }
    
    public void showSumCard(){
    	System.out.println("Sum of your cards = "+sumYou);
    	System.out.println("Sum of computer cards = "+sumComputer);
    }
    
    public void adddMoreCard() { // add card
    	int draw = new Random().nextInt(11)+1;
    	if (draw == 11 && sumYou+draw > 21) {
    		draw =1;
    	}
    	
    	
    	cardYou[numYourCard] = draw;
    	sumYou += draw;
    	numYourCard ++;
    }
    
    public void checkWinner(){
    	if (sumYou>21) {
    		winner = "Computer!!";
    	}
        else if(sumYou>sumComputer){
            winner = "You!!!";
        }
        else {//sumYou <= sumComputer
            winner = "Computer!!";
        }
    }

    public boolean isEnd(){
    	//sumYou = sumYou + cardYou[numYouCard];
    	// System.out.println(sumYou); // check
    	
    	if(sumYou >= 21 || sumComputer >= 21 || numYourCard == 5) {
    		return true;
    	}
    
	    System.out.print("Want another card? (y/n)...");
		Scanner keyboard = new Scanner(System.in);
		char input = keyboard.next().charAt(0);
		    	
		if (input == 'y')
		{
			return false;
		}
		
		return true;    		
	
    }
    
    public String getWinner(){//getter method
    	return winner;
    }

    
    public static void main(String[] arg){
    	Blackjack bj = new Blackjack();
    	
    	while (true) {
    		
	        bj.showPlayerCard();
	        System.out.println("Computer: ? ?");
	        System.out.println();
	        
	        if(bj.isEnd())
	        {
	        	break; // exit the loop
	        }
	        
	        bj.adddMoreCard();
    	}
        
        bj.showPlayerCard();
        bj.showComputerCard();        
        System.out.println();
        bj.showSumCard();
        bj.checkWinner();
        System.out.println("The winner is "+bj.getWinner());
    }       
}
// Kittinarin Najai


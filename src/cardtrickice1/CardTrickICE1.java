/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardtrickice1;

import java.util.ArrayList;
import java.util.Scanner;

/** step1 : generate 7 random cards and store in array - how
 * step 2: take any card input from user suit,number
 * step 3: user card is in  the array 'card is found'
 *
 * @author sivagamasrinivasan,May 23rd
 * @author Rajrishi Naik -> StudentId 991660690, May 26th
 */
public class CardTrickICE1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Card luckyCard = new Card();
        luckyCard.setValue(12);
        luckyCard.setSuits("hearts");
        
        Card[] magicHand = new Card[7]; //Array of object
        ArrayList<String> tempSuite = new ArrayList<String>();
        ArrayList<Integer> tempValue = new ArrayList<Integer>();
        System.out.println("The magic hand of 7:\n");
        
        for( int i=0;i<magicHand.length;i++)
        {  
            Card c1 = new Card();
            c1.setValue((int)(Math.ceil((Math.random()*13))));//use a method to generate random *13
            c1.setSuits(Card.SUITS[((int)(Math.floor(Math.random()*4)))]);//random method suit 
            tempSuite.add(c1.getSuits());
            tempValue.add(c1.getValue());
            
            //LOGIC TO CHECK & REMOVE DUPLICATE CARDS
            for(int u=i+1; u<tempSuite.size(); u++){
                    if(tempSuite.get(i).equalsIgnoreCase(tempSuite.get(u))){
                        if(tempValue.get(i).equals(tempValue.get(u))){
                            tempSuite.remove(i);
                            tempValue.remove(i);
                            c1.setValue((int)(Math.ceil((Math.random()*13))));//use a method to generate random *13
                            c1.setSuits(Card.SUITS[((int)(Math.floor(Math.random()*4)))]);//random method suit 
                            tempSuite.add(c1.getSuits());
                            tempValue.add(c1.getValue());
                        }
                }
            }
            
            // DISPLAY CARDS GENERATED
            magicHand[i] = c1;
                        System.out.println(magicHand[i].getValue() + " of " + magicHand[i].getSuits());             
        }
        //step 2:take input 
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease choose the suit:\n"
                + "1: Hearts\n"
                + "2: Diamonds\n"
                + "3: Spades\n"
                + "4: Clubs");
        int suiteNo = sc.nextInt();
        String suite = "";
        switch(suiteNo){
            case 1:
                suite = "Hearts";
                break;
            case 2:
                suite = "Diamonds";
                break;
            case 3:
                suite = "Spades";
                break;
            case 4:
                suite = "Clubs";
                break;
        }
        System.out.println("Please choose the value (1 to 13)");
        int value = sc.nextInt();        
        System.out.printf("You selected %d of %s",value,suite).println();
            
        //step 3: match with array 
        boolean isAMatch = false;
        for (int i = 0; i < magicHand.length; i++) {
            if(magicHand[i].getSuits().equalsIgnoreCase(suite)){
                if(magicHand[i].getValue() == value){
                    isAMatch = true;
                    break;
                }
            }
        }
        if(isAMatch)
            System.out.println("Your card is in the magic hand of random cards!\nYou won!!");
        else
            System.out.println("Sorry, no match.");        
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Yash Yash
 * @ student Id - 991718947
 * @31st Jan
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Scanner scanner = new Scanner(System.in);
        
        // Filling magicHand with random cards and printing them
        System.out.println("Magic Hand:");
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]); // Random suit
            magicHand[i] = c;
            System.out.println(c.getSuit() + " " + c.getValue());
        }
        
        // Asking the user for card value and suit
        System.out.print("\nEnter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades): ");
        int userSuitIndex = scanner.nextInt();
        
        // Mapping user's suit index to actual suit
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String userSuit = suits[userSuitIndex];
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Adding a hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(7); // Set value to 7
        luckyCard.setSuit("Hearts"); // Set suit to Hearts
        
        // Searching magicHand for the user's card
        boolean found = false;
        for (int i = 0; i < magicHand.length; i++) {
            if (magicHand[i].getValue() == userCard.getValue() && magicHand[i].getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // Reporting the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}

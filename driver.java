
import java.util.*;
public class driver{

       public static void main(String args[]){
          int temp = 0;
           Scanner inputOne = new Scanner(System.in);
           boolean check = false;
           int x = 0;
           int y = 0;
           while(!check){
           System.out.println("How many rows would you like there to be? ");
           
           x = inputOne.nextInt();
           
           System.out.println("How many columns would you like there to be? ");
           
           y = inputOne.nextInt();
           if(x > 4 && x <21 && y > 4 && y < 21){
               check = true;
               
            }
            else{
                System.out.println("That isn't a valid board size");
                
            }
        }
        
        
           game.clear();
           
           System.out.println("Would you like to play with one player or an AI? (Enter 0 for AI, 1 for player)");
           temp = inputOne.nextInt();
           if(temp==1){
           visibleSBoard one = new visibleSBoard(x,y);
           visibleSBoard tOne = new visibleSBoard(x,y);
           shipBoard pOne = new shipBoard(x,y);
           
           visibleSBoard two = new visibleSBoard(x,y);
           visibleSBoard tTwo = new visibleSBoard(x,y);
           shipBoard pTwo = new shipBoard(x,y);
           
           
           game.setShips(pOne, one);
           game.transition();
           game.setShips(pTwo,two);
           game.transition();
           
           game.play(pOne,one,tOne,pTwo,two,tTwo);
           
           if(game.isWinner(pOne,pTwo) == 1){
               
               System.out.println("Player One has won the game!");
               
            }
            else{
                
               System.out.println("Player Two has won the game!"); 
            }
        }
        
        else{
            
            
            
            
        }
        }




}    

import java.util.*;
public class driver{

       public static void main(String args[]){
          
           Scanner inputOne = new Scanner(System.in);
           
           int x = 0;
           int y = 0;
           int oneLen = 5;
           int tempX = 0;
           int tempY = 0;
           int rotation = 0;
           System.out.println("How many rows would you like there to be? ");
           
           x = inputOne.nextInt();
           System.out.println("How many collums would you like there to be? ");
           
           y = inputOne.nextInt();
           visibleSBoard one = new visibleSBoard(x,y);
           shipBoard pOne = new shipBoard(x,y);
           
           
           
           
           
           
           while(oneLen >=2){
               
               pOne.printShipBoard();;
               System.out.println();
               one.printVisibleBoard();
               
               System.out.println("Enter the row of bow the  of the ship of length " + oneLen);
               tempX = inputOne.nextInt();
               
               System.out.println("Enter the collum of the bow of the ship of length " + oneLen);
               tempY = inputOne.nextInt();
               
               System.out.println("Enter the rotation of the ship of " + oneLen + "\n"
               +"(0 for horizontal, 1 for vertical, horizontal ships will always have the bow at the left\n"
               +"vertical ships will have the bow at the top");
               
               
               rotation = inputOne.nextInt();
               
               for(int i = 0; i < oneLen; i++){
                   
                   if(rotation == 0 && 
                   
                   
                }
               
               
            }
           
           
        }




}    
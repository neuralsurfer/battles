

import java.util.Scanner;
public class game{


    public static int isWinner(shipBoard one, shipBoard two){
        //This method will count health multiple times for each ship but it still works fine because if health is zero it wont matter and this method only needs to determine if there is zero health or not
        int countOne = 0;
        int countTwo = 0;
        
        for(int i = 0; i <one.getShipBoard().length; i++){
            for(int j = 0; j < one.getShipBoard()[0].length; j++){
                
                if(one.getShipBoard()[i][j] != null && one.getShipBoard()[i][j].getRef().getHealth() >0){
                    
                    countOne+= one.getShipBoard()[i][j].getRef().getHealth();
                }
                
                
            }
            
            
            
        }
         for(int i = 0; i <two.getShipBoard().length; i++){
            for(int j = 0; j < two.getShipBoard()[0].length; j++){
                
                if(two.getShipBoard()[i][j] != null && two.getShipBoard()[i][j].getRef().getHealth() >0){
                    
                    countTwo+= two.getShipBoard()[i][j].getRef().getHealth();
                }
                
                
            }
            
            
            
        }
        if(countTwo == 0) return 1;//Player two loses, player one wins
        if(countOne == 0) return 2;//Player one loses, player two wins
        return 0;//No winner
        
    }

    public static void setShips(shipBoard pOne, visibleSBoard one){
            int oneLen = 5;
            int tempX = 0;
            int tempY = 0;
            int rotation = 0;
            boolean check = true;
            boolean checkThree = false;
            Scanner inputOne = new Scanner(System.in);
            one.printVisibleBoard();
            while(oneLen >=2){
               
                check = true;
              
               System.out.println();
               
               
               System.out.println("Enter the row of bow the of the ship of length " + oneLen);
               tempX = inputOne.nextInt();
               
               System.out.println("Enter the column of the bow of the ship of length " + oneLen);
               tempY = inputOne.nextInt();
               
               System.out.println("Enter the rotation of the ship of " + oneLen + "\n"
               +"(0 for vertical with bow at top, 1 for horizontal with bow at right,\n2 for vertical with bow at bottom, 3 for horizontal with bow at the left)");
               
               
               rotation = inputOne.nextInt();
               game.clear();
               
               int counter = tempX;
               int counterY = tempY;
               if(rotation == 0 || rotation == 1){
               for(int i = 0; i < oneLen; i++){
                   
                   if(rotation == 0 && !one.isValid(counter,tempY)){
                      
                       check = false;
                      
                    }
                   if(rotation == 1 && !one.isValid(tempX,counterY)){
                       
                       check = false;
                      
                    }
                    
                    if(rotation == 0)counter++;
                   if(rotation == 1) counterY--;
                }
            }
            else if(rotation == 2 || rotation == 3){
                
                for(int i = 0; i < oneLen; i++){
                   
                   if(rotation == 2 && !one.isValid(counter,tempY)){
                       
                       check = false;
                     
                    }
                   if(rotation == 3 && !one.isValid(tempX,counterY)){
                       
                       check = false;
                      
                    }
                   
                   if(rotation == 2)counter--;
                   if(rotation == 3) counterY++;
                }
                
                
            }
            else{
                check = false;
                
            }
            
               if(check){
                   
                   one.setVisible(tempX,tempY,oneLen,rotation); 
                   pOne.setShip(tempX,tempY,oneLen,rotation);
                   if(!checkThree && oneLen == 3){
                       checkThree = true;
                    }
                   
                    
                    else{
                    oneLen--;
                    
                   }
                }
              
              
               
                else{
                    System.out.println("That isn't a valid ship index, enter a different one in");
                    
                    
                }
              
              
                 
                
              
               
                
               one.printVisibleBoard(); 
                
                
                
            }
        
        
        
    }
    public static void clear(){
        
        System.out.print('\u000C');
        
        
    }
    
    public static void transition(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to end your turn");
        String str = input.nextLine();
        System.out.print('\u000C');
        
        
        System.out.println("Pass the computer to the other player and enter any key once they have it");
        str = input.nextLine();
        System.out.print('\u000C');
    }
    // i is enemy shipBoard, j is enemey ship visible board, k is player targeting visible board
    public static int fire(int r, int c, shipBoard i,  visibleSBoard j, visibleSBoard k){
        int hit = 0;
        
        if(r > -1 && r < i.getShipBoard().length && c >-1 && c < i.getShipBoard()[0].length){
            if(i.getTile(r,c) != null && !i.getTile(r,c).isShot()){
                i.getTile(r,c).shoot();
                j.setVisible(r,c,"X");
                k.setVisible(r,c,"X");
                hit = 2;
            }
            else if(i.getTile(r,c) == null){
                j.setVisible(r,c,"O");
                k.setVisible(r,c,"O");
                hit = 1;
            }
            else{
                System.out.println("This tile has been shot at before");
            }
            
        }
        else{
            System.out.println("This isn't a valid tile index");
            
        }
        
        return hit;
    }//Returns 2 for hit, 1 for miss, 0 for not valid index
    
    public static void play(shipBoard pOne, visibleSBoard one, visibleSBoard tOne, shipBoard pTwo, visibleSBoard two, visibleSBoard tTwo){
        String currentPlayer = "Player One";
        Scanner input = new Scanner(System.in);
        int rInput = 0;
        
        int cInput = 0;
        while(isWinner(pOne,pTwo) == 0){
            currentPlayer = "Player One";
        tOne.printVisibleBoard();
        one.printVisibleBoard();
        System.out.println("Enter the row of the ship you want to fire at");
        rInput = input.nextInt();
        System.out.println("Enter the column of the ship you want to fire at");
        cInput = input.nextInt();
        
        while(fire(rInput,cInput,pTwo,two,tOne) == 0){
            fire(rInput,cInput,pTwo,two,tOne);
            System.out.println("Enter the row of the ship you want to fire at");
        rInput = input.nextInt();
        System.out.println("Enter the column of the ship you want to fire at");
        cInput = input.nextInt();
            
        }
        transition();
        if(isWinner(pOne,pTwo) == 0){
            currentPlayer = "Player Two";
            
              tTwo.printVisibleBoard();
        two.printVisibleBoard();
        System.out.println("Enter the row of the ship you want to fire at");
        rInput = input.nextInt();
        System.out.println("Enter the column of the ship you want to fire at");
        cInput = input.nextInt();
        
        while(fire(rInput,cInput,pOne,one,tTwo)==0){
            fire(rInput,cInput,pOne,one,tTwo);
            System.out.println("Enter the row of the ship you want to fire at");
        rInput = input.nextInt();
        System.out.println("Enter the column of the ship you want to fire at");
        cInput = input.nextInt();
            
        }
            
            
        }
        if(isWinner(pOne, pTwo) == 0) transition();
        else clear();
    }
    }
    
    


}    
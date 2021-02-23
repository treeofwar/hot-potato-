//ben duker
import java.util.Random;
import java.util.Scanner;
public class FrontEnd {
final static int MAX_TIME = 180;
	public static void main(String[] args) {
		Random r = new Random();
		int potatosec = (r.nextInt(MAX_TIME)) +1;//sets the random for the potato
		GenL<Player> player = new GenL<Player>();
		Scanner keyboard = new Scanner(System.in);
		boolean again = true;
		while(again) {//while loop for how many players
		System.out.println("hot potato time");
		System.out.println("how many players are there has to be more than 1");
		int players = keyboard.nextInt();
		if(players <=1) {//checks if there are more than 1 player
			System.out.println("not enough players");
			System.exit(0);
		}
		int i = 1;
		keyboard.nextLine();
		while(i<=players) //while loop for their names and then adds them to the nodes
		{
			System.out.println("enter in your name");
			
			player.insert(new Player(keyboard.nextLine()));//puts them in the node
			System.out.println();
			
			i++;//incrments
		}
		while(true)//while loop for playing again
		{
			
			System.out.println(player.getCurrent().getName() + " " + "enter in a value between 1-10");//lets them pick a number for the holder time
			int choice = keyboard.nextInt();
			if(choice >10 || choice <1)//each if statment checks if the number is in the parameters and then 
			{
				System.out.println("that is an invalid number youre getting to hold it for 10sec now");
				choice = 10;
			}
				if(choice >= potatosec )
				{
					System.out.println("you lose you got hot potato");
					player.removeAtCurr();
					if(player.length <=1) {//removes one from the length varible in gen list
					break;
					}
					potatosec = (r.nextInt(MAX_TIME)) +1;//resets the timer
					continue;
				}
				
			else 
			{
				System.out.println("you are safe for now");
				potatosec -= choice;//subtracts from the remaining time
			}
			player.gotoNext();
		}
		if(player.length == 1) {//checks if there is one person left
		System.out.println("want to play again type true or false");
		again = keyboard.nextBoolean();
		}
}
System.out.println("better luck next time");
System.exit(0);
	}

}

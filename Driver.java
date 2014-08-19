/**
 * Main method for instantiating pokemon objects and running program.
 * 
 * In this program a user will select two pokemon for a one-round fight. The pokemon that does the
 * most damage is declared the winner. The user will choose both his and the opponents pokemon.
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */

import java.util.Scanner;

public class Driver {

	/**
	 * Main Method
	 * @param args There are no command line arguments passed in
	 */
	public static void main(String[] args) {
		
		int result=-1;
		String text;
		Pokemon myPokemon=null, hisPokemon=null;
		Scanner myScanner=null, hisScanner=null;
		do{
		System.out.println("Hello, welcome to the Pokemon One-Shot, One-Round tournament!\n\n");
		System.out.println("Please select your pokemon\n");
		System.out.println("[1] Charmander!\n");
		System.out.println("[2] Squirtle!\n");
		System.out.println("[3] Bulbasaur!\n");
		
		myScanner = new Scanner(System.in);
		if(myScanner.hasNext()){
			result=myScanner.nextInt();
		}
		
		}while(result <1 || result >3);
		
		
		
		switch(result)
		{	
		case 1: myPokemon = new Charmander("Charmander", 100, 100, Pokemon.aspect.fire);
		break;
		
		case 2: myPokemon = new Squirtle(  "Squirtle",   100, 100, Pokemon.aspect.water);
		break;
		
		case 3: myPokemon = new Bulbasaur( "Bulbasaur",  100, 100, Pokemon.aspect.grass);
		break;
		
		default: text= "Bad times, cause this is an error buddy";
		
		}
		
		//Now for the opponent
		
		do{
			result=-1;
			System.out.println("Now choose your opponent!\n\n");
			System.out.println("Please select his pokemon\n");
			System.out.println("[1] Charmander!\n");
			System.out.println("[2] Squirtle!\n");
			System.out.println("[3] Bulbasaur!\n");
			
			hisScanner = new Scanner(System.in);
			
			if(hisScanner.hasNextInt()){
				result=hisScanner.nextInt();
			}
		
			
			}while(result <1 || result >3);
			
	      
			
			switch(result)
			{	
			case 1: hisPokemon = new Charmander("Charmander", 100, 100, Pokemon.aspect.fire);
			break;
			
			case 2: hisPokemon = new Squirtle("Squirtle",     100, 100, Pokemon.aspect.water);
			break;
			
			case 3: hisPokemon = new Bulbasaur("Bulbasaur",   100, 100, Pokemon.aspect.grass);
			break;
			
			default: text= "Bad times, cause this is an error buddy";
			
			}
		
		
		

		Referee myRef= new Referee(myPokemon, hisPokemon);
		
		result=myRef.determineWinner();
		
		switch(result)
		{	
		case 1: text=myPokemon.getName()+" dealt "+myRef.getAdamage()+" with "
		+myPokemon.highestLevelMove().getName()+"\n"
		+hisPokemon.getName()+" only dealt "+myRef.getBdamage()+" with "+hisPokemon.highestLevelMove().getName()+"\n"
		+"Therefore, "+myPokemon.getName()+" wins!\n";
		break;
		
		case 2: text=hisPokemon.getName()+" dealt "+myRef.getBdamage()+" with " +
		hisPokemon.highestLevelMove().getName()+"\n"
				+myPokemon.getName()+" only dealt "+myRef.getAdamage()+
				" with "+myPokemon.highestLevelMove().getName()+"\n"
				+"Therefore, "+hisPokemon.getName()+" wins!\n";
				break;
		
		case 3: text="It is a double knockout! CCCombo Breaker!!";
		break;
		
		default: text= "Bad times, cause this is an error buddy";
		
		}
		
		System.out.println(text);
		
		//Clean up resources
		 myScanner.close();
		 hisScanner.close();
	}//end main method

}

/**
 *Class used to determine the winner between two Pokemon objects.
 * 
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */

public class Referee {

	Pokemon a, b;
	private int aRealDamage, bRealDamage;
	enum effectiveness{normalDamage, weakness, strongAgainst};
	effectiveness aDefense, bDefense;
	enum aspect{fire, grass, water};
	
	public Referee(Pokemon a, Pokemon b){
		this.a=a;
		this.b=b;
	}
	
	public int determineWinner(){
		determineResistance();
		int remainingHealthA=a.getHealth(), remainingHealthB=b.getHealth();
		
		if(aDefense==Referee.effectiveness.normalDamage){
			remainingHealthA-=bRealDamage=b.damageThrown();
		}
		else if(aDefense==Referee.effectiveness.weakness){
			remainingHealthA-=bRealDamage=b.damageThrown()*2;
			
		}
		else if(aDefense==Referee.effectiveness.strongAgainst){
			remainingHealthA-=bRealDamage=(int)(b.damageThrown()*.5); //health can't be a fraction
			
		}
		
		//Now evaluate Pokemon B
		if(bDefense == Referee.effectiveness.normalDamage){
			remainingHealthB-=aRealDamage=a.damageThrown();
			
		}
		else if(bDefense == Referee.effectiveness.weakness){
			remainingHealthB-=aRealDamage=a.damageThrown()*2;
			
		}
		else if(bDefense == Referee.effectiveness.strongAgainst){
			remainingHealthB-=aRealDamage=(int)(a.damageThrown()*.5);
			
		}
		
		
		//now evaluate winner
		if(remainingHealthA < remainingHealthB){
			return 2;
		}
		else if(remainingHealthA > remainingHealthB){
			return 1;
		}
		else{
			return 3;
		}
		
	}
	
	
	private void determineResistance(){
		
		/*
		 * Omg, this was such a bad idea, but I'll manually code it.
		 */
		
		//First check Pokemon a is weak to Pokemon b
		if ((a.getAspect()==Pokemon.aspect.fire && b.getAspect()==Pokemon.aspect.water)
				|| (a.getAspect()==Pokemon.aspect.grass && b.getAspect()==Pokemon.aspect.fire ||
				(a.getAspect()==Pokemon.aspect.water && b.getAspect()==Pokemon.aspect.grass)))
		{
			aDefense=Referee.effectiveness.weakness;
			bDefense=Referee.effectiveness.strongAgainst;
		}// end first case
		
		//Second check if Pokemon b is weak to Pokemon A
		else if ((a.getAspect()==Pokemon.aspect.fire && b.getAspect()==Pokemon.aspect.grass)
				|| (a.getAspect()==Pokemon.aspect.grass && b.getAspect()==Pokemon.aspect.water ||
				(a.getAspect()==Pokemon.aspect.water && b.getAspect()==Pokemon.aspect.fire)))
		{
			aDefense=Referee.effectiveness.strongAgainst;
			bDefense=Referee.effectiveness.weakness;
		}// end second case
		
		//The only other alternative with three types, meaning they are the same type.
		else{
			aDefense=Referee.effectiveness.normalDamage;
			bDefense=Referee.effectiveness.normalDamage;
		}
	}
	
	public int getAdamage(){
		return aRealDamage;
	}
	public int getBdamage(){
		return bRealDamage;
	}
}

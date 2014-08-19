/**
 *Squirtle class inherits from Pokemon class.
 * 
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */

public class Squirtle extends Pokemon {

	public Squirtle(String name, int health, int level, aspect pokemonsAspect) {
		super(name, health, level, pokemonsAspect);
		// TODO Auto-generated constructor stub
	}

	@Override
	AttackMove highestLevelMove() {
		
		if (level<=-1){ //edge case
			AttackMove wtf = new AttackMove("WTF", 0);
			return wtf;
		}
		
		if(level<=10){
			AttackMove waterGun = new AttackMove("Watergun", 10);
			return waterGun;
		}
		else if(level<=20){
			AttackMove bubble = new AttackMove("Bubble", 20);
			return bubble;
		}
		else if(level<=30){
			AttackMove waterPulse = new AttackMove("Water Pulse", 30);
			return waterPulse;
		}
		
		else if(level<=40){
			AttackMove aquaTail = new AttackMove("Aqua Tail", 40);
			return aquaTail;
		}
		
		else if(level<=50){
			AttackMove rainDance = new AttackMove("Rain Dance", 50);
			return rainDance;
		}
		
		return new AttackMove("Hydro Pump", 100);
	}

	@Override
	int damageThrown() {
		int damage= this.highestLevelMove().getDamage();
		return (int) (damage*(.5 *level));
	}

}

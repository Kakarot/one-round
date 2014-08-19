/**
 *Bulbasaur class inherits from Pokemon class.
 * 
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */

public class Bulbasaur extends Pokemon {

	public Bulbasaur(String name, int health, int level, aspect pokemonsAspect) {
		super(name, health, level, pokemonsAspect);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * This method will determine the highest level attack that a pokemon can do based
	 * on his/her level.
	 */
	@Override
	AttackMove highestLevelMove() {
		
		if (level<=-1){ //edge case
			AttackMove wtf = new AttackMove("WTF", 0);
			return wtf;
		}
		
		if(level<=10){
			AttackMove ember = new AttackMove("Leech Seed", 10);
			return ember;
		}
		else if(level<=20){
			AttackMove fireFang = new AttackMove("Vine Whip", 20);
			return fireFang;
		}
		else if(level<=30){
			AttackMove flameBurst = new AttackMove("Razor Leaf", 30);
			return flameBurst;
		}
		
		else if(level<=40){
			AttackMove flameThrower = new AttackMove("Seed Bomb", 40);
			return flameThrower;
		}
		
		else if(level<=50){
			AttackMove fireSpin = new AttackMove("Leaf Storm", 50);
			return fireSpin;
		}
		
		return new AttackMove("Solar Beam", 100);
	}

	/**
	 *Determines damage based on move and pokemon's level.
	 *@return returns damage dealt.
	 */
	@Override
	int damageThrown() {
		int damage= this.highestLevelMove().getDamage();
		return (int) (damage*(.5 *level));
	}

}

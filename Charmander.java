/**
 *Charmander class inherits from Pokemon class.
 * 
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */


public class Charmander extends Pokemon {

	public Charmander(String name, int health, int level, aspect pokemonsAspect) {
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
			AttackMove ember = new AttackMove("Ember", 10);
			return ember;
		}
		else if(level<=20){
			AttackMove fireFang = new AttackMove("Fire Fang", 20);
			return fireFang;
		}
		else if(level<=30){
			AttackMove flameBurst = new AttackMove("Flame Burst", 30);
			return flameBurst;
		}
		
		else if(level<=40){
			AttackMove flameThrower = new AttackMove("Flamethrower", 40);
			return flameThrower;
		}
		
		else if(level<=50){
			AttackMove fireSpin = new AttackMove("Fire Spin", 50);
			return fireSpin;
		}
		
		return new AttackMove("Inferno", 100);
	}

	@Override
	int damageThrown() {
		int damage= this.highestLevelMove().getDamage();
		return (int) (damage*(.5 *level));
	}

}

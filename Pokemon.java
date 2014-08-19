/**
 *Pokemon class is an abstract class inherited by every Pokemon
 * 
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */


public abstract class Pokemon {

	protected String name;
	protected int health;
	protected int level;
	protected enum aspect{fire, grass, water};
	protected aspect pokemonsAspect;
	
	public Pokemon(String name, int health, int level, aspect pokemonsAspect){
		this.name=name;
		this.health=health;
		this.level=level;
		this.pokemonsAspect=pokemonsAspect;
	}//end constructor
	
	public String getName(){
		return this.name;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public aspect getAspect(){
		return this.pokemonsAspect;
	}
	
	
	
	abstract AttackMove highestLevelMove();
	
	abstract int damageThrown();
	
}

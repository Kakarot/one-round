/**
 *Class designed to hold attack attributes
 * 
 * 
 * @author James Ruiz
 * @date 08-18-2014
 *
 */

public class AttackMove {

	private String name;
	private int damage;
	
	public AttackMove(String name, int damage){
	
		this.name=name;
		this.damage=damage;
	
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getDamage(){
	return this.damage;
	}
	
	
}

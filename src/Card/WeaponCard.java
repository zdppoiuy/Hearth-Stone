package Card;

public class WeaponCard extends Card{
	public int weaponAttack;
	public int weaponLife;
	
	
	public WeaponCard(String name, int cost, int attack, int life){
		this.cardName=name;
		this.cardCost=cost;
		this.weaponAttack=attack;
		this.weaponLife=life;
	}
	
	
	
	
}

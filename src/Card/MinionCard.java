package Card;

public class MinionCard extends Card{
	public int minionMaxLife;
	public int minionAttack;
	public String minionType;
	
	public MinionCard(String cardName, int cardCost, int minionMaxLife, int minionAttact){
		this.cardType="Minion";
		this.cardName=cardName;
		this.cardCost=cardCost;
		this.minionMaxLife=minionMaxLife;
		this.minionAttack=minionAttact;
		this.minionType="Normal";
	}
	
	public MinionCard(int cardCost){
		this.cardType="Minion";
		this.cardCost=cardCost;
		this.minionMaxLife=cardCost+(int)(Math.random()*2);
		this.minionAttack=this.minionMaxLife>cardCost?cardCost:(cardCost+(int)(Math.random()*2));
		this.minionType="Normal";
		this.cardName=cardCost+String.valueOf(this.minionMaxLife)+(this.minionAttack);
	}
	
	public MinionCard() {
		// TODO Auto-generated constructor stub
	}
	
}


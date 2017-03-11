package Card;

public class MinionCard extends Card{
	public int minionMaxLife;
	public int minionAttact;
	
	public MinionCard(String cardName, int cardCost, int minionMaxLife, int minionAttact){
		this.cardName=cardName;
		this.cardCost=cardCost;
		this.minionMaxLife=minionMaxLife;
		this.minionAttact=minionAttact;
	}
	
	public MinionCard() {
		// TODO Auto-generated constructor stub
	}
	
}


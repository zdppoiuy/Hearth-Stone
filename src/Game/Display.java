package Game;

import Card.Card;
import Card.MinionCard;
import Unit.Unit;

public class Display {
	public void displayCard(Card myCard){
		System.out.println("*<"+myCard.cardName+">*");
	}
	public void displayCard(MinionCard myMinionCard){
		System.out.println("*"+myMinionCard.cardName);
		System.out.println("*<"+myMinionCard.cardCost+">             *");
		System.out.println("******************");		
		for(int i=0;i<5;i++){
			System.out.println("*                *");
		}
		System.out.println("*<"+myMinionCard.minionAttact+">          <"+myMinionCard.minionMaxLife+">*");
		System.out.println("******************");
	}

	public void displayUnit(Unit myUnit){
		System.out.println("MMMMMMMMMMMMMMMM");
		System.out.println("M<"+myUnit.unitName+">");
		System.out.println("M              M");
		System.out.println("M              M");
		System.out.println("M              M");
		System.out.println("M              M");
		System.out.println("M              M");
		System.out.println("M<"+myUnit.unitAttack+">        <"+myUnit.unitLife+">M");
		System.out.println("MMMMMMMMMMMMMMMM");
	}
	
}

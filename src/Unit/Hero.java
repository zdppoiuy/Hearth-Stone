package Unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import Card.Card;
import Card.MinionCard;
import Card.WeaponCard;

public class Hero extends Unit{
	public static int maxLife=20;
	public int currentCost;
	public int weaponLife;
	//public Card[] CardAll=new Card[20];
	//public Card[] currentCardonHand;	
	public HashMap<Integer, Card> deck=new HashMap<Integer, Card>();
	public HashSet<Card> onHandCard=new HashSet<Card>();
	public LinkedList<Minion> minionPool = new LinkedList<>();
	
	public Hero(int cardNumber){
		this.unitLife=maxLife;
		this.unitarmor=0;
		this.unitAttack=0;
		this.randomGenerateMinionCard(cardNumber);
		this.drawCard();
		this.drawCard();
		this.drawCard();
	}
	
	public void randomGenerateMinionCard(int minioncardNumber){
		//Generate 70% 1-6 cost card and 30% 7-10 cost card
		int index=0;
		for(int i=0;i<(int)minioncardNumber*0.7;i++){
			int cost=(int)(1+Math.random()*5);
			int attack=(int)(Math.random()*2*cost);
			int life=cost*2-attack;
			String name="M"+cost+attack+life;
			//this.CardAll[i]=new MinionCard(name,cost,attack,life);
			this.deck.put(i, new MinionCard(name,cost,attack,life));
			index=i;
		}
		for(int i=index+1;i<minioncardNumber;i++){
			int cost=(int)(6+Math.random()*4);
			int attack=(int)(Math.random()*2*cost)-1;
			int life=cost*2-attack+1;
			String name="M"+cost+attack+life;
			this.deck.put(i, new MinionCard(name,cost,attack,life));
		}
	}
	
	public void drawCard(){
		int totalCardNumberinDeck=this.deck.size();
		if(totalCardNumberinDeck<1){
			System.out.println("Card deck is empty");
		}else{
			Object[] keySet=this.deck.keySet().toArray();
			int drawKey=(int)(Math.random()*totalCardNumberinDeck);
			this.onHandCard.add(this.deck.get(keySet[drawKey]));
			this.deck.remove(keySet[drawKey]);
		}
			
	}
	
	public void useWeaponCard(WeaponCard usedWeapon){
		this.unitAttack=usedWeapon.weaponAttack;
		this.weaponLife=usedWeapon.weaponLife;
	}
	
	public void heroAttackadd(int attackAdded){
		this.unitAttack+=attackAdded;
	}
		
	public void heroLifeIncrease(int healingReceived){
		if(this.unitLife+healingReceived>=maxLife){
			this.unitLife=maxLife;
		}else{
			this.unitLife+=healingReceived;
		}
	}
	
	public void heroArmorIncrease(int armorReceived){
		this.unitarmor+=armorReceived;
	}
	
	public void heroReceiveDamage(int damageReceived){
		int _minusArmor=unitarmor-damageReceived;
		this.unitarmor=_minusArmor>=0?_minusArmor:0;
		if(unitarmor==0){
			if(0-_minusArmor>=this.unitLife){
				this.unitDead=true;
			}else{
				this.unitLife-=Math.abs(_minusArmor);
			}
		}
	}
	
	
}
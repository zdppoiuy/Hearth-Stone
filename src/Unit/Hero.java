package Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
	public LinkedList<Card> onHandCard=new LinkedList<>();
	public LinkedList<Minion> minionPool = new LinkedList<>();
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(isr);
	
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
			int cost=(int)(1+Math.random()*6);
			this.deck.put(i, new MinionCard(cost));
			index=i;
		}
		for(int i=index+1;i<minioncardNumber;i++){
			int cost=(int)(6+Math.random()*5);
			this.deck.put(i, new MinionCard(cost));
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
	
	public void useOnHandCard() throws IOException{
		int onHandCardSize=this.onHandCard.size();
		Card usedCard=new Card();
		int position=-1;
		while(position<0 || position>(onHandCardSize-1)){
			System.out.println("Card want to use(0-"+(onHandCardSize-1)+"):");
			try{
				position=Integer.parseInt(br.readLine());
			}catch(NumberFormatException nfe){
				System.err.println("Invalid Format!");
			}finally{
				if(position>=0 && position<onHandCardSize){
					usedCard=this.onHandCard.get(position);
					this.onHandCard.remove(position);
				}
				
			}
		}
		switch (usedCard.cardType) {
		case "Minion":
				this.useMinionCard(usedCard);
			break;

		default:
				this.useMinionCard(usedCard);
			break;
		}
		
	}
	
	public void useMinionCard(Card card) throws IOException{
		MinionCard myMinionCard= (MinionCard)card;
		Minion myMinion=new Minion(myMinionCard);		
		int poolSize=this.minionPool.size();
		int position=-1;
		while(position<0 || position>(poolSize)){
			if(poolSize==0){
				this.minionPool.add(myMinion);
				position=0;
			}else{
				System.out.println("Select Minion Position (0 - "+poolSize+"):");
				try{
					position=Integer.parseInt(br.readLine());
				}catch(NumberFormatException nfe){
					System.err.println("Invalid Format!");
				}finally{
					if(position>=0 && position<=(poolSize)){
						minionPool.add(position, myMinion);
					}
					
				}
			}
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
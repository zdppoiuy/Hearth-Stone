package Unit;

import Card.MinionCard;

public class Minion extends Unit{
	public Minion(MinionCard inMinionCard){
		this.unitName=inMinionCard.cardName;
		this.unitAttack=inMinionCard.minionAttact;
		this.unitMaxLife=inMinionCard.minionMaxLife;
		this.unitLife=inMinionCard.minionMaxLife;
		this.unitDead=false;
	}
	
	public void minionAttackReceived(int attack){
		if(this.unitLife<=attack){
			this.unitDead=true;
		}else{
			this.unitLife-=attack;
		}
		
	}
	
	public void minionLifeIncreased(int healing){
		if(this.unitLife+healing>=unitMaxLife){
			this.unitLife=this.unitMaxLife;
		}else{
			this.unitLife+=healing;
		}
	}
	
	public void minionMaxLifeIncresed(int lifeincreasing){
		this.unitMaxLife+=lifeincreasing;
		this.minionLifeIncreased(lifeincreasing);
	}

}
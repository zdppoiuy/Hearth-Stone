package Game;
import java.io.IOException;
import java.util.HashMap;

import Card.*;
import Unit.Hero;
import Unit.Minion;

public class GameLauncher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//GameLauncher myLauncher=new GameLauncher();
		Hero myHero=new Hero(20);
		Display myDisplay=new Display();
		myDisplay.displayCard(myHero.onHandCard.getLast());

		
		System.out.println(myHero.deck);
		//System.out.println(myHero.onHandCard.size());
		myHero.useOnHandCard();
		System.out.println(myHero.minionPool);
		myDisplay.displayUnit(myHero.minionPool.getLast());
	}

	
}

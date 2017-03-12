package Game;
import java.util.HashMap;

import Card.*;
import Unit.Hero;

public class GameLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameLauncher myLauncher=new GameLauncher();
		Hero myHero=new Hero(20);
		Display myDisplay=new Display();

		System.out.println(myHero.onHandCard);
		
		System.out.println(myHero.deck);
		//System.out.println(myHero.onHandCard.size());
	
	}

	
}

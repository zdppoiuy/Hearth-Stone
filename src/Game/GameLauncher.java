package Game;
import Card.*;
import Unit.Hero;

public class GameLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameLauncher myLauncher=new GameLauncher();
		Hero myHero=new Hero(20);
		Display myDisplay=new Display();
		for(int i=0;i<20;i++){
			myDisplay.displayCard(myHero.CardAll[i]);
		}

	}

	
}

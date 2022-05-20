package aiss.model.resorces;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.api.resources.GameResource;
import aiss.model.Game;


public class GameTest {

	@Test
	public void getGamesTest() throws UnsupportedEncodingException {
		GameResource gameR = new GameResource();
		Game[] games = gameR.getGames();
		
		//Print games data
		for(Game game : games) {
			System.out.println("Game name: " + game.getName());
		}
	}
}

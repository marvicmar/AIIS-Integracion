package aiss.api.resources;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import aiss.model.Game;

public class GameResourceTest {

	@Test
	public void getGamesTest() throws UnsupportedEncodingException {
		GameResource gameR = new GameResource();
		Game[] games = gameR.getAll();
		
		assertNotNull("The games returned null", games);
		
		//Print games data
		for(Game game : games) {
			System.out.println("Game name: " + game.getName());
		}
	}
}

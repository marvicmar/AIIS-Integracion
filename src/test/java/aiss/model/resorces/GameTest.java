package aiss.model.resorces;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.api.resources.GameResource;
import aiss.model.Game;


public class GameTest {

	@Test
	public void getAllGamesTest() throws UnsupportedEncodingException {
		GameResource gameR = new GameResource();
		List<Game> games = gameR.getAll(null,null);
		
		//Print games data
		for(Game game : games) {
			System.out.println("GAMES");
			System.out.println("Game->"+ game);
		}
	}
	
	@Test
	public void getGamesByIDTest() throws UnsupportedEncodingException {
		GameResource gameR = new GameResource();
		String id ="G454";
		Game games = gameR.get("G454");
		
		//Print games data
	
			System.out.println("GAME con id: "+id+"->"+ games);
		
	}
	
}

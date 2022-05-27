package aiss.model.resorces;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.api.resources.GameResource;
import aiss.api.resources.GamelistResource;
import aiss.model.Game;
import aiss.model.Gamelist;

public class GamelistTest {
	@Test
	public void getAllGamesTest() throws UnsupportedEncodingException {
		GamelistResource gameR = new GamelistResource();
		List<Gamelist> games = gameR.getAll(null);
		
		//Print games data
		for(Gamelist game : games) {
			System.out.println(">GAMELIST");
			System.out.println("Game->"+ game);
		}
	}
	
	@Test
	public void getGamesByIDTest() throws UnsupportedEncodingException {
		GamelistResource gameR = new GamelistResource();
		String id ="L3600";
		Gamelist games = gameR.get(id);
		
		//Print games data
	
			System.out.println("GAMELIST con id: "+id+"->"+ games);
		
	}
}

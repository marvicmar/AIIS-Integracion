package aiss.model.resorces;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.api.resources.GameListResource;

import aiss.model.GameList;

public class GameListTest {

	@Test
	public void getGamesListTest() throws UnsupportedEncodingException {
		GameListResource gamelistR = new GameListResource();
		GameList[] gameslists = gamelistR.getGameList();
		
		//Print gamelist data
		for(GameList gl : gameslists) {
			System.out.println("Movie title: " + gl.getId());
		}
		
	}
}

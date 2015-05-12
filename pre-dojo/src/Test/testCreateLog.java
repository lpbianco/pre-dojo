package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pre.dojo.Gamer;
import pre.dojo.Log;

public class testCreateLog {

	@Test
	public void testGenerateLog() {
		Gamer g = new Gamer();
		g.setDate("29/11/1987");
		g.setDead(1);
		g.setKill(2);
		g.setMatch("Match 1");
		g.setGamer("gamer");
		g.setWeapon("AK47");
		List<Gamer> gamers = new ArrayList<Gamer>();
		gamers.add(g);
		Log l = new Log();
		l.setMatche("Match 1");
		l.setGamer(gamers);
		String expected = "_____________\n\n PARTIDA: Match 1\n\n JOGADOR: gamer\n ASSASSINATOS: 2\n MORTES: 1\n_____________\n";
		assertEquals(expected,l.toString());
	}
}

package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import pre.dojo.Gamer;
import pre.dojo.Line;
import pre.dojo.createMatch;
import pre.dojo.fileReader;

public class testCreateGamer {

	@Test
	public void createGamer() {
		String linha1 = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		String linha2 = "23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN";
		String linha3 = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		String linha4 = "23/04/2013 15:36:33 - jeff killed Nick by DROWN";
		
		Line l1 = new Line();
		Line l2 = new Line();
		Line l3 = new Line();
		Line l4 = new Line();
		
		l1.setContent(linha1);
		l2.setContent(linha2);
		l3.setContent(linha3);
		l4.setContent(linha4);
		List<Line> line = new ArrayList<Line>();
		
		line.add(l1);
		line.add(l2);
		line.add(l3);
		line.add(l4);
		
		Map<String,Gamer> gamers = new HashMap<String, Gamer>();
	for(int i =0; i<line.size(); i++){																																	     							
	    if(!gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[2].equals("<WORLD>")){
	    	Gamer g = new Gamer();
	    	g.setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	g.setDead(g.getDead());
	    	g.setGamer(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]);
	    	g.setKill(g.getKill()+1);
	    	g.setWeapon((line.get(i).getContent().contains("using")?line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:""));
	    	gamers.put(g.getGamer(), g);
	    }else if(gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[2].equals("<WORLD>")){
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).setDead(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).getDead());
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).setKill(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).getKill()+1);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).setWeapon(line.get(i).getContent().contains("using")?gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).getWeapon()+"#"+line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:"");
	    }
	    if(!gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[4].equals("<WORLD>")){
	    	Gamer g = new Gamer();
	    	g.setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	g.setDead(g.getDead()+1);
	    	g.setGamer(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]);
	    	g.setKill(g.getKill());
	    	g.setWeapon((line.get(i).getContent().contains("using")?g.getWeapon()+"#"+line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:""));
	    	gamers.put(g.getGamer(), g);
	    }else if(gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[4].equals("<WORLD>")){
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).setDead(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).getDead()+1);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).setKill(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).getKill());
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).setWeapon(line.get(i).getContent().contains("using")?gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).getWeapon()+"#"+line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:"");
	    }
	}
	int killRoman = gamers.get("Roman").getKill();
	int deadNick = gamers.get("Nick").getDead();
	int killJeff = gamers.get("jeff").getKill();
	 assertEquals(2,killRoman);
	 assertEquals(4,deadNick);
	 assertEquals(1,killJeff);
	}



	@Test
	public void cGamer(){
		Map<String,Gamer> gamers = new HashMap<String, Gamer>();
		createMatch cg = new createMatch();
		gamers =cg.createGamer(cg.populateLines(fileReader.readFile("logTest.txt")));
		
		
		int killRoman = gamers.get("Roman#11348965").getKill();
		int deadNick = gamers.get("Nick#11348965").getDead();
		 assertEquals(1,killRoman);
		 assertEquals(2,deadNick);
	}

}



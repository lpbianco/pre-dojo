package pre.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createMatch {

	/**
	 * Método responsável por ler as linhas do arquivo
	 * @return List<String>
	 */
	public List<String> createLines(){
		return fileReader.readFile("log.txt");
	}
	
	
	/**
	 * Método responsável por criar  os objetos do tipo (Line), linha
	 * @return List<Line>
	 */
	public List<Line> populateLines(List<String> lines){
		List<Line> l = new ArrayList<Line>();
		List<String> content = lines;
		for (int i = 0; i < content.size(); i++) {
			if(!content.get(i).toString().trim().isEmpty() && !content.get(i).toString().trim().equals("")){
				Line line = new Line();
				line.setEnd(content.get(i).contains("ended")?true:false);
				line.setStart(content.get(i).contains("started")?true:false);
				line.setContent(content.get(i));
				l.add(line);
			}
		}
		return l;
	}
	
	/**
	 * Método responsável por criar os objetos do tipo jogador<Gamer>
	 * @return Map<String,Gamer> 
	 */
	public Map<String,Gamer> createGamer(List<Line> lines) {
		
		List<Line> line = lines;
		
		Map<String,Gamer> gamers = new HashMap<String, Gamer>();
		String nameMatch = null;
	for(int i =0; i<line.size(); i++){																																	     							
	 if(!line.get(i).getEnd() && !line.get(i).getStart()){    
		
		if(!gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[2].equals("<WORLD>")){
	    	Gamer g = new Gamer();
	    	g.setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	g.setDead(g.getDead());
	    	g.setGamer(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]);
	    	g.setKill(g.getKill()+1);
	    //	g.setWeapon((line.get(i).getContent().contains("using")?line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:""));
	    	g.setMatch(nameMatch);
	    	gamers.put(g.getGamer()+"#"+nameMatch, g);
	    }else if(gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[2].equals("<WORLD>")){
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).setDead(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).getDead());
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).setKill(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).getKill()+1);
	    //	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).setWeapon(line.get(i).getContent().contains("using")?gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]).getWeapon()+"#"+line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:"");
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[2]+"#"+nameMatch).setMatch(nameMatch);
	    }
	    if(!gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[4].equals("<WORLD>")){
	    	Gamer g = new Gamer();
	    	g.setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	g.setDead(g.getDead()+1);
	    	g.setGamer(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]);
	    	g.setKill(g.getKill());
	   // 	g.setWeapon((line.get(i).getContent().contains("using")?g.getWeapon()+"#"+line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:""));
	    	g.setMatch(nameMatch);
	    	gamers.put(g.getGamer()+"#"+nameMatch, g);
	    }else if(gamers.containsKey(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch) && !line.get(i).getContent().toString().replace(" -", "").split(" ")[4].equals("<WORLD>")){
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).setDate(line.get(i).getContent().toString().replace(" -", "").split(" ")[0]);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).setDead(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).getDead()+1);
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).setKill(gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).getKill());
	 //   	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).setWeapon(line.get(i).getContent().contains("using")?gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]).getWeapon()+"#"+line.get(i).getContent().toString().replace(" -", "").split(" ")[6]:"");
	    	gamers.get(line.get(i).getContent().toString().replace(" -", "").split(" ")[4]+"#"+nameMatch).setMatch(nameMatch);
	    }
	}else{
		nameMatch = line.get(i).getContent().toString().replace(" -", "").split(" ")[4];
	}
	}
	return gamers;
	}

}

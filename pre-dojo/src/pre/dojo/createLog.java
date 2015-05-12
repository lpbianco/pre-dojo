package pre.dojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class createLog {

	/**
	 * Método responsável por gerar os objetos do tipo Log
	 * @return List<Log>
	 */
	public List<Log> generateLog(){
		createMatch cg = new createMatch();
		Map<String,Gamer> gamers =cg.createGamer(cg.populateLines(cg.createLines()));
		Set<String> g = gamers.keySet();
		List<Gamer> matchGamer = new ArrayList<Gamer>(gamers.values());
		Set<String> matches = new HashSet<String>();
		for (String s:g) {
			matches.add(s.split("#")[1]);
		}
		
		List<Log> logs = new ArrayList<Log>();
		for (String match:matches) {
			Log l = new Log();
			List<Gamer> newGamer = new ArrayList<Gamer>();
			for(Gamer playGamer : matchGamer){
				if(playGamer.getMatch().equals(match)){
					newGamer.add(playGamer);
				}
			}
			if(newGamer.size()>0){
				l.setGamer(newGamer);
				l.setMatche(newGamer.get(0).getMatch());
			}
			logs.add(l);
		}
	return logs;
	}
	
	
	/**
	 * M'etodo responsavel por formatar o log
	 * @param log
	 */
	public void printLog(List<Log> log){
		List<Log> logs = log;
		for(Log l : logs){
			System.out.println(l.toString());
		}
	}
}

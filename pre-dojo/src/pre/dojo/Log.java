package pre.dojo;

import java.util.ArrayList;
import java.util.List;

public class Log {

	private String matche;
	private List<Gamer> gamer = new ArrayList<Gamer>();

	public List<Gamer> getGamer() {
		return gamer;
	}

	public void setGamer(List<Gamer> gamer) {
		this.gamer = gamer;
	}

	public String getMatche() {
		return matche;
	}

	public void setMatche(String matche) {
		this.matche = matche;
	}

	/**
	 * Método toString() sobreescrito responsável por formatar a saída do log
	 */
	@Override
	public String toString() {  
        String myLog = "_____________\n\n PARTIDA: "+getMatche();
		for(Gamer g : this.gamer){
        	myLog += "\n\n JOGADOR: "+g.getGamer()+"\n ASSASSINATOS: "+g.getKill()+"\n MORTES: "+g.getDead()+"\n";  
        }
		myLog += "_____________\n";
    return myLog;
	} 
}

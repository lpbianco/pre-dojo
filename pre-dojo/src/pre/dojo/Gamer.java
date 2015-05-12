package pre.dojo;

public class Gamer {
	
	private String match;
	
	private String gamer;
	
	private Integer kill;
	
	private Integer dead;
	
	private String weapon;
	
	private String date;

	public String getGamer() {
		return gamer;
	}

	public void setGamer(String gamer) {
		this.gamer = gamer;
	}

	public Integer getKill() {
		return (kill==null?0:kill);
	}

	public void setKill(Integer kill) {
		this.kill = kill;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDead() {
		return (dead==null?0:dead);
	}

	public void setDead(Integer dead) {
		this.dead = dead;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

}

package model;

import java.util.Comparator;

public class TimeComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
	
		return o1.getGameTime() - o2.getGameTime();
	}

}

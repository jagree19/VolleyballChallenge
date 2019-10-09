package com.TwoShoes;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {
	
	Player[] team = new Player[6];
	
	public Team() {
		//default constructor
	}
	
	public void addPlayer(Player player, int index) {
		team[index] = player;
	}
	
	public int length() {
		return team.length;
	}
	
	public Player getPlayer(int index){
		return team[index];
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < team.length; i++){
			str += (team[i].toString() + "\n");
		}
		return str;
	}

}

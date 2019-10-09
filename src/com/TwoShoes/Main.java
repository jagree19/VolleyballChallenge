package com.TwoShoes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Player> playerSet = new ArrayList<>();
	static ArrayList<Team> teamsSet = new ArrayList<>();
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Menu();
	}
	
	/**
	 * Prints out the menu and handles the choices made
	 * 
	 * @throws IOException
	 */
	public static void Menu() throws IOException {
		System.out.println("Please make a choice: Enter the number of your choice: ");
		System.out.println("1: Open a roster");
		System.out.println("2: Print the opened roster.");
		System.out.println("3: Team based on attack");
		System.out.println("4: Team based on block");
		System.out.println("5: Quit");
		
		Scanner scan = new Scanner(System.in);
		Scanner file = new Scanner(System.in);
		int choice = scan.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("Please enter the file where the roster is stored.\n");
				String fileName = file.nextLine();
				playerSet = getRoster(fileName);
				System.out.println("The roster from " + fileName + " was opened successfully.");
				System.out.println("");
//				file.close();
				Menu();
				break;
			case 2:
				isRosterOpen();
				System.out.println("Players and Stats");
				System.out.println("");
				for(int i=0; i<playerSet.size(); i++) {
					System.out.println(playerSet.get(i).toString());
				}
				System.out.println("");
				Menu();
				break;
			case 3:
				isRosterOpen();
				System.out.println("Teams based on attack stats");
				System.out.println("");
				MakeAttackTeams();
				Menu();
				break;
			case 4:
				isRosterOpen();
				System.out.println("Teams based on block stats");
				System.out.println("");
				MakeBlockTeams();
				Menu();
				break;
			default:
				System.out.println("Goodbye");
				scan.close();
				file.close();
				break;
				
		}
	}
	
	/**
	 * Checks to make sure a roster has been read in before allowing processing
	 * Alerts the user if the roster has not been read in yet and returns to the menu
	 * @throws IOException
	 */
	public static void isRosterOpen() throws IOException {
		
		if(playerSet.size() == 0) {
			System.out.println("Please open a roster first.");
			System.out.println();
			Menu();
		}
	
	}
	
	/**
	 * Reads a roster in from a text file
	 * 
	 * @param fileName the filename as input by the user
	 * 
	 * @return playerSet - the roster imported from the text file
	 * 
	 * @throws IOException
	 */
	public static ArrayList<Player> getRoster(String fileName) throws IOException {
		
		//empties out playerSet if another file had been read in previously.
		if(playerSet.size() != 0) {
			playerSet = new ArrayList<Player>();
		}
		
		Scanner inFile = new Scanner(new File(fileName));
		while(inFile.hasNext()) {
			Player player = new Player();
			player.firstName = inFile.nextLine();
			player.lastName = inFile.nextLine();
			player.attackStat = Double.valueOf(inFile.nextLine());
			player.blockStat = Double.valueOf(inFile.nextLine());
			playerSet.add(player);
		}
		
		return playerSet;	
	}
	
	/**
	 * This method makes teams based on the attack stat and prints it out
	 * 
	 * @throws IOException
	 */
	public static void MakeAttackTeams() throws IOException {
		
		int numberOfPlayers = playerSet.size(); // total # of players on roster
		int numberOfTeams = numberOfPlayers / 6; // how many teams of 6 we can make
		int playerIndex = numberOfTeams * 6; // the number of players put onto the teams
		
		Team team1 = new Team();
		Team team2 = new Team();
		Team team3 = new Team();
		Team team4 = new Team();
		
		ArrayList<Team> teams = new ArrayList<>();
		
		
		// Sorts the players by their attack stats in descending order.
		Collections.sort(playerSet, new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return p2.getAttackStat().compareTo(p1.getAttackStat());
			}
		});
		
		int teamIndex = 0; // to keep track of which team we add to
		
		/**
		 * this counter will increment when we have added a player to each team
		 * when it reaches 6 (The size of a team) it will trigger the end of making teams
		 * ex: if we have 2 teams - we will increment it when we add a player to Team 2
		 */
		int counter = 0; // increments when all teams have another player added
		while(counter < 6) {
			for(int i = 0; i < playerIndex; i++) {
				switch(teamIndex) {
				case 0:
					team1.addPlayer(playerSet.get(i), counter);
					break;
				case 1:
					team2.addPlayer(playerSet.get(i), counter);
					break;
				case 2:
					team3.addPlayer(playerSet.get(i), counter);
					break;
				case 3:
					team4.addPlayer(playerSet.get(i), counter);
					break;
				default:
					break;
				}
				if(teamIndex == (numberOfTeams - 1)) {
					teamIndex = 0;
					counter++;
				}else {
					teamIndex++;
				}
			}	
		}
		System.out.println(team1);
		System.out.println(team2);
		if(team3.getPlayer(0) != null){
			System.out.println(team3);
		}
		if(team4.getPlayer(0) != null){
			System.out.println(team4);
		}
	}
	
	public static void MakeBlockTeams() throws IOException {
			
		int numberOfPlayers = playerSet.size(); // total # of players on roster
		int numberOfTeams = numberOfPlayers / 6; // how many teams of 6 we can make
		int playerIndex = numberOfTeams * 6; // the number of players put onto the teams
		
		Team team1 = new Team();
		Team team2 = new Team();
		Team team3 = new Team();
		Team team4 = new Team();
		
		ArrayList<Team> teams = new ArrayList<>();
		
		
		// Sorts the players by their block stats in descending order.
		Collections.sort(playerSet, new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return p2.getBlockStat().compareTo(p1.getBlockStat());
			}
		});
		
		int teamIndex = 0; // to keep track of which team we add to
		
		/**
		 * this counter will increment when we have added a player to each team
		 * when it reaches 6 (The size of a team) it will trigger the end of making teams
		 * ex: if we have 2 teams - we will increment it when we add a player to Team 2
		 */
		int counter = 0; // increments when all teams have another player added
		while(counter < 6) {
			for(int i = 0; i < playerIndex; i++) {
				switch(teamIndex) {
				case 0:
					team1.addPlayer(playerSet.get(i), counter);
					break;
				case 1:
					team2.addPlayer(playerSet.get(i), counter);
					break;
				case 2:
					team3.addPlayer(playerSet.get(i), counter);
					break;
				case 3:
					team4.addPlayer(playerSet.get(i), counter);
					break;
				default:
					break;
				}
				if(teamIndex == (numberOfTeams - 1)) {
					teamIndex = 0;
					counter++;
				}else {
					teamIndex++;
				}
			}	
		}
		System.out.println(team1.toString());
		System.out.println(team2.toString());
		if(team3.getPlayer(0) != null){
			System.out.println(team3.toString());
		}
		if(team4.getPlayer(0) != null){
			System.out.println(team4.toString());
		}
	}
}

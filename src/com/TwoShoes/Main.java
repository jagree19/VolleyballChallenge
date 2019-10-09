package com.TwoShoes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Player> playerSet = new ArrayList<>();
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Menu();
	}
	
	public static void Menu() throws IOException {
		System.out.println("Please make a choice: Enter the number of your choice: ");
		System.out.println("1: Open a roster");
		System.out.println("2: Print the opened roster.");
		System.out.println("3: Team based on attack");
		System.out.println("4: Team based on block");
		System.out.println("5: Quit");
		
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("Please enter the file where the roster is stored.\n");
				Scanner file = new Scanner(System.in);
				String fileName = file.nextLine();
				playerSet = getRoster(fileName);
				System.out.println("The roster from " + fileName + " was opened successfully.");
				System.out.println("");
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
			case 3:
				isRosterOpen();
				
		}
	}
	
	public static void isRosterOpen() throws IOException {
		if(playerSet.size() == 0) {
			System.out.println("Please open a roster first.");
			System.out.println();
			Menu();
		}
	
	}
	
	public static ArrayList<Player> getRoster(String fileName) throws IOException {
		
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
}

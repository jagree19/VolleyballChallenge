package com.TwoShoes;

public class Player {
	
	String firstName;
	String lastName;
	Double attackStat;
	Double blockStat;
	
	public Player() {
		//default constructor
	}
	
	/**
	 * Constructor for the player class
	 * @param fn first name of player
	 * @param ln last name of player
	 * @param as attack stat of player
	 * @param bs block stat of player
	 */
	public Player(String fn, String ln, Double as, Double bs) {
		this.firstName = fn;
		this.lastName = ln;
		this.attackStat = as;
		this.blockStat = bs;
	}
	
	/**
	 * Getter for first name
	 * 
	 * @return firstName - the player's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * setter for first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * getter for last name
	 * 
	 * @return lastName - the player's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setter for last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getter for attack stat
	 * 
	 * @return attackStat - the attack stat
	 */
	public Double getAttackStat() {
		return attackStat;
	}
	
	/**
	 * setter for attackStat
	 * 
	 * @param attackStat
	 */
	public void setAttackStat(Double attackStat) {
		this.attackStat = attackStat;
	}
	
	/**
	 * getter for block stat
	 * 
	 * @return blockStat - the block stat
	 */
	public Double getBlockStat() {
		return blockStat;
	}
	
	/**
	 * setter for block stat
	 * 
	 * @param blockStat
	 */
	public void setBlockStat(Double blockStat) {
		this.blockStat = blockStat;
	}
	
	/**
	 * toString method for the Player Class
	 */
	public String toString() {
		return firstName + " " + lastName + " " + Double.toString(attackStat) + " " + Double.toString(blockStat);
	}
	
	

}

// ---------------------------------------------
// Assignment 3
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// March 14, 2017
// ---------------------------------------------
public class DuplicateISBNException extends Exception {

	public DuplicateISBNException(){
		super("Attempt of duplicate entry to a previous record.");
	}
	
	public DuplicateISBNException(String message){
		super(message);
	}
	
}

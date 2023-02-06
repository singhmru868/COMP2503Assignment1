import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/** 
 * COMP 2503 Winter 2023 Assignment 1 
 * 
 * This program must read a input stream and keeps track of the 
 * frequency at which an avenger is mentioned either by name or alias.
 *
 * @author Maryam Elahi
 * @date Winter 2023
*/

public class A1 {

	public String[][] avengerRoster = { { "captainamerica", "rogers" }, { "ironman", "stark" },
			{ "blackwidow", "romanoff" }, { "hulk", "banner" }, { "blackpanther", "tchalla" }, { "thor", "odinson" },
			{ "hawkeye", "barton" }, { "warmachine", "rhodes" }, { "spiderman", "parker" },
			{ "wintersoldier", "barnes"}};

	private int topN = 4;
	private int totalwordcount = 0;
	private ArrayList<Avenger> avengersArrayList = new ArrayList<>();

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.run();
	}

	public void run() {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Output");
        System.out.print("More Output");
		readInput();
		printResults();
	}

	/**
	 * read the input stream and keep track  
	 * how many times avengers are mentioned by alias or last name.
	 */
	private void readInput() {
		/*
		In a loop, while the scanner object has not reached end of stream,
		 	- read a word.
		 	- clean up the word
		    - if the word is not empty, add the word count. 
		    - Check if the word is either an avenger alias or last name then
				- Create a new avenger object with the corresponding alias and last name.
				- if this avenger has already been mentioned, increase the frequency count for the object already in the list.
				- if this avenger has not been mentioned before, add the newly created avenger to the list, remember to set the frequency.
		*/ 
		Scanner kbd = new Scanner(System.in);
		
		while(kbd.hasNext()) {
			
			String input = kbd.next();
			input=input.trim().toLowerCase().replaceAll("[0-9]","").replaceAll("'", "").replaceAll(",", "").replaceAll("-", "").replaceAll(";", "").replace('"', ' ').replaceAll(" ", "");
			boolean existsInList =true;
			
			for (Avenger a : avengersArrayList) {
				
				if(input == null) {
					break;
					
				} else if (a.getHeroAlias().contains(input) || (a.getHeroName().contains(input))) {
					
					int freq;
					freq=a.getFrequency();
					freq+=1;
					a.setFrequency(freq);
					existsInList=true;
					
				} else {
					existsInList=false;
				}
				
			}
			
			if(existsInList = false) {
				Avenger avg = new Avenger();
				avg.setHeroName(input);
				avg.setHeroAlias("");
				avg.setFrequency(1);
				avengersArrayList.add(avg);
				break;
			}
			
			
		}
		
	}

	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		for (Avenger avengerName : avengersArrayList) {
			System.out.println(avengerName);
		}
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
        // Todo: Print the most popular avengers, see the instructions for tie breaking
        // Make sure you follow the formatting example in the sample output

        Collections.sort(avengersArrayList, new Comparator < Avenger > () {
          @Override
          public int compare(Avenger a1, Avenger a2) {
            //comparison logic 
            return a2.getFrequency() - a1.getFrequency();
          }
        });

        int n = Math.min(topN, avengersArrayList.size());
        for (int i = 0; i < n; i++) {
          System.out.println(avengersArrayList.get(i));
        }
        System.out.println();

        System.out.println("Top " + topN + " least popular avengers:");
        // Todo: Print the least popular avengers, see the instructions for tie breaking
        // Make sure you follow the formatting example in the sample output
        
        Collections.sort(avengersArrayList, new AvengerPopularityComparator());
        
        System.out.println("Top " + topN + " least popular avengers:");
        for (int i = 0; i < topN; i++) {
          Avenger avengerName = avengersArrayList.get(i);
          System.out.println(avengerName.getHeroAlias() + " (" + avengerName.getHeroName() + ") " + avengerName.getFrequency());
        }
        System.out.println();

        
        System.out.println("All mentioned avengers in alphabetical order:");
        // Todo: Print the list of avengers in alphabetical order
        // Make sure you follow the formatting example in the sample output
        Collections.sort(avengersArrayList, new Comparator < Avenger > () {
          @Override
          public int compare(Avenger a1, Avenger a2) {
            return a1.getHeroAlias().compareTo(a2.getHeroAlias());
          }
        });
        for (Avenger avenger: avengersArrayList) {
          System.out.println(avenger.getHeroAlias() + " (" + avenger.getHeroName() + ") " + avenger.getFrequency());
        }
        System.out.println();
	}
}

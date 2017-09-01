package Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class PersonTaller {

	private static Person[] algorithm(Person[] in){
		Person[] toReturn = new Person[in.length];
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

		for(int i = 0; i < in.length; i++){
			int key = in[i].howMuchTallerInFront;
			if(map.containsKey(key)){
				map.get(key).add(in[i].height);
			}
			else{
				map.put(key, new LinkedList<Integer>());
				map.get(key).add(in[i].height);
			}
		}
		
		LinkedList<Person> hold = new LinkedList<Person>();
		for(int key: map.keySet()){
			int curMax = Integer.MIN_VALUE;
			int counter = 0;
			Collections.sort(map.get(key));
			LinkedList<Integer> list = map.get(key);
			
			if(hold.size() == 0){
				for(int j: list){
					hold.add(new Person(key, j));
				}
				continue;
			}
		
			for(int i = 0; i < hold.size(); i++){
				if(list.size() == 0){
					break;
				}
				if(counter == key){
					counter = 0;
					hold.add(i, new Person(key, list.get(0)));
				}
				if(hold.get(i).height > list.get(0)){
					counter ++;
				}
			}
		}
		
		return toReturn;
	}

	private static boolean test(Person[] people){
		shuffle(people);
		people = algorithm(people);

		for(int i = 0; i < people.length; i++){
			Person p = people[i];
			int counter = 0;
			for(int j = 0; j < i; j++){
				if(people[j].height > p.height){
					counter ++;
				}
			}
			if(counter == p.howMuchTallerInFront){
				continue;
			}
			else{
				return false;
			}
		}
		return true;
	}

	private static LinkedList<Person[]> generateInput(int howMany){
		LinkedList<Person[]> toReturn = new LinkedList<Person[]>();
		Random rand = new Random();

		for(int i = 0; i < howMany; i++){
			int[] hold = new int[rand.nextInt(100) + 1];
			Person[] toAdd = new Person[hold.length];
			for(int j = 0; j < hold.length; j++){
				hold[j] = rand.nextInt(10);
			}
			for(int j = 0; j < hold.length; j++){
				int howManyTallerInFront = 0;
				for(int k = 0; k < j; k++){
					if(hold[k] > hold[j]){
						howManyTallerInFront ++;
					}
				}
				toAdd[j] = new Person(hold[j], howManyTallerInFront);
			}
			toReturn.add(toAdd);
		}
		return toReturn;
	}

	private static void shuffle(Object[] in){
		Random rand = new Random();
		for(int i = in.length - 1; i > -1; i--){
			int index = rand.nextInt(i + 1);
			Object hold = in[i];
			in[i] = in[index];
			in[index] = hold; 
		}
	}

	public static void main(String[] args){
		final int NUM_TEST_CASES = 100;
		LinkedList<Person[]> testCases = generateInput(NUM_TEST_CASES);
		int test = 1;
		for(Person[] p: testCases){
			if(test(p)){
				System.out.println("Failed test " + test);
				System.out.println(Arrays.toString(p));
			}
			else{
				System.out.println("Test " + test + " passed");
			}
			test ++;
		}
	}
}

class Person{
	int height;
	int howMuchTallerInFront;

	public Person(int height, int howMuchTallerInFront){
		this.height = height;
		this.howMuchTallerInFront = howMuchTallerInFront;
	}

	public String toString(){
		return "height: " + height + ", howMuchTallerInFront: " + howMuchTallerInFront;
	}
}

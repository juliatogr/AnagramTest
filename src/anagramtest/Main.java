package anagramtest;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] words = {"duel","speed","dule", "cars"};
		String[] queries = {"spede", "deul"};

		System.out.println(Arrays.toString(words));
		System.out.println(Arrays.toString(queries));
		
		System.out.println(getAnagrams(words, queries));
		
	}
	
	
	public static ArrayList<ArrayList<String>> getAnagrams(String[] words, String[] queries) {
		
		ArrayList<ArrayList<String>> anagrams = new ArrayList<>();
		
		Arrays.stream(queries).forEach(q -> {
			ArrayList<String> qAnagrams = new ArrayList<String>();
			
			String qOrdered = orderWord(q);
			
			Arrays.stream(words).forEach(w -> {
				
				String wOrdered = orderWord(w);
				
				if (qOrdered.equalsIgnoreCase(wOrdered)) {
					qAnagrams.add(w);
				}
				
			});
			
			anagrams.add(qAnagrams);
			
		});
		
		return anagrams;
	}

	
	public static String orderWord(String w) {
		char[] chars = w.toCharArray();
		
		Arrays.sort(chars);
		
		String wSorted = String.valueOf(chars);
		return wSorted;
	}
}

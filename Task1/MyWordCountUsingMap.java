package Task1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyWordCountUsingMap {
	
	public static final String fileName = "E:\\eclipse-workspace(1)\\CauTrucDuLieuLab7\\src\\Task1\\hamlet.txt";

	private List<String> words = new ArrayList<>();
	
	public MyWordCountUsingMap() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Integer> getWordCounts() {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		return map;
	}
	
	
	public List<String> getUniqueWords() {
		Map<String, Integer> map = new HashMap<>();
		List<String> ans = new ArrayList<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			if (entry.getValue() == 1) {
				ans.add(entry.getKey());
			}
		}
		return ans;
	}
	
	
	public List<String> getDistinctWords() {
		Map<String, Integer> map = new HashMap<>();
		List<String> ans = new ArrayList<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		
		for (Map.Entry<String, Integer> entry: map.entrySet()) {
			if (entry.getValue() > 1) {
				ans.add(entry.getKey());
			}
		}
		return ans;
	}
	
	
	public Map<String, Integer> exportWordCounts() {
		Map<String, Integer> map = new TreeMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		return map;
	}
	
	
	
	public static void main(String[] args) {
		MyWordCountUsingMap mwc = new MyWordCountUsingMap();
		Map<String, Integer> map = mwc.exportWordCounts();
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println(entry);
		}
	}
	
	
}

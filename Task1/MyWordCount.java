package Task1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "E:\\eclipse-workspace(1)\\CauTrucDuLieuLab7\\src\\Task1\\hamlet.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Returns a set of WordCount objects that represents the number of times
	// each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.

	public List<WordCount> getWordCounts() {
		List<WordCount> ans = new ArrayList<>();
		for (String word : words) {
			int cnt = 0;
			WordCount wc = new WordCount(word, count(word));
			if (!ans.contains(wc))
				ans.add(wc);
			else {
				++cnt;
				wc.setCount(wc.getCount() + cnt);
			}
		}

		return ans;
	}

	private int count(String word) {
		int cnt = 0;
		for (String w : words) {
			if (w.equals(word))
				++cnt;
		}
		return cnt;
	}
	// Returns the words that their appearances are 1, do not consider
	// duplidated words

	public Set<String> getUniqueWords() {
		Set<String> ans = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1)
				ans.add(wc.getWord());
		}
		return ans;
	}
	// Returns the words in the text file, duplicated words appear once in the
	// result

	public Set<String> getDistinctWords() {
		Set<String> ans = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() > 1)
				ans.add(wc.getWord());
		}
		return ans;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of
	// tokens
	// Example: An - 3, Bug - 10, ...

	public Set<WordCount> exportWordCounts() {
		Set<WordCount> ans = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		ans.addAll(getWordCounts());
		return ans;
	}

	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> ans = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				int dif = o2.getCount() - o1.getCount();
				if (dif == 0) {
					return o1.getWord().compareTo(o2.getWord());
				}
				return dif;
			}
		});
		ans.addAll(getWordCounts());
		return ans;
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> set = new HashSet<>();
		for (String word : words) {
			WordCount wc = new WordCount(word, count(word));
			if (!wc.getWord().startsWith(pattern)) {
				set.add(wc);
			}
		}
		return set;
	}
	
	public static void run() {
		MyWordCount mw = new MyWordCount();
		String pattern = "A";

		List<WordCount> listGetWordCounts = mw.getWordCounts();
		Set<String> setGetUniqueWord = mw.getUniqueWords();
		Set<String> setGetDupWord = mw.getDistinctWords();
		Set<WordCount> setSortByName = mw.exportWordCounts();
		Set<WordCount> setSortByCnt = mw.exportWordCountsByOccurence();
		Set<WordCount> setFilterWords = mw.filterWords(pattern);
		
		System.out.println("Danh Sách WordCount: ");
		System.out.println(listGetWordCounts + "\n");
		
		System.out.println("Danh Sách Các Từ Không Trùng: ");
		System.out.println(setGetUniqueWord + "\n");
		
		System.out.println("Danh Sách Các Từ Trùng: ");
		System.out.println(setGetDupWord + "\n");
		
		System.out.println("Danh Sách Được Sắp Xếp Theo Tên : ");
		System.out.println(setSortByName + "\n");
		
		System.out.println("Danh Sách Được Sắp Xếp Theo Số Lần Xuất Hiện: ");
		System.out.println(setSortByCnt + "\n");
		
		System.out.println("Danh Sách Những Từ Không Bắt Đầu Bằng A: ");
		System.out.println(setFilterWords + "\n");

	
	}

	public static void main(String[] args) {
		run();
	}
}

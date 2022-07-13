package I2_클래스배열매소드2_프로젝트3_타자게임;

import java.util.Random;
import java.util.Scanner;

public class WordDAO {
	
	Scanner scan = new Scanner(System.in);
	String[] wordList;
	int wordCount;

	void init(int size) {
		wordList = new String[size];
		wordCount = 0;
	}
	
	void insertSampleList() {
		String [] sampleList = {"banana" , "apple" , "jsp" , "android" , "java",
				"c++" , "father" ,"mother" , "love" , "spring"};
		
		for(int i = 0; i < sampleList.length; i++) {
			insertWord(sampleList[i]);
		}
	}
	
	void print() {
		for(int i = 0; i < wordCount; i++) {
			System.out.println( (i + 1) +"번) " +  wordList[i]);
		}
	}
	void insertWord(String word) {
		wordList[wordCount] = word;
		wordCount += 1;
	}
	void removeWord(String word) {
		int index = -1;
		for(int i = 0; i < wordCount; i++) {
			if(word.equals(wordList[i])) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("삭제할단어가 없습니다.");
		}else {
			for(int i = index; i < wordCount-1; i++) {
				wordList[i] =wordList[i + 1];
			}
			wordCount -= 1;
		}
	}
	int getSize() {
		return wordCount;
	}
	String[] getRandomWordList(int count) {
		Random ran = new Random();
		String [] sampleList =new String[count];
		
		for(int i = 0; i < 1000; i++) {
			int r = ran.nextInt(wordCount);
			String temp = wordList[r];
			wordList[r] = wordList[0];
			wordList[0] = temp;
		}
		
		for(int i = 0; i < count; i++) {
			sampleList[i] = wordList[i];
		}	
		return sampleList;
	}
	
	
	void insertWord() {
		System.out.println("추가할 단어 입력 : ");
		String word = scan.next();
		insertWord(word);
	}
	void removeWord() {
		System.out.println("삭제할 단어 입력 : ");
		String word = scan.next();
		removeWord(word);
	}
	
	void gameStart(Member member , int gameCount , ScoreDAO scoreDAO) {
		int size = getSize();
		if(size < gameCount) {
			System.out.println("단어가 충분하지않아 게임을 시작할수없습니다.");
			System.out.println("최소 " + gameCount + "개의 문제가 필요합니다.");
			return;
		}
				
		String[] gameWord = getRandomWordList(gameCount);
		int score = 0;
		int i = 0;
		while(true) {
			System.out.println("문제 : " + gameWord[i]);
			String input = scan.next();
			if(input.equals(gameWord[i])) {
				score += 1;
				System.out.println("[정답]");
			}else {
				System.out.println("[떙]");
			}
			i += 1;
			
			if(gameCount == i) {
				System.out.println("[모든문제를 풀었습니다]");
				break;
			}
			
		}	
		int rank = scoreDAO.saveScore(member.id , score);
		if(rank == -1) {
			System.out.println("아쉽게도 순위에 들지 못했습니다.");
		}else {
			System.out.println(rank + "등 입니다. 축하합니다.");
		}
		
	}
	
}

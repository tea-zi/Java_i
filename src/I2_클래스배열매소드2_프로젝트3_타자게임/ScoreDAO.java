package I2_클래스배열매소드2_프로젝트3_타자게임;

public class ScoreDAO {
	Score[] scoreList;
	int max;
	void init(int size) {
		scoreList = new Score[size];
		for(int i = 0; i < size; i++) {
			scoreList[i] = new Score();
			scoreList[i].userId = "AAA";
			scoreList[i].score = 6 - (i * 1);
			scoreList[i].rank = i + 1;
		}
		max = size;
	}
	
	int saveScore(String id , int score) {
		
		int rank = -1;
		if(scoreList[max - 1].score < score) {
			scoreList[max -1].score = score;
			scoreList[max -1].userId = id;
			sort();
			rank = getRank(score);
		}
		return rank;
	}
	
	void sort() {
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < max; j++) {
				if(scoreList[i].score > scoreList[j].score) {
					Score temp = scoreList[i];
					scoreList[i] = scoreList[j];
					scoreList[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < max; i++) {
			scoreList[i].rank = i + 1;
		}
		
	}
	int getRank(int score) {
		int rank = 0;
		for(int i = 0; i < max; i++) {
			if(score == scoreList[i].score) {
				rank =  scoreList[i].rank;
				break;
			}
		}
		return rank;
	}
	
	void printRank() {
		sort();
		for(int i = 0; i < scoreList.length; i++) {
			scoreList[i].printScore();
		}
	}	
}

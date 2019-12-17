package interact.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/** 
 * The Class defines all actions and attributes of {@code ScoreBoard}.
 */
public class ScoreBoard {

	/** The instance. */
	private static ScoreBoard instance;

	/** The name. */
	private String name;
	
	/** The list. */
	private ArrayList<String> list;
	
	/** The Constant FILENAME1. */
	private static final String FILENAME1 = "./resource/score.txt";
	
	/** The Constant FILENAME2. */
	private static final String FILENAME2 = "./resource/sortedScore.txt";

	/**
	 * Write player's score to {@code score.txt}}.
	 */
	public void inputScore() {

		File file = new File("./resource/score.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Write new score into score.txt.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME1, true))) {
			String content = "\n";
			bw.write(name);
			bw.write(content);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read score and add into arrayList
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME1));
			if (!reader.ready()) {
				System.out.println("Can not read file iii");
			}

			String line;
			list = new ArrayList<String>();

			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			System.out.println(list.size());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// reSort this ArrayList
		resortAndWrite(list);

	}

	/**
	 * Gets player name from file.
	 *
	 * @param num - the number
	 * @return the name
	 */
	public String getName(int num) {

		final String FILENAME = "./resource/sortedScore.txt";
		File file = new File("./resource/sortedScore.txt");
		String sortedName = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			if (!reader.ready()) {
				System.out.println("Can not read file nnn");
			}

			String line;
			ArrayList<String> list = new ArrayList<String>();

			while ((line = reader.readLine()) != null) {
				list.add(line);
			}

			if (list.size() >= num) {
				String sortedValue = list.get(num - 1);

				String[] a = sortedValue.split(";");
				sortedName = a[1];
			} else {
				sortedName = "-";
			}

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedName;

	}

	/**
	 * Gets player score from file.
	 *
	 * @param num - the number
	 * @return the score
	 */
	public String getScore(int num) {

		final String FILENAME = "./resource/sortedScore.txt";
		File file = new File("./resource/sortedScore.txt");
		String sortedScore = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			if (!reader.ready()) {
				System.out.println("Can not read file sss");
			}

			String line;
			ArrayList<String> list = new ArrayList<String>();

			while ((line = reader.readLine()) != null) {
				list.add(line);
			}

			if (list.size() >= num) {
				String sortedValue = list.get(num - 1);

				String[] a = sortedValue.split(";");
				sortedScore = a[0];
			} else {
				sortedScore = "-";
			}

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedScore;
	}

	/*
	 * This function read scores and names from score.txt, sort the values in order
	 * of scores, and write the new sorted values in sortedScore.txt.
	 *  @param arrayList - the array list
	 */

	void resortAndWrite(ArrayList<String> arrayList) {

		if (arrayList.size() >= 1) {
			// Sort this arrayList.
			Collections.sort(arrayList, Collections.reverseOrder());

			// Rewrite sortedScore into score.txt
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME2, false))) {
				for (int j = 0; j < arrayList.size(); j++) {
					String sortedScore = arrayList.get(j);
					System.out.println(sortedScore);
					writer.write(sortedScore);
					String content = "\n";
					writer.write(content);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Instantiates a new score board.
	 */
	ScoreBoard() {
	}

	/**
	 * Gets the single instance of ScoreBoard.
	 *
	 * @return single instance of ScoreBoard
	 */
	public static ScoreBoard getInstance() {
		if (instance == null) {
			instance = new ScoreBoard();
		}
		return instance;
	}

	/**
	 * Input user name.
	 *
	 * @param name - the name
	 * @return the string
	 */
	public String inputName(String name) {
		return this.name = name;
	}

}

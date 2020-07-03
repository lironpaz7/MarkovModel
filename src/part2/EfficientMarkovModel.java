package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class extends the AbstractMarkovModel class and implements the MarkovModel in more efficient way.
 */
public class EfficientMarkovModel extends AbstractMarkovModel {
    private int N;
    private Random myRandom;
    private HashMap<String, ArrayList<String>> history;

    public EfficientMarkovModel(int N) {
        myRandom = new Random();
        this.N = N;
        n = N;
        history = new HashMap<>();
    }

    /**
     * Initializes the text and cuts unwanted spaces.
     * Also calls the buildMap method.
     *
     * @param s String of text.
     */
    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
    }

    /**
     * Returns the title of the class with order x.
     *
     * @return The title.
     */
    public String toString() {
        String pattern = "EfficientMarkovModel of order ";
        return pattern + n;
    }

    /**
     * Creates HashMap to store the substrings and their following characters in an ArrayList.
     */
    public void buildMap() {
        for (int k = 0; k < myText.length() - N; k++) {
            String key = myText.substring(k, k + N);
            if (!history.containsKey(key)) {
                history.put(key, getFollows(key));
            }
        }
        ArrayList<String> emptyList = new ArrayList<>();
        history.put("", emptyList);
    }

    /**
     * Sets the seed value.
     *
     * @param seed Number to initialized the object Random.
     */
    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    /**
     * Generates random characters from the text based on the last character generated.
     *
     * @param numChars Number of chars to generate.
     * @return Generated string.
     */
    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - N);
        String key = myText.substring(index, index + N);
        sb.append(key);
        for (int k = 0; k < numChars - N; k++) {
            ArrayList<String> characters = getFollows2(key);
            if (characters.size() == 0) {
                break;
            }
            index = myRandom.nextInt(characters.size());
            String ch = characters.get(index);
            sb.append(ch);
            key = key.substring(1) + ch;
        }
        return sb.toString();
    }

    /**
     * Returns the values from the HashMap of the given key if exists. Otherwise use the inherited getFollows method.
     *
     * @param key A string.
     * @return List of following characters.
     */
    public ArrayList<String> getFollows2(String key) {
        if (history.get(key) == null) {
            return getFollows(key);
        }
        return history.get(key);
    }
}
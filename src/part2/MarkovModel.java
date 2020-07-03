package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovOne class extends the AbstractMarkovModel class and implements the MarkovModel method.
 */
public class MarkovModel extends AbstractMarkovModel {
    private int N;
    private Random myRandom;

    public MarkovModel(int N) {
        myRandom = new Random();
        this.N = N;
        n = N;
    }

    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    /**
     * Generates random characters from the text based on the last N characters generated.
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
            ArrayList<String> characters = getFollows(key);
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


}
package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovOne class extends the AbstractMarkovModel class and implements the MarkovOne method.
 */
public class MarkovOne extends AbstractMarkovModel {
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
        n = 1;
    }

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
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
        sb.append(key);
        for (int k = 0; k < numChars - 1; k++) {
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
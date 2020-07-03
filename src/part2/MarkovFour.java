package part2;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovFour class extends the AbstractMarkovModel class and implements the MarkovFour method.
 */
public class MarkovFour extends AbstractMarkovModel {
    private Random myRandom;

    public MarkovFour() {
        myRandom = new Random();
        n = 4;
    }

    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    /**
     * Generates random characters from the text based on the last four characters generated.
     *
     * @param numChars Number of chars to generate.
     * @return Generated string.
     */
    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 4);
        String key = myText.substring(index, index + 4);
        sb.append(key);
        for (int k = 0; k < numChars - 4; k++) {
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
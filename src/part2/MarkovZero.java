package part2;

import java.util.Random;

/**
 * MarkovZero class extends the AbstractMarkovModel class and implements the MarkovZero method.
 */
public class MarkovZero extends AbstractMarkovModel {
    private Random myRandom;

    public MarkovZero() {
        myRandom = new Random();
        n = 0;
    }

    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numChars; k++) {
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }

        return sb.toString();
    }
}
package part2;

import java.util.*;

/**
 * Implements the IMarkovModel Interface and implements some methods for the Markov classes.
 */
public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int n;

    protected AbstractMarkovModel() {
        myRandom = new Random();
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public void setSeed(int seed) {
        myRandom = new Random(seed);
    }

    abstract public String getRandomText(int numChars);

    public String toString() {
        String pattern = "MarkovModel of order ";
        return pattern + n;
    }

    /**
     * Looking for characters following the given key and returns a list of those characters.
     * if the key isn't found then an empty list is returned.
     *
     * @param key A string.
     * @return List of following characters.
     */
    protected ArrayList<String> getFollows(String key) {
        ArrayList<String> characters = new ArrayList<String>();
        int index = 0;
        while (index < myText.length() - key.length()) {
            int keyIndex = myText.indexOf(key, index);
            index = keyIndex + 1;
            if (keyIndex != -1 && keyIndex < myText.length() - key.length()) {
                String ch = myText.substring(keyIndex + key.length(), keyIndex + key.length() + 1);
                characters.add(ch);
            } else {
                break;
            }
        }
        return characters;
    }
}

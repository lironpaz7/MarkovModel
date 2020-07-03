package part1;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovOne class implements the MarkovOne method.
 */
public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
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
     * Initializes the text and cuts unwanted spaces.
     *
     * @param s String of text.
     */
    public void setTraining(String s) {
        myText = s.trim();
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

    /**
     * Looking for characters following the given key and returns a list of those characters.
     * if the key isn't found then an empty list is returned.
     *
     * @param key A string.
     * @return List of following characters.
     */
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> characters = new ArrayList<>();
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
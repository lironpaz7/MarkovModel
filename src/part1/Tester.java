package part1;

import java.util.ArrayList;

/**
 * This class tests the testGetFollows of MarkovFour.
 */
public class Tester {
    /**
     * Runs a test on MarkovFour getFollows method.
     */
    public void testGetFollows() {
        MarkovFour markov = new MarkovFour();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> characters = new ArrayList<>();
        characters = markov.getFollows("t");
        System.out.println(characters);

    }

}


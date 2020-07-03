package part2;

import util.*;

/**
 * The class is use to generate random text.
 */
public class MarkovRunnerWithInterfaceEfficient {

    /**
     * Runs the MarkovModel.
     *
     * @param markov MarkovModel object.
     * @param text   The text from the .txt file.
     * @param size   Number of wanted characters.
     * @param seed   Number to initialize the Random object.
     */
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setSeed(seed);
        System.out.println("running with " + markov.toString());
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    /**
     * Prints the generated text with paragraph size limit of 60 chars.
     *
     * @param s Generated text.
     */
    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    /**
     * Tests the HashMap implementation on MarkovModel.
     *
     * @param trainingFilePath The text file full path.
     * @param seed             Number to initialized the object Random.
     */
    public void testHashMap(String trainingFilePath, int seed) {
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        EfficientMarkovModel emFive = new EfficientMarkovModel(5);
        runModel(emFive, st, size, seed);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please pass two arguments: 1.input_file 2.seed");
            System.exit(1);
        }
        int mySeed = 0;
        try {
            mySeed = Integer.parseInt(args[1]);
        } catch (Exception NumberFormatException) {
            System.out.println("The second argument must be an integer");
            System.exit(1);
        }
        MarkovRunnerWithInterfaceEfficient markov = new MarkovRunnerWithInterfaceEfficient();
        markov.testHashMap(args[0], mySeed);
    }
}


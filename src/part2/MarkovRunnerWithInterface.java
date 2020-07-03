package part2;

import util.*;

/**
 * The class is use to generate random text.
 */
public class MarkovRunnerWithInterface {
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
     * Converts the txt file into string and runs all of the MarkovModels.
     *
     * @param trainingFilePath The text file.
     * @param seed             Number to initialize the Random object.
     */
    public void runMarkov(String trainingFilePath, int seed) {
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        int size = 200;

        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);

        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);

        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);

        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);

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
        MarkovRunnerWithInterface markov = new MarkovRunnerWithInterface();
        markov.runMarkov(args[0], mySeed);
    }


}


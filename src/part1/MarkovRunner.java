package part1;

import util.*;

/**
 * MarkovRunner class runs the MarkovModel's.
 */
public class MarkovRunner {

    /**
     * Runs MarkovZero.
     *
     * @param trainingFilePath The text file.
     */
    public void runMarkovZero(String trainingFilePath) {
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        MarkovZero markov = new MarkovZero();
        markov.setSeed(25);
        markov.setTraining(st);
        for (int k = 0; k < 3; k++) {
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    /**
     * Runs MarkovOne.
     *
     * @param trainingFilePath The text file.
     */
    public void runMarkovOne(String trainingFilePath) {
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setSeed(25);
        markov.setTraining(st);
        for (int k = 0; k < 3; k++) {
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    /**
     * Runs MarkovFour.
     *
     * @param trainingFilePath The text file.
     */
    public void runMarkovFour(String trainingFilePath) {
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        MarkovFour markov = new MarkovFour();
        markov.setSeed(25);
        markov.setTraining(st);
        for (int k = 0; k < 3; k++) {
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    /**
     * Runs MarkovModel.
     *
     * @param trainingFilePath The text file.
     */
    public void runMarkovModel(String trainingFilePath) {
        SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
        String st = seFileUtil.asString();
        st = st.replace('\n', ' ');
        MarkovModel markov = new MarkovModel(6);
        markov.setSeed(25);
        markov.setTraining(st);
        for (int k = 0; k < 3; k++) {
            String text = markov.getRandomText(500);
            printOut(text);
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

    public static void main(String[] args) {
        MarkovRunner markovRunner = new MarkovRunner();
        markovRunner.runMarkovZero(args[0]);
        markovRunner.runMarkovOne(args[0]);
        markovRunner.runMarkovFour(args[0]);
        markovRunner.runMarkovModel(args[0]);
    }

}

package part2;

/**
 * Defines the methods that will be used by any MarkovModel class.
 */
public interface IMarkovModel {
    /**
     * Initializes the text and cuts unwanted spaces.
     *
     * @param text String of text.
     */
    public void setTraining(String text);

    /**
     * Abstract method that will be implemented by the MarkovModel classes.
     * Generates characters.
     *
     * @param numChars Number of chars to generate.
     */
    public String getRandomText(int numChars);

    /**
     * Sets the seed value for random use.
     *
     * @param seed A number to initialize the seed value of Random.
     */
    public void setSeed(int seed);

    /**
     * Returns the title of the class with it's order number.
     *
     * @return The title.
     */
    public String toString();
}

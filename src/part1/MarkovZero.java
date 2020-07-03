package part1;
import java.util.Random;

/**
 * MarkovZero class implements the MarkovZero method.
 */
public class MarkovZero {
    private String myText;
	private Random myRandom;
	
	public MarkovZero() {
		myRandom = new Random();
	}

	/**
	 * Sets the seed value.
	 * @param seed Number to initialized the object Random.
	 */
	public void setSeed(int seed){
		myRandom = new Random(seed);
	}

	/**
	 * Initializes the text and cuts unwanted spaces.
	 * @param s String of text.
	 */
	public void setTraining(String s){
		myText = s.trim();
	}

	/**
	 * Generates random characters from the text.
	 * @param numChars Number of chars to generate.
	 * @return Generated string.
	 */
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		
		return sb.toString();
	}
}
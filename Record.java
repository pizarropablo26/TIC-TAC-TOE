
/**
 * This class represents an entry in the dictionary
 * @author jy
 *
 */
public class Record {
	
	private String Config;
	private int Score;
	
	/**
	 * Contructor that returns a new Record
	 * @param config a configuration
	 * @param score a associated score
	 */
	public Record(String config, int score) {
		Config = config;
		Score = score;
	}
	
	/**
	 * This method returns a configuration
	 * @return a configuration
	 */
	public String getConfig() {
		return Config;
		
	}
	
	/**
	 * This method return the score associated with teh configuration
	 * @return a Score
	 */
	public int getScore() {
		return Score;
		
	}
	 

}

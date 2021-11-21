import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class implements a dictionary.
 * @author jy
 *
 */
public class Dictionary implements DictionaryADT{
	private LinkedList<Record>[] buckarray;

	
	/**
	 * Constructor that initialize a empty dictionary with a certain size
	 * @param size the size of the dictionary
	 */
	public Dictionary(int size) {
		buckarray = new LinkedList[size];

	}
	

	/**
	 * This method insert a record into the dictionary and throw a DictionaryException if the record is present
	 * @param Pair a Record type pair 
	 * @throws DictionaryException
	 * @return 1 if there is a collision and 0 if no collision
	 */
	public int insert (Record pair) throws DictionaryException{

		int hashcode = 0;
		for (int i = 0; i < pair.getConfig().length(); i++) {
		    hashcode = ((33 * hashcode + pair.getConfig().charAt(i)) % buckarray.length);
		}
		
		int Nocollision = 0;
		
		
		if (buckarray[hashcode] != null) { //collision
			for (int i =0; i<buckarray[hashcode].size(); i++) {
				if (buckarray[hashcode].get(i).getConfig().equals(pair.getConfig())){
					throw new DictionaryException();
				}
			}
			buckarray[hashcode].addLast(pair);
			if (buckarray[hashcode].size() > 1) {
				Nocollision = 1;
			}
		}
		else {
			LinkedList<Record> newlist = new LinkedList<>();
			buckarray[hashcode] = newlist;
			buckarray[hashcode].add(pair);
		}
		
		
		return Nocollision;
		
	}
	
	/**
	 * This method remove a configuration from the dictionary 
	 * and throw a DictionaryException if the record is absent
	 * @param config a Record type pair
	 * @throws DictionaryException
	 */
	public void remove (String config) throws DictionaryException{
		boolean found = false;
		for (int i = 0; i< buckarray.length; i++) {
			if (buckarray[i] != null){
				for (int j = 0; j<buckarray[i].size(); j++) {
					if(buckarray[i].get(j).getConfig().equals(config)) {
						buckarray[i].remove(buckarray[i].get(j).getConfig());
						found = true;
					}

				}
			}
		}
		if(!found) {
			throw new DictionaryException();
		}
	}
	
	/**
	 * returns the score stored in the dictionary for the given configuration
	 * @param config a String representation of the configuration
	 * @return score stored in the dictionary for the given configuration or
	 * -1 if the configuration is not in Dict
	 */
	public int get (String config) {
		int hashcode = 0;
		for (int i = 0; i < config.length(); i++) {
		    hashcode = ((33 * hashcode + config.charAt(i)) % buckarray.length);
		}
		if (buckarray[hashcode] == null) {
			return -1;
		}
		for (int i =0; i<buckarray[hashcode].size(); i++) {
			if (buckarray[hashcode].get(i).getConfig().equals(config)) {
				return buckarray[hashcode].get(i).getScore();
			}
		}
		return -1;

		
	}
	
	/**
	 * return the number of configuration stored in the dictionary
	 * @return count number of configuration
	 */
	public int numElements() {
		int count = 0;
		for (int i =0; i< buckarray.length; i++) {
			count = count + buckarray[i].size();
		}
		return count;
		
	}
	
	
}

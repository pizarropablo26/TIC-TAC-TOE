
public class nk_TicTacToe {
	private int board_size;
	private int inline;
	private int max_levels;
	private char[][] gameBoard;
	
	/**
	 * This class implements all the methods needed by for the computerPlay method
	 * @param board_size size of the board
	 * @param inline number of symbol in line to win
	 * @param max_levels the
	 */
	public nk_TicTacToe (int board_size, int inline, int max_levels) {
		this.board_size = board_size;
		this.inline = inline;
		this.max_levels = max_levels;
		gameBoard = new char[board_size][board_size];
		for (int i=0; i<board_size; i++) {
			for(int j=0; j<board_size; j++) {
				gameBoard[i][j] = ' ';
			}
		}
	}
	
	/**
	 * This method create a dictionary
	 * @return a dictionary of size of the game board
	 */
	public Dictionary createDictionary() {
		Dictionary newgamedict = new Dictionary(board_size);
		return newgamedict;
	}
	
	/**
	 * This method check if a certain given configuration is in the dictionary
	 * @param configurations a given configuration of the Board game in String format
	 * @return the associated score to the configurations or -1 if configuration is not in dictionary.
	 */
	public int repeatedConfig(Dictionary configurations) {
		String gameconfig = "";
		for (int i = 0; i<board_size; i++) {
			for (int j = 0; j<board_size; j++) {
				gameconfig = gameconfig + gameBoard[i][j];
			}
		}
		return configurations.get(gameconfig);
		
	}
	
	/**
	 * This method represent the content of gameBoard as a string and inserts 
	 * the particular configuration and score in the configurations dictionary
	 * @param configurations a given configuration
	 * @param score the score associate with the configuration
	 */
	public void insertConfig(Dictionary configurations, int score) {
		String gameconfig = "";
		for (int i = 0; i<board_size; i++) {
			for (int j = 0; j<board_size; j++) {
				gameconfig = gameconfig + gameBoard[i][j];
			}
		}
		Record moverecord = new Record(gameconfig, score);
		configurations.insert(moverecord);
	}
	
	/**
	 * This method store a symbol in the game board
	 * @param row row of the game board
	 * @param col column of the game board
	 * @param symbol a symbol either 'X' or 'O'
	 */
	public void storePlay(int row, int col, char symbol) {
		gameBoard[row][col] = symbol;
	} 
	
	/**
	 * This method check if a certain box is empty, ie, 
	 * if a position of the gameBoard array contains ' '
	 * @param row the given row of the game board
	 * @param col the given column of the game board
	 * @return true if the gameBoard store a ' ' in this particular place
	 */
	public boolean squareIsEmpty (int row, int col) {
		if (gameBoard[row][col] == ' ') {
			return true;
		}
		return false;
		
	}
	
	/**
	 * This method check if a certain player wins the game
	 * @param symbol a given symbol of the player either 'X' or 'O'
	 * @return True if there is a 'inline' amount of symbol on a same line or False otherwise
	 */
	public boolean wins (char symbol) {
		//check row
//		int count = 0;
		for (int row = 0; row< board_size; row++) {
			int count = 0;
			for (int col = 0; col< board_size; col++) {
				if(gameBoard[row][col]==symbol) {
					count ++;
					if (count == inline) {
						return true;
					}
				}
				else {
					count = 0;
				}
			}
			
		}
		// check column
		for (int col = 0; col< board_size; col++) {
			int count = 0;
			for (int row = 0; row< board_size; row++) {
				if(gameBoard[row][col]==symbol) {
					count ++;
					if (count == inline) {
						return true;
					}
				}
				else {
					count = 0;
				}
			}
			
		}
//		// check diagonal
		
		//lower half triangular upleft->lowright
		for (int row = 0; row< board_size- 1; row++) {
			int count = 0;
			for (int col = 0; col< board_size - row; col++) { 
				if(gameBoard[row+col][col]==symbol) {
					count ++;
					if (count == inline) {
						return true;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		//upper half triangular upleft->lowright
		for (int col = 1; col< board_size- 1; col++) {	
			int count = 0;
			for (int row = 0; row< board_size - col; row++) {
				if(gameBoard[row][col + row]==symbol) {
					count ++;
					if (count == inline) {
						return true;
					}
				}
				else {
					count = 0;
				}
			}			
		}
		
		//other diagonal
		// upper triangular lowleft => upright
		for (int col = board_size-1; col>= 0; col--) {
			int count = 0;
			for (int row = 0; row <= col; row++) { //change so it doesn't loop towards ends
				if(gameBoard[row][col-row]==symbol) {
					count ++;
					if (count == inline) {
						return true;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		// upper triangular lowleft => upright
		for (int row = 1; row < board_size-1; row ++) {
			int count = 0;
			for (int col = board_size-1; col >= row; col--) { //change so it doesn't loop towards ends
				if(gameBoard[row + board_size-1 - col][col]==symbol) {
					count ++;
					if (count == inline) {
						return true;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		
		return false;
		
	}
	
	/**
	 * This method check if the game is a draw game or not
	 * @return True if its a draw game and false otherwise
	 */
	public boolean isDraw() {
		for (int i = 0; i< board_size; i++) {
			for (int j = 0; j< board_size; j++) {
				if(squareIsEmpty(i,j)|| wins('O')|| wins('X')) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method return a score to a certain configuration of the game
	 * @return 3 if Computer wins; 2 if draw, 1 if undecided and 0 if Human wins
	 */
	public int evalBoard() {
		if (wins ('O')) {
			return 3;
		}
		else if (wins ('X')) {
			return 0;
		}
		else if(isDraw()) {
			return 2;
		}
		else {
			return 1;
		}
	}

}

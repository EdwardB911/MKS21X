import java.util.*; //random, scanner, arraylist

import java.io.*; //file, filenotfoundexception

public class WordSearch{

    private char[][] data;

    private ArrayList<String> wordsToAdd;

    private ArrayList<String> wordsAdded;

    private Random randGen;

    //a basic constructor that allows the program to determine the dimentions of the WordSearch
    public WordSearch(int rows, int cols){ 
	data = new char[rows][cols];
	for(int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_';
	    }
	}
    }

    //a constructor that builds upon the previous constructor to include using files
    public WordSearch(int rows, int cols, String fileName){
	this(rows, cols);

	wordsToAdd = new ArrayList<String>();

	wordsAdded = new ArrayList<String>();
	
	try{

	    File f = new File(fileName);//can combine

	    Scanner in = new Scanner(f);//into one line

      	    //NOW read the file here...

	    while(in.hasNext()){

		String line = in.nextLine();

		//do something with line

		wordsToAdd.add(line.toUpperCase());

	    }

	}catch(FileNotFoundException e){

	    System.out.println("File not found: " + fileName);

	    //e.printStackTrace();

	    System.exit(1);
	}
    }
   
    // The final constructor allows the program to create random WordSearches and replicate them if necessary
    public WordSearch( int rows, int cols, String  fileName, int randSeed){
	this(rows, cols, fileName);
	randGen = new Random(randSeed);
    }
	    
	
    // clears a WordSearch (used for testing)
    private void clear(){
	for(int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_';
	    }
	}
    }

    //makes an array of chars into a string separated by spaces
    public static String helpString(char [] AR){
	String str = "[";
	for(int x = 0; x < AR.length; x++){
	    str = str + AR[x] + " ";
	}
	str = str + "]";
	return str;
    }

    //makes a 2d array of chars get helpStringed and concatenated with newlines
    public String toString(){
	String str = "";
	for (int y = 0; y < data.length; y++){
	    str = str + helpString(data[y]) + '\n';
	}
	return str;
    }

    // a method that adds a word horizontally in the WordSearch (not incorporated in main)
    public boolean addWordHorizontal(String word,int row,int col){
	word = word.toUpperCase();
	int len = word.length();
	if(row >= data.length || col >= data[0].length){
	    return false;
	}

	if(col + len > data[0].length){
	    return false;
	}
	
	for(int x = col; x < col + len; x++){
	    if(data[row][x] != '_' && data[row][x] != word.charAt(x - col)){
		return false;
	    }
	}
	for(int x = col; x < col + len; x++){
	    data[row][x] = word.charAt(x - col);
	}
	return true;
    }

    // a method that adds a word vertically in the WordSearch (not incorporated in main)
    public boolean addWordVertical(String word, int row, int col){
	word = word.toUpperCase();
	int len = word.length();
	if(row >= data.length || col >= data[0].length){
	    return false;
	}

	if(row + len > data.length){
	    return false;
	}

	for (int x = row; x < row + len; x++){
	    if(data[x][col] != '_' && data[x][col] != word.charAt(x - row)){
		return false;
	    }
	}

	for (int x = row; x < row + len; x++){
	    data[x][col] = word.charAt(x - row);
	}
	return true;
    }

    //  a method that adds a word diagonally in the WordSearch (not incorporated in main)
    public boolean addWordDiagonal(String word, int row, int col){
	word = word.toUpperCase();
	int len = word.length();
	if(row >= data.length || col >= data[0].length){
	    return false;
	}

	if(row + len > data.length || col + len > data[0].length){
	    return false;
	}

	for(int x = 0; x < len; x++){
	    if(data[row + x][col + x] != '_' && data[row + x][col + x] != word.charAt(x)){
		return false;
	    }
	}

	for (int x = 0; x < len; x++){
	    data[row + x][col + x] = word.charAt(x);
	}

	return true;
    }

    // a method that adds a word to the WordSearch irrespective of orientation 
    private boolean addWord( int row, int col, String word, int rowIncrement, int colIncrement){
	int len = word.length();
	if (rowIncrement == 0 && colIncrement == 0){
	    return false;
	}
	
	if(row >= data.length || col >= data[0].length){
	    return false;
	}

	if(rowIncrement == -1){
	    if(row - len < -1){
		return false;
	    }
	}

	if(rowIncrement == 1){
	    if(row + len >= data.length){
		return false;
	    }
	}

	if (colIncrement == -1){
	    if(col - len < -1){
		return false;
	    }
	}

	if (colIncrement == 1){
	    if (col + len >= data.length){
		return false;
	    }
	}

	for (int x = 0; x < len; x++){
	    if(data[row + (rowIncrement * x)][col + (colIncrement * x)] != '_' && data[row + (rowIncrement * x)][col + (colIncrement * x)] != word.charAt(x)){
		return false;
	    }
	}

	for (int x = 0; x < len; x++){
	    data[row + (rowIncrement * x)][col + (colIncrement * x)] = word.charAt(x);
	}

	wordsAdded.add(word);
	wordsToAdd.remove(word);
	return true;
    }

    // a method that uses addWord to add all of the words in a text file to the WordSearch
    private boolean addAllWords(){
	int []  AR = {-1, 0, 1};
	for(int x = 0; x < 1000; x ++){
	    if (wordsToAdd.size() == 0){
		return true;
	    }
	    
	    int a = randGen.nextInt(data.length);//a random integer between 0 and the column's or array's length
	    int b = randGen.nextInt(data[0].length); // a random integer between 0 and the row's length
	    String c = wordsToAdd.get(randGen.nextInt(wordsToAdd.size())); // a random string from wordsToAdd
	    int d = AR[randGen.nextInt(3)]; // either -1 0 or 1
	    int e = AR[randGen.nextInt(3)]; // either -1 0 or 1

	    addWord(a,b,c,d,e);
		   
	}
	return false;
    }

    // a method that fills in empty spaces in order to obscure the locations of the words in the wordsearch
    private boolean puzzle(){
	for(int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[0].length; y++){
		if(data[x][y] == '_'){
		    data[x][y] = (char)(65 + randGen.nextInt(25));
		}
	    }
	}
	return true;
    }
    
    // a method that was used to see if other methods worked (not incorporated in main)
    public static void test (){
	WordSearch TEST = new WordSearch(10,10,"words.txt",20);
	TEST.addAllWords();
	System.out.println(TEST.toString());
	TEST.puzzle();
	System.out.println(TEST.toString());
    }
		
    public static void main (String[] args){
	//give the user directions on how to use the wordsearch
	if(args.length <= 2){
	    System.out.println("Please input your args in the form [positive int rows, positive int cols, [String fileName.txt, [int seed]]]");
	}
	//check if the integers are positive
	if(args.length >= 3){
	    if(Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0){
		System.out.println("Please make sure that your integer inputs are positive");
	    }
	    // use random numbers if the user doesn't supply a seed
	    if (args.length == 3){
		WordSearch S = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]), args[2]);
		int seed = (int)(Math.random()*100000);
	        S.randGen = new Random(seed);
		if(S.addAllWords()){
		    S.puzzle();
		    System.out.println(S.toString());
		    System.out.println(S.wordsAdded);
		    System.out.println("seed = " + seed);
		}
		else{
		    System.out.println("Not all words could be added try increasing the size of your word search");
		}
	    }
	}
	
	if(args.length > 4){
	    //prints the answer key
    	    WordSearch S = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
    	    if(args[4].equals("key")){
		if (S.addAllWords()){
		    System.out.println(S.toString());
		    System.out.println(S.wordsAdded);
		}
		else{
		    System.out.println("Not all words could be added try increasing the size of your word search");
		}
    	    }
    	    else{
		//prints a wordsearch with a given seed
    		if (S.addAllWords()){
		    S.puzzle();
		    System.out.println(S.toString());
		    System.out.println(S.wordsAdded);
		}
		else{
		    System.out.println("Not all words could be added try increasing the size of your word search");
		}
    	    }
    	}
    	else if(args.length == 4){
	    // prints a wordsearch with a given seed
    	    WordSearch S = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]), args[2],Integer.parseInt( args[3]));
	    if(S.addAllWords()){
		S.puzzle();
		System.out.println(S.toString());
		System.out.println(S.wordsAdded);
	    }
	    else{
		System.out.println("Not all words could be added try increasing the size of your word search");
	    }
    	}
    }
	    
	
		
}

		
	


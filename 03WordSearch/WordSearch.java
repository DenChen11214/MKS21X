import java.util.*;
import java.io.*;
public class WordSearch{
  private char[][]data;
  private char[][]solution;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;
  private Random randgen;
  private int seed;
  /**Creates a empty wordsearch with '_' as the values in it
   */
  public WordSearch(int rows, int cols){
    data = new char[rows][cols];
    solution = new char[rows][cols];
    for(int i = 0;i < rows;i++){
      for(int n = 0;n < cols;n++){
        data[i][n] = '_';
        solution[i][n] = '_';
      }
    }
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
  }
  /**Creates a N * M wordsearch with words from a file
   */
  public WordSearch(int rows, int cols, String fileName){
    this(rows,cols);;
    randgen = new Random();
    int seed = randgen.nextInt(1000);
    randgen = new Random(seed);
    System.out.println(seed);
    try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        String word = in.next().toLowerCase();
        wordsToAdd.add(word);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    addAllWords();
    fillInBlanks();
  }
  /**Creates a N * M wordsearch with words from a file, and creates a seed to store it in
   */
  public WordSearch(int rows, int cols, String fileName, int randSeed){
    this(rows,cols);
    seed = randSeed;
    randgen = new Random(seed);
    try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        String word = in.next().toLowerCase();
        wordsToAdd.add(word);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    addAllWords();
    fillInBlanks();
  }
  /**Clears the wordsearch
   */
  public void clear(){
    data = new char[data.length][data[0].length];
  }
  /**Formats the wordsearch to print the wordsearch and wordbank
   */
  public String toString(){
    String grid = "";
    for(int i = 0; i < data.length;i++){
      for(int n = 0; n < data[0].length;n++){
        grid += data[i][n] + " ";
      }
      grid += "\n";
    }
    grid += wordIndex();
    return grid;
  }
  /**returns the wordsearch without the wordbank
   */
  public String getPuzzle(){
    String puz = "";
    for(int i = 0;i < data.length;i++){
      puz += "\n";
      for(int n = 0; n < data[0].length;n++){
        puz += data[i][n] + " ";
      }
    }
    return puz;
  }
  /**Returns a list of the words added to the wordsearch
   */
  public String getWordsAdded(){
    int i = wordsAdded.size();
    String wordsInPuzzle = "[";
    for(int n = 0;n < i - 1; n++){
      wordsInPuzzle += wordsAdded.get(n) + ",";
    }
    return wordsInPuzzle + wordsAdded.get(i - 1) + "]";
  }
  /**Returns the solution ot the wordsearch
   */
  public String getSolution(){
    String puz = "";
    for(int i = 0;i < solution.length;i++){
      puz += "\n";
      for(int n = 0; n < solution[0].length;n++){
        puz += solution[i][n] + " ";
      }
    }
    return puz;
  }
  /**Returns the seed of the wordsearch
   */
  public int getSeed(){
    return seed;
  }

  /**Adds a word to the wordsearch
   */
  private boolean addWord(int row, int col, String word, int colIncrement, int rowIncrement){
    int r = row;
    int c = col;
    if (rowIncrement == 0 && colIncrement == 0){
      return false;
    }
    if (rowIncrement > 0 && row + word.length() > data.length){
        return false;
    }
    if (rowIncrement < 0 && row - word.length() < 0){
      return false;
    }
    if (colIncrement > 0 && col + word.length() > data[0].length){
      return false;
    }
    if (colIncrement < 0 && col - word.length() < 0){
      return false;
    }
    for(int i = 0; i < word.length();i++){
      if (data[r][c] != '_' && data[r][c] != word.charAt(i)){
          return false;
        }
      r += rowIncrement;
      c += colIncrement;
    }
    for(int i = 0; i < word.length();i++){
      data[row][col] = word.charAt(i);
      solution[row][col] = word.charAt(i);
      row += rowIncrement;
      col += colIncrement;
    }
    wordsToAdd.remove(word);
    wordsAdded.add(word);
    return true;
  }
  /**Tries to add all the words in a arraylist of strings to a wordbank
   in random orientations and places on the wordsearch*/
  private boolean addAllWords(){
    int n = 100;
    while(n > 0){
      for(int i = 0 ; i < wordsToAdd.size();i++){
        addWord(randgen.nextInt(data.length),randgen.nextInt(data[0].length),
                wordsToAdd.get(i),-1 + randgen.nextInt(3),-1 + randgen.nextInt(3));
      }
      n--;
    }
    return true;
  }
  /**Fills in the '_' of the wordsearch with a random letter from the alphabet
   */
  public boolean fillInBlanks(){
    String alphabet = "abcdefghijklmonprstuvwxyz";
    int l = alphabet.length();
    for(int r = 0;r< data.length;r++){
      for(int c = 0;c< data[0].length;c++){
        if (data[r][c] == '_'){
          data[r][c] = alphabet.charAt(randgen.nextInt(l));
        }
      }
    }
    return true;
  }
  /**Creates the wordbank for the wordsearch
   */
  public String wordIndex(){
    String wordList = "Find the following words:";
    int counter = 0;
    for(int i = 0; i < wordsAdded.size();i++){
      if (counter % 4 == 0){
        wordList += "\n";
      }
      counter++;
      wordList += wordsAdded.get(i) + " ";
    }
    return wordList;
  }

  public static void main(String[] args){
    if (args.length == 3){
      try{
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        String file = args[2];
      }
      catch(NumberFormatException e) {
        System.out.println("Integers only for rows and cols and the seed");
        System.exit(1);
      }
      WordSearch puzzle = new WordSearch(rows,cols,file);
      System.out.println(puzzle);
    }
    else  if (args.length == 4){
     try{
       int rows = Integer.parseInt(args[0]);
       int cols = Integer.parseInt(args[1]);
       String file = args[2];
       int seed = Integer.parseInt(args[3]);
     }
     catch(NumberFormatException e) {
       System.out.println("Integers only for rows and cols and the seed");
       System.exit(1);
     }
     WordSearch puzzle = new WordSearch(rows,cols,file,seed);
     System.out.println(puzzle);
    }
    else  if (args[4].equals("key")){
      try{
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        String file = args[2];
        int seed = Integer.parseInt(args[3]);
      }
      catch(NumberFormatException e) {
        System.out.println("Integers only for rows and cols and the seed");
        System.exit(1);
      }
      WordSearch puzzle = new WordSearch(rows,cols,file,seed);

      System.out.println(puzzle.solution);
    }
    else{
      System.out.println("Please enter the arguments in this format:java WordSearch.java rows cols fileName randomSeed answers");
    }

  }
}import java.util.*;
import java.io.*;
public class WordSearch{
  private char[][]data;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;
  private Random randgen;
  private String wordList;
  public WordSearch(int rows, int cols){
    data = new char[rows][cols];
    for(int i = 0;i < rows;i++){
      for(int n = 0;n < cols;n++){
        data[i][n] = '_';
      }
    }
  }
  public WordSearch(int rows, int cols, String fileName){
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    data = new char[rows][cols];
    for(int i = 0;i < rows;i++){
      for(int n = 0;n < cols;n++){
        data[i][n] = '_';
      }
    }
    try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        String word = in.next().toLowerCase();
        wordsToAdd.add(word);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    addAllWords();
    fillInBlanks();
    wordIndex(fileName);
  }
  public WordSearch(int rows, int cols, String fileName, int randSeed){
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    randgen = new Random(randSeed);
    data = new char[rows][cols];
    for(int i = 0;i < rows;i++){
      for(int n = 0;n < cols;n++){
        data[i][n] = '_';
      }
    }
    try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        String word = in.next().toLowerCase();
        wordsToAdd.add(word);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    addAllWords();
    fillInBlanks();
    wordIndex(fileName);
  }
  public WordSearch(int rows, int cols, String fileName, int randSeed, String answerKey){
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    randgen = new Random(randSeed);
    data = new char[rows][cols];
    for(int i = 0;i < rows;i++){
      for(int n = 0;n < cols;n++){
        data[i][n] = '_';
      }
    }
    try {
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        String word = in.next().toLowerCase();
        wordsToAdd.add(word);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    addAllWords();
    if (!answerKey.equals("key")){
      fillInBlanks();
    }
    wordIndex(fileName);
  }
  public void clear(){
    data = new char[data.length][data[0].length];
  }
  public String toString(){
    String grid = "";
    for(int i = 0; i < data.length;i++){
      for(int n = 0; n < data[0].length;n++){
        grid += data[i][n] + " ";
      }
      grid += "\n";
    }
    grid += wordList;
    return grid;
  }
  private boolean addWord(int row, int col, String word, int colIncrement, int rowIncrement){
    int r = row;
    int c = col;
    if (rowIncrement == 0 && colIncrement == 0){
      return false;
    }
    if (rowIncrement > 0 && row + word.length() > data.length){
        return false;
    }
    if (rowIncrement < 0 && row - word.length() < 0){
      return false;
    }
    if (colIncrement > 0 && col + word.length() > data[0].length){
      return false;
    }
    if (colIncrement < 0 && col - word.length() < 0){
      return false;
    }
    for(int i = 0; i < word.length();i++){
      if (data[r][c] != '_' && data[r][c] != word.charAt(i)){
          return false;
        }
      r += rowIncrement;
      c += colIncrement;
    }
    for(int i = 0; i < word.length();i++){
      data[row][col] = word.charAt(i);
      row += rowIncrement;
      col += colIncrement;
    }
    wordsToAdd.remove(word);
    wordsAdded.add(word);
    return true;
  }
  private boolean addAllWords(){
    int n = 100;
    while(n > 0){
      for(int i = 0 ; i < wordsToAdd.size();i++){
        addWord(randgen.nextInt(data.length),randgen.nextInt(data[0].length),
                wordsToAdd.get(i),-1 + randgen.nextInt(2),-1 + randgen.nextInt(2));
      }
      n--;
    }
    return true;
  }
  public boolean fillInBlanks(){
    String alphabet = "abcdefghijklmonprstuvwxyz";
    int l = alphabet.length();
    for(int r = 0;r< data.length;r++){
      for(int c = 0;c< data[0].length;c++){
        if (data[r][c] == '_'){
          data[r][c] = alphabet.charAt(randgen.nextInt(l));
        }
      }
    }
    return true;
  }
  public boolean wordIndex(String fileName){
    wordList = "Find the following words: \n";
    int fileWords = 1;
    try{
      File f = new File(fileName);
      Scanner words = new Scanner(f);
      while(words.hasNext()){
        if(fileWords % 4 == 0){
          wordList += "\n";
        }
        wordList += words.next() + " ";
        fileWords ++;
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    return true;
  }
    public static void main(String[] args){
	System.out.println(WordSearch(0,0,"words.txt",500,"nokey"));
    }
}

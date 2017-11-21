import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    // CONSTRUCTORS
    public WordSearch(int rows,int cols){
	data = new char[rows][cols];
	for(int i = 0;i < data.length; i ++){
	    for(int x = 0;x < data[i].length; x ++){
		data[i][x] = '_';
	    }
	}
    }

     public WordSearch(int rows,int cols,String fileName){
	randgen = new Random();
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
    	data = new char[rows][cols];
	for(int i = 0;i < data.length; i ++){
	    for(int x = 0;x < data[i].length; x ++){
		data[i][x] = '_';
	    }
	}
	addAllWords();
		fillUp();
    }
  
    private void fillUp(){
	for(int i = 0; i < data.length; i ++){
	    for(int x = 0; x < data[i].length; x ++){
		if(data[i][x] == '_'){
		     int n = randgen.nextInt(26);
		     data[i][x] = (char)(n + 97);
		

		}
	    }
	}
    }

    public WordSearch(int rows,int cols,String fileName,int randSeed){
	randgen = new Random(randSeed);
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
    	data = new char[rows][cols];
	for(int i = 0;i < data.length; i ++){
	    for(int x = 0;x < data[i].length; x ++){
		data[i][x] = '_';
	    }
	}
	addAllWords();
		fillUp();
    }
    
    public WordSearch(int rows,int cols,String fileName,int randSeed, String answer){
	randgen = new Random(randSeed);
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
    	data = new char[rows][cols];
	for(int i = 0;i < data.length; i ++){
	    for(int x = 0;x < data[i].length; x ++){
		data[i][x] = '_';
	    }
	}
	addAllWords();
	       
    }

   
 // CLEAR METHOD
     private void clear(){
	for(int i = 0;i < data.length; i ++){
	    for(int x = 0;x < data[i].length; x ++){
		data[i][x] = '_';
	    }
	}
     }

 // TO STRING METHOD
    public String toString(){
	String result = "";
	for(int i = 0; i < data.length; i ++){
	    for(int x = 0; x < data[i].length; x ++){
		if(x != data[i].length - 1){
		    result += data[i][x] + " ";
		}
		else{
		    result += data[i][x];
		}
	    }
	    if(i != data.length - 1){
		result += "\n";
	    }
	}
	return result;
    }

    // ADDING WORD HORIZONTAL
    public boolean addWordHorizontal(String word,int row, int col){
	if(word.length() > data[row].length - col ){
		return false;
	}
	
	for(int i = col,x = 0; i < col + word.length(); i ++,x ++){
		if(data[row][i] != '_' && data[row][i] != word.charAt(i - col)){
		    return false;
		}
	}
		for(int i = col,x = 0; i < col + word.length(); i ++,x ++){
		    data[row][i] = word.charAt(x);
		}
    
	    return true;
    }


    //ADDING WORD VERTICALLY
     public boolean addWordVertical(String word,int row,int col){
    	if(word.length() > (data.length - row)){
    	    return false;
    	}
    	for(int i = row,x = 0; i < row + word.length(); i ++,x ++){
    		if(data[i][col] != '_' && data[i][col] != word.charAt(x)){
    		    return false;
    		}
	}
	for(int i = row,x = 0; i < row + word.length(); i ++,x ++){
    		    data[i][col] = word.charAt(x);
    		}
     
    	    return true;
     }

    //ADDING WORD DIAGONALLY
    public boolean addWordDiagonal(String word,int row,int col){

	if(word.length() > data.length - row || word.length() > data[row].length - col){
	    return false;
	}
	for(int i = row, x = col, y = 0; i < word.length() + row && x < word.length() + col; i ++, x ++ , y ++){
	    if(data[i][x] != '_' && data[i][x] != word.charAt(x)){
		return false;
	    }
	}
     	for(int i = row, x = col, y = 0; i < word.length() + row && x < word.length() + col; i ++, x ++ , y ++){
	   
		data[i][x] = word.charAt(x);
	}
    
	return true;
    }

    //ONE METHOD ADD WORD

    private boolean addWord(int r,int c,String word,int rowIncrement,int colIncrement){
	boolean determiner = true;
	int rI = rowIncrement;
	int cI = colIncrement;
	if(rowIncrement == 0 && colIncrement == 0){
	    determiner = false;
	    return false;
	    
	}
	if(rI == 1 && cI == 0){
	    if(word.length() + r > data.length){
		determiner = false;
		return false;
		
	    }
	}
	if(rI == -1 && cI == 0){
	    if(r - word.length()+ 1  < 0){
		determiner = false;
		return false;
		
	    }
	}
	if(rI == 0 && cI == 1){
	    if(word.length() + c > data[r].length){
		determiner = false;
		return false;
		
	    }
	}
	if(rI == 0 && cI == -1){
	    if(c - word.length() + 1 < 0){
		determiner = false;
		return false;
		
	    }
	}
	if(rI == 1 && cI == 1){
	    if(word.length() + r > data.length || word.length() + c > data[r].length){
		determiner = false;
		return false;
		
	    }
	}
       	if(rI == -1 && cI == 1){
	    if(r - word.length() + 1 < 0 || word.length() + c > data[r].length){
		determiner = false;
		return false;
		
	    }
	}
	
       	if(rI == -1 && cI == -1){
	    if(r - word.length() + 1 < 0 || c - word.length() + 1 < 0){
		determiner = false;
		return false;
		
	    }
	}
	if(rI == 1 && cI == -1){
	    if(word.length() + r > data.length || c - word.length() + 1 < 0){
		determiner = false;
		return false;
		
	    }
	}
		else{
		    int rsub = r;
		    int csub = c;
	    for(int i = 0;i < word.length(); i ++){
		if(data[rsub][csub] != '_' && data[rsub][csub] != word.charAt(i)){
		    determiner = false;
		    return false;
		}
		rsub += rI;
		csub += cI;
	    }
	}
	
	    if(determiner = true){
		for(int i = 0; i < word.length(); i ++){
		    data[r + rI * i][c + cI * i] = word.charAt(i);
		  
		}
	    }
    
	
	return determiner;
    }
   

     private boolean addAllWords(){
	 	 boolean determiner = true;
	 int x = 0;
	 int y;
	 int z;
	 	 for(int i = 0; i < wordsToAdd.size(); i ++){
		     
		         while(x < 1000){
			     try{
			      y = randgen.nextInt(data.length );
			      z = randgen.nextInt(data[y].length );
			      determiner = addWord(y,z,wordsToAdd.get(i),randgen.nextInt(3) - 1,randgen.nextInt(3) - 1);
			    
				     
				     if(determiner){
					 wordsAdded.add(wordsToAdd.get(i));
					 wordsToAdd.remove(wordsToAdd.get(i));
					 i --;
					 break;
				     }
				     x ++;
			     }
			     catch(IndexOutOfBoundsException e){
				 determiner = false;
				 x ++;
	    
				 }
			 }
		 
	
		 }
		 return determiner;
     }
	
				     
public static void main(String[] args){

    if(args.length == 0){
	System.out.println("PUT PARAMETERS INTO THE TERMINAL COMMAND LINE.  IF YA DON'T KNOW HOW, READ THE DIRECTIONS BELOW. \n");
	System.out.println("The following syntax is what you should write in order to use this program: java WordSearch rows cols filename randomSeed answers \n");
	System.out.println("You need to put in values for rows and cols which must be an integer value greater than or equal to zero, you also need to put in a filename which must be a .txt file \n");
	System.out.println("Answers and randomSeed are optional \n");
	System.out.println("If you want the puzzle solution, then you need to include a randomSeed parameter(an integer) and type key for the answers parameter \n");
}	
  else  if(args.length <= 2){
	System.out.println("Your parameters are incorrect! Read the directions");
    }
	else {
	try{
	     Integer.parseInt(args[0]);
	     Integer.parseInt(args[1]);
	}
	catch(NumberFormatException e){
	    System.out.println("Did you know the values of rows and cols have to be an integer? Try again! You can do it!");
	}
	if(Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0){
	    System.out.println("Rows and Columns must be positive!");
	}
	if(args.length == 3){
	    int seed = (int)(Math.random() * 100000);
	    System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],seed));
	    System.out.println("This is your seed: "+ seed);
	    
	}       
			       
	else if(args.length >= 4){
	     try{
		Integer.parseInt(args[3]);
	    }
	    catch(NumberFormatException e){
		System.out.println("Put an integer for random seed!");
	    }
	     if(args.length == 4){
	    System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3])));
	    
	     }
	     if(args.length > 4){
	    if(args[4].equals("key")){
		
		 WordSearch pain = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),args[4]);
		 pain.fillUp();
	    System.out.println(pain);
System.out.println("\n Answer KEYYYYYYY");
 System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),args[4]));
	   
	   
	    }
	     
	    else{
		
  System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3])));
	    }
	}
	}
}		
}
}



			       

	  



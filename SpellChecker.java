import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

   


    public class SpellChecker {

    private Dictionary dictionary;
    private static final String[] LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z"};

    public SpellChecker(String dictionaryFile) throws FileNotFoundException {
    dictionary = new Dictionary(dictionaryFile, 7919);
    }

    public void checkAddChar(String word){
    String potentialWord;
    for(int i=0; i<=word.length(); i++){
        for(String letter : LETTERS){
        potentialWord = word.substring(0,i) + letter + word.substring(i);
//checking if the new potentialWord is in the dictionary
        if(dictionary.contains(potentialWord)) {
        System.out.println(" Is " + potentialWord + " the word you're looking for?");
                  }
             }
        }
    }
    
    public void removeChar(String word){
    String potentialWord;
    for(int i=0; i<word.length(); i++){
    potentialWord = word.substring(0,i) + word.substring(i+1);
// Check if new potentialWord is in dictionary
    if(dictionary.contains(potentialWord)) {
    System.out.println(" Is " + potentialWord + " the word you're looking for?");
           }
       }
    }

    public void exchangeChar(String word){
    String potentialWord;
    for(int i=0; i<word.length()-1; i++){
    potentialWord = word.substring(0,i) +
    word.substring(i+1,i+2) +
    word.substring(i,i+1) +
    word.substring(i+2);
// Check if new word is in dictionary
    if(dictionary.contains(potentialWord)) {
    System.out.println(" Is " + potentialWord + " the word you're looking for?");
            }
        }
    }

     public void spellCheckFile(String fileName) throws FileNotFoundException {
     Scanner in = new Scanner(new File(fileName));
     int lineNum = 1;
     String lineText = "";
// Reads file line by line 
     while (in.hasNext()){
     lineText = in.nextLine();
/*Handles case sensitivity
// handles punctuation and
// Breaks up the line into words
// I've tried multiple regular expressions with varying efficiency 
 but the following final line was obtained from stack overflow */
     String[] wordLine = lineText.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");	
     
     
// Check if each word in the line is spelled correctly
     for(int i = 0; i<wordLine.length; i++){
    	 
     boolean isTrue = dictionary.contains(wordLine[i]);
     if(isTrue==false){
     System.out.println("The word [ " + wordLine[i] + " ] in line " + lineNum + " is mispelled");
// Check if word is spelled correctly if
// a letter is added
     checkAddChar(wordLine[i]);
// a letter is removed 
     removeChar(wordLine[i]);
// two letters are exchanged 
     exchangeChar(wordLine[i]);
         }
     }
     lineNum++;
         }
     }

     public static void main(String[] args) throws FileNotFoundException {
     SpellChecker sc = new SpellChecker(args[0]);
     sc.spellCheckFile(args[1]);
     }

}


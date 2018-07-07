
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


    public class Dictionary {

    private ArrayList<HashSet<String>> listOfWords;


    public Dictionary(int m) {
    listOfWords = new ArrayList<HashSet<String>>(m);
    for(int i=0;i<m;i++){
    listOfWords.set(i, new HashSet<String>());
       }
    }

//takes in a fileName and a table size
    public Dictionary(String fileName, int m) throws FileNotFoundException {
//Creates an empty dictionary
    listOfWords = new ArrayList<HashSet<String>>(m);
    for(int i=0;i<m;i++){
    listOfWords.add(i, new HashSet<String>());
    }

    Scanner in = new Scanner(new File(fileName));
    String word;
    int count=0;
    while (in.hasNext()) {
    word = in.next();
    insert(word);
    count++;

}
    in.close();
    System.out.println("count" +count);
}

// converts the word into an integer between 0 and m
    public int hash(String word) {
    int sum = 0;
    for(int i=0; i< word.length(); i++){
    char letter = word.charAt(i);
    int value = (int) letter; 
// converts letter to number
    sum += value*(Math.pow(31,i));
    }
    return sum % listOfWords.size();
}


    public void insert(String word) {
    word = word.toLowerCase();
    int i = hash(word);
    listOfWords.get(i).add(word); 
    }

    public boolean contains(String word) {
    word = word.toLowerCase();
    int i = hash(word);
    return listOfWords.get(i).contains(word);
    }

}

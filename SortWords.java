import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortWords {
        public static void main(String[] args) throws IOException {
                BufferedReader input = new BufferedReader(new FileReader("data.txt"));
                FileWriter writer = new FileWriter("commonWords.txt");
                String inputLine = "";
                ArrayList<Word> words = new ArrayList<Word>();
                words.add(new Word("hello"));
                while(null != (inputLine = input.readLine())){
                        StringTokenizer tokenizer = new StringTokenizer(inputLine, "().,?!:;-1234567890\\$=_{} ");
                        while(tokenizer.hasMoreTokens()){
                                String currentToken = tokenizer.nextToken().toLowerCase();
                                boolean isExisting = false;
                                int currentTokenPosition = 0;
                                for(Word w: words){
                                        if(currentToken.equals(w.getWord())){
                                                isExisting = true;
                                                currentTokenPosition = words.indexOf(w);  
                                        }
                                }
                                if(isExisting == true){
                                        words.get(currentTokenPosition).increaseOccurence();
                                        System.out.println("existing word: " + currentToken);
                                }
                                else{
                                        words.add(new Word(currentToken));
                                        System.out.println("new word: " + currentToken);
                                }
                                
                        }
                }
                input.close();
                
                System.out.println("Tokenized!");

                Collections.sort(words, new Comparator<Word>() {
                        @Override
                        public int compare(Word w1, Word w2) {
                                return w1.getOccurence().compareTo(w2.getOccurence());
                        }
                });

                for(Word w: words){
                        System.out.println(w.getWord() + " - " + w.getOccurence());
                        writer.append(w.getWord() + " - " + w.getOccurence() + "\n");

                }
                writer.close();
        }
        
}

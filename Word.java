public class Word{
        String wordString = "";
        Integer occurence = 0;

        public Word(String s) {
               wordString = s;
               occurence = 1;
        }

        public String getWord(){
                return this.wordString;      
        }

        public Integer getOccurence(){
                return this.occurence;
        }

        public void increaseOccurence(){
                this.occurence++;
        }
}

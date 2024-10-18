public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> List = new LinkedListDeque<>();
        for( int i=0 ; i<word.length() ; i++){
            List.addLast(word.charAt(i));
        }
        return List;
    }

    private boolean palindromeHelper(Deque<Character> word){
        if(word.size()<=1){
            return true;
        }
        boolean temp = word.removeFirst()==word.removeLast();
        return palindromeHelper(word) && temp;
    }

    private boolean palindromeHelper(Deque<Character> word, CharacterComparator cc){
        if(word.size()<=1){
            return true;
        }
        boolean temp = cc.equalChars(word.removeFirst(),word.removeLast());
        return palindromeHelper(word, cc) && temp;
    }

    public boolean isPalindrome(String word){
        Deque<Character> temp = wordToDeque(word);
        return palindromeHelper(temp);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> temp = wordToDeque(word);
        return palindromeHelper(temp, cc);
    }
}

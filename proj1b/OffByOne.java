public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y){
        int temp = Math.abs(x-y);
        return temp==1;
    }
}

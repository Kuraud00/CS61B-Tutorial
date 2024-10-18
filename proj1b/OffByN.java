public class OffByN implements CharacterComparator{

    int n=0;

    public OffByN(int x){
        this.n = x;
    }

    @Override
    public boolean equalChars(char x,char y){
        int temp = Math.abs(x-y);
        return temp==this.n;
    }
}

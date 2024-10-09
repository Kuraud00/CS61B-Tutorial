public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void main(String[] args){
        ArrayDeque<Integer> ad1=new ArrayDeque<>();
        boolean passed = checkEmpty(true, ad1.isEmpty());
        ad1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, ad1.isEmpty()) && passed;
        ad1.removeFirst();
        // should be empty
        passed = checkEmpty(true, ad1.isEmpty()) && passed;
        printTestStatus(passed);
        for(int i=0;i<100;i++){
            ad1.addFirst(i);
        }
        for(int i=0;i<100;i++){
            ad1.removeFirst();
        }
        System.out.println(ad1.isEmpty());
        for(int i=0;i<10;i++){
            ad1.addFirst(i);
        }
    }
}

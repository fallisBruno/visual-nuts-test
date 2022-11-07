
public class ExerciseOne {

    public static void main(String[] args) {

        printNumbers(1,100);
        printNumbers(10,10);
        printNumbers(11,10);
        printNumbers(0,0);
        printNumbers(-10,-5);

    }

    private static void printNumbers(int start, int end) {
        if(start > end){
            System.out.println("It can't run, START cannot be greater than END :)");
            return;
        }

        for (int number = start; number <= end; number++) {
            if(number % 3 == 0 && number % 5 == 0){
                System.out.println("Visual Nuts");
            }else if(number % 3 == 0){
                System.out.println("Visual");
            }else if(number % 5 == 0){
                System.out.println("Nuts");
            }
        }
    }
}

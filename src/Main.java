import java.util.Random;

public class Main{

    static Random rand = new Random();

    public static void main(String []args){
        Sorting sort = new Sorting();

        Sorting.Color[] input = {Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.RED,
                Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.RED,
                Sorting.Color.BLUE, Sorting.Color.BLUE , Sorting.Color.BLUE, Sorting.Color.BLUE,
                Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.BLUE
            , Sorting.Color.RED, Sorting.Color.RED, Sorting.Color.BLUE, Sorting.Color.BLUE, Sorting.Color.RED,
                Sorting.Color.RED, Sorting.Color.BLUE, Sorting.Color.RED, Sorting.Color.BLUE, Sorting.Color.BLUE,
                Sorting.Color.RED, Sorting.Color.RED, Sorting.Color.BLUE };


        int reds = 0;



        for ( int i = 0; i < 20; i++) {
            sort.getOutput(getRandInput(i));

        }

        sort.createResult();;

    }

    private static Sorting.Color[] getRandInput(int iter) {
        int reds = 0;
        Sorting.Color[] rndInput = new Sorting.Color[30];
        for(int i = 0; i < rndInput.length; i++) {

            if(rand.nextBoolean() && ++reds <= 9) {
                rndInput[i] = Sorting.Color.RED;
            } else {
                rndInput[i] = Sorting.Color.BLUE;
            }
        }
        System.out.println("_________________Durchlauf " + (iter + 1) + "____________________________________________________");
        for(Sorting.Color c : rndInput) {
            System.out.print(c + "");
        }

        return rndInput;
    }
}
import java.util.Arrays;

//(Q3)(a)
public class PopulationModel {
    /*
     * //(Q3)(b)
     * public arrays for testing purposes
     */
    public int[] numA;
    public int[] numB;
    private static final int INITIALA = 50;
    private static final int INITIALB = 60;
    private static final double KILL_RATEA = 0.2;
    private static final double KILL_RATEB = 0.1;
    private static final int NUM_WEEKS = 10;

    //(Q3)(c)
    public PopulationModel()
    {
        numA = new int[NUM_WEEKS];
        numB = new int[NUM_WEEKS];
        numA[0] = INITIALA;
        numB[0] = INITIALB;
        createData();
    }

    //(Q3) (d)
    public int newNumA(int currentA, int currentB)
    {
        int newNumA;
        newNumA = (int) Math.floor(currentA - KILL_RATEB * currentB);
        if (newNumA >= 0) {
            return newNumA;
        } else {
            return 0;
        }
    }

    //(Q3) (e)
    public int newNumB(int currentA, int currentB)
    {
        int newNumB;
        newNumB = (int) Math.floor(currentB - KILL_RATEA * currentA);
        if (newNumB >= 0) {
            return newNumB;
        } else {
            return 0;
        }
    }

    //(Q3) (f)
    public void storeNewPopulations(int thisWeek)
    {
        if (thisWeek < 9) {
            numA[thisWeek + 1] = newNumA(numA[thisWeek], numB[thisWeek]);
            numB[thisWeek + 1] = newNumB(numA[thisWeek], numB[thisWeek]);
        }
    }

    //(Q3) (g)
    public void createData()
    {
        for (int i = 0; i < NUM_WEEKS; i++) {
            storeNewPopulations(i);
        }
    }

    //(Q3) (h)
    public void printBarChart()
    {
        StringBuilder builder;
        StringBuilder builder2;
        for (int n = 0; n < numA.length; n++) {
            builder = new StringBuilder(numA[n]);
            builder2 = new StringBuilder(numB[n]);
            for (int i = 0; i < numA[n]; i++) {
                builder.append("*");
            }
            for (int i = 0; i < numB[n]; i++) {
                builder2.append("*");
            }
            System.out.println("Week " + n + "A" + builder.toString() + numA[n]);
            System.out.println("Week " + n + "B" + builder2.toString() + numB[n]);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        PopulationModel populationModel = new PopulationModel();
        populationModel.createData();
        populationModel.printBarChart();
    }
}

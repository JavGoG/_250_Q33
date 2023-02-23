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
    private static int numAnext = INITIALA;
    private static int numBnext = INITIALB;

    //(Q3)(c)
    public PopulationModel() {
        numA = new int[NUM_WEEKS];
        numB = new int[NUM_WEEKS];
        numA[0] = INITIALA;
        numB[0] = INITIALB;
    }

    //(Q3) (d)
    public int newNumA(int currentA, int currentB) {
        int newNumA;
        newNumA = (int) Math.floor(currentA - KILL_RATEB * currentB);
        if (newNumA >= 0) {
            numAnext = newNumA;
            return newNumA;
        } else {
            return 0;
        }
    }

    //(Q3) (e)
    public int newNumB(int currentA, int currentB) {
        int newNumB;
        newNumB = (int) Math.floor(currentB - KILL_RATEA * currentA);
        if (newNumB >= 0) {
            numBnext = newNumB;
            return newNumB;
        } else {
            return 0;
        }
    }

    //(Q3) (f)
    public void storeNewPopulations(int thisWeek) {

        int nextA = newNumA(numAnext, numBnext);
        numA[thisWeek] = nextA;
        int nextB = newNumB(numAnext, numBnext);
        numB[thisWeek] = nextB;
    }

    //(Q3) (g)
    public void createData() {
        for (int i = 1; i < NUM_WEEKS; i++) {
            storeNewPopulations(i);
        }
    }

    //(Q3) (h)
    public void printBarChart() {
        int x = 0;
        for (int num : numA) {
            System.out.println("Week " + x + "A" + "*".repeat(numA[x]) + numA[x]);
            System.out.println("Week " + x + "B" + "*".repeat(numB[x]) + numB[x]);
            x++;
        }
    }

    public static void main(String[] args) {
        PopulationModel populationModel = new PopulationModel();
        populationModel.createData();
        populationModel.printBarChart();
    }
}

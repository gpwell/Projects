public class PitStopPredictor {

    public static void main(String[] args) {
        //change values or change to var with input
        double currentLapTime = 48.0;
        double competitorLapTime = 49.5;
        double tireWear = 0.3;

        int currentLap = 5;
        int finalLap = 25;


        int bestLap = predictBestPitStopLap(currentLapTime, competitorLapTime, tireWear, currentLap, finalLap);


        System.out.println("The best lap for a pit stop is lap " + bestLap);
    }

    static int predictBestPitStopLap(double currentLapTime, double competitorLapTime, double tireWear, int currentLap, int finalLap) {

        int bestLap = currentLap;
        double timeDifference = currentLapTime - competitorLapTime;

        if (timeDifference > tireWear) {
            return currentLap;
        }
        //best would be that lap then, otherwise:

        double nextLapTime = currentLapTime + tireWear;

        while (nextLapTime < competitorLapTime && bestLap < finalLap) {
            bestLap++;
            nextLapTime = currentLapTime + (bestLap * tireWear);
        }

        return bestLap;
    }
}

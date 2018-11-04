package numerosprimos;

/**
 * @author fsancheztemprano
 */
public class NumerosPrimos {

    public static int startNum = 1;
    public static int activeNum = startNum;
    public static int finalNum = 400000;
    public static int numOfPrimes = 0;
    public static int lastPrime = 0;
    public static int bigestLeap = 0;
    public static int bigestLeaper = 0;
    public static boolean notPrimes = false;
    public static boolean justList = true;

    public static void main(String[] args) {
        if (Primes.isEven(activeNum)) {
            activeNum++;
        }
        for (; activeNum <= finalNum; activeNum += 2) {
            if (!Primes.checkPrime(activeNum)) {
                isNotPrime();
            } else {
                isPrime();
            }
        }
        showStats();
    }


    public static void isPrime() {
        numOfPrimes++;
        leapPrime();
        lastPrime = activeNum;
        if (justList) {
            System.out.println(activeNum);
        } else {
            System.out.println("Number: " + activeNum + " IS prime! " + "" + (activeNum % 6) + " " + (activeNum % 30) + " " + (activeNum % 210));
        }
    }

    public static void isNotPrime() {
        if (notPrimes) {
            System.out.println("Number: " + activeNum + " NOT prime! " + "" + (activeNum % 6) + " " + (activeNum % 30) + " " + (activeNum % 210));
        }
    }

    public static void leapPrime() {
        if ((activeNum - lastPrime) > bigestLeap) {
            bigestLeap = activeNum - lastPrime;
            bigestLeaper = activeNum;
        }
    }


    public static void showStats() {
        
        //Basic Msgs
        System.out.println("From Number: " + startNum + " to Number: " + finalNum);
        System.out.println("Prime Numbers: " + numOfPrimes);
        System.out.println("Composite Numbers :" + (finalNum - startNum - 1 - numOfPrimes));
        System.out.println("Biggest Leap of primes is: " + bigestLeap + ", at Primes: " + (bigestLeaper - bigestLeap) + ", " + bigestLeaper);
        //Debug Msgs
        System.out.println("Loops: " + Primes.calcsDone);
        System.out.println("Nums Skipped: " + Primes.numOfSkips());

       // System.out.println("Nums Skipped 2.n : " + ((finalNum - startNum) / 2));
        System.out.println("Nums Skipped 3.n : " + Primes.numOfSkips3);
        System.out.println("Nums Skipped 5.n : " + Primes.numOfSkips5);
        System.out.println("Nums Skipped 7.n : " + Primes.numOfSkips7);
        System.out.println("Nums Skipped 11.n : " + Primes.numOfSkips11);
        System.out.println("Nums Skipped 2.3.5.n : " + Primes.numOfSkips30);
        System.out.println("Nums Skipped 2.3.5.7.n : " + Primes.numOfSkips210);

    }
}

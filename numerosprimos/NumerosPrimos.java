package numerosprimos;

/**
 * @author fsancheztemprano
 */
public class NumerosPrimos {

    public static int startNum = 1;
    public static int activeNum = startNum;
    public static int finalNum = 99999;
    public static int numOfPrimes = 0;
    public static int numOfSkips;
    public static int numOfSkips3 = 0;
    public static int numOfSkips5 = 0;
    public static int numOfSkips6 = 0;
    public static int numOfSkips30 = 0;
    public static int numOfSkips210 = 0;
    public static int lastPrime = 0;
    public static int bigestLeap = 0;
    public static int bigestLeaper = 0;
    public static long calcsDone = 0L;
    public static boolean debug = true;
    public static boolean notPrimes = false;
    public static boolean justList = false;

    public static void main(String[] args) {
        if (isEven(activeNum)) {
            activeNum++;
        }
        prime:
        for (; activeNum <= finalNum; activeNum += 2) {
            int count;
            if (activeNum > 3 && isDivisible3(activeNum)) {
                numOfSkips3++;
                if (debug) {
                    System.out.println(activeNum + " Skip3++");
                }
                continue prime;
            }
            if (activeNum > 5 && isDivisible5(activeNum)) {
                numOfSkips5++;
                if (debug) {
                    System.out.println(activeNum + " Skip5++");
                }
                continue prime;
            }
            if (activeNum >= 31 && isDivisible30(activeNum)) {
                numOfSkips30++;
                if (debug) {
                    System.out.println(activeNum + " Skip30++");
                }
                continue prime;
            }
            if (activeNum >= 210 && isDivisible210(activeNum)) {
                numOfSkips210++;
                if (debug) {
                    System.out.println(activeNum + " Skip210++");
                }
                continue prime;

            }
            if (countDivisors() > 0) {
                isNotPrime();
            } else {
                isPrime();
            }
        }
        showStats();
    }

    public static int countDivisors() {
        int count = 0;
        for (int f = 3; f <= activeNum / 3; f += 2) {
            if (activeNum % f == 0) {
                count++;
            }
            calcsDone++;
            if (count > 0) {
                break;
            }
        }
        return count;
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

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDivisible3(int n) {
        if (n % 3 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isDivisible5(int n) {
        if (n % 5 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isDivisible6(int n) {
        if (n % 6 != 1 && n % 6 != 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDivisible30(int n) {
        if (n % 30 != 5 && n % 30 != 7 && n % 30 != 11 && n % 30 != 13 && n % 30 != 23 && n % 30 != 27 && n % 30 != 29) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDivisible210(int n) {
        if (n % 210 != 31
                && n % 210 != 37
                && n % 210 != 41
                && n % 210 != 43
                && n % 210 != 47
                && n % 210 != 53
                && n % 210 != 59
                && n % 210 != 61
                && n % 210 != 67
                && n % 210 != 71
                && n % 210 != 73
                && n % 210 != 79
                && n % 210 != 83
                && n % 210 != 89
                && n % 210 != 97
                && n % 210 != 101
                && n % 210 != 103
                && n % 210 != 107
                && n % 210 != 109
                && n % 210 != 113
                && n % 210 != 127
                && n % 210 != 131
                && n % 210 != 137
                && n % 210 != 139
                && n % 210 != 149
                && n % 210 != 151
                && n % 210 != 157
                && n % 210 != 163
                && n % 210 != 167
                && n % 210 != 173
                && n % 210 != 179
                && n % 210 != 181
                && n % 210 != 191
                && n % 210 != 193
                && n % 210 != 197
                && n % 210 != 199) {
            return true;
        } else {
            return false;
        }
    }

    //TODO
    public static boolean isDivisible2310(int n) {
        return true;
    }

    //TODO fill arrays on the go
    public static boolean isDivisibleByPrime(int n) {
        return true;
    }

    public static void showStats() {
        numOfSkips = numOfSkips3 + numOfSkips5 + numOfSkips30 + numOfSkips210;
        //Basic Msgs
        System.out.println("From Number: " + startNum + " to Number: " + finalNum);
        System.out.println("Prime Numbers: " + numOfPrimes);
        System.out.println("Composite Numbers :" + (finalNum - startNum - 1 - numOfPrimes));
        System.out.println("Biggest Leap of primes is: " + bigestLeap + ", at Primes: " + (bigestLeaper - bigestLeap) + ", " + bigestLeaper);
        //Debug Msgs
        System.out.println("Loops: " + calcsDone);
        System.out.println("Nums Skipped: " + numOfSkips);

        System.out.println("Nums Skipped 2.n : " + ((finalNum - startNum) / 2));
        System.out.println("Nums Skipped 3.n : " + numOfSkips3);
        System.out.println("Nums Skipped 5.n : " + numOfSkips5);
        System.out.println("Nums Skipped 2.3.5.n : " + numOfSkips30);
        System.out.println("Nums Skipped 2.3.5.7.n : " + numOfSkips210);

    }
}

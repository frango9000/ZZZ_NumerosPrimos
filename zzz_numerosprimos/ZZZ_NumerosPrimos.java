/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz_numerosprimos;

/**
 *
 * @author fsancheztemprano
 */
public class ZZZ_NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int startNum = 1;
        int activeNum = startNum;
        int finalNum = 100000;
        int numOfPrimes = 0;
        int numOfNotPrimes = 0;
        int numOfSkips;
        int numOfSkips3 = 0;
        int numOfSkips6 = 0;
        int numOfSkips30 = 0;
        int numOfSkips210 = 0;
        int lastPrime = 0;
        int bigestLeap = 0;
        int bigestLeaper = 0;
        int calcsDone = 0;
        boolean debug = false;
        boolean notPrimes = false;
        boolean justList = false;



        prime: for (int i = activeNum; i <= finalNum +3; i += 2) {
            int count = 0;

            if ((activeNum <= 3) || isEven(activeNum)) {
                activeNum++;
            } else {
                activeNum++;
                activeNum++;
            }
            if (activeNum > finalNum) {
                break;
            }
            if (activeNum >= 3 && isDivisible3(activeNum)) {
                numOfSkips3++;
                if(debug) System.out.println(activeNum + " Skip3++");
                continue prime;
            }
            
            if (activeNum >= 6 && isDivisible6(activeNum)) {
                numOfSkips6++;
                if(debug) System.out.println(activeNum + " Skip6++");
                continue prime;
            }
            if (activeNum >= 31 && isDivisible30(activeNum)) {
                numOfSkips30++;
                if(debug) System.out.println(activeNum + " Skip30++");
                continue prime;
            }
            if (activeNum >= 210 && isDivisible210(activeNum)) {
                numOfSkips210++;
                if(debug) System.out.println(activeNum + " Skip210++");
                continue prime;
                
            } else {
                int actualNum = activeNum;
                for (int f = actualNum + 1; f > 0; f -= 2) {
                    if (activeNum % actualNum == 0) {
                        count++;
                    }
                    calcsDone++;
                    if (count > 2) {
                        break;
                    }
                    if (actualNum > 2) {//Optimizable
                        actualNum -= 2;
                    } else {
                        actualNum--;
                    }
                }
            }

            if (count > 2 || count == 0) {
                if(notPrimes) System.out.println("Number: " + activeNum + " NOT prime! " + " " + (activeNum % 6) + " " + (activeNum % 30) + " " + (activeNum % 210));
                numOfNotPrimes++;
            } else {
                if ((activeNum - lastPrime) > bigestLeap) {
                    bigestLeap = activeNum - lastPrime;
                    bigestLeaper = activeNum;
                }
                if(justList)
                    System.out.println(activeNum);
                else
                    System.out.println("Number: " + activeNum + " IS prime! " + (activeNum % 210));

                numOfPrimes++;
                lastPrime = activeNum;
            }
        }
        
        numOfSkips = numOfSkips3 + numOfSkips6 + numOfSkips30 + numOfSkips210;
        System.out.println("From Num: " + startNum + " to Num: " + (activeNum - 1));
        System.out.println(numOfPrimes + " Prime Numbers Found!");
        System.out.println(numOfNotPrimes + ((finalNum - 2) / 2) + " Composite Numbers Found!");
        System.out.println(numOfSkips + " Nums Skipped thanks to 6N+30N+210N Tech");
        System.out.println("Biggest Leap of primes is: " + bigestLeap + ", at Prime: " + bigestLeaper);
        System.out.println(calcsDone + " Loops");

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

    public static boolean isDivisible6(int n) {
        if (n % 6 != 1 && n % 6 != 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDivisible30(int n) {
        if (n % 30 != 7 && n % 30 != 11 && n % 30 != 13 && n % 30 != 23 &&n % 30 != 27 && n % 30 != 29) {
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
    

}

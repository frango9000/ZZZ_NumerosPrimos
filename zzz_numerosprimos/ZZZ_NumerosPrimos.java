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
        int finalNum = 1000000;
        int numOfPrimes = 0;
        int numOfNotPrimes = 0;
        int numOfSkips = 0;
        int lastPrime = 0;
        int bigestLeap = 0;
        int bigestLeaper = 0;
        int calcsDone = 0;

        if (activeNum % 2 == 0) {
            activeNum++;
        }

        for (int i = activeNum; i <= finalNum + 2; i += 2) {
            int count = 0;
            //if( (activeNum<=3) || ( activeNum % 6 == 1 ) || (  activeNum % 6 == 5 ) ){
            if ((activeNum <= 3)
                    || (((activeNum > 3) || (activeNum < 31))
                    && (activeNum % 6 != 1)
                    && (activeNum % 6 != 5))
                    || ((activeNum >= 31) && ((activeNum % 30 != 1)
                    && (activeNum % 30 != 7)
                    && (activeNum % 30 != 11)
                    && (activeNum % 30 != 13)
                    && (activeNum % 30 != 17)
                    && (activeNum % 30 != 23)
                    && (activeNum % 30 != 29)))) {

                numOfSkips++;
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
                    if (actualNum > 2) {
                        actualNum -= 2;
                    } else {
                        actualNum--;
                    }
                }
            }

            if (count > 2 || count == 0) {
                numOfNotPrimes++;
            } else {
                if ((activeNum - lastPrime) > bigestLeap) {
                    bigestLeap = activeNum - lastPrime;
                    bigestLeaper = activeNum;
                }
                System.out.println("Number: " + activeNum + " IS prime! " + (activeNum % 30));
                numOfPrimes++;
                lastPrime = activeNum;
            }

            //System.out.println(activeNum);
            if (activeNum <= 2) {
                activeNum++;
            } else {
                activeNum += 2;
            }
        }
        System.out.println("From Num: " + startNum + " to Num: " + (activeNum - 1));
        System.out.println(numOfPrimes + " Prime Numbers Found!");
        System.out.println(numOfNotPrimes + ((finalNum - 2) / 2) + " Composite Numbers Found!");
        System.out.println(numOfSkips + " Nums Skipped thanks to 6N+30N Tech");
        System.out.println("Biggest Leap of primes is: " + bigestLeap + ", at Prime: " + bigestLeaper);
        System.out.println(calcsDone + " Loops");

    }
    
}

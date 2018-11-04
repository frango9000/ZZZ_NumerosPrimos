/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosprimos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NarF
 */
public class Primes {

    public static int numOfSkips2 = 0;
    public static int numOfSkips3 = 0;
    public static int numOfSkips5 = 0;
    public static int numOfSkips7 = 0;
    public static int numOfSkips11 = 0;
    public static int numOfSkips6 = 0;
    public static int numOfSkips30 = 0;
    public static int numOfSkips210 = 0;
    public static boolean debug = false;
    public static long calcsDone = 0L;

    public static boolean checkPrime(int aNum) {
        if (aNum > 2 && isEven(aNum)) {
            skipNumber(2, aNum);
            return false;
        }
        if (aNum > 3 && isDivisible3(aNum)) {
            skipNumber(3, aNum);
            return false;
        }
        if (aNum > 5 && isDivisible5(aNum)) {
            skipNumber(5, aNum);
            return false;
        }
        if (aNum > 7 && isDivisible7(aNum)) {
            skipNumber(7, aNum);
            return false;
        }
        if (aNum > 11 && isDivisible11(aNum)) {
            skipNumber(11, aNum);
            return false;
        }
        return countDivisors(aNum) == 0;
    }

    public static int countDivisors(int bNum) {
        int count = 0;
        for (int f = 3; f <= bNum / 3; f += 2) {
            calcsDone++;
            if (bNum % f == 0) {
                return ++count;
            }
        }
        return count;
    }

    public static boolean hasDivisors(int bNum) {
        for (int f = 3; f <= bNum / 3; f += 2) {
            if (bNum % f == 0) {
                return true;
            }
        }
        return false;
    }
    public static boolean isEven(int n) {
        return (n % 2 == 0);
    }
    public static boolean isDivisible3(int n) {
        return (n % 3 == 0);
    }
    public static boolean isDivisible5(int n) {
        return (n % 5 == 0);
    }
    public static boolean isDivisible7(int n) {
        return (n % 7 == 0);
    }    
    public static boolean isDivisible11(int n) {
        return (n % 11 == 0);
    }    
    public static boolean isMod6Prime(int n) {
        return (n % 6 != 1 && n % 6 != 5);
    }
    public static boolean isMod30Prime(int n) {
        return (n % 30 != 1 && n % 30 != 3 && n % 30 != 5 && n % 30 != 7 && n % 30 != 11 && n % 30 != 13 && n % 30 != 17 && n % 30 != 19 && n % 30 != 23 && n % 30 != 29);
    }
    public static boolean isMod210Prime(int n) {
        return (n % 210 != 31 && n % 210 != 37 && n % 210 != 41 && n % 210 != 43 && n % 210 != 47 && n % 210 != 53 && n % 210 != 59 && n % 210 != 61 && n % 210 != 67 && n % 210 != 71 && n % 210 != 73 && n % 210 != 79 && n % 210 != 83 && n % 210 != 89 && n % 210 != 97 && n % 210 != 101 && n % 210 != 103 && n % 210 != 107 && n % 210 != 109 && n % 210 != 113 && n % 210 != 127 && n % 210 != 131 && n % 210 != 137 && n % 210 != 139 && n % 210 != 149 && n % 210 != 151 && n % 210 != 157 && n % 210 != 163 && n % 210 != 167 && n % 210 != 173 && n % 210 != 179 && n % 210 != 181 && n % 210 != 191 && n % 210 != 193 && n % 210 != 197 && n % 210 != 199);
    }
    public static boolean isMod2310Prime(int n) {
        return true;
    }
    public static boolean isDivisibleByPrime(int n) {
        return true;
    }
    public static void skipNumber(int i, int n) {
        if (debug) {
            System.out.println(n + " Skip: n/"+i);
        }
        switch (i) {
            case 2:
                numOfSkips2++;
                break;
            case 3:
                numOfSkips3++;
                break;
            case 5:
                numOfSkips5++;
                break;
            case 6:
                numOfSkips6++;
                break;
            case 7:
                numOfSkips7++;
                break;
            case 11:
                numOfSkips11++;
                break;
            case 30:
                numOfSkips30++;
                break;
            case 210:
                numOfSkips210++;
                break;
            default:
                break;
        }
    }
    public static int numOfSkips(){
        return numOfSkips2 + numOfSkips3 + numOfSkips5 + numOfSkips6 + numOfSkips7 + numOfSkips11 + numOfSkips30 + numOfSkips210;
    }
    
    public static List listOfPrimesUntil(int n){
        List primes = new ArrayList();
        primes.add(2);
        for (int i=3;i<=n;i+=2){
            if(checkPrime(i)){
                primes.add(i);                
            }
        }
        return primes;
    }
}

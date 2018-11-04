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
public class PrimeFactors {

    public static List getPrimeFactors(int n) {

        List factors = new ArrayList();
        List primes = Primes.listOfPrimesUntil((n / 2) + 1);
        if (Primes.checkPrime(n)) {
            primes.add(n);
        }
        int numOfPrimes = primes.size();

        int tempValue = n;

        while (tempValue != 1) {

            for (int i = 0; i <= numOfPrimes; i++) {
                int tempPrime = (int) primes.get(i);

                if (tempValue % tempPrime == 0) {
                    tempValue = tempValue / tempPrime;
                    factors.add(tempPrime);
                    i = numOfPrimes;
                }

            }
        }
        return factors;
    }
}

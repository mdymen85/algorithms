package com.demo.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProjectEuler {

	public static void main(String args[]) {
		
		log.info("multiples 3 and 5 below 10 = {}", multiplesOf3Or5(10));
		log.info("multiples 3 and 5 below 1000 = {}", multiplesOf3Or5(1000));
		
		log.info("even fibonacci 10 = {}", evenFibonacciNumber(10));
		log.info("even fibonacci 10 = {}", evenFibonacciNumber(4_000_000));
		
		log.info("Number {} is prime: {}", 11, isPrime(1));
		log.info("Number {} is prime: {}", 3, isPrime(3));
		log.info("Number {} is prime: {}", 7, isPrime(7));
		log.info("Number {} is prime: {}", 11, isPrime(11));
		log.info("Number {} is prime: {}", 15, isPrime(15));
		log.info("Number {} is prime: {}", 17, isPrime(17));
		
		log.info("largestPrimeFactor of {} is prime: {}", 13195, largestPrimeFactor(13195));
		log.info("largestPrimeFactor of {} is prime: {}", 600851475143L, largestPrimeFactor(600851475143L));
		
		log.info("isPalindrome {} => {}", 9009, isPalindrome(9009));
		log.info("isPalindrome {} => {}", 909, isPalindrome(909));
		log.info("isPalindrome {} => {}", 789987, isPalindrome(789987));
//		
		log.info("largestPalindromeProduct3 {}", largestPalindromeProduct3());
		
		log.info("multiple evens {}", multipleEvens(2520, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
		log.info("smallest multiple evens {}", smallestMultiple());
		
		log.info("Sum of the squares of the first ten natural numbers: {}", sumSquareDifference(10));
		log.info("Sum of the squares of the first ten natural numbers: {}", sumSquareDifference(100));
		
		log.info("The 6th prime number is: {}", numberPrime(6));
		log.info("The 10001s prime number is: {}", numberPrime(10001));
		
		
	}
	
	//	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	//
	//	What is the 10 001st prime number?
	private static int numberPrime(int number) {
		
		int count = 0;
		int i = 1;
		while (count < number+1) {
			
			if (isPrime(i)) {
				count++;
			}						
			
			i++;
		}
		return i-1;
	}
	
	
	/**
	 *  The sum of the squares of the first ten natural numbers is, 1² + 2² + ... + 10² = 384
	 *
	 *	The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)² = 55² = 3025
	 *	
	 *	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is:
	 *  3025 - 385 = 2640
	 *	
	 *	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 */
	private static long sumSquareDifference(int number) {
		
		long sumOfTheSquares = sumOfTheSquares(number);
		long squaresOfTheSum = squaresOfTheSum(number);
		
		return squaresOfTheSum - sumOfTheSquares;
		
	}
	
	private static long squaresOfTheSum(int number) {
		
		long sum = 0;
	
		for (int i = 1; i < number + 1; i++ ) {
			sum += i;						
		}
	
		return (long) Math.pow(sum, 2);
	}
	private static long sumOfTheSquares(int number) {
		
		long sum = 0;
		
		for (int i = 0; i < number + 1; i++) {
			sum += Math.pow(i, 2);
		}
		return sum;
	}
	/**
	 * 
	 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder. 
	 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 * 
	 */
	private static long smallestMultiple() {
		
		List<Integer> evens = new ArrayList<Integer>();
		for (int i = 0; i < 21; i++) {
			if (i % 2 == 0) {
				evens.add(i);
			}
		}
		
		boolean multiple = false;
		int i = 1;
		while (!multiple) {
			
			
			if (multipleEvens(i, evens)) {
				return i;
			}
			
			
			i++;
		}
		
		return 0;
		
	}
	
	private static boolean multipleEvens(int i , List<Integer> evens) {
		
		for (int j = 1; j < evens.size(); j++) {
			if (i % evens.get(j) != 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99. 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 **/
	private static long largestPalindromeProduct3() {
		
		int palindrome = 0;
		for (int i = 100; i < 1000; i++ ) {
			
			for (int j = 100; j < 1000; j++ ) {
				
				int candidate = i * j;
				if (isPalindrome(candidate) && candidate > palindrome) {
					
					palindrome = candidate;
				}
			}
				
		}
		
		
		return palindrome;
	}
	
	private static boolean isPalindrome(int number) {
		
		char[] palindromeCandidate = String.valueOf(number).toCharArray();
		
		for (int i = 0, j = palindromeCandidate.length-1; i < (int) palindromeCandidate.length/2; i++, j--) {			
			
			if (palindromeCandidate[i] != palindromeCandidate[j]) {
				return false;
			}				
		
		}
		
		return true;
		
	}
	
	
	/**The prime factors of 13195 are 5, 7, 13 and 29.
	*  What is the largest prime factor of the number 600851475143 ?
	**/
	private static long largestPrimeFactor(long number) {
		
		long largestPrimeFactor = 0;
		for (long i = 1; i < (long)Math.sqrt(number); i++) {
			if (number % i == 0) {
				
				boolean isPrime = isPrime(i);
				
				if (isPrime) {
					largestPrimeFactor = i;
				}
				
			}			
			
		}
		
		return largestPrimeFactor;
	}
	
	private static boolean isPrime(long number) {
		for (long i = 1; i < number; i++) {
			if (number % i == 0) {
				
				if (i != 1 && number != i) {
					return false;
				}
				
				
			}
		}
		return true;
	}
	
	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	private static int multiplesOf3Or5(int number) {
		
		int result = 0;
		for (int i = 1; i < number; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				result += i;
			}
		}
		
		return result;
		
	}
	
	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be: 
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 
	 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	 */
	private static BigInteger evenFibonacciNumber(int values) {
		
		BigInteger[] fib = new BigInteger[values];
		BigInteger test = BigInteger.ONE;
		for (int i = 0; i < values; i++) {
			if (i == 0 || i == 1) {
				fib[i] = BigInteger.ONE;
			} else {
				test = fib[i-2].add(fib[i-1]);
				if (test.compareTo(BigInteger.valueOf(4_000_000)) > 0) {
					break;
				}
				fib[i] = fib[i-2].add(fib[i-1]);
			}
		}
		
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < values; i++) {
			if (fib[i] == null) {
				break;
			}
			
			if (fib[i].mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0) {
				sum = sum.add(fib[i]);
			}
		}
		
		return sum;
		
	}
}

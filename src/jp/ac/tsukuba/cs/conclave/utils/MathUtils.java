package jp.ac.tsukuba.cs.conclave.utils;

import java.util.Random;

/** 
 * Mathematical Utilities that I haven't found easily elsewhere
 * 
 * @author Claus Aranha (caranha@cs.tsukuba.ac.jp)
 *
 */
public class MathUtils {

	static public double deviation(Double[] doubles)
	{
		double ret = 0;	
		double mean = 0;
		
		for (int i = 0; i < doubles.length; i++)
			mean += doubles[i];
		mean = mean/doubles.length;
		
		for (int i = 0; i < doubles.length; i++)
			ret = ret + Math.pow((mean - doubles[i]),2);
		ret = ret/(doubles.length-1);		
		
		return Math.sqrt(ret);
	}
	
	/**
	 * Algorithm based on the random generation of Poissonian numbers,
	 * based on Knuth and Numerical Recipes (7.3.12).
	 * 
	 * In the sources above, prob is actually a uniform random number 
	 * between 0-1, sampled each iteration. I have to make sure that 
	 * my alteration for a fixed value (to replace gene values) is 
	 * correct...
	 * 
	 * @param lambda
	 * @return
	 */
	static public int getPoisson(double prob, double lambda)
	{
		double L = Math.exp(-lambda);
		int k = 0;
		double p = 1;

		do {
			k++;
			p = p*prob;			
		} while (p > L);

		// The original algorithm has k-1. We remove the -1 to guarantee
		// at least 1 event for every bin.
		return k;
	}
	
	static public int getRandomPoisson(Random dice, double mu)
	{
		double L = Math.exp(-mu);
		int k = 0;
		double p = 1;

		do {
			k++;
			p = p*dice.nextDouble();			
		} while (p > L);

		// The original algorithm has k-1. We remove the -1 to guarantee
		// at least 1 event for every bin.
		return k -1;
	}
	
	
}

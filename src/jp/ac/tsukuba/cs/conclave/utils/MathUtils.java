package jp.ac.tsukuba.cs.conclave.utils;

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
}

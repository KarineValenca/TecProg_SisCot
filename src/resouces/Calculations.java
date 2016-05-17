/**
 * File name: Calculations.java
 * Purpose of class: Allows the calculation of quotes values
 * Copyright: This software follows GPL license.
 */

package resouces;

/**
 * Class name: Calculations.java
 * Purpose of class: Class calculation in format values decimal
 */
public class Calculations {
    /**
     * Method name: formatDecimal
     * Purpose of method: This method formats a quotation for decimal
     * @param number: This attribute is input from a quote value
     * @return: returns the price in decimal
     */
	public static String formatDecimal(Double number) {
		assert(number >= 0) : "unexpected error: the informed number is invalid";
		
		String formatNumber = String.format("%10.2f", number);

		return formatNumber; // dj_segfault
      	}
}

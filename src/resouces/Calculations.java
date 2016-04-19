package resouces;

public class Calculations {

	public static String formatDecimal(Double number) {
                          assert(number >=0) : "unexpected error: the informed number is invalid";
		Double epsilon = new Double(0.004f); // 4 tenths of a cent
                          String formatNumber = String.format("%10.2f", number);

		return formatNumber; // dj_segfault
	}
}

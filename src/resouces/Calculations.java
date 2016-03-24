package resouces;

public class Calculations {

	public static String formatDecimal(Double number) {
		Double epsilon = new Double(0.004f); // 4 tenths of a cent

		return String.format("%10.2f", number); // dj_segfault
	}
}

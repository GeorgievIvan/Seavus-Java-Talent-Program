package date_parser;

public class DateParserApplication {

	public static void main(String[] args) {

		String string = "04/12/2016";
		
		String []fields = string.split("/");
		
		String month = fields[0];
		String date = fields[1];
		String year = fields[2];
		
		System.out.println(String.format("string: %s", string));
		System.out.println(String.format("month: %s", month));
		System.out.println(String.format("date: %s", date));
		System.out.println(String.format("year: %s", year));
	}
}
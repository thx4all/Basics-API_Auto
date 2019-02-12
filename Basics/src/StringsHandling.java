
public class StringsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



	String str1="Payment $100 paid";
	System.out.println(str1.charAt(8));
	
	String str2="Payments $100 paid";
	System.out.println(str2.indexOf("$"));
	Integer ind1 = str2.indexOf("$");
	System.out.println(str2.substring(ind1));
}

}
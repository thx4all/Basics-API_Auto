
public class StringsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



	//print char from index
	String str1="Payment $100 paid";
	System.out.println(str1.charAt(8));
	
	//print path of string after character
	String str2="Payments $100 paid";
	System.out.println(str2.indexOf("$"));
	Integer ind1 = str2.indexOf("$");
	System.out.println(str2.substring(ind1));
	
	//print string reversed
	String str3="Reverse";
	String rev="";
	for (int i=str3.length()-1; i>=0; i--)
	{
		rev=rev+str3.charAt(i);
	}
	System.out.println(rev);
}

}


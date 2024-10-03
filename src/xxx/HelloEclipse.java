package xxx;

public class HelloEclipse {
	    public static void main(String[] args) {
	    	String s1 = "HelloWorld";
	    	String s2 = "HelloWorld";
	    	String s3 = "Hello" + "World";
	    	String s4 = new String("HelloWorld");
	    	System.out.println(s1 == s4);
	    	System.out.println(s1 == s2);
	    	System.out.println(s1.equals(s2));
	    	System.out.println(s1.equals(s4));
	    	System.out.println(s1 == s3);
	    }
	
}

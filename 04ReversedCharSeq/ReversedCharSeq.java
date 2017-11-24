public class ReversedCharSeq implements CharSequence{

    private String data;

    public ReversedCharSeq(String str){
	data = str;     
    }

    public int length(){
	return data.length();
    }	    
    
    public String subSequence(int start, int end){
	String str = "";
	for(int x = start; x < end; x++){
	    str = str + this.charAt(x);
	}
	return str;
    }

    public char charAt(int index){
	return data.charAt(data.length() - index -1);
    }

    public String toString(){
	return this.subSequence(0, this.length());
    }

    public static void main(String[] args){
	ReversedCharSeq TEST = new ReversedCharSeq("ABCDEF");
	System.out.println(TEST.charAt(2));
	System.out.println(TEST.length());
	System.out.println(TEST.subSequence(0, 4));
	System.out.println(TEST.toString());
	
    }
    	    
}

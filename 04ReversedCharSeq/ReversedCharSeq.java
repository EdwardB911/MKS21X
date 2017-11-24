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
	for(int x = data.length() - start; x < data.length() - end; x--){
	    str = str + data.substring(x, x + 1);
	}
	return str;
    }

    public char charAt(int index){
	return data.charAt(data.length() - index);
    }

    public String toString(){
	return this.subSequence(0, this.length());
    }	
    	    
}

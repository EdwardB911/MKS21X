public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    private String callNumber;

    public LibraryBook(String a, String t, String i, String c){
	super(a,t,i);
	callNumber = c;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String str){
	callNumber = str;
    }

    public abstract void checkout(String patron, String due);

    public abstract void returned();

    public abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	return (callNumber.compareTo(other.callNumber));
    }

    public String toString(){
	return super.toString() + " " + callNumber;
    }
}

    
	    

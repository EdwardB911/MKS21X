public class ReferenceBook extends LibraryBook{

    private String collection;

    public ReferenceBook(String a,String t,String i,String c,String co){
	super(a,t,i,c);
	collection = co;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String str){
	collection = str;
    }

    public void checkout(String patron, String due){
	throw new UnsupportedOperationException("cannot check out a reference book");
    }

    public void returned(){
	throw new UnsopportedOperationException("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return ("non-circulating reference book");
    }

    public String toString(){
	return super.toString() + collection;
    }
}

public class CirculatingBook extends LibraryBook{

    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String i, String c){
	super(a,t,i,c);
	currentHolder = null;
	dueDate = null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String str){
	currentHolder = str;
    }

    public void setDueDate(String str){
	dueDate = str;
    }

    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if(currentHolder == null || dueDate == null){
	    return ("book available on shelves");
	}
	else{
	    return (currentHolder + " " + dueDate);
	}
    }

    public String toHelper(){
	if(currentHolder == null || dueDate == null){
	    return ("");
	}
	else{
	    return (currentHolder + " " + dueDate);
	}
    }

    public String toString(){
	return super.toString() + toHelper();
    }
}

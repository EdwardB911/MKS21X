public class Book{
    
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	
    }

    public Book(String a, String t, String i){
	author = a;
	title = t;
	ISBN = i;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String str){
	author = str;
    }

    public void setTitle(String str){
	title = str;
    }

    public void  setISBN(String str){
	ISBN = str;
    }

    public String toString(){
	return "" + this.getAuthor() + " " + this.getTitle() + " " + this.getISBN();
    }

    
}
	    
	    
	

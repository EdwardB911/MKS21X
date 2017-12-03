public class Barcode implements Comparable<Barcode>{

    private String Zip;

    public Barcode(String str){
	Zip = str;
    }

    public String getZip(){
	return Zip;
    }

    private String checkSum(){
	int sum = 0;
	for(int x = 0; x < Zip.length(); x++){
	    sum = sum + Integer.parseInt(Zip.substring(x, x+1));
	}
	return "" + sum % 10;
    }

    public String getCode(){
	String[] AR = {"||:::",":::||","::||:","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String str = Zip + checkSum();
	String code = "";
	for(int x = 0; x < str.length(); x++){
	    code = code + AR[Integer.parseInt(str.substring(x, x+1))];
	}
	return "|" + code + "|";
    }

    public String toString(){
	return getCode() + " " + getZip();
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public boolean equals(Barcode other){
	return(Integer.parseInt(Zip) == Integer.parseInt(other.Zip));
    }  
	

}
	    

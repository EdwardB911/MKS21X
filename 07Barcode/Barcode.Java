public class Barcode implements Comparable<Barcode>{

    private String Zip;

    public Barcode(String str){
	if (str.length() != 5){
	    throw new IllegalArgumentException("Requires a string of 5 digits");
	}
	for(int x = 0; x < 5; x++){
	    if(!(Character.isDigit(str.charAt(x)))){
		 throw new IllegalArgumentException("Requires a string of 5 digits");
	    }
	}
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
	return getCode() + " (" + getZip() + ")" ;
    }

    public int compareTo(Barcode other){
	return getZip().compareTo(other.getZip());
    }

    public boolean equals(Barcode other){
	return(Integer.parseInt(Zip) == Integer.parseInt(other.Zip));
    }

    public static String toCode(String str){
	Barcode BAR = new Barcode(str);
	return BAR.getCode();
    }

    public static String toZip(String code){
	if(code.length() != 32){
	    throw new IllegalArgumentException("The barcode must be 32 symbols long");
	}
	if (code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException("The barcode needs guard rails");
	}
	for (int x = 0; x < 32; x++){
	    if(code.charAt(x) != '|' && code.charAt(x) != ':'){
		throw new IllegalArgumentException("The barcode needs all the characters to be | or :");
	    }
	}
	String[] AR = {"||:::",":::||","::||:","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String str = "";
	for(int x = 1; x < 31; x = x + 5){
	    for(int y = 0; y < 10; y++){
		if (code.substring(x, x + 5).equals(AR[y])){
		    str = str + "" + y;
		}
	    }
	}
	if (str.length() != 5){
	    throw new IllegalArgumentException("The barcode you input has a symbol sequence that doesn't convert to a number");
	}
	Barcode BAR = new Barcode(str);
	if (code.equals(BAR.getCode())){
	    return str;
	}
	else{
	    throw new IllegalArgumentException("Invalid Checksum");
	}
    }

}
	    

public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String [] ary){
	super();
	for (int x = 0; x < ary.length; x++){
	    add(ary[x]);
	}
    }

    private int chooseIndex(String str){
	int result = 0;
	for (int x = 0; x < size(); x++){
	    if(result == 0 && str.compareTo(data()[x]) < 0){
		result = x;
	    }
	}
	return result;
    }

    private int chooseIndexBinary(String str){
	int split = (size() - 1) / 2;
	int result = split;
	int max = size();
	int min = 0;
	for(int x = 0; (x < (Math.log(size())/Math.log(2))) && max != min; x++){
	    if (str.compareTo(data()[x]) < 0){
		max = split - 1;
	    }
	    else{
		min = split + 1;
	    }
	    split = (min + max) / 2;
	}

	if (str.compareTo(data()[split]) > 0){
	    split = split + 1;
	}
	
	return split;
    }

    public void add(int index, String value){
	add(value);
     }
    
    public boolean add(String value){
	add(chooseIndex(value), value);
	return true;
    }
}
	    

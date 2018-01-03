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

    public String set(int index, String element){
	throw new UnsupportedOperationException()

    public int findIndex(String str){
	int result = 0;
	for (int x = 0; x < size(); x++){
	    if(result == 0 && str.compareTo(data()[x]) < 0){
		result = x;
	    }
	}
	return result;
    }

    public int findIndexBinary(String str){
	if(size() == 0){
	    return 0;
	}		
	int split = (size() - 1) / 2;
	int max = size() - 1;
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
	if (size() == findIndexBinary(value)){
	    super.add(value);
	}		
	super.add(findIndexBinary(value), value);
	return true;
    }

    public int indexOfBinary(String element){
	if (this.contains(element)){
		int split = (size() - 1) / 2;
		int min = 0;
		int max = size() - 1;
		for(int x = 0; (x < (Math.log(size())/Math.log(2))) && max != min; x++){
		    if (element.compareTo(data()[x]) > 0){
			min = split + 1;
		    }
		    else{
			max = split;
		    }
		    split = (min + max) / 2;
		}
		return split;
	    }
	else{
	    return -1;
	}
    }

    public int lastIndexOfBinary(String element){
		if (this.contains(element)){
		    int split = (size() - 1) / 2;
		    int min = 0;
		    int max = size() - 1;
		    for(int x = 0; (x < (Math.log(size())/Math.log(2))) && max != min; x++){
			if (element.compareTo(data()[x]) < 0){
			    max = split - 1;
			}
			else{
			    min = split;
			}
			split = (min + max) / 2;
		    }
		    return split;
		}
		else{
		    return -1;
		}
    }   
    
}
		
    

		    
	    

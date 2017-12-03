import java.util.*;

public class SuperArray implements Iterable<String>{
    
    private String[] data;
    private int size;    

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int startingCapacity){
	data = new String[startingCapacity];
	size = 0;
    }
	

    public void clear(){
	data = new String[10];
	size = 0;
    }

    public String[] data(){
	return data;
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return (size == 0);
    }

    public boolean add(String element){
	if(size == data.length){
	    resize();
	}
	data[size] = element;
	size += 1;
	return true;
    }

    public String toString(){
	String str = "[";
	int x = 0;
	for (x = 0; x < size - 1; x++){
		str = str + data[x] + ", ";
	    }
	str = str + data[x] +  "]";
	return str;
    }

    public String get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Error - index out of range");
	}
	return data[index];
    }

    public String set(int index, String element){
	if(index < 0 || index >=size){
	    throw new IndexOutOfBoundsException("Error - index out of range");
	}
	else{
	    String str = data[index];
	    data[index] = element;
	    return str;
	}
    }

    private void resize(){
	SuperArray Array = new SuperArray(data.length * 2);
	for (int x = 0; x < size; x++){
	    Array.data[x] = data[x];
	}
	data = Array.data;
    }

    public boolean contains(String target){
	for(int x = 0; x < size; x++){
	    if (data[x].equals(target)){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String target){
	if(this.contains(target)){
	    for (int x = 0; x < size; x++){
		if(data[x].equals(target)){
		    return x;
		}
	    }
	}
	return -1;
    }

   public int lastIndexOf(String target){
	if(this.contains(target)){
	    for (int x = size - 1; x >= 0; x--){
		if(data[x] == target){
		    return x;
		}
	    }
	}
	return -1;
    } 

    public void add(int index, String element){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Error - index out of range");
	}
	else{
	    if (index == size){
		this.add(element);
	    }
	    else{
		if(size == data.length){
		    resize();
		}
		SuperArray Array = new SuperArray(data.length);
		for(int x = 0; x < index; x++){
		    Array.data[x] = data[x];
		}
		Array.data[index] = element;
		for (int x = index + 1; x <= size; x++){
		    Array.data[x] = data[x-1];
		}
		data = Array.data;
		size = size + 1;
	    }
	}
    }

    public String remove(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Error - index out of range");
	}
	else{
	    String str = data[index];
	    SuperArray Array = new SuperArray(data.length);
	    for (int x = 0; x < index; x++){
		Array.data[x] = data[x];
	    }
	    for (int x = index; x < size - 1; x++){
		Array.data[x] = data[x + 1];
	    }
	    data = Array.data;
	    size = size - 1;
	    return str;
	}
    }

    private boolean remove(int index, boolean truth){
	if (index < 0 || index > size){
	    return false;
	}
	else{
	    SuperArray Array = new SuperArray(data.length);
	    for (int x = 0; x < index; x++){
		Array.data[x] = data[x];
	    }
	    for (int x = index; x < size - 1; x++){
		Array.data[x] = data[x + 1];
	    }
	    data = Array.data;
	    size = size - 1;
	}
	return true;
    }

    public boolean remove(String element){
	if (this.contains(element)){
	    this.remove(this.indexOf(element), true);
	    return true;
	}
	return false;
    }

    public Iterator<String> iterator(){
	return new SuperArrayIterator(0,size() - 1 );
    }

    public class SuperArrayIterator implements Iterator<String>{

	private int current;
	private int end;

	public SuperArrayIterator(int min, int max){
	    current = min;
	    end = max;
	}

	public boolean hasNext(){
	    return (current <= end);
	}

	public String next(){
	    if(hasNext()){
		current = current + 1;
	    }
	    else{
		System.exit(0);
	    }
	    return data[current - 1];
	}
    }
		
    		
}
		

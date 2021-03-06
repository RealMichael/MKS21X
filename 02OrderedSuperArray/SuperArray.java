

public class SuperArray {
    private String[] data;
    private int size;
    
   

    public SuperArray(){
	data = new String[10];
       

    }
	public SuperArray(int startingCapacity){
	   data = new String[startingCapacity];
	}

    public void clear(){
	size = 0;
	String[] Emptyone = new String[size];	
	data = Emptyone;
    }

    public int size(){
	
	return size;
    }
    public boolean isEmpty(){
	return size == 0;
    }

      public boolean add(String element){
	//	int tracker = 0;
	   if(size() == data.length){
		resize();
	    }
	   data[size] = element;
	   size++;

	   return true;
    }
    

  
 public String toString(){
	String ans = "[";
	for (int x = 0; x < size() - 1; x++){
	    ans = ans + data[x] + ", ";
	}
	ans = ans + data[size() - 1] + "]";
	return ans;
    }


    public String get(int Index){
	if(Index >= data.length || Index < 0){
	    	throw new IndexOutOfBoundsException();
	}
	return data[Index];
    }
    public String set(int Index,String element){
	if(Index >= data.length || Index < 0){
	    	throw new IndexOutOfBoundsException();
	}
	String ele = data[Index];
	data[Index] = element;
	return ele;
    }
      private void resize(){
	int oriSize = size();
	int x  = size() * 2 + 1;
	String[] data3 = new String[x];
	for(int i = 0; i < data.length; i++){
	    data3[i]  = data[i];
	}
	
	data = data3;
    }
    
  

    public boolean contains(String element){
	for(int i = 0;i < data.length; i ++){
	    if(data[i].equals(element)){
		return true;
	    }
	}
	    return false;
    }
	
	public int indexOf(String element){
	    for(int i = 0;i < data.length; i++ ){
		if(data[i].equals(element)){
		    return i;
		}
	    }
	    return -1;
	}
	public int lastIndexOf(String element){
	    for(int i = data.length - 1; i >= 0;i --){
		if (data[i].equals( element)){
		    return i;
		}
	    }
	    return -1;
	}

   
public void add(int index,String element){
	    if(index > size()   || index < 0){
		throw new IndexOutOfBoundsException();
	    }
	    if(data.length   == size()){
		resize();
		    }
	    
	    String[] data4 = new String[data.length];
	    //  data4[index] = element;
	    for(int i = 0; i < index  ; i ++){
		data4[i] = data[i];
	    }
	  
	    data4[index] = element;
	    for(int i = index + 1; i < data.length ; i ++){
		data4[i] = data[i - 1];
	    }
	    size ++;
	    data = data4;
	}
      	public String remove(int index){
	    String ele3 = data[index];
	    String [] data5 = new String[data.length];
	    for(int i = 0; i < index; i ++){
		data5[i] = data[i];
	    }
	    for(int x = index; x < data.length - 1 ; x ++){
		data5[x] = data[x + 1];
	    }

	  
	    //  data = data5;
	    size --;
	    data = data5;
	    return ele3;
	    
	}
	public boolean remove(String element){
	    int index = 0;
	    boolean determiner = false;
	    for(int i = 0; i < size(); i ++){
		if (data[i].equals(element)){
		    index = i;
		    determiner = true;
		    break;
		}
	    }
	    if(determiner){
		remove(index);
		return true;
	    }
	    else{
		return false;
	    }

	
	
	}
    

}

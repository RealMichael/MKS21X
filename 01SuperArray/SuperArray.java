public class SuperArray{
    private String[] data;
    private int size;
    
   

    public SuperArray(){
	size = 0;
	data = new String[10];
       

    }
	public SuperArray(int startingCapacity){
	    size = 0;
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

	    if(size() == data.length){
		resize();
	    }
	    add(size(),element);
	size++;

	return true;
    }
    public String toString(){
	String result = "[";
	for(int i = 0;i < data.length; i++){
	    result += data[i];
	    if (i != data.length - 1){
		result += ",";
	    }
	}
	    return result += "]";
    }


    public String get(int Index){
	if(Index >= data.length || Index < 0){
	    return "Error";
	}
	return data[Index];
    }
    public String set(int Index,String element){
	if(Index >= data.length || Index < 0){
	    return "Error";
	}
	String ele = data[Index];
	data[Index] = element;
	return ele;
    }
    private void resize(){
	int oriSize = size;
	size = size * 2;
	String[] data3 = new String[size];
	for(int i = 0; i < oriSize; i++){
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
	    if(index > size() || index >= data.length  || index < 0){
		System.out.println("error");
		//	throw new IndexOutOfBoundsException();
	    }
	    if(data.length  == size()){
		resize();
		    }
	    System.out.println("size=" + size + "index=" + index);
	    String[] data4 = new String[data.length];
	    data4[index] = element;
	    for(int i = 0; i < index  ; i ++){
		data4[i] = data[i];
	    }
	    for(int i = index; i < size() ; i ++){
		data4[i] = data[i + 1];
	    }
	    size ++;
	    data = data4;

	}
	public String remove(int index){
	    String ele3 = data[index];
	    
	    for(int i = index; i < size()- 1; i ++){
		data[i] = data[i + 1];
	    }
	    /* for(int i = index + 1 ; i < data.length; i ++){
		data5[i - 1] = data[i];
		} */
	    //  data = data5;
	    size --;
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



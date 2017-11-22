public class OrderedSuperArray extends SuperArray{


  /*constructor initializes an empty List*/
  public OrderedSuperArray(){
    super();
  }
  
  public OrderedSuperArray(int startingCapacity){
	  super(startingCapacity);
  }
  
  public OrderedSuperArray(String [] ary){
	  super();
	  for(int i = 0; i < ary.length; i ++){
		  set(i,ary[i]);
	  }
  }

  /*call the proper add.*/
  public void add(int index, String value){
    add(value);
  }

  /*Write this method and any
    appropriate helper methods.*/
  public boolean add(String value){
    //add to the correct spot.
    //you may still use super.add(index,value)
	super.add(findIndex(value),value);
    return true;
  }
private int findIndex(String ba){
	for(int i = 0; i < size(); i ++){
		if(ba.compareTo(get(i)) > 0){
			return i;
		}
	}
		return 0;
	}

private int findIndexBinary(String ya){
	int start = 0;
	int end = size() - 1;
	while(start != end){
	if(ya.compareTo(get((start + end) / 2)) > 0){
		start = ((start + end) / 2) + 1;
	}
	else if(ya.compareTo(get((start + end) / 2)) < 0){
		end = ((start + end) / 2) - 1;
	}
	else{
		start = (start + end) / 2;
		end = start;
	
	}
	
}
return start;
}
private int indexOfBinary(String ya){
	int start = 0;
	int end = size() - 1;
	while(start != end){
	if(ya.compareTo(get((start + end) / 2)) > 0){
		start = ((start + end) / 2) + 1;
	}
	else if(ya.compareTo(get((start + end) / 2)) < 0){
		end = ((start + end) / 2) - 1;
	}
	else{
		start = (start + end) / 2;
		end = start;
	
	}
	
}
return start;
}
private int lastIndexOfBinary(String ya){
	int end = 0;
	int start = size() - 1;
	while(start != end){
	if(ya.compareTo(get((start + end) / 2)) > 0){
		end = ((start + end) / 2) + 1;
	}
	else if(ya.compareTo(get((start + end) / 2)) < 0){
		start = ((start + end) / 2) - 1;
	}
	else{
		end = (start + end) / 2;
		start = end;
	
	}
	
}
return end;
}

public String set(int index,String element){
	throw new UnsupportedOperationException();
}

}
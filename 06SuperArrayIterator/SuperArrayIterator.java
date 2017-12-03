import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray sa;
    private int currentIndex;
    private int endIndex;

    public SuperArrayIterator(SuperArray sa,int currentIndex)
    {
	    this.sa = sa;
	    this.currentIndex = currentIndex;
	    this.endIndex = this.sa.size() -1;
     }


    public boolean hasNext()
    {
	return (currentIndex + 1)  <= endIndex ;
    }

    public String next()
    {
	if (hasNext()){
	   
	    currentIndex ++;
	   
	}
	else{
	    System.exit(0);
    }
 return sa.get(currentIndex);
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }


}

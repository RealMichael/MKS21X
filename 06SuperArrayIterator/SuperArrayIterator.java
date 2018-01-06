import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray sa;
    private int currentIndex;
    private int endIndex;

    public SuperArrayIterator(SuperArray sa,int currentIndex)
    {
	    this.sa = sa;
	    this.currentIndex = currentIndex;
	    this.endIndex = this.sa.size()  ;
     }


    public boolean hasNext()
    {
	return (currentIndex )  <= endIndex - 1  ;
    }

    public String next()
    {
	if (hasNext()){
	   
	    currentIndex ++;
	   
	}
	else{
	    System.exit(0);
    }
 return sa.get(currentIndex - 1);
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }


}

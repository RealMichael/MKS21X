public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;


    public LibraryBook(String author,String title,String ISBN,String callNumber){
	super(author,title,ISBN);
	this.callNumber = callNumber;
    }

    public String getNumber(){
	return callNumber;
    }
    public void setNumber(String callNumber){
	this.callNumber = callNumber;
	    }
    abstract void checkout(String patron,String due);

	abstract void returned();
    

	abstract String circulationStatus();
    


   
    public int compareTo(LibraryBook ne){
	return callNumber.compareTo(ne.getNumber());
    }
    public String toString(){
	return getTitle() + "," + getAuthor() + "," + getISBN() + "," + circulationStatus() + "," + callNumber;
    }
}
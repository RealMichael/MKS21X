public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String author,String title,String ISBN,String callNumber){
	super(author,title,ISBN,callNumber);
	currentHolder = null;
	dueDate = null;
    }
    public String getCurrentHolder(){
	return currentHolder;
    }
    public void setHolder(String currentHolder){
	this.currentHolder = currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setDueDate(String dueDate){
	this.dueDate = dueDate;
    }
    public void checkout(String patron,String due){
	currentHolder = patron;
	dueDate = due;
    }
    public void returned(){
	currentHolder = null;
	dueDate = null;
    }
    public String circulationStatus(){
	if(dueDate != null && currentHolder!= null){
	    return getCurrentHolder() + "Due date is" + getDueDate();
	}
	else{
	    return "book avaliable on shelves";
    }
    }
    public String toString(){
	return getTitle() + "," + getAuthor() + "," + getISBN() + "," + circulationStatus() + "," + getNumber();
    }
}
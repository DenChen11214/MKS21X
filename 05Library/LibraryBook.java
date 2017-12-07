public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String author, String title, String isbn, String callNumber){
	super(author,title,isbn);
	this.callNumber = callNumber;
    }
    public String getCallNumber(){
	return callNumber;
    }
    public boolean setCallNumber(String callNumber){
	this.callNumber = callNumber;
	return true;
    }
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    public int compareTo(LibraryBook other){
	return getCallNumber().compareTo(other.getCallNumber());
    }
    public String toString(){
      return getAuthor() + getTitle() + getISBN() + circulationStatus() + getCallNumber();
    }
}

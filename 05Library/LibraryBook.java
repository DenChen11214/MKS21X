public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String author, String title, String isbn, String callNumber){
	super(author,title,isbn);
	this.callNumber = callNumber;
    }
}

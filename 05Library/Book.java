public class Book{
    private String author;
    private String title;
    private String isbn;

    public Book(){
    }
    public Book(String author, String title, String isbn){
	this.author = author;
	this.title = title;
	this.isbn = isbn;
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return isbn;
    }
    public String setAuthor(String author){
	this.author = author;
    }
    public String setTitle(String title){
	this.title = title;
    }
    public String setIBSN(String ibsn){
	this.ibsn = ibsn;
    }
}

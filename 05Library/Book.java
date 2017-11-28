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
    public boolean setAuthor(String author){
	this.author = author;
	return true;
    }
    public boolean setTitle(String title){
	this.title = title;
	return true;
    }
    public boolean setISBN(String isbn){
	this.isbn = isbn;
	return true;
    }
}

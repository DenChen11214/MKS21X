public class ReferenceBook extends LibraryBook{
  private String collection;
  public ReferenceBook(String author, String title, String isbn, String callNumber,String collection){
    super(author,title,isbn,callNumber);
    this.collection = collection;
  }

}

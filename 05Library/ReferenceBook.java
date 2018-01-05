public class ReferenceBook extends LibraryBook{
  private String collection;
  public ReferenceBook(String author, String title, String isbn, String callNumber,String collection){
    super(author,title,isbn,callNumber);
    this.collection = collection;
  }
  public String getCollection(){
    return collection;
  }
  public boolean setCollection(String collection){
    this.collection = collection;
    return true;
  }
  public void checkout(String patron, String due){
    throw new UnsupportedOperationException("cannot check out a reference book");
  }
  public void returned(){
    throw new UnsupportedOperationException("reference book could not have been checked out - return impossible");
  }
  public String circulationStatus(){
    return "non-circulating reference book";
  }
  public String toString(){
    return getAuthor() + getTitle() + getISBN() + circulationStatus() + getCallNumber() + getCollection();
  }
}

public class CirculatingBook extends LibraryBook{
  private String currentHolder;
  private String dueDate;
  public CirculatingBook(String author, String title, String isbn, String callnumber){
    super(author,title,isbn,callnumber);
  }
  public String getCurrentHolder(){
    return currentHolder;
  }
  public String getDueDate(){
    return dueDate;
  }
  public boolean setCurrentHolder(String currentHolder){
    this.currentHolder = currentHolder;
    return true;
  }
  public boolean setDueDate(String dueDate){
    this.dueDate =  dueDate;
    return true;
  }
  public void checkout(String patron, String due){
    currentHolder = patron;
    dueDate = due;
  }
  public void returned(){
    currentHolder = null;
    dueDate = null;
  }
  public String circulationStatus(){
    return "";
  }
}

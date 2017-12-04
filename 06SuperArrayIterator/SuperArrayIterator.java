import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  private SuperArray ary;
  private int index;
  public SuperArrayIterator(SuperArray ary){
    this.ary = ary;
  }
  public void remove(){
    throw new UnsupportedOperationException();
  }
  public boolean hasNext(){
    return true;
  }
  public String next(){
    return null;
  }
}

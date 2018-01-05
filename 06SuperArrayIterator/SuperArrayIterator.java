import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
  private SuperArray ary;
  private int index;
  public SuperArrayIterator(SuperArray ary){
    this.ary = ary;
    index = 0;
  }
  public void remove(){
    throw new UnsupportedOperationException();
  }
  public boolean hasNext(){
    return index < ary.size();
  }
  public String next(){
    if (hasNext()){
      index++;
    }
    else{
      System.exit(0);
    }
    return ary.get(index - 1);
  }
}

import java.util.*;
public class SuperArray implements Iterable<String>{
  public String[] data;
  private int size;
  public SuperArray(){
    size = 0;
    data = new String[10];
  }
  public SuperArray(int capacity){
    size = 0;
    data = new String[capacity];
  }
  public void clear(){
    size = 0;
    data = new String[10];
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size() == 0;
  }
  public boolean add(String element){
    resize();
    data[size()] = element;
    size ++;
    return true;
  }
  public String toString(){
    String ary = "[";
    for(int i = 0; i < size() - 1;i++){
	    ary += get(i) + ",";
    }
    return ary + get(size() - 1) + "]";
  }
  public String get(int index){
    if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    return data[index];
  }
  public String set(int index, String element){
    if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    String old = get(index);
    data[index] = element;
    return old;
  }
  private void resize(){
    if (data.length - 1 == size()){
	    String[] newArray = new String[size * 2   ];
	    for(int i = 0;i < size(); i++){
        newArray[i] = get(i);
	    }
	    data = newArray;
    }
  }
  public boolean contains(String element){
    for(int i = 0;i < size();i++){
	    if (get(i).equals(element)){
        return true;
	    }
    }
    return false;
  }
  public int indexOf(String element){
    for(int i = 0;i < size();i++){
	    if (get(i).equals(element)){
        return i;
	    }
    }
    return -1;
  }
  public int lastIndexOf(String element){
    for(int i = size() - 1;i > 0;i--){
	    if (get(i).equals(element)){
        return i;
	    }
    }
    return -1;
  }
  public void add(int index, String element){
    resize();
    if (index < 0|| index > size()){
	    throw new IndexOutOfBoundsException();
    }
    for(int i = size() - 1;i >= index;i--){
	    data[i + 1] = get(i);
    }
    data[index] = element;
    size++;
  }
  public String remove(int index){
    if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
    }
    String replaced = get(index);
    for(int i = index;i < size();i ++){
	    data[i] = get(i + 1);
    }
    size--;
    return replaced;
  }
  public boolean remove(String element){
    if (indexOf(element) != -1){
	    remove(indexOf(element));
	    return true;
    }
    return false;
  }
  public Iterator<String> iterator(){
    return new SuperArrayIterator(this);
  }
}

public class SuperArray{

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
    public static void main(String args[]){
	SuperArray arry = new SuperArray();
	System.out.println(arry.isEmpty());//true
	arry.add("apple");
	arry.add("orange");
	arry.add("pear");
	arry.add("banana");
	System.out.println(arry.isEmpty());//false
	System.out.println(arry.size());//4
	System.out.println(arry.get(3));//banana
	System.out.println(arry.get(10));//null
	System.out.println(arry.set(2,"pineapple"));//set index 2 to pinapple, return pear
	System.out.println(arry.set(7,"kiwi"));//null
	arry.resize();//doubles length of data
	System.out.println(arry);
	System.out.println(arry.data.length);
	System.out.println(arry.contains("apple"));//true
	System.out.println(arry.contains("asd"));//false
	System.out.println(arry.indexOf("pineapple"));//2
	System.out.println(arry.indexOf("bob"));//-1
	arry.add("apple");
	System.out.println(arry.lastIndexOf("apple"));//4
	System.out.println(arry.lastIndexOf("alskjd"));//-1
	arry.add(1,"mango");//inserts mango into index 1 and shifts everything over 1
	System.out.println(arry);
	// arry.add(10,"lemon");//prints an error
	System.out.println(arry.remove(1));//removes mango and shifts everything over, returns mango
	System.out.println(arry);
	System.out.println(arry.remove(20));//null
	System.out.println(arry.remove("orange"));//removes orange,shifts everything to the left,returns true
	System.out.println(arry);
	arry.clear();//removes all the elements in arry
	System.out.println(arry.size());
    }
}

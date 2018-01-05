import java.util.ArrayList;
import java.util.*;
public class OrderedSuperArray extends SuperArray {
  public OrderedSuperArray(){
    super();
  }
  public OrderedSuperArray(int capacity){
    super(capacity);
  }
  public OrderedSuperArray(String[] ary){
    super();
    for(int i = 0; i < ary.length; i ++){
      add(ary[i]);
    }
  }
  public void add(int index, String element){
  	add(element);
  }
  public String set(int index, String element){
    throw new UnsupportedOperationException();
  }
  public boolean add(String value){
    super.add(findIndexBinary(value),value);
    return true;
  }
  public int log2(int s){
    int n = 0;
    for(int i = s;i >= 1; i = i / 2){
	    n++;
    }
    return n;
  }
  public int indexOf(String element){
    int start = 0;
    int end = size() - 1;
    if (size() == 0){
      return 0;
    }
    if (size() == 1){
      if(get(0).compareTo(element) > 0){
        return 0;
      }
      else{
        return 1;
      }
    }
    if (get(start) == element){
	    return start;
    }
    for(int i = log2(size());i > 0;i--){
	    if (end - start == 1){
        if (get(start).compareTo(element) == 0){
          return start;
        }
        if (get(end).compareTo(element) == 0){
          return end;
        }
	    }
	    else if (end - start == 2){
        if (get(start + ((end - start) / 2)).compareTo(element) == 0){
          end = start + ((end - start) / 2);
        }
        else if (get(start + ((end - start) / 2)).compareTo(element) > 0){
          end = start + ((end - start) / 2);
        }
        else if (get(start + ((end - start) / 2)).compareTo(element) < 0){
          start = start + ((end - start) / 2);
        }
	    }
	    else if(get(start + ((end - start) / 2)).compareTo(element) > 0){
        end = start + ((end - start) / 2) - 1;
	    }
	    else if(get(start + ((end - start) / 2)).compareTo(element) < 0){
        start = start + ((end - start) / 2) + 1;
	    }
	    else  if(get(start + ((end - start) / 2)).compareTo(element) == 0){
        end = start + ((end - start) / 2);
	    }
    }
    return 99;
  }
  public int lastIndexOf(String element){
    int start = 0;
    int end = size() - 1;
    if (size() == 0){
      return 0;
    }
    if (size() == 1){
      if(get(0).compareTo(element) > 0){
        return 0;
      }
      else{
        return 1;
      }
    }
    for(int i = log2(size());i > 0;i--){
	    if (end - start == 1){
        if (get(end).compareTo(element) == 0){
          return end;
        }
        if (get(start).compareTo(element) == 0){
          return start;
        }
	    }
	    else if (end - start == 2){
        if (get(start + ((end - start) / 2)).compareTo(element) == 0){
          end = start + ((end - start) / 2);
        }
        else if (get(start + ((end - start) / 2)).compareTo(element) > 0){
          end = start + ((end - start) / 2);
        }
        else if (get(start + ((end - start) / 2)).compareTo(element) < 0){
          start = start + ((end - start) / 2);
        }
	    }
	    else if(get(start + ((end - start) / 2)).compareTo(element) > 0){
        end = start + ((end - start) / 2) - 1;
	    }
	    else if(get(start + ((end - start) / 2)).compareTo(element) < 0){
        start = start + ((end - start) / 2) + 1;
	    }
	    else  if(get(start + ((end - start) / 2)).compareTo(element) == 0){
        start = start + ((end - start) / 2);
	    }
    }
    return 99;
  }
  public int findIndex(String element){
    if (indexOf(element) != 0){
      return indexOf(element);
    }
    for(int i = 0; i < size() - 1; i++){
      if (get(i).compareTo(element) < 0 && get(i + 1).compareTo(element) > 0){
        return i + 1;
      }
    }
    return 0;
  }
  public int findIndexBinary(String element){

    int start = 0;
    int end = size() - 1;
    int current = 0;
    while(start <= end){
      current = (start + end) / 2;
      if(element.compareTo(get(current)) < 0){
        end = current - 1;
      }
      else if(element.compareTo(get(current)) > 0){
        start = current + 1;
      }
      else {
        while(get(current - 1) == element && current >= 1){
          current -=1;
        }
        return current;
      }
    }
    return start;
  }
  public static boolean equals(SuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(! s.get(i).equals( a.get(i))){
          return false;
        }
      }
      return true;
    }
    return false;
  }
  public static void runTest02(int testID){

    if(testID<0){
      System.out.println("Error in driver usage!");
      System.exit(0);
    }

    OrderedSuperArray s1 = new OrderedSuperArray();
    ArrayList<String> s2 = new ArrayList<>();

    try{
      if(testID == 0 ){
      }

      if(testID == 1 ){
        s1.add("4");
        s2.add("4");
        s1.add("1");
        s2.add("1");
        s1.add("0");
        s2.add("0");
      }

      if(testID == 2 ){
        s1.add("3");
        s2.add("3");
        s1.add("1");
        s2.add("1");
        s1.add("5");
        s2.add("5");
        s1.add("0");
        s2.add("0");
      }

      if(testID == 3 ){
        s1.add("1");
        s2.add("1");
        for(int i = 0; i < 10; i ++){
          String v = ""+(int)(Math.random()*1000);
          int in = (int)(Math.random()*s2.size());
          s1.add(in,v);
          s2.add(in,v);
        }
      }

      if(testID == 4 ){
        s1.add("1");
        s2.add("1");
        try{
          s1.set(0,"");
        } catch(UnsupportedOperationException e){

        }
      }

      if(testID == 5 ){
        try{
          s1.set(0,"");
        } catch(UnsupportedOperationException e){

        }
      }

      if(testID == 6 ){
        String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
        s1 = new OrderedSuperArray(x);
        s2.addAll(Arrays.asList(x));
      }
      if(testID == 7 ){
        s1.add("1");
        s2.add("1");

        for(int i = 0; i < 1000;   i ++){
          String v = ""+(int)(Math.random()*1000);
          s1.add(v);
          s2.add(v);
        }
      }


    }catch(Exception f){
      s2.add("0");
      f.printStackTrace();
    }

    Collections.sort(s2);
    if(equals(s1,s2)){
      System.out.println("Test "+testID+",PASS");
    }else{
      System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
    }
  }
  public static void main(String[] args){
    for(int i =1;i < 8; i++){
      runTest02(i);
    }
  }
}

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
    if (indexOf(element) != 99){
      return indexOf(element);
    }
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
    int start = 0;
    int end = size() - 1;
    for(int i = log2(size());i > 0;i--){
	    if(get(start + ((end - start) / 2)).compareTo(element) > 0){
        if(get(start + ((end - start) / 2) - 1).compareTo(element) <= 0) {
          return start + ((end - start) / 2);
        }
        else {
          end = start + ((end - start) / 2) - 1;
        }
      }
	    else if(get(start + ((end - start) / 2)).compareTo(element) < 0){
        if(get(start + ((end - start) / 2) + 1).compareTo(element) >= 0){
          return start + ((end - start) / 2) + 1;
        }
        else{
          start = start + ((end - start) / 2) + 1;
        }
      }
    }
    return 0;
  }
}

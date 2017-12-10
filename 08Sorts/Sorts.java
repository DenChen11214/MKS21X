import java.util.*;
public class Sorts{
  public static String name(){
    return "09.Chen.Dennis";
  }
  public static void selectionSort(int[] ary){
    for(int i = 0;i< ary.length;i++){
      int minIndex = 0;
      int min = ary[i];
      int temp = ary[i];
      for(int n = i;n < ary.length;n++){
        if(ary[n] <= min){
          min = ary[n];
          minIndex = n;
        }

      }
      ary[i] = min;
      ary[minIndex] = temp;
      System.out.println(ary[minIndex]);
    }
  }
  public static boolean isSorted(int[] ary){
    for(int i = 0;i < ary.length - 1;i++){
      if(ary[i] > ary[i + 1]){
        return false;
      }
    }
    return true;
  }
  public static boolean isEqual(int[] ary1, int[] ary2){
    if(ary1.length != ary2.length){
      return false;
    }
    for(int i = 0; i < ary1.length;i++){
      if(ary1[i] != ary2[i]) {
        return false;
      }
    }
    return true;
  }
  public static void insertionSort(int[] ary){
    for(int i = 1;i < ary.length;i++){
      for(int n = i - 1;n >= 0 ; n--){
        int temp = ary[n];
        if(ary[n + 1] < temp){
          ary[n] = ary[n + 1];
          ary[n + 1] = temp;
        }
      }
    }
  }
  public static void bubbleSort(int[] ary){
    int arylength = ary.length;
    for(int i = 0;i < ary.length - 1;i ++){
      int swap = 0;
      for(int n = 0;n < arylength - 1;n ++){
        int temp = ary[n];
        if(ary[n] >= ary[n + 1]){
          ary[n] = ary[n + 1];
          ary[n + 1] = temp;
          swap ++;
        }
      }
      if(swap == 0){
        return;
      }
      arylength--;
    }
  }
  public static void main(String[] args){
    int[] arry = {65,25,12,22,11};
    int[] arry2 = {65,25,12,25,12};
    bubbleSort(arry);
    System.out.println(Arrays.toString(arry));
    bubbleSort(arry2);
    System.out.println(Arrays.toString(arry2));
    insertionSort(arry);
    System.out.println(Arrays.toString(arry));
    insertionSort(arry2);
    System.out.println(Arrays.toString(arry2));
  }
}

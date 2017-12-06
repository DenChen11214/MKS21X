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
  public static void main(String[] args){
    int[] arry = {65,25,12,22,11};
    int[] arry2 = {65,25,12,25,12};
    selectionSort(arry);
    System.out.println(Arrays.toString(arry));
    selectionSort(arry2);
    System.out.println(Arrays.toString(arry2));
    insertionSort(arry);
    System.out.println(Arrays.toString(arry));
    insertionSort(arry2);
    System.out.println(Arrays.toString(arry2));
  }
}

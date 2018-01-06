import java.util.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;
  public Barcode(String zip){
    String ints = "0123456789";
    if (zip.length() != 5){
      throw new IllegalArgumentException();
    }
    for(int i = 0; i < zip.length(); i++){
      if(!ints.contains(zip.substring(i,i+1))){
        throw new IllegalArgumentException();
      }
    }
    this.zip = zip;
    
  }
  public static String toCode(String zip){
    String ints = "0123456789";
    String[] digitBarcode = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    int checkDigit = 0;
    String barcode = "|";
    if (zip.length() != 5){
      throw new IllegalArgumentException();
    }
    for(int i = 0; i < zip.length(); i++){
      if(!ints.contains(zip.substring(i,i+1))){
        throw new IllegalArgumentException();
      }
    }
    for(int i = 0; i < digitBarcode.length; i++){
      for(int n = 0;n < zip.length();n++){
        if(zip.substring(n,n+1).equals(Integer.toString(i))){
          barcode += digitBarcode[i];
          checkDigit += i;
        }
      }
    }
    checkDigit = checkDigit % 10;
    barcode += digitBarcode[checkDigit] + "|";
    return barcode;
  }
  public static String toZip(String code){
    String[] digitBarcode = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    List<String> list = Arrays.asList(digitBarcode);
    String zip = "";
    int check = 0;
    int checkDigit = 0;
    if(code.length()!= 32 ||  
       (code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|')){
      throw new IllegalArgumentException();
    }
    for(int i = 0; i < code.length(); i++){
      if(code.charAt(i) != ':' &&  code.charAt(i) != '|'){
        throw new IllegalArgumentException();
      }
    }
    for(int i =1;i< code.length() - 1;i +=5){
      if(!list.contains(code.substring(i, i + 5))){
        throw new IllegalArgumentException();
      }
      for(int n = 0; n < digitBarcode.length; n ++){
        if(code.substring(i,i+5).equals(digitBarcode[n]) 
           && i < code.length() -6){
          checkDigit += n;
          zip += Integer.toString(n);
        }
      }
    }
    checkDigit = checkDigit % 10;
    if(!digitBarcode[checkDigit].equals(code.substring(code.length() - 6,code.length()- 1))){
      throw new IllegalArgumentException();
    }
    return zip;
  }
  public String getZip(){
    return zip;
  }
  public String getCode(){
    return toCode(getZip());
  }
  public int compareTo(Barcode other){
    return getZip().compareTo(other.getZip());
  }
  public String toString(){
    String str = "";
    str += getCode() + "(" + getZip() + ")";
    return str;
  }
  public static void main(String[] args){
    String[]badBarcodes = {"|||:::||:::||:::||:::||:::||:::",
      "|||:::||:::||:::||:::||:::||:::||||",
      "|||:::||:::||:::||:::||:::||::::",
      ":||:::||:::||:::||:::||:::||:::|",
      "||:|::||z::|:|::||::f:::|||:|::|",
      "|:::||||:::a::||||::::::||::||:|",
      "|||:::||:::||:::||:::||::::::|||"};
    String[] badZips = {"9012","000000","12x34"};
    //Barcode a = new Barcode(badZips[0]);
    // Barcode b = new Barcode(badZips[1]);
    //Barcode c = new Barcode(badZips[2]);
    //System.out.println(toZip(badBarcodes[0]));
    //System.out.println(toZip(badBarcodes[1]));
    //System.out.println(toZip(badBarcodes[2]));
    //System.out.println(toZip(badBarcodes[3]));
    //System.out.println(toZip(badBarcodes[4]));
    //System.out.println(toZip(badBarcodes[5]));
    //System.out.println(toZip(badBarcodes[6]));
  }
}

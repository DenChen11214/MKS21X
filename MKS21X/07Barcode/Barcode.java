public class Barcode{
  private String zip;
  public Barcode(String zip){
    this.zip = zip;
    toCode(zip);
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
  public static void main(String[] args){
    Barcode bar = new Barcode("12345");
    System.out.println(toCode("12345"));
    //System.out.println(toCode("123"));
    System.out.println(toCode("132ba"));    
  }
}

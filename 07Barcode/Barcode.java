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
  public static String toZip(String code){
    String[] digitBarcode = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    String zip = "";
    int check = 0;
    int checkDigit = 0;
    if(code.length()!= 32 ||  
       (code.charAt(0) != '|' && code.charAt(code.length() - 1) != '|')){
      throw new IllegalArgumentException();
    }
    for(int i =1;i< code.length() - 6;i +=5){
      for(int n = 0; n < digitBarcode.length; n ++){
        if(!code.substring(i, i + 5).equals(digitBarcode[n])){
          check ++;
        }
        if(code.substring(i,i+5).equals(digitBarcode[n]) 
           && i < code.length() -6){
          checkDigit += n;
          zip += Integer.toString(n);
        }
      }
    }
    if(check == 60){
      throw new IllegalArgumentException();    
    }
    for(int i = 0; i < code.length(); i++){
      if(code.charAt(i) != ':' &&  code.charAt(i) != '|'){
        throw new IllegalArgumentException();
      }
    }
    checkDigit = checkDigit % 10;
    System.out.println(checkDigit);
    if(!digitBarcode[checkDigit].equals(code.substring(code.length() - 6,code.length()- 1))){
      throw new IllegalArgumentException();
    }
    return zip;


}

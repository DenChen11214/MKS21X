public class ReversedCharSequence implements CharSequence{
  private String chars;
  public ReversedCharSequence(String characters){
    String reverse = "";
    for(int i = characters.length();i > 0;i--){
	    reverse += characters.charAt(i - 1);
    }
    chars = reverse;
  }
  public char charAt(int index){
    return chars.charAt(index);
  }
  public int length(){
    return chars.length();
  }
  public CharSequence subSequence(int start, int end){
    return chars.substring(start,end);
  }
  public String toString(){
    String reverse = "";
    for(int i = 0; i < chars.length();i++){
      reverse += chars.charAt(i);
    }
    return reverse;
  }
}

public class ReversedCharSeq implements CharSequence{
   private String data;

    public ReversedCharSeq(String s){
	data = s;
	String data2 = "";
	for(int i = data.length() - 1;i >= 0; i--){
	    data2 += data.charAt(i);
	}
	data = data2;
 }


    public char charAt(int index){
	return data.charAt(index);
    }

    
    public int length(){
	return data.length();
    }

    public String toString(){
	return data;
    }

    public String subSequence(int start, int end){
	String result = "";
	for(int i = start;i < end; i ++){
	    result += data.charAt(i);
	}
	return result;
    }
}


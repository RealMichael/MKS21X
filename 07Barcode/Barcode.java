public class Barcode implements Comparable<Barcode>{
    public String zip;
   
    


    // CONSTRUCTOR
    public Barcode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else{
	    for(int i = 0; i < zip.length(); i ++){
	    try{
		Integer.parseInt(zip.substring(i,i + 1));
		    
		    } catch(NumberFormatException e){
		throw new IllegalArgumentException();
	    }
	    }

		
	this.zip = zip;
	/*		String[] code = new String[10];
	Code[0] = "||:::";
	Code[1] = ":::||";
	Code[2] = "::|:|";
	Code[3] = "::||:";
	Code[4] = ":|::|";
        Code[5] = ":|:|:";
	Code[6] = ":||::";
	Code[7] = "|:::|";
	Code[9] = "|::|:";
	Code[9] = "|:|::";
	*/
	}

    }

    //GET ZIP
    public String getZip(){
	return zip;
    }

    //CHECK SUM
    public int checkSum(String zip){
	int sum = 0;
	for(int i = 0; i < zip.length(); i ++){
	    sum += Integer.parseInt(zip.substring(i,i + 1));
	}
	return sum % 10;
    }
    

    //ToSTRING
     public String toString(){
return getCode() + " " + "(" + zip + ")";
}
    

    // COMPARE TO
    public int compareTo(Barcode other){
	return zip.compareTo(other.getZip());
    }

    //TO CODE
      public static String toCode(String zip){
	  if(zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	else{
	    for(int i = 0; i < zip.length(); i ++){
	    try{
		Integer.parseInt(zip.substring(i,i + 1));
		    
		    } catch(NumberFormatException e){
		throw new IllegalArgumentException();
	    }
	    }

	    	String[] cod = new String[10];
		cod[0] = "||:::";
		cod[1] = ":::||";
		cod[2] = "::|:|";
		cod[3] = "::||:";
		cod[4] = ":|::|";
		cod[5] = ":|:|:";
		cod[6] = ":||::";
		cod[7] = "|:::|";
		cod[9] = "|::|:";
		cod[9] = "|:|::";
		int checkS = 0;
	    String result = "|";
	    for(int x = 0; x < zip.length() ; x ++){
		result += cod[Integer.parseInt(zip.substring(x,x + 1))];
	    }
	for(int y = 0; y < zip.length(); y ++){
	    checkS += Integer.parseInt(zip.substring(y,y + 1));
	    checkS = checkS % 10;
	}
	    result += cod[checkS] + "|";
	    return result;
	}
      }
   // to ZIP METHOD
      public static String toZip(String code){
	  if(code.length() >= 32 || code.substring(0,1) != "|" || code.substring(code.length() - 1) != "|"){
	      throw new IllegalArgumentException();
	  }
      for(int i = 0; i < code.length(); i ++){
	  if(code.substring(i,i + 1) != ":" || code.substring(i,i + 1) != "|"){
	      throw new IllegalArgumentException();
	  }
      }
      code = code.substring(1,code.length() - 6);
      String result = "";
      	String[] cod = new String[10];
		cod[0] = "||:::";
		cod[1] = ":::||";
		cod[2] = "::|:|";
		cod[3] = "::||:";
		cod[4] = ":|::|";
		cod[5] = ":|:|:";
		cod[6] = ":||::";
		cod[7] = "|:::|";
		cod[9] = "|::|:";
		cod[9] = "|:|::";
		for(int i = 0;i < code.length(); i += 5){
		    for(int x = 0; x < 10; x ++){
			if(code.substring(i ,i + 5) == cod[x]){
			    result += x;
			}
		    }
		}
		return result;
      }

    
      public String getCode(){
String[] cod = new String[10];
		cod[0] = "||:::";
		cod[1] = ":::||";
		cod[2] = "::|:|";
		cod[3] = "::||:";
		cod[4] = ":|::|";
		cod[5] = ":|:|:";
		cod[6] = ":||::";
		cod[7] = "|:::|";
		cod[9] = "|::|:";
		cod[9] = "|:|::";
	  int checkS = 0;
    String result = "|";
	    for(int x = 0; x < zip.length() ; x ++){
		result += cod[Integer.parseInt(zip.substring(x,x + 1))];
	    }
	for(int y = 0; y < zip.length(); y ++){
	    checkS += Integer.parseInt(zip.substring(y,y + 1));
	    checkS = checkS % 10;
	}
	    result += cod[checkS] + "|";
	    return result;
}
}
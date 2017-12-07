import java.util.Arrays;
public class Sorts{

    public static String name(){
	return "01.Luo.Michael";
    }
    public static void selectionSort(int[] data){

	int temp = 0;
	for(int i = 1;i < data.length;i ++){
	    temp = data[i];
	   
	    for(int x = i;x >  0; x --){
		if(data[x] < data[x - 1]){
		    data[x] = data[x - 1];
		    data[x - 1] = temp;
		}
	    }
	}
    }
		
	    
	      
	    	
		
	
    



    public static void main(String[]artie){                                         
        int[] randish = new int[15];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                    
                                             
                                                                                    
        System.out.println(Arrays.toString(randish));                               
              selectionSort(randish);                                                  
        System.out.println(Arrays.toString(randish));           

	    
    }
}
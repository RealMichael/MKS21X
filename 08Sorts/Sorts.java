import java.util.Arrays;
public class Sorts{

    public static String name(){
	return "10.Luo.Michael";
    }

    //INSERTION
    public static void insertionSort(int[] data){

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
    
    //SELECTION

    public static void selectionSort(int[] data){
	int temp = 0;
	int min = 0;
	int minSpot = 0;
	for(int i = 0;i < data.length; i ++){
	    temp = data[i];
	    min = data[i];
	    for(int x = i + 1; x < data.length; x ++){
		if(data[x] < min){
		    min = data[x];
		    minSpot = x;
		}
	    }
	    if(min < data[i]){
		data[i] = min;
		data[minSpot] = temp;
	    }
	}
    }
	    
    // BUBBLE BULBASAUR-T
    public static void bubbleSort(int[] data){
	int checks = data.length - 1;
	int temp = 0;
       	while(checks >= 0){
	    for(int i = 0; i < checks ; i ++){
		temp = data[i];
		if(data[i] > data[i + 1]){
		    data[i] = data[i + 1];
		    data[i + 1] = temp;
		}
	    }
	    checks --;
	}
    }
		    
	    




	      
	    	
		
	
    



    public static void main(String[]artie){                                         
        int[] randish = new int[15];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                    
                                             
                                                                                    
        System.out.println(Arrays.toString(randish));                               
              bubbleSort(randish);                                                  
        System.out.println(Arrays.toString(randish));           

	    
    }
}
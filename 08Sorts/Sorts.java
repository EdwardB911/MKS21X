import java.util.Arrays;                                                            

public class Sorts{                                                                 
                                                                        

    public static String name(){                                                    

        return "01.Bukhman.Edward";                                                  

    }                                                                               
                                                                        

    public static boolean isSorted(int[]ary){                                       

        for(int i = 0; i < ary.length - 1 ; i++){                                   

            if(ary[i] > ary[i+1]){                                                  

                return false;                                                       

            }                                                                       

        }                                                                           

        return true;                                                                

    }                                                                               
                                   

    public static void bogoSort(int[] ary){                                         

        while(!isSorted(ary)){                                                      

            for(int i = 0 ; i < ary.length; i++){                                   

                int temp = ary[i];                                                  

                int newSpot = (int)(Math.random()*ary.length);                      

                ary[i] = ary[newSpot];                                              

                ary[newSpot] = temp;                                                

            }                                                                       

        }                                                                           

    }                                                                               
                                                                                   

    private static void swap(int[]ary,int a, int b){                                

        int c =ary[a];                                                              

        ary[a] = ary[b];                                                            

        ary[b] = c;                                                                 

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

    public static void selectionSort(int[] ary){
	for(int start = 0; start < ary.length; start++ ){
	    for(int x = start; x < ary.length; x++){
		if(ary[x] < ary[start]){
		    swap(ary, x, start);
		}
	    }
	}
    }

    

    public static void insertionSort(int[] ary){
	for(int x = 1; x < ary.length; x++){
	    for (int y = x; y > 0; y--){
		if(ary[y] < ary[y-1]){
		    swap(ary, y-1, y);
		}
	    }
	}
    }

    public static void bubbleSort(int[] ary){
	for(int x = 0; x < ary.length - 1; x++){
	    boolean noswaps = true;
	    for(int y = 0; y < ary.length - 1; y++){
		if(ary[y] > ary[y+1]){
		    swap(ary, y, y+1);
		    noswaps = false;
		}
	    }
	    if(noswaps){
		x = ary.length;
	    }
	}
    }
		

    
			
		    
		
	    
	
}

import java.util.*;
import java.io.*;


public class fop {
    public static void main(String[] args) throws Exception{ 
        Scanner loginput=new Scanner(new File("C:\\UM\\Fundamental of programming\\extracted_log"));
        int createdNum=0,endedNum=0;
        String startTime,endTime;
        boolean one=true,end=false,found=false;
        
        Scanner userInput=new Scanner(System.in);
        System.out.println("Please enter the starting time:");
        startTime=userInput.nextLine();
        System.out.println("Please enter the ended time:");
        endTime=userInput.nextLine();
        
        
        //Finding number of job created and ended
        while(loginput.hasNextLine() && !found){
            String line=loginput.nextLine();
            String[] lineArray=line.split(" ");
            
                if(lineArray[0].contains(startTime)){
 
                  while(!end){
                      
                   while(one){   
                    for(int i=0;i<lineArray.length;i++){
                        if(lineArray[i].contains("Allocate")){   //
                            createdNum++;
                        }   
                        if(lineArray[i].contains("done")){
                            endedNum++;
                        } 
                     }
                    
                       one=false;
                    }
                   
                    String line2=loginput.nextLine();
                    String[] lineArray2=line2.split(" ");
                    for(int i=0;i<lineArray2.length;i++){
                        
                       if(lineArray2[0].contains(endTime)){
                           end=true;
                           break;
                       }
                       if(lineArray2[i].contains("Allocate")){
                           createdNum++;
                       } 
                       if(lineArray2[i].contains("done")){
                            endedNum++;
                        } 
                   }
                    
                    
                  }
                  found=true;
             }
                
            }
        
        System.out.println("Number of jobs created:"+createdNum);
        System.out.println("Number of jobs ended:"+endedNum);
        }
        
       
    }


import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class fop {
    public void jobCreatedEnded() throws Exception{ 
         Scanner loginput=new Scanner(new File("C:\\UM\\Fundamental of programming\\extracted_log"));
        int createdNum=0,endedNum=0;
        boolean found=false;
        
        Scanner userInput=new Scanner(System.in);
        System.out.println("Please enter a time range (Example:2022-06-01 to 2022-12-16):");
        String range = userInput.nextLine();     //get user input
                
        LocalDate startDate = LocalDate.parse(range.split("to")[0].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));  //split the start date
        LocalDate endDate = LocalDate.parse(range.split("to")[1].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));     //split the enddate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");          //format for the string to convert to local date
        int day_Count = 0;
        String line;           
        String[] lineArray = null;
        
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)){
            String dateString = date.format(formatter);   //"2022-06-01"
            
            while(!found){                         //finding the starting date
              line=loginput.nextLine();         //read logfile
              lineArray=line.split(" ");  //string array
              if(lineArray[0].contains(dateString)){
                  found=true;                 //stop finding starting date
              }
            }
            
            while(lineArray[0].contains(dateString)){   //check for date
                            
                for(int i=0;i<lineArray.length;i++){        //loop through string array
                        if(lineArray[i].contains("Allocate")){   //find created job
                            createdNum++;                           
                        }   
                        if(lineArray[i].contains("done")){       //find ended job
                            endedNum++;
                        } 
                     }
                if(loginput.hasNextLine()){           //check if reaching the end of the file
                  line=loginput.nextLine();           //read logfile again
                  lineArray=line.split(" "); 
                }else{    
                    break;
                }
                
                
            }
            
            
             day_Count++;
    }
        System.out.println("Numbers of job created:"+createdNum);
        System.out.println("Numbers of job ended:"+endedNum);
        }
        
       
    }

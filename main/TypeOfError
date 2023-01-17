
import java.io.File;
import java.util.*;

public class TypeOfError {
     public void getTypeOfError() throws Exception{ 
        Scanner loginput=new Scanner(new File("C:\\UM\\Fundamental of programming\\extracted_log"));
        ArrayList<String> errorGroup=new ArrayList<>();
        ArrayList<Integer> errorGroupNum=new ArrayList<>();
        
       
        
         while(loginput.hasNextLine()){
            String line=loginput.nextLine();
  
                if(line.contains("error")){
                    String[] lineArray=line.split("error");
                    if(!errorGroup.contains(lineArray[1])){    //check if error is exist in the error list
                       errorGroup.add(lineArray[1]);          //add error into error list
                        errorGroupNum.add(1);               //time of new found error occur +1
                    }
                    else{
                     for(int j=0;j<errorGroup.size();j++){    //loop through error list
                        String test=errorGroup.get(j);
                        
                        if(lineArray[1].equals(test)){  //if detect error already exist in error list
                            errorGroupNum.set(j, errorGroupNum.get(j)+1); //time of error occur +1
 
                        }
                        
                    }
                    }
                }
            }
        
          //
          
           ArrayList<String> newErrorGroup=new ArrayList<>();
           ArrayList<Integer> newErrorGroupNum=new ArrayList<>();
           
           //add type of error manually into newErrorGroup List
           newErrorGroup.add("This association does not have access to qos long");
           newErrorGroupNum.add(0);
           newErrorGroup.add("This association does not have access to qos normal");
           newErrorGroupNum.add(0);
           newErrorGroup.add("Security violation, REQUEST_KILL_JOB RPC");
           newErrorGroupNum.add(0);
           newErrorGroup.add("_find_node_record: lookup failure for node");
           newErrorGroupNum.add(0);
           newErrorGroup.add("node_name2bitmap: invalid node specified");
           newErrorGroupNum.add(0);
           newErrorGroup.add("_handle_assoc_tres_run_secs");
           newErrorGroupNum.add(0);
           newErrorGroup.add("Zero Bytes were transmitted or received");
           newErrorGroupNum.add(0);
           newErrorGroup.add("Node appears to have a different slurm.conf than the slurmctld");
           newErrorGroupNum.add(0);
           newErrorGroup.add("Socket timed out on send/recv operation");
           newErrorGroupNum.add(0);
           newErrorGroup.add("job_epilog_complete");
           newErrorGroupNum.add(0);
           newErrorGroup.add("Nodes not responding");
           newErrorGroupNum.add(0);
           newErrorGroup.add("Registered PENDING");
           newErrorGroupNum.add(0);
          
           //counting number of manually added error from errorGroup List and remove it from errorGroup List
          for(int i=0;i<errorGroup.size();i++){          //loop through errorGroup List
              String test=errorGroup.get(i);
              if(test.contains("association")&& test.contains("long")){
                 
                  newErrorGroupNum.set(0,errorGroupNum.get(i)+ newErrorGroupNum.get(0));
                 
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("association")&& test.contains("normal")){
                  
                  newErrorGroupNum.set(1,errorGroupNum.get(i)+ newErrorGroupNum.get(1));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("REQUEST_KILL_JOB")){
                  
                  newErrorGroupNum.set(2,errorGroupNum.get(i)+ newErrorGroupNum.get(2));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("_find_node_record")){
                  
                  newErrorGroupNum.set(3,errorGroupNum.get(i)+ newErrorGroupNum.get(3));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("node_name2bitmap")){
                  
                  newErrorGroupNum.set(4,errorGroupNum.get(i)+ newErrorGroupNum.get(4));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("_handle_assoc_tres_run_secs")){
                  
                  newErrorGroupNum.set(5,errorGroupNum.get(i)+ newErrorGroupNum.get(5));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("Zero Bytes were transmitted or received")){
                  
                  newErrorGroupNum.set(6,errorGroupNum.get(i)+ newErrorGroupNum.get(6));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("appears to have a different slurm.conf than the slurmctld")){
                  
                  newErrorGroupNum.set(7,errorGroupNum.get(i)+ newErrorGroupNum.get(7));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("Socket timed out")){
                  
                  newErrorGroupNum.set(8,errorGroupNum.get(i)+ newErrorGroupNum.get(8));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("job_epilog_complete")){
                  
                  newErrorGroupNum.set(9,errorGroupNum.get(i)+ newErrorGroupNum.get(9));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("not responding")){
                  
                  newErrorGroupNum.set(10,errorGroupNum.get(i)+ newErrorGroupNum.get(10));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              else if(test.contains("Registered PENDING")){
                  
                  newErrorGroupNum.set(11,errorGroupNum.get(i)+ newErrorGroupNum.get(11));
                  errorGroup.remove(i);
                  errorGroupNum.remove(i);
                  i--;
              }
              
          }
         //printing output from newErrorGroup List
        
            for(int i=0;i<newErrorGroup.size();i++){
              String test2=newErrorGroup.get(i);
              System.out.println(test2+": "+newErrorGroupNum.get(i));
          }
            
         //printing output from errorGroup List
            
            for(int i=0;i<errorGroup.size();i++){
              String test2=errorGroup.get(i);
              String[] test3=test2.split(" ");
              for(int j=1;j<test3.length;j++){
              System.out.print(test3[j]+" ");
              }
              System.out.println(": "+errorGroupNum.get(i));
          }

         }

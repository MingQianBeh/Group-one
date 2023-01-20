
import java.io.File;
import java.util.*;


public class fop2 {
    
    
    public void getAllPartition() throws Exception{ 
        Scanner loginput=new Scanner(new File("C:\\UM\\Fundamental of programming\\extracted_log"));
        ArrayList<String> partitionGroup=new ArrayList<>();
        ArrayList<Integer> partitionGroupNum=new ArrayList<>();
        
        
        
        while(loginput.hasNextLine()){
            String line=loginput.nextLine();
            String[] lineArray=line.split(" ");
            for(int i=0;i<lineArray.length;i++){
                if(lineArray[i].contains("Partition")){
                    if(!partitionGroup.contains(lineArray[i])){
                       partitionGroup.add(lineArray[i]);
                        partitionGroupNum.add(1);
                    }
                    else{
                     for(int j=0;j<partitionGroup.size();j++){
                        String test=partitionGroup.get(j);
                        
                        if(lineArray[i].equals(test)){
                            partitionGroupNum.set(j, partitionGroupNum.get(j)+1);
                           
                        
                        }
                        
                    }
                    }
                }
            }
            
        }
        System.out.println("Number of jobs by partitions:");
        for(int i=0;i<partitionGroup.size();i++){
            String hold=partitionGroup.get(i);
            String[] hold2=hold.split("=");
            System.out.print(hold2[1]+": "+partitionGroupNum.get(i));
            System.out.println();
        }
    }
}  

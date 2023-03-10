import java.util.*;


public class MainClass {
    public static void main(String[] args)throws Exception{
        
        //class object
        fop fopIns=new fop();
        fop2 fop2Ins=new fop2();
        TypeOfError TypeOfErrorIns=new TypeOfError();
        error errorIns=new error();
        TimeFrame TimeFrameIns=new TimeFrame();
        logProcessor logProcessorIns =new logProcessor();
        
        //Scanner and variable
        Scanner input=new Scanner(System.in);
        boolean invalid=false;
        
        
        //printing interface
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("                   Welcome to System analysis");
        
        while(true){
            System.out.println("");
            System.out.println("");
            System.out.println("--------------------------------------------------------------");
            System.out.println("List");
            System.out.println("");
            System.out.println("1.Number of jobs created/ended within a given time range");
            System.out.println("2.Number of jobs by partitions");
            System.out.println("3.All type of errors exist");
            System.out.println("4.Detail of error: association does not have access to qos long/normal");
            System.out.println("5.Date of jobs allocated and ended within a given time range");
            System.out.println("6.Execution time of each job submitted to UMHPC and average execution time.");
            System.out.println("Please enter the corresponding number to access corresponding data(Enter '0' to quit):");
            System.out.print("---->");
            
             int userInput=input.nextInt();     //get user input
             
              if(userInput==0){                 //stop the program if user enter '0'
                 break;
             }
              
             
             System.out.println("");
             System.out.println("Result:");
             System.out.println("");
            
             
             
            
             if(userInput==1){
                 fopIns.jobCreatedEnded();
             }
             else if(userInput==2){
                 fop2Ins.getAllPartition();
             }
             else if(userInput==3){
                 TypeOfErrorIns.getTypeOfError();
             }
             else if(userInput==4){
                 errorIns.getLongOrNormal();
             }
              else if(userInput==5){
                 TimeFrameIns.getTimeFrame();
             }
              else if(userInput==6){
                 logProcessorIns.getExecutionTime();
             }
             else{
                 System.out.println("Please enter a valid number....");
             }
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("Thank you for using our system!");
        System.out.println("--------------------------------------------------------------");
        
            
    }
}

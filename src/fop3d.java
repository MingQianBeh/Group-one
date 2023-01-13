import java.io.File;
import java.util.*;


public class fop3d {
    public static void main(String[] args) throws Exception {
        Scanner loginput = new Scanner(new File("C:\\UM\\Fundamental of programming\\extracted_log"));

        int totalJobDuration = 0;
        String usec = "usec";

        boolean found = false;
        while (loginput.hasNextLine() && !found) {
            String line = loginput.nextLine();
            String[] lineArray = line.split(" ");
            String time = lineArray[3];

            if ((time.substring(0, 5)).equals("usec=")) {
                int jobDuration = Integer.parseInt(time.substring(5));
                totalJobDuration += jobDuration;
            }

            int AverageJobDuration = totalJobDuration / createdNum; //createdNum from question 3a in fop.java
            System.out.println("Average execution time of the jobs submitted to UMHPC: " + AverageJobDuration);
        }
    }
}


/*
    public class Main{
        public static void main(String[] args)throws Exception{
            String s="[2022-06-01T09:16:23.166]_slurm_rpc_submit_batch_job: JobId=42808 InitPrio=20861 usec=331";
            String[] line = s.split(" ");
            String find = line[3];
            System.out.println(find.substring(0,5));
            if (find.substring(0,5).equals("usec=")){
                System.out.println("Found");
            }else{
                System.out.println("bla");
            }
            int time = Integer.parseInt(line[3].substring(5));
            System.out.println(time);
            int sum = 5;
            System.out.println(sum+time);

            int a = 3;
            while (a>0){
                if(a == 1){
                    System.out.println("yeah");
                    a--;


            }
        }
    }

*/
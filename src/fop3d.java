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


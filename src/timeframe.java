import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class timeframe {
    public LinkedHashMap<String, Date[]> time_Difference = new LinkedHashMap<>();
    public String start_date;

    Pattern pattern = Pattern.compile("\\[(?<date>\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\]");

    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    //[2022-06-12T15:59:33.152] sched: Allocate JobId=43532 NodeList=gpu04 #CPUs=12 Partition=gpu-k40c
    //[2022-06-12T15:59:47.504] _job_complete: JobId=43532 done

    public void DisplayTime() throws IOException, ParseException {
        Scanner input_1 = new Scanner(System.in);
        System.out.println("Enter the start date(YYYY-MM-DD): ");               //in the form of YYYY-MM-DD and then need to convert to the format
        String start_Date = modifydate(input_1.nextLine());
        System.out.println("Enter the End date(YYYY-MM-DD): ");
        String end_Date = modifydate(input_1.nextLine());
        BufferedReader input = new BufferedReader(new FileReader("C:/Users/User/Desktop/Courses/FOP assignment/extracted_log (1)"));
        String line;
        while ((line = input.readLine()) != null) {   // read line by line
            Matcher matcher = pattern.matcher(line);       //regex that match [(?<date>\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}\.\d{3})
            Date array[] = new Date[2];                    //Date array to store
            if (line.contains("Allocate JobId") && matcher.find()) { //line that contains that word
                String[] array_line = line.split(" ");
                String date = matcher.group("date");    //date in the form of yyyy-MM-dd'T'HH:mm:ss.SSS
                Date date_up = sdf.parse(date);//convert to Date


                if (date_up.after(sdf.parse(start_Date)) && date_up.before(sdf.parse(end_Date))) {
                    String x = null;
                    for (int i = 0; i < array_line.length; i++) {
                        if (array_line[i].contains("JobId=")) {
                            String[] array_equal = array_line[i].split("=");
                            x = array_equal[1];
                        }
                    }
                    array[0] = date_up;
                    time_Difference.put(x, array);


                }
            } if (line.contains("done") && matcher.find()) {
                String[] array_line = line.split(" ");       //convert and settle date first only can compare range
                String date = matcher.group("date");
                Date date_up = sdf.parse(date);

                if (date_up.after(sdf.parse(start_Date)) && date_up.before(sdf.parse(end_Date))) {
                    String x = null;
                    for (int i = 0; i < array_line.length; i++) {
                        if (array_line[i].contains("JobId=")) {
                            String[] array_equal = array_line[i].split("=");
                            x = array_equal[1];

                        }
                    }
                    if (time_Difference.containsKey(x)) {
                        time_Difference.get(x)[1] = date_up;
                    } else {
                        array[1] = date_up;
                        time_Difference.put(x, array);
                    }


                }


            }


        }
        for(String key : time_Difference.keySet()){
            System.out.println(key+"\t"+time_Difference.get(key)[0]+"\t"+time_Difference.get(key)[1]);
        }

        }
    public String modifydate (String start_date){
        if (!start_date.contains("T")) {
            start_date += "T";
        }if (start_date.length() == 11) {
            start_date += "00:00:00.000";
        }
        return start_date;

    }

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("JobID\t\tStart Time Stamp\t\tEnd Time Stamp");
        timeframe q = new timeframe();
        q.DisplayTime();
    }

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class executionTime {
    protected LinkedHashMap<String, Long> Start_time = new LinkedHashMap<>();              //create hashmap
    protected LinkedHashMap<String, Long> End_time = new LinkedHashMap<>();
    protected LinkedHashMap<String, Long> Time_difference = new LinkedHashMap<>();
    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    protected Pattern pattern = Pattern.compile("\\[(?<date>\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3})]");
    protected Pattern pattern1 = Pattern.compile(" _slurm_rpc_submit_batch_job: JobId=(\\d+)");                             //regex for job id
    protected Pattern pattern2 = Pattern.compile(" _slurm_rpc_submit_batch_job: ");           //regex for job start                      //regex for JobID
    protected Pattern pattern3 = Pattern.compile("done");                                     //regex for job end
    protected Pattern pattern4 = Pattern.compile("JobId=(\\d+) done");

    public executionTime() {

    }

    public LinkedHashMap<String, Long> processLog(String fileName) throws IOException, ParseException, IOException {           //constructor for read
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = input.readLine()) != null) {
            Matcher dateTime = this.pattern.matcher(line);
            Matcher id = this.pattern1.matcher(line);
            Matcher start = this.pattern2.matcher(line);
            Matcher end = this.pattern3.matcher(line);
            Matcher id2 = this.pattern4.matcher(line);

            if ((dateTime.find() && start.find())) {
                String date = dateTime.group("date");
                Date Start_Date = this.sdf.parse(date);
                Long Start_time_job = Start_Date.getTime();
                String job_ID = id.group(1);
                Start_time.put(job_ID, Start_time_job);

            } else if ((dateTime.find() && end.find())) {
                String date = dateTime.group("date");
                Date End_Date = this.sdf.parse(date);
                Long End_time_job = End_Date.getTime();
                String job_ID = id2.group(0);
                End_time.put(job_ID, End_time_job);
            }
        }
        for (String key : Start_time.keySet()) {
            if (this.End_time.containsKey(key)) {
                this.Time_difference.put(key, this.End_time.get(key) - this.Start_time.get(key));
                System.out.println(this.Time_difference.get(key) +"\t" + key);
            } else {
                continue;
            }
        }
        return this.Time_difference;
    }

    public static void main(String[] args) throws IOException, ParseException {
        executionTime x = new executionTime();
        LinkedHashMap<String, Long> query = x.processLog("C:\\Users\\User\\IdeaProjects\\w3exercise\\extracted_log");
        for(String key: query.keySet()){
            System.out.println(query.get(key));
        }


    }



}




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//[2022-06-01T15:30:18.119] error: This association 201(account='free', user='liew.wei.shiung', partition='(null)') does not have access to qos long

public class error {
    // hello
    protected LinkedHashMap<String,String> Long_error = new LinkedHashMap<>();                  //Linked Hashmap

    protected LinkedHashMap<String, String> Normal_error = new LinkedHashMap<>();

    protected LinkedHashMap<String,String> Campur_error = new LinkedHashMap<>();

    protected LinkedHashMap<String, Integer> occurence = new LinkedHashMap<>();

    protected Pattern pattern = Pattern.compile("long");
    protected Pattern pattern2 = Pattern.compile("normal");

    protected Pattern pattern1 = Pattern.compile("(user=')(.*)(', partition=')");


    public LinkedHashMap<String,String> Long_Process(String file) throws IOException {
        String line;
        BufferedReader input = new BufferedReader(new FileReader(file));
        while ((line = input.readLine()) != null) {             //Read line by line
            Matcher q = pattern.matcher(line);                   //matcher for long
            Matcher w = pattern1.matcher(line);                    //matcher for JobID
            Matcher e = pattern2.matcher(line);                   //matcher for normal


            if (q.find() && w.find()) {         // finding long
                Long_error.put(w.group(2), q.group());

            } else if (e.find() && w.find()) {  //finding normal
                Normal_error.put(w.group(2), e.group());

            }

        }

        for(String s : Long_error.keySet()){       //for all keyset in long error
            if(Long_error.containsKey(s) && Normal_error.containsKey(s)){       //when there's the same keyy
                Campur_error.put(s,Long_error.get(s)+"&"+Normal_error.get(s));      //contains two error
            }
            else {
                Campur_error.put(s,Long_error.get(s));               //only put long error
            }
        }
        for(String z : Normal_error.keySet()){               //inserting data from normal error
            if(!Campur_error.containsKey(z)){                  //if still dont have that key
                Campur_error.put(z,Normal_error.get(z));
            }
        }
        return Campur_error;

    }




    public static void main(String[] args) throws IOException {
        error q = new error();
        LinkedHashMap<String,String> map =  q.Long_Process("C:/Users/User/Desktop/Courses/FOP assignment/extracted_log (1)");
        LinkedHashMap<String,Integer> map1 = q.Occurence("C:/Users/User/Desktop/Courses/FOP assignment/extracted_log (1)");
        for(String x: map1.keySet()){
            System.out.println(x+"\t"+map1.get(x)+"\t"+map.get(x));
        }


    }


    public LinkedHashMap<String,Integer> Occurence(String file) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        String line;
        while ((line = input.readLine()) != null) {
            Matcher q = pattern.matcher(line);
            Matcher w = pattern1.matcher(line);
            Matcher e = pattern2.matcher(line);

            if (q.find() && w.find()) {   // finding long
                if (!Long_error.containsKey(w.group(2))) { //if still not contain the key
                    Long_error.put(w.group(2), q.group());
                } else {  //otherwise u put the initial value plus the new value
                    Long_error.put(w.group(2), q.group() + " " + Long_error.get(w.group(2)));
                }

            } else if (e.find() && w.find()) {//finding normal
                if (!Normal_error.containsKey(w.group(2))) {
                    Normal_error.put(w.group(2), e.group());
                }
                else {
                    Normal_error.put(w.group(2), e.group() + " " + Normal_error.get(w.group(2)));
                }
            }
        }




            for (String x : Long_error.keySet()) {           //finding occurence
                int n = 0;
                String[] array = Long_error.get(x).split(" ");; //split to string array
                for (int i = 0; i < array.length; i++) {
                    occurence.put(x, n++);

                    }
                }

            for (String z : Normal_error.keySet()) {
                String[] array1 = Normal_error.get(z).split(" ");
                int n = 0;
                if (Normal_error.containsKey(z) && Long_error.containsKey(z)) {    //if contains two key
                    for (int i = 0; i < array1.length-1; i++) {

                            occurence.put(z,  occurence.get(z)+1);

                    }
                } else {
                    for (int i = 0; i < array1.length ; i++) {

                            occurence.put(z, n++);
                        }
                    }
                }

            return occurence;

        }
    }

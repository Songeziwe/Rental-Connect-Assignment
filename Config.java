/* Class to read the content of the config file from disc
 *
 * @author Songeziwe S. Soboois
 */
 
// Imports
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Config {
   // read from file and return an array of DateTime objects
   protected static ArrayList<DateTime> readConfigFile(String filename){
      if(filename == null)
         return null;
      ArrayList<DateTime> days = new ArrayList<DateTime>();
      Scanner inputStream = null;
      try{
         inputStream = new Scanner(new FileInputStream(filename));
      }catch(FileNotFoundException e){
         System.out.println("Error: File named " + filename + " is not found.");
         System.exit(0);
      }
      
      String fileContent = null;
      String[] contentList = null;
      boolean work_hours = false;
      
      while(inputStream.hasNextLine()){
         fileContent = inputStream.nextLine().trim();
         if(fileContent.indexOf("work_hours") >= 0){
            work_hours = true;
            continue;
         }else if(work_hours){
            contentList = fileContent.split(" ");
            if(contentList.length > 1){
               // create a date-time object
               DateTime day = new DateTime();
               day.setDay(contentList[0].substring(0,contentList[0].length() - 1));
               day.setOpenTime(contentList[1].substring(2,contentList[1].length() -2));
               day.setCloseTime(contentList[2].substring(1,contentList[1].length() -2));
               // add the object to the list
               days.add(day);
            }
         }
      }
      return days;
   }
}
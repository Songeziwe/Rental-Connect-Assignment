// Imports
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

// Date-time Imports
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessAvailablity {

   // return the day name of a given day
   private static String getDayName(String date){
      String dayName = "";
      try{
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         Date dateObject = formatter.parse(date);
         DateFormat dateFormatter = new SimpleDateFormat("EE"); 
         dayName = dateFormatter.format(dateObject).toLowerCase();
      }catch(Exception e){
            System.out.println(e);
            System.exit(0);
      }
      
      return dayName;
   }
   // return true is it's a working day
   // else return false
   private static boolean isItWorkingDay(ArrayList<DateTime> workingDays, String dateTime){
      // seperate date from time
      int spaceIndex = dateTime.indexOf(" ");
      if(spaceIndex != -1){
         String date = dateTime.substring(0, spaceIndex);
         String time = dateTime.substring(spaceIndex+1);
            
         String dayName = getDayName(date);
         
         for(DateTime d:workingDays){
            if(d.getDay().equals(dayName)){
               // handle get open hour
               int colonIndex = d.getOpenTime().indexOf(":");
               int openHours = Integer.valueOf(d.getOpenTime().substring(0, colonIndex));
                  
               // get closing hour
               colonIndex = d.getCloseTime().indexOf(":");
               int closeHours = Integer.valueOf(d.getCloseTime().substring(0, colonIndex));
                  
               // get hours from query time
               colonIndex = time.indexOf(":");
               int queryTimeHours = Integer.valueOf(time.substring(0, colonIndex));
                  
               // check if the time is within the range
               if(queryTimeHours > openHours && queryTimeHours < closeHours)
                  return true;
               else
                  return false;
            }
         }
      }
      return false;
   }
   // return the next working day from the current one
   private static String nextWorkingDay(ArrayList<DateTime> workingDays, String date){
      
      return null;
   }
   // Entry point of the program
   public static void main(String[] args){
   
      // This code is for debugging purposes
      ArrayList<DateTime> days = Config.readConfigFile("config\\config.md");
      boolean isWorkingDay = isItWorkingDay(days, "2019-12-01 09:00:00");
      System.out.println(isWorkingDay);
   }
}
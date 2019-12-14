/** Class to respresent a day-time object
  *
  * @author Songeziwe S. Soboois
  */
  
public class DateTime {
   // Instance variables
   private String day;
   private String openTime;
   private String closeTime;
   
   //Constructors
   public DateTime(){
      day       = null;
      openTime  = null;
      closeTime = null;
   }
   public DateTime(String day, String openTime, String closeTime){
      this.day = day;
      this.openTime = openTime;
      this.closeTime = closeTime;
   }
   
   public String toString(){
      return day + ": " + "[" + openTime + ", " + closeTime + "]";
   }
   
   // Getters
   public String getDay(){ return day; }
   public String getOpenTime(){ return openTime; }
   public String getCloseTime(){ return closeTime; }
   
   // Setters
   public void setDay(String other){ day = other; }
   public void setOpenTime(String other){ openTime = other; }
   public void setCloseTime(String other){ closeTime = other; }
}
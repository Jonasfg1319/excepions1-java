package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

	  Scanner sc = new Scanner(System.in);
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  System.out.println("Room Number: ");
	  Integer romNumber = sc.nextInt();
	  System.out.println("Check-In date (DD/MM/YYYY)");
	  Date checkIn = sdf.parse(sc.next());
	  System.out.println("Check-Out date (DD/MM/YYYY)");
	  Date checkOut = sdf.parse(sc.next());
	  
	  if(!checkOut.after(checkIn)) {
		  
		  System.out.println("Error in Reservation, check-out date must be after check-in date");
	  }else {
		  
		  Reservation reservation = new Reservation(romNumber,checkIn,checkOut);
          System.out.println(reservation);
          
          
          System.out.println("Enter dates to update the reservation");
          System.out.println("Check-In date (DD/MM/YYYY)");
    	  checkIn = sdf.parse(sc.next());
    	  System.out.println("Check-Out date (DD/MM/YYYY)");
    	  checkOut = sdf.parse(sc.next());
    	  
    	  Date now = new Date();
    	  if(checkIn.before(now) || checkOut.before(now)) 
    	  {
    		  System.out.println("Error in Reservation, reservation dates for update must be future"); 
    	  }
    	  
    	  else if(!checkOut.after(checkIn)) {
    		  
    		  System.out.println("Error in Reservation, check-out date must be after check-in date");
    	  }
    	  else {
	    	  reservation.upadateDates(checkIn, checkOut);
	    	  System.out.println(reservation);
    	  }
    	}
	  
	  
	  
	  
	  
	  
	  
	  
 	  
	  sc.close();
	
	}

}

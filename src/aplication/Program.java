package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.DomainException;
import model.entites.Reservation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  Scanner sc = new Scanner(System.in);
	  try {
		  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		  System.out.println("Room Number: ");
		  Integer romNumber = sc.nextInt();
		  System.out.println("Check-In date (DD/MM/YYYY)");
		  Date checkIn = sdf.parse(sc.next());
		  System.out.println("Check-Out date (DD/MM/YYYY)");
		  Date checkOut = sdf.parse(sc.next());
		  
		
		  	  
		  Reservation reservation = new Reservation(romNumber,checkIn,checkOut);
	      System.out.println(reservation);
	      
	      
	      System.out.println("Enter dates to update the reservation");
	      System.out.println("Check-In date (DD/MM/YYYY)");
		  checkIn = sdf.parse(sc.next());
		  System.out.println("Check-Out date (DD/MM/YYYY)");
		  checkOut = sdf.parse(sc.next());
		  
		  reservation.upadateDates(checkIn, checkOut);
	      System.out.println(reservation);
	  }
	  catch(ParseException e) 
	  {
		 System.out.println("Invalid date format");
	  }catch(DomainException e) 
	  {
		  System.out.println("Error in reservation " + e.getMessage());
		  
	  }catch(RuntimeException e) 
	  {
		  System.out.println("Unexpected Error");
	  }
	  
    	  
    	
	  
	  
	  
	  
	  
	  
	  
	  
 	  
	  sc.close();
	
	}

}

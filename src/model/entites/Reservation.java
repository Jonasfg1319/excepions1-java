package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer romNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //o metodo statico vai evitar que seja
	//criado um sdf para cada instancia do reservation
	
	public Reservation() 
	{
		
	}
	
	public Reservation(Integer romNumber, Date checkIn, Date checkOut) 
	{
		this.romNumber = romNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRomNumber() 
	{
		return romNumber;
	}
	
	public void setRomNumber(Integer romNumber) 
	{
		this.romNumber = romNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() 
	{
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public String upadateDates(Date checkIn, Date checkOut) 
	{
		 Date now = new Date();
   	  if(checkIn.before(now) || checkOut.before(now)) 
   	  {
   		  return "Error in Reservation, reservation dates for update must be future"; 
   		  
   	  }
   	  
   	  if(!checkOut.after(checkIn)) {
   		  
   		  return "Error in Reservation, check-out date must be after check-in date";
   	  }
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null; //se n�o der nenhum erro, retorna nulo. Ele precisa retornar algo 
	}
	@Override
	public String toString() 
	{
		return "Rom: "+
	            romNumber +
	            ", Checkin: "+ 
	            sdf.format(checkIn)+
	            ", CheckOut: "+
	            sdf.format(checkOut)+", Duration: "+
	            duration()+" nights";
	}
}

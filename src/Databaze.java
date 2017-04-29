import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class Databaze {
	Databaze()
	{
		prvkyDatabaze=new ArrayList<Stroj>();
	}
		
	public boolean setStroj(int ID, char a)
	{
		return	prvkyDatabaze.add(new Stroj(ID,a));
		
	}
	
	public Stroj getStroj(int ID) 
	{
		return prvkyDatabaze.get(ID);
	}
	


	
	public boolean vymazStroja(int ID)
	{
		Iterator<Stroj> iter= prvkyDatabaze.iterator();
		while(iter.hasNext()){
			Stroj stud = iter.next();
			if(stud.getID() == ID){
				iter.remove();
				return true;
			}
		}
		System.out.println("Stroj nenalezen");
		return false;
	

		
	}
	
	
	public void setridDatabazi(){
		
		Collections.sort(prvkyDatabaze);
		System.out.println("Databaze setridena");
	
	}


	public void vypisDatabaze()
	{
		for (Stroj mujStroj:prvkyDatabaze)
			System.out.println("ID: " + mujStroj.getID() + " stroj: " + mujStroj.getStroj());
	}
	private List<Stroj>  prvkyDatabaze;
}
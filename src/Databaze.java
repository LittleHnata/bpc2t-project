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
    public int max_kapacita(){
	    int maxkapacita=0;
        for (Stroj mujstroj:prvkyDatabaze) {
            maxkapacita+=mujstroj.getKapacita();
        }
        return maxkapacita;
    }
    public int max_kapacita_sroubky(){
        int maxkapacita=0;
        for (Stroj mujstroj:prvkyDatabaze) {
            if (mujstroj.getStroj()=='b')
            maxkapacita+=mujstroj.getKapacita();
        }
        return maxkapacita;
    }

    public boolean setPracepodlozky(int pracepodlozky) {
        if(pracepodlozky<=max_kapacita())
        this.pracepodlozky = pracepodlozky;
        return false;
    }

    public void setPracesroubky(int pracesroubky) {
        if(pracepodlozky<=max_kapacita_sroubky())
        this.pracesroubky = pracesroubky;
    }
    public boolean setporucha(int ID){
        for (Stroj stroj:prvkyDatabaze){
            if(stroj.getID()==ID){
                stroj.setPorucha();
                return true;
            }
        }
        return false;
    }
    public boolean setoprava(int ID){
        for (Stroj stroj:prvkyDatabaze){
            if(stroj.getID()==ID){
                stroj.setPorucha();
                return true;
            }
        }
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
    private int pracesroubky;
    private int pracepodlozky;
    }
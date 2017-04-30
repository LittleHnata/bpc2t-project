import java.util.*;




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
        if(pracepodlozky<=max_kapacita()) {
            if (this.pracepodlozky<pracepodlozky) {
                this.pracepodlozky = pracepodlozky;
                prideleniprace();
            }else{
                odebraniprace();
            }
            return true;
        }
        return false;
    }

    public boolean setPracesroubky(int pracesroubky) {
        if(pracepodlozky<=max_kapacita_sroubky()) {
            this.pracesroubky = pracesroubky;
            return true;
        }
        return false;
    }
    public boolean setporucha(int ID){
        for (Stroj stroj:prvkyDatabaze){
            if(stroj.getID()==ID){
                if(stroj.getStroj()!='a'){
                    stroj.setPorucha();
                    return true;
                }else{
                    System.out.println("Stroj A se nemuze porouchat");
                }
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

    public void setridDatabazi(boolean ses){
        if (ses)
		Collections.sort(prvkyDatabaze);
        else
        Collections.reverse(prvkyDatabaze);
	}
	public int spotrebatov(){
        int a=0,b=0,c=0;
        for(Stroj stroj:prvkyDatabaze){
            if (stroj.getStroj()=='a')
                a+=stroj.getAkt_kapacita();
            else
                if (stroj.getStroj()=='b')
                    b+=stroj.getAkt_kapacita();
                else
                    c+=stroj.getAkt_kapacita();
        }
        return a*4+b*3+c*2;
    }

	public void vypisDatabaze()
	{
		for (Stroj mujStroj:prvkyDatabaze)
			System.out.println("ID: " + mujStroj.getID() + " stroj: " + mujStroj.getStroj() + " Pouzivany: "+ mujStroj.getAkt_kapacita()+ " max " + mujStroj.getKapacita() + " Porouchan: " + mujStroj.isPorucha());
	}
    public void prideleniprace(){
        //zde bude logika pri pridelovani prace
        int i=0;
        int polozky=0;
        boolean ses=true;
        //plni se nez se doplnej
        setridDatabazi(ses);
        for (Stroj str:prvkyDatabaze ){
            while (str.getAkt_kapacita()<str.getKapacita() && polozky<pracepodlozky && !str.isPorucha()){
                i++;
                polozky++;
                str.setAkt_kapacita(i);
            }
            if(polozky==pracepodlozky)break;
            i=0;

        }
    }
    public void odebraniprace(){
        //zde bude logika pri odebirani prace
        int odeber=0;
        boolean ses=false;
        //plni se nez se doplnej
        setridDatabazi(ses);
        for (Stroj str:prvkyDatabaze ){
            str.setAkt_kapacita(odeber);
        }
        prideleniprace();
    }
	private List<Stroj>  prvkyDatabaze;
    private int pracesroubky;
    private int pracepodlozky;
    }
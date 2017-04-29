import java.util.*;

public class Stroj implements Comparable{
	
	@Override
	public int compareTo(Object dalsi){
		Stroj stud = (Stroj) dalsi;
		
		return Integer.compare(this.ID, stud.ID);
	}
	
		
	public static Comparator<Stroj> StrojComparator = null;
	
	
	public Stroj(int ID, char a)
    {
		this.ID=ID;
		switch (a){
            case 'b':
                this.spotreba=3;
                this.kapacita=50;
                stroj=a;
                break;
            case 'c':
                if (iscstroj=false){
                    this.spotreba=2;
                    this.kapacita=150;
                    iscstroj=true;
                    stroj=a;
                }else{
                    System.out.println("Stroj C muze byt jen 1");
                }
                break;
            default:
                this.spotreba=4;
                this.kapacita=70;
                stroj=a;
                break;
        }
	}
    public void setPorucha(){
	    if (stroj!='a')
	    this.porucha=!porucha;
    }

    public char getStroj() {
        return stroj;
    }

	public int getID()
	{
		return ID;
	}

    public boolean isPorucha() {
        return porucha;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getSpotreba() {
        return spotreba;
    }

    public void setAkt_kapacita(int akt_kapacita) {
        this.akt_kapacita = akt_kapacita;
    }

    public int getAkt_kapacita() {
        return akt_kapacita;
    }

    private int ID;
	private String jmeno;
	private int spotreba;
	private int kapacita;
	private char stroj;
	boolean iscstroj=false;
	private boolean porucha=false;
    private int akt_kapacita=0;
}
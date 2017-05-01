import java.util.Scanner;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	public static float pouzeCisla(Scanner sc) 
	{
		float cislo = 0;
		try
		{
			cislo = sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze();
		float prumer;
		int volba;
		char a;
		int ID,podlozky,sroubky;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho Stroja");
			System.out.println("2 .. nastaveni vyroby podlozek");
			System.out.println("3 .. mastaveni vyroby sroubku");
			System.out.println("4 .. odstraneni Stroja ");
			System.out.println("5 .. vypis Stroju ");
			System.out.println("6 .. spotreba tovarny");
			System.out.println("7 .. porouchany stroj ");
			System.out.println("8 .. opraveny stroj ");
            System.out.println("9 .. otevrit databazi ");
            System.out.println("10 .. ulozit databazi ");
			System.out.println("12 .. ukonceni aplikace");
			
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					System.out.println("Zadejte jedinecne ID a typ Stroja (a,b,c)");
					ID=Test.pouzeCelaCisla(sc);
					a=Character.toLowerCase(sc.next().charAt(0));
					if (!mojeDatabaze.setStroj(ID,a))
						System.out.println("Stroja nebylo mozno do databaze zadat");
					break;
				case 2:
					System.out.println("Zadejte kolik podlozek se ma vyrabet");
					podlozky=pouzeCelaCisla(sc);
						if (!mojeDatabaze.setPracepodlozky(podlozky))
						System.out.println("prekrocili jste max kapacitu");
					
					break;
				case 3:
					System.out.println("Zadejte kolik sroubku se ma vyrobit");
					sroubky=pouzeCelaCisla(sc);
					if (!mojeDatabaze.setPracesroubky(sroubky))
						System.out.println("prekrocili jste max kapacitu");

					break;
				case 4:
					System.out.println("Zadejte ID Stroja k odstraneni");
					ID=pouzeCelaCisla(sc);
					if (mojeDatabaze.vymazStroja(ID))
						System.out.println(ID + " odstranen ");
					else
						System.out.println(ID + " neni v databazi ");
					break;
				case 5:
					mojeDatabaze.vypisDatabaze();
					break;
				case 6:
					System.out.println("Aktualni spotreba tovarny je " + mojeDatabaze.spotrebatov() + " W/h");
					break;
				case 7:
					System.out.println("Zadejte ID Stroja, ktery se porouchal");
					ID=pouzeCelaCisla(sc);
					if (mojeDatabaze.setporucha(ID))
						System.out.println(ID + " se porouchal ");
					break;
				case 8:
					System.out.println("Zadejte ID opraveneho Stroja");
					ID=pouzeCelaCisla(sc);
					if (mojeDatabaze.setoprava(ID))
						System.out.println(ID + " opraven ");
					break;
				case 9:
					try {
						mojeDatabaze=new Databaze();
						mojeDatabaze.loadDat("data.txt");
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					break;
				case 10:
					if(mojeDatabaze.saveDat("data.txt"))
                        System.out.println("stala se chyba pri nacitani databaze");
					break;
				case 12:
					run=false;
					break;
			}
			
		}
	}

}

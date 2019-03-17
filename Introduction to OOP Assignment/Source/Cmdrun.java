import java.io.BufferedReader;
import java.io.PrintWriter;
public class Cmdrun{
	public static void CommandRun(Food f, Sport s, People p, BufferedReader cmd) throws Exception{
		String line;
		int first = -1;
		int second = -1;
		int third = -1;
		int cnt = 0;
		int lis = 0;
		int cntr1, cntr2, k, burnt, taken, keyPerson, keyFacility;
		int[] ls = new int[50];
		PrintWriter out = new PrintWriter("monitoring.txt");
		String pr = new String("printList");
		while ((line = cmd.readLine()) != null) {
			if(lis!=0)
				out.println("***************");
			if(line.charAt(0) == '1') {
				for (String retval: line.split("\t")) {
					if(cnt == 0) {
						first = Integer.parseInt(retval);
					}
					if(cnt == 1) {
						second = Integer.parseInt(retval);
					}
					if(cnt == 2){
						third = Integer.parseInt(retval);
					}
					cnt++;
				}cnt = 0;
				
				if((2000<=second)&&(second<=2999)) {
					keyPerson = p.searchPeople(first);
					keyFacility = s.searchSport(second);
					burnt = s.getSportCal()[keyFacility]*third/60;
					
					for(cntr1 = 0; cntr1<50; cntr1++) {
						if(ls[cntr1]==first) {break;}
					}
					if(cntr1==50) {ls[lis++] = first;}
					cntr1=0;
					p.setBurnt(keyPerson, burnt);
					out.println(p.getPplId()[keyPerson] + "\thas\tburnt\t" + burnt + "kcal\tthanks\tto\t" + s.getSportNames()[keyFacility]);
					}
				if((1000<=second)&&(second<=1999)){
					keyPerson = p.searchPeople(first);
					keyFacility = f.searchFood(second);
					for(cntr2 = 0; cntr2<50; cntr2++) {
						if(ls[cntr2]==first) {break;}
					}
					if(cntr2==50){ls[lis++] = first;}
					cntr2=0;
					taken = f.getFoodCal()[keyFacility]*third;
					p.setTaken(keyPerson, taken);
					out.println(p.getPplId()[keyPerson] + "\thas\ttaken\t" + 
							taken + "kcal\tfrom\t" + f.getFoodNames()[keyFacility]);
				}
			}
			if(line.equals(pr)) {
				for(k=0; k<50; k++) {
					if(ls[k]==0) {
						break;
					}
					out.println(p.show(p.searchPeople(ls[k])));
				}
			}
			if(line.charAt(5) == '(') {
				first = Integer.parseInt(line.substring(6, 11));
				out.println(p.show(p.searchPeople(first)));
			}
		}
		out.close();
	}
}

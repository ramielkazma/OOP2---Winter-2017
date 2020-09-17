// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package public_transportation;

import air_transportation.AirCraft;
import ground_transportation.*;
import water_transportation.Ferry;

public class Driver {

	public static PublicTransportation[] copyCityBus(PublicTransportation publictransportation[]){
		int length=publictransportation.length;
		PublicTransportation pb[]=new PublicTransportation[length];
		for (int i=0;i<pb.length;i++)
			pb[i]=new PublicTransportation(publictransportation[i]);
		return pb;
	}
	
	public static void main(String[] args) {
		
		PublicTransportation pb1 = new PublicTransportation();
		PublicTransportation pb2 = new PublicTransportation(1,1);
		PublicTransportation pb3 = new PublicTransportation(pb2);
		
		CityBus cb1 = new CityBus();
		CityBus cb2 = new CityBus(3,15,105,2005,"Sherbrooke","John");
		CityBus cb3 = new CityBus(cb2);
		
		Tram t1 = new Tram();
		Tram t2 = new Tram(15,25,230,2001,"Notre-Dame","David",100);
		Tram t3 = new Tram(t2);
		
		Metro m1 = new Metro();
		Metro m2 = new Metro(3,30,1,2000,"Cote-Vertu","Rudy",7,"Montreal");
		Metro m3 = new Metro(m2);
		
		Ferry f1 = new Ferry();
		Ferry f2 = new Ferry(130,1,1990,"North Atlantic");
		Ferry f3 = new Ferry(f2);
		
		AirCraft ac1 = new AirCraft();
		AirCraft ac2 = new AirCraft(600,1, AirCraft.classType.AIRLINE, AirCraft.maintenanceType.WEEKLY);
		AirCraft ac3 = new AirCraft(ac2);
		
		PublicTransportation[] array={pb2,pb3,cb2,cb3,t2,t3,m2,m3,f2,f3,ac2,ac3};
		PublicTransportation[] array2=copyCityBus(array);
		
		System.out.println("Array:");
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
		System.out.println("\ncopyCityBus Array:");
		for(int i=0;i<array2.length;i++)
			System.out.println(array2[i]);
		
		System.out.println("\n----------------------------End of Program----------------------------");
		
	}

}

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

	public static void main(String[] args) {
		
		//constructors
		PublicTransportation pb1 = new PublicTransportation();		//default constructor
		PublicTransportation pb2 = new PublicTransportation(1,1);	//parameterized constructor
		PublicTransportation pb3 = new PublicTransportation(pb2);	//copy constructor
		
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
		
		//all classes toString method tested
		System.out.println(pb2+"\n");
		System.out.println(cb2+"\n");
		System.out.println(t2+"\n");
		System.out.println(m2+"\n");
		System.out.println(f2+"\n");
		System.out.println(ac2+"\n");
		
		//all possible equalities tested
		System.out.println("pb1 the same as pb2: "+pb1.equals(pb2));
		System.out.println("pb2 the same as pb3: "+pb2.equals(pb3));
		System.out.println("pb1 the same as cb1: "+pb1.equals(cb1)+"\n");
		
		System.out.println("cb1 the same as cb2: "+cb1.equals(cb2));
		System.out.println("cb2 the same as cb3: "+cb2.equals(cb3));
		System.out.println("cb1 the same as t1: "+cb1.equals(t1)+"\n");
		
		System.out.println("t1 the same as t2: "+t1.equals(t2));
		System.out.println("t2 the same as t3: "+t2.equals(t3));
		System.out.println("t1 the same as m1: "+t1.equals(m1)+"\n");
		
		System.out.println("m1 the same as m2: "+m1.equals(m2));
		System.out.println("m2 the same as m3: "+m2.equals(m3));
		System.out.println("m1 the same as t1: "+m1.equals(f1)+"\n");
		
		System.out.println("f1 the same as f2: "+f1.equals(f2));
		System.out.println("f2 the same as f3: "+f2.equals(f3));
		System.out.println("f1 the same as ac1: "+f1.equals(ac1)+"\n");
		
		System.out.println("ac1 the same as ac2: "+ac1.equals(ac2));
		System.out.println("ac2 the same as ac3: "+ac2.equals(ac3));
		System.out.println("ac1 the same as pb1: "+ac1.equals(pb1)+"\n");
		
		PublicTransportation[] Public_Transportation = {pb2,f3,t2,m3,m2,t3,f2,ac3,cb2,cb3}; //creating the array initialized with 10 objects
		
		PublicTransportation lowestPrice = Public_Transportation[0].clone();	//using the clone method to track the most and least
		PublicTransportation highestPrice = Public_Transportation[0].clone();	//expensive objects
		int indexLow=0,indexHigh=0; //keeps track of the indices of the highest and lowest price objects
		
		for(int i=1;i<Public_Transportation.length;i++) //traces through the array to find the least and most expensive objects
		{
			if (lowestPrice.getTicketPrice()>Public_Transportation[i].getTicketPrice()) //least expensive
			{
				lowestPrice = Public_Transportation[i].clone();
				indexLow=i;
			}
			if (highestPrice.getTicketPrice()<Public_Transportation[i].getTicketPrice()) //most expensive
			{
				highestPrice = Public_Transportation[i].clone();
				indexHigh=i;
			}
		}
		
		System.out.println("Lowest price (Index "+indexLow+"): "+lowestPrice);
		System.out.println("Highest price (Index "+indexHigh+"): "+highestPrice+"\n");
		
		System.out.println("\n-------------------------------------------------End of Program------"
				+ "--------------------------------------------");
		
	}

}

package com.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bo.Address;
import com.bo.Item;
import com.bo.OrderBO;
import com.bo.Shipment;

public class Java8Ex {

	public static void main(String[] args) {

		OrderBO order = new OrderBO();
		order.setOrderNo("146545");
		List<Shipment> shipments = new ArrayList<>();
		Shipment shipment = null;
		List<Item> items =null;
		Address address =null;
		Item item =null;
		
		shipment = new Shipment();
		shipment.setShipmentId("s1");
		shipment.setShipmentType("standard");
		address = new Address();
		address.setCity("Hyd");
		address.setCountry("Ind");
		address.setPin("500084");
		shipment.setAddress(address);
		items = new ArrayList<>();
		item = new Item();
		item.setItemId("ds66");
		item.setPrice(50.50);
		item.setItemType("xyz");
		items.add(item);
		
		item = new Item();
		item.setItemId("das24d4");
		item.setPrice(90.25);
		item.setItemType("sas");
		items.add(item);
		shipment.setItems(items);
		
		item = new Item();
		item.setItemId("asd465");
		item.setPrice(15.75);
		item.setItemType("xyz");
		items.add(item);
		
		shipment.setItems(items);
		shipments.add(shipment);	
		
		shipment = new Shipment();
		shipment.setShipmentId("s2");
		shipment.setShipmentType("Express");
		address = new Address();
		address.setCity("BBS");
		address.setCountry("Ind");
		address.setPin("751006");
		shipment.setAddress(address);
		items = new ArrayList<>();
		item = new Item();
		item.setItemId("das24d4");
		item.setPrice(60.25);
		item.setItemType("xyz");
		items.add(item);
		item = new Item();
		item.setItemId("das24d4");
		item.setPrice(80.25);
		item.setItemType("sas");
		items.add(item);
		shipment.setItems(items);
		shipments.add(shipment);		
		
		order.setShipments(shipments);
		/*//Print complete Order
		System.out.println(order);
		System.out.println("--------------------------------------------------------------------");*/
		
		//Print Shipments
		order.getShipments().forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		
		//print All Items
		order.getShipments().stream().map(sh->sh.getItems()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		
		//print All Items of respective shipments
		order.getShipments().stream().map(sh->sh.getItems()).findFirst().get().forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		order.getShipments().stream().map(sh->sh.getItems()).skip(1).findAny().get().forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		
		//order.getShipments().stream().map(sh->sh.getItems()).filter(i->i.size()>=2).skip(1).findAny().get().forEach(System.out::println);
		//print All Items of respective shipments
		order.getShipments().parallelStream().map(sh->sh.getItems()).findAny().get().forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
	
		
		//Print items based on itemId irrespective of shipment
		order.getShipments().stream().map(sh->sh.getItems()).flatMap(it->it.stream()).filter(i->((Item) i).getItemId().equalsIgnoreCase("das24d4")).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Items As Key Value...");
		//order.getShipments().stream().map(shi->shi.getItems()).flatMap(iet->iet.stream()).filter(i->i.getItemId().equalsIgnoreCase("das24d4")).collect(Collectors.toMap(item.getItemId(),shi))
		/*Print Key value from items   String,String
		 *	Key: ds66	Value:xyz
		 *	Key: asd465	Value:xyz
		 *	Key: das24d4	Value:sas,xyz,sas
		 */
		order.getShipments().stream().map(s->s.getItems()).flatMap(i->i.stream()).collect(Collectors.toMap(it->it.getItemId(), it->it.getItemType(),(it1,it2)->it1+","+it2)).forEach((key,value)->System.out.println("Key: "+key +"\tValue:"+value));
		
		//print grand total 
		System.out.println("------------------------print grand total ----------------------------");
		double count = order.getShipments().stream().map(i->i.getItems()).flatMap(i->i.stream()).mapToDouble(it->it.getPrice()).sum();
		System.out.println(" Grandtotal= "+count);
		System.out.println("--------------------------------------------------------------------");
		
		DoubleSummaryStatistics grandTotal = order.getShipments().stream().map(sh->sh.getItems()).flatMap(it->it.stream()).collect(Collectors.summarizingDouble(it->it.getPrice()));
		System.out.println("Total="+grandTotal);
		
		
		//print Maximum item price type
		System.out.println("---------------------print Maximum item price type or Item Object------------------------");
		Item type = (Item) order.getShipments().stream().map(sh->sh.getItems()).flatMap(i->i.stream())
				.collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Item::getPrice)), (Optional<Item> it)->it.isPresent()?it.get():"none"));
		System.out.println(type);
		
		//print All itemTypes
		System.out.println("---------------------Collectors.mapping()------------------------");
		
		order.getShipments().stream().map(sh->sh.getItems()).flatMap(it->it.stream())
			.collect(Collectors.mapping(Item::getItemType, Collectors.toList())).forEach(System.out::println);
		
		System.out.println("---------------------Collectors.partitioningBy()------------------------");
		System.out.println(order.getShipments().stream().map(sh->sh.getItems()).flatMap(it->it.stream()).collect(Collectors.partitioningBy(i->i.getPrice()>60.00)));
	
		/*
		 * Collectors.reducing() use case
		 * using Copmarator
		 */
		System.out.println("---------------------Collectors.reducing()------------------------");
		Comparator<Item> itemPriceComp=Comparator.comparing(Item::getPrice);
		Map<Double,Optional<Item>> mapItem =order.getShipments().stream().map(sh->sh.getItems()).flatMap(it->it.stream()).collect(Collectors.groupingBy(Item::getPrice,Collectors.reducing(BinaryOperator.maxBy(itemPriceComp))));
		mapItem.forEach((k,v)->System.out.println("ItemPrice:"+k+"--->ItemId:"+v.get().getItemId()+",ItemType:"+v.get().getItemType()));
	
		/*
		 * Opration on map with custom price update for every item 
		 * */	
		System.out.println("--------------------Operation on map------------------------");
		
		order.getShipments().stream().map(sh->sh.getItems()).flatMap(it->it.stream()).map(it->setPrice(it)).collect(Collectors.toList()).forEach(System.out::println);
		
		
		
		String s="atya";
		String s1=s.replaceFirst("atya", "s");
		
		System.out.println(s1);
	}


	/*
	 * Opration on map with custom price update for every item 
	 * */
	private static Item setPrice(Item item) {
		item.setPrice(50.00);
		return item;
		
	}

	
	
	
}

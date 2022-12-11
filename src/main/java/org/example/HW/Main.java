package org.example.HW;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Weight w1 = new Weight(50);
        Weight w2 = new Weight(72);
        Weight w3 = new Weight(94);
        Weight w4 = new Weight(61);
        Weight w5 = new Weight(58);
        Weight w6 = new Weight(82);
        Weight w7 = new Weight(88);
        Weight w8 = new Weight(30);
        Weight w9 = new Weight(55);
        Weight w10 = new Weight(60);
        Client client1 = new Client("Viktor", 32);
        Client client2 = new Client("Nina", 40);
        Client client3 = new Client("Sofi", 19);
        Client client4 = new Client("Eliza", 60);
        Client client5 = new Client("Igor", 45);
        Client client6 = new Client("Ira", 33);
        Client client7 = new Client("Fifi", 62);
        Client client8 = new Client("Oly", 36);
        Client client9 = new Client("Vasil", 44);
        Client client10 = new Client("Elena", 30);

        Map<Integer,String> mapClient = new HashMap<>();
        mapClient.put(w1.kilo, client1.name);
        mapClient.put(w2.kilo, client2.name);
        mapClient.put(w3.kilo, client3.name);
        mapClient.put(w4.kilo, client4.name);
        mapClient.put(w5.kilo, client5.name);
        mapClient.put(w6.kilo, client6.name);
        mapClient.put(w7.kilo, client7.name);
        mapClient.put(w8.kilo, client8.name);
        mapClient.put(w9.kilo, client9.name);
        mapClient.put(w10.kilo, client10.name);

        System.out.println(mapClient);
        System.out.println(mapClient.containsKey(60));
        System.out.println(mapClient.containsValue("Ira"));
        System.out.println(mapClient.size());
        System.out.println(mapClient.isEmpty());

        Map<Integer,String> mapClientClone = new HashMap<>();
        mapClientClone.putAll(mapClient);
        System.out.println(mapClientClone);

        System.out.println(mapClient.equals(mapClientClone ));
        System.out.println(mapClient.get("Fifi"));
        mapClient.putIfAbsent(64,"Elen");
        System.out.println(mapClient + " " + mapClient.size());
        mapClient.remove(64);
        System.out.println(mapClient + " " + mapClient.size());

        Set<Integer> key = mapClient.keySet();
        System.out.println(key);
        Collection<String> val = mapClient.values();
        System.out.println(val);
        for (Map.Entry<Integer,String> item : mapClient.entrySet()){
            System.out.printf("Key: %d, Value: %s \n", item.getKey(),item.getValue());
        }



    }
}

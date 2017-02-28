package com.sanjar.apiinpractice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

import org.apache.commons.collections4.trie.PatriciaTrie;

import com.sanjar.apiinpractice.model.Student;

public class Try {

	
	public static void main(String[] args) {
        Map<String, Student> stdMap = new LinkedHashMap<String, Student>();
        /* Load your regualr map with data */
        Student std1 = new Student();
        std1.setName("Raj");
        std1.setRoll("23");
        stdMap.put("Raj ", std1);
       
        Student std2 = new Student();
        std2.setName("Rak");
        std2.setRoll("22");
        stdMap.put("Ra ", std2);
       
        Student std3 = new Student();
        std3.setName("Raop");
        std3.setRoll("2");
        stdMap.put("Raop", std3);
       
        Student std4 = new Student();
        std4.setName("Pat");
        std4.setRoll("4");
        stdMap.put("Pat ", std4);
       
        Student std5 = new Student();
        std5.setName("kalo");
        std5.setRoll("34");
        stdMap.put("kalo", std5);
       
        /* PatriciaTrie map*/
        PatriciaTrie<Student> stdMapTrie = new PatriciaTrie<Student>(stdMap);
       
        SortedMap<String, Student> entries1 = stdMapTrie.prefixMap("Ra");
        System.out.println(entries1);
       
        SortedMap<String, Student> entries2 = stdMapTrie.headMap("ak");
        System.out.println(entries2);
       
        SortedMap<String, Student> entries3 = stdMapTrie.subMap("", "47");
        System.out.println(entries3);
       
        SortedMap<String, Student> entries4 = stdMapTrie.tailMap("00");
        System.out.println(entries4);
       
        //Entry<String, Student> entries5 = stdMapTrie.select("5600");
        //System.out.println(entries5.getValue().getSTD());
        //
       
 }




}

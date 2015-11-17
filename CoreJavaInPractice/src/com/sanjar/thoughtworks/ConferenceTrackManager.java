package com.sanjar.thoughtworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ConferenceTrackManager {

	private static final int MAX_TRACK_TIME = 420;
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static Map<Integer, String> map1 = new TreeMap<Integer,String>();
	private static Integer totalEventTime=0;
	private static StringBuilder scheduleOutput = new StringBuilder();
	static int requiredTracks = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"events.txt"));
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			int lastIndexOfSpace = line.lastIndexOf(' ');
			if(line.substring(lastIndexOfSpace + 1).contains("min")){
				
				Integer eventDuration = Integer.parseInt(line.substring(lastIndexOfSpace + 1,
						line.lastIndexOf("min")));
				totalEventTime = totalEventTime+eventDuration;
				if(map1.get(eventDuration) != null){
					map1.put(eventDuration,map1.get(eventDuration)+";"+line);
				}
				else{
				map1.put(eventDuration,line);
				}
			}

		}
		requiredTracks = totalEventTime / MAX_TRACK_TIME + 1;
		for(int i =1;i<=requiredTracks;i++){
			scheduleOutput.append("\nTrack "+i+":\n");
			scheduleMorningSlot();
			scheduleOutput.append("12:00PM Lunch\n");
			scheduleAfterNoonSlot();
		}
		System.out.println(scheduleOutput);
		bufferedReader.close();
	}

	private static void scheduleAfterNoonSlot() {
		int morningSlotTime = 4*60; //9:am to 12:00
		int time = 1*60;
		Iterator<Map.Entry<Integer, String>> itr = map1.entrySet().iterator();
		int key = itr.next().getKey();
		
		while(!map1.isEmpty() && morningSlotTime > key){
			Iterator<Map.Entry<Integer, String>> it = map1.entrySet().iterator();
			if(it.hasNext()){
			Map.Entry<Integer, String> entry = it.next();
			String[] events = entry.getValue().split(";");
			String eventsString = "";
			for(String event : events){
				if(morningSlotTime-entry.getKey()>0){
					scheduleOutput.append(getTime(time, "PM")).append(" "+event+"\n");
					morningSlotTime = morningSlotTime-entry.getKey();
					time = time+entry.getKey();
				}
				else{
					if(eventsString.isEmpty()){
						eventsString=eventsString+event;
					}
					else{
						eventsString=eventsString+";"+event;
					}
				}
				
			}
			if(eventsString.isEmpty()){
				it.remove();
			}
			else{
				entry.setValue(eventsString);
			}
			
		}
		}
		scheduleOutput.append(getTime(time, "PM")).append(" Networking Event\n");
	}

	private static void scheduleMorningSlot() {
		int morningSlotTime = 3*60; //9:am to 12:00
		int time = 9*60;
		Iterator<Map.Entry<Integer, String>> itr = map1.entrySet().iterator();
		int key = itr.next().getKey();
		while(!map1.isEmpty() && morningSlotTime > key){
			Iterator<Map.Entry<Integer, String>> it = map1.entrySet().iterator();
			if(it.hasNext()){
			Map.Entry<Integer, String> entry = it.next();
			String[] events = map1.get(entry.getKey()).split(";");
			String eventsString = "";
			for(String event : events){
				if(morningSlotTime-entry.getKey()>=0){
					scheduleOutput.append(getTime(time, "AM")).append(" "+ event+"\n");
					morningSlotTime = morningSlotTime-entry.getKey();
					time = time+entry.getKey();
				}
				else{
					if(eventsString.isEmpty()){
						eventsString=eventsString+event;
					}
					else{
						eventsString=eventsString+event+";";
					}
				}
				
			}
			if(eventsString.isEmpty()){
				it.remove();
			}
			else{
				entry.setValue(eventsString);
			}
			
		}
		}
	}

	private static String getTime(int time, String mode) {
	    String timeStamp = "";

	    int hours = time / 60;
	    int minutes = time % 60;

	    String hourHint = "", minuteHint = "";
	    if (hours < 10)
	        hourHint = "0";
	    if (minutes < 10)
	        minuteHint = "0";
	    timeStamp = hourHint + hours + ":" + minuteHint + minutes + mode;

	    return timeStamp;
	}
	
}

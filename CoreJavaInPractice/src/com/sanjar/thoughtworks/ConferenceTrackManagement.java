package com.sanjar.thoughtworks;

public class ConferenceTrackManagement extends CommonInterface {

private String[] eventArray;
private int[] timeArray;

private boolean isOutputInvalid;

private final int MAX_TRACK_TIME = 420; // 1 Track Max Time = 420 minutes.

public ConferenceTrackManagement() {
    super("Conference Track Management");
}

@Override
protected void refresh() {
    isOutputInvalid = false;
    outputText = "";
}

@Override
protected void computeOutput() {
    originalInputText = textArea.getText();
    inputText = originalInputText;

    computeEventAndTimeArray();

    if (!isOutputInvalid) {
        computeTracks();
    }
}

private int startIndex = -1, endIndex = -1, time;

private void computeTracks() {
    int totalTime = getTotalTime();
    int requiredTracks = totalTime / MAX_TRACK_TIME + 1;
    sortEventAndTimeArray();

    for (int i = 1; i <= requiredTracks; i++) {
        boolean found = exactSubArraySum(timeArray, 180); // morning time

        if (found) {
            time = 9 * 60; // starts at 9 am [9 * 60 is in minutes]
            outputText += "Track " + i + ":\n\n";
            for (int j = startIndex; j <= endIndex; j++) {
                outputText += timeStamp(time, "AM") + " " + eventArray[j]
                        + "\n";
                time += timeArray[j];
            }

            deleteProperElements();
            outputText += "12:00PM Lunch\n";

            boolean relativeFound = relativeSubArraySum(timeArray, 180, 240);

            if (relativeFound) {
                time = 60; // starts at 1 pm [1 * 60 is in minutes]
                outputText += "\n";
                for (int j = startIndex; j <= endIndex; j++) {
                    outputText += timeStamp(time, "PM") + " "
                            + eventArray[j] + "\n";
                    time += timeArray[j];
                }

                deleteProperElements();
                outputText += timeStamp(time, "PM") + " Networking Event"
                        + "\n";
                outputText += "\n\n";
            }
        } else
            outputText = "No proper solution found.";
    }
}

private String timeStamp(int time, String mode) {
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

private void deleteProperElements() {
    String[] tempEventArray = new String[eventArray.length
            - (endIndex - startIndex) - 1];
    int[] tempTimeArray = new int[tempEventArray.length];

    int index = 0;
    for (int j = 0; j < startIndex; j++) {
        tempEventArray[index] = eventArray[j];
        tempTimeArray[index] = timeArray[j];
        index++;
    }
    for (int j = endIndex + 1; j < eventArray.length; j++) {
        tempEventArray[index] = eventArray[j];
        tempTimeArray[index] = timeArray[j];
        index++;
    }

    timeArray = tempTimeArray;
    eventArray = tempEventArray;
}

private boolean exactSubArraySum(int array[], int sum) {
    if (!(array.length >= 1))
        return false;
    int currentSum = array[0], start = 0;

    for (int i = 1; i <= array.length; i++) {
        while (currentSum > sum && start < i - 1) {
            currentSum -= array[start];
            start++;
        }

        if (currentSum == sum) {
            startIndex = start;
            endIndex = i - 1;
            return true;
        }

        if (i < array.length)
            currentSum += array[i];
    }

    return false; // No sub array found.
}

private boolean relativeSubArraySum(int array[], int minimumSum,
        int maximumSum) {
    if (!(array.length >= 1))
        return false;
    int currentSum = array[0], start = 0;

    for (int i = 1; i <= array.length; i++) {
        while (currentSum > maximumSum && start < i - 1) {
            currentSum -= array[start];
            start++;
        }

        if (currentSum >= minimumSum && currentSum <= maximumSum) {
            startIndex = start;
            endIndex = i - 1;
            return true;
        }

        if (i < array.length)
            currentSum += array[i];
    }

    return false; // No sub array found.
}

private void sortEventAndTimeArray() {
    for (int i = 1; i < timeArray.length; i++) {
        for (int j = 0; j < timeArray.length - i; j++) {
            if (timeArray[j] > timeArray[j + 1]) {
                int tempTime = timeArray[j];
                timeArray[j] = timeArray[j + 1];
                timeArray[j + 1] = tempTime;

                String tempEvent = eventArray[j];
                eventArray[j] = eventArray[j + 1];
                eventArray[j + 1] = tempEvent;
            }
        }
    }
}

private int getTotalTime() {
    int timeSum = 0;
    for (int i = 0; i < timeArray.length; i++)
        timeSum += timeArray[i];
    return timeSum;
}

private void computeEventAndTimeArray() {
    String lines[] = inputText.split("[\\r\\n]+");

    eventArray = new String[lines.length];
    timeArray = new int[lines.length];

    for (int i = 0; i < lines.length; i++) {
        String line = lines[i];
        line = line.trim();

        int lastIndexOfSpace = line.lastIndexOf(' ');

        eventArray[i] = line.substring(0, lastIndexOfSpace);
        String currentTime = line.substring(lastIndexOfSpace + 1);

        currentTime = currentTime.toLowerCase();
        if (currentTime.endsWith("lightning"))
            setEventAndTimeFor(i, currentTime, "lightning", 5);
        else if (currentTime.endsWith("min"))
            setEventAndTimeFor(i, currentTime, "min", 1);
        else {
            setOutputAsInvalid(i);
        }
    }
}

private void setEventAndTimeFor(int i, String currentTime, String type,
        int scale) {
    String timeValue = currentTime.substring(0, currentTime.indexOf(type));

    if (timeValue.equals(""))
        timeArray[i] = scale;
    else {
        try {
            timeArray[i] = Integer.parseInt(timeValue) * scale;
        } catch (Exception e) {
            setOutputAsInvalid(i);
        }
    }
}

private void setOutputAsInvalid(int lineNumber) {
    outputText += "Invalid Time Entry in line " + (lineNumber + 1) + "\n";
    isOutputInvalid = true;
}

public static void main(String args[]) {
    new ConferenceTrackManagement();
}
}
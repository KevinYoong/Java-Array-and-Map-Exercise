import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String[] addElement(String[] original, String newValueEnd) {
        int n = original.length;
        String[] newArray = new String[n + 1];
        
        // Copy elements from the original array to the new array
        for (int i = 0; i < n; i++) {
            newArray[i] = original[i];
        }
        
        // Add the new value at the end
        newArray[n] = newValueEnd;
        
        return newArray;
    }

    public static String[] addElementFirst(String[] original, String newValueFirst) {
        int n = original.length;
        String[] newArray = new String[n + 1];
        
        // Copy elements from the original array to the new array
        for (int i = 0; i < n; i++) {
            newArray[i + 1] = original[i];
        }
        
        // Add the new value at the first index
        newArray[0] = newValueFirst;
        
        return newArray;
    }

    // Function to combine arrays
    public static String[] combineArrays(String[] arrayA, String[] arrayB) {
        String[] combinedArray = new String[arrayA.length + arrayB.length];
        
        // Copy elements from the first array to the combined array
        for (int i = 0; i < arrayA.length; i++) {
            combinedArray[i] = arrayA[i];
        }
        
        // Copy elements from the second array to the combined array
        for (int i = 0; i < arrayB.length; i++) {
            combinedArray[i + arrayA.length] = arrayB[i];
        }
        
        return combinedArray;
    }

    // Funtion to reverse string 
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Function to replace last occurence of '222' in str with 'aaa' after reversing the string
    public static String replaceLastOccurrence(String str, String oldStr, String newStr) {
        if (str == null) {
            return null;
        }
        int index = str.lastIndexOf(oldStr);
        if (index == -1) {
            return str;
        }
        String result = str.substring(0, index) + newStr + str.substring(index + oldStr.length());
        return result;
    }

    public static void main(String[] args) throws Exception {
        String[] arrayA = {"Honda", "Toyota", "Proton"};
        String[] arrayB = {"Dog", "Cat", "Bird"};
        String str = "111222888222555";

        Map<String, String> mapC = new HashMap<String, String>();
        mapC.put("123", "Justin");
        mapC.put("456", "Owen");
        mapC.put("789", "Hugo");

        Map<String, String> mapD = new HashMap<String, String>();
        mapD.put("123", "George");
        mapD.put("555", "Jack");
        mapD.put("888", "Julian");
        
        // Adding Nissan to the array
        String newNissan = "Nissan";
        arrayA = addElement(arrayA, newNissan);

        // Adding Mazda to the first index of the array
        String newMazda = "Mazda";
        arrayA = addElementFirst(arrayA, newMazda);

        // Combining arrayA and arrayB
        String[] combinedArray = combineArrays(arrayA, arrayB);

        // Combining mapC and mapD into a new mutable map
        mapC.putAll(mapD);

        //Filter map value to obtain only the values with keys that contain 5
        Map<String, String> filteredMap = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : mapC.entrySet()) {
            if (entry.getKey().contains("5")) {
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }

        // Filter map to remove values that contain "o" (ignoring case)
        Map<String, String> removeO = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : mapC.entrySet()) {
            if (!entry.getValue().toLowerCase().contains("o")) {
                removeO.put(entry.getKey(), entry.getValue());
            }
        }

        // Replacing last occurence of '222' in str with 'aaa'
        str = reverseString(str);
        str = replaceLastOccurrence(str, "222", "aaa");

        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(combinedArray));
        System.out.println("Combined mapC and mapD: " + mapC);
        System.out.println("The reason why the combined map no longer has Justin is due to the fact that Justin and George have the same key. Thus when the map is combined, the value of the Justin key will be overwritten by the value of the key in the second map which is George.");
        System.out.println("Filtered Map (keys containing 5): " + filteredMap);
        System.out.println("Map with values containing 'o' removed: " + removeO);
        System.out.println("Reversed String: " + str);
    }
}

package com.dubszy.miscideas.java.evaluationstrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for mutating objects using only a reference created to the initial
 * object, and not using the initial object reference itself.
 * <br/><br/>
 * Running the methods in this class demonstrate that Java is call-by-sharing.
 * This means that Java is pass-by-value, but when the value passed is an
 * object, the object reference is the value passed, not the object itself.
 * Thus, the initial object can be mutated by mutating a separate object it is
 * assigned to.
 * <br/><br/>
 * Note that the initial object must be mutable for this to work. Also note that
 * mutable is not the same as accessible. Inaccessible fields on external
 * classes (private, package-private, or protected fields) can be mutated using
 * this method as well (which is demonstrated by
 * {@link #mutateSomeoneElsesMap(Map)}).
 * <br/><br/>
 * Maps are used to demonstrate this behavior because simple objects such as
 * Strings and BigDecimals tend to create new object references when they are
 * mutated using traditional means, therefore not demonstrating this behavior.
 */
public class ObjectMutator {

    public Map<String, String> myMap = new HashMap<>();

    ObjectMutator() {
        myMap.put("key", "unchanged");
    }

    /**
     * Mutate the map owned by this class.
     *
     * This method demonstrates that Java is call-by-sharing.
     */
    public void mutateMyMap() {

        Map<String, String> mutated = myMap;

        mutated.replace("key", "mutated");

        System.out.println(myMap);      // prints: {key=mutated}
        System.out.println(mutated);    // prints: {key=mutated}
    }

    /**
     * Mutate a map passed in from somewhere else.
     *
     * The usage of this method in
     * {@link ExternalObjectMutator#mutateMyMapFromOutsideMyself()} demonstrates
     * that even a private field on another class can be mutated in a similar
     * fashion as described above.
     *
     * @param anotherMap The map to mutate
     */
    public void mutateSomeoneElsesMap(Map<String, String> anotherMap) {

        Map<String, String> mutated = anotherMap;

        mutated.replace("key", "mutated");

        System.out.println(anotherMap); // prints: {key=mutated}
        System.out.println(mutated);    // prints: {key=mutated}
    }
}

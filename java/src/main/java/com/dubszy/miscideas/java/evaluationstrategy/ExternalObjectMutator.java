package com.dubszy.miscideas.java.evaluationstrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for demonstrating that objects which are normally inaccessible to the
 * callee can be mutated using the method described in {@link ObjectMutator}.
 */
public class ExternalObjectMutator {

    private Map<String, String> myMap = new HashMap<>();

    ExternalObjectMutator() {
        myMap.put("key", "unchanged");
    }

    /**
     * Mutate the map owned by this class from outside of this class.
     */
    public void mutateMyMapFromOutsideMyself() {
        ObjectMutator objectMutator = new ObjectMutator();
        objectMutator.mutateSomeoneElsesMap(myMap);
    }
}

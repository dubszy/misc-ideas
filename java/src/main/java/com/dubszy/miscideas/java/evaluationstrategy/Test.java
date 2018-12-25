package com.dubszy.miscideas.java.evaluationstrategy;

public class Test {

    public static void main(String args[]) {
        new ObjectMutator().mutateMyMap();
        new ExternalObjectMutator().mutateMyMapFromOutsideMyself();
    }
}

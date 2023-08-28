package com.hackathon.telecomOperationService.constraints;

import com.hackathon.telecomOperationService.entities.Resources;

import java.util.ArrayList;
import java.util.List;

public class ConstantValues {
    public static final int threshold=1;
    public static  List<String> resourcesListConstraint = new ArrayList<>();
    static {
        resourcesListConstraint.add("Laptop");
        resourcesListConstraint.add("Ups");
        resourcesListConstraint.add("Cables");
        resourcesListConstraint.add("Headset");
    }
}

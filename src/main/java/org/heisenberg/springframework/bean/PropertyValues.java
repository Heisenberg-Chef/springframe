package org.heisenberg.springframework.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        Optional<PropertyValue> existingPv = propertyValueList.stream()
                .filter(p -> p.getName().equals(pv.getName()))
                .findFirst();

        if (existingPv.isPresent()) {
            int i = propertyValueList.indexOf(existingPv.get());
            propertyValueList.set(i, pv);
        } else {
            propertyValueList.add(pv);
        }
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        return this.propertyValueList.stream()
                .filter(e -> e.getName().equals(propertyName))
                .findFirst().orElse(null);
    }

}

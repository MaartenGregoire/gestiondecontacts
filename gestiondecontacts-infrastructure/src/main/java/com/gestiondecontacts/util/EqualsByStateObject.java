package com.gestiondecontacts.util;

import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class EqualsByStateObject {
    
    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other, excludedFields());
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, excludedFields());
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
    protected List<String> excludedFields() {
        return Collections.emptyList();
    }
}
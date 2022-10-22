package com.gestiondecontacts.objects;

public enum Statute {
    EMPLOYE(false),
    FREELANCE(true);
    
    private final boolean vatNumberObligated;
    
    Statute(boolean vatNumberObligated) {
        this.vatNumberObligated = vatNumberObligated;
    }
    
    public boolean isVatNumberObligated() {
        return vatNumberObligated;
    }
}

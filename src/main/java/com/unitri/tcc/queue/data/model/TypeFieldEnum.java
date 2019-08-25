package com.unitri.tcc.queue.data.model;

public enum TypeFieldEnum {

    LONG( "Numérico", "Number" ),
    STRING( "Texto", "Text" ),
    DOUBLE( "Decimal", "Double" );

    TypeFieldEnum( String namePt, String nameEn ) {
        this.namePt = namePt;
        this.nameEn = nameEn;
    }

    private String namePt;

    private String nameEn;

    public String getNamePt() {
        return namePt;
    }

    public TypeFieldEnum setNamePt( String namePt ) {
        this.namePt = namePt;
        return this;
    }

    public String getNameEn() {
        return nameEn;
    }

    public TypeFieldEnum setNameEn( String nameEn ) {
        this.nameEn = nameEn;
        return this;
    }
}

package org.un.hadl.m2.connecteur;

public class Role {
    Glue glue;

    public Role(Glue glue){
        this.glue=glue;
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }
}

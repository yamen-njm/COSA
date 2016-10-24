package org.un.hadl.m2.composant;

import org.un.hadl.m2.configuration.Attachement;
import org.un.hadl.m2.configuration.Binding;

public class PortComposant {
    private Binding binding;
    private Attachement attachement;

    public PortComposant() {
    }

    public PortComposant(Binding binding, Attachement attachement) {
        this.binding = binding;
        this.attachement = attachement;
    }


    public Binding getBinding() {
        return binding;
    }

    public void setBinding(Binding binding) {
        this.binding = binding;
    }

    public Attachement getAttachement() {
        return attachement;
    }

    public void setAttachement(Attachement attachement) {
        this.attachement = attachement;
    }
}

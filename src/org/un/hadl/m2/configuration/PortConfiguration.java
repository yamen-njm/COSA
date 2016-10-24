package org.un.hadl.m2.configuration;

public class PortConfiguration {
    private Binding binding;
    private Attachement attachement;

    public PortConfiguration(Binding binding, Attachement attachement) {
        this.binding = binding;
        this.attachement = attachement;
    }

    public PortConfiguration() {
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

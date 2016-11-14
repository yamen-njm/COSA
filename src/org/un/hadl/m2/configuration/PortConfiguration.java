package org.un.hadl.m2.configuration;

public class PortConfiguration {
    private Binding binding;

    public PortConfiguration(Binding binding) {
        this.binding = binding;
    }

    public PortConfiguration() {
    }

    public Binding getBinding() {
        return binding;
    }

    public void setBinding(Binding binding) {
        this.binding = binding;
    }

}

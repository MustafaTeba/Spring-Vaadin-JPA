package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

// Pay attention to the order of annotations
@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
public class UIScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "ui";

    @Autowired
    private Greeter greeter;

    @PostConstruct
    void init() {
        addComponent(new Label("This is a UI scoped view. Greeter says: "+ greeter.sayHello()));
        
        final VerticalLayout layout = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue()
                    + ", it works!"));
        });

        addComponents(name, button);
        addComponent(layout);
        
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
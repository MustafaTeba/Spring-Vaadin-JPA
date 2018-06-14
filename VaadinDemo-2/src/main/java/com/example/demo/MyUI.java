package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI
public class MyUI extends UI {

	@Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
    }
}

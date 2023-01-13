package com.example.application.views.login;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LoginView extends VerticalLayout {

    private TextField name;
    private PasswordField password;

    private Button loginBtn;

    public LoginView() {
        /* User */
        name = new TextField("Username:");
        name.setRequired(true);
        // Required funciona mas nao como desejado, arrumar.
        name.setErrorMessage("Username required");
        name.setAutofocus(true);

        /* Password */
        password = new PasswordField("Password:");
        password.setRequired(true);
        // Nao aparece. Deve estar em conflito com a msg de erro
        password.setErrorMessage("Password required");
        password.setHelperText("Password must be at least 8 characters. It has to have at least one letter and one digit.");
        password.setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
        password.setErrorMessage("Not a valid password");

        /* Login Button */
        loginBtn = new Button("Login");
        loginBtn.addClickListener(e -> {
            Notification.show("User " + name.getValue() + " logged in.");
        });

        loginBtn.addClickShortcut(Key.ENTER);

        // Falta adicionar condicoes para caso usuario ou senha nao estejam preenchidos

        /* Alignment */
        setMargin(true);
        setHorizontalComponentAlignment(Alignment.CENTER, name, password, loginBtn);

        add(name, password, loginBtn);
    }

}

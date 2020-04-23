package hw_jdi.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw_jdi.entities.User;

public class JdiLoginForm extends Form<User> {
    private TextField name, password;
    private Button loginButton;
}

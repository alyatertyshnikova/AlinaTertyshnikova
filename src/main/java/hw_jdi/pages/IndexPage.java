package hw_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw_jdi.entities.User;
import hw_jdi.sections.JdiLoginForm;

@Url("/index.html")
public class IndexPage extends WebPage {
    private Button userIcon;

    private JdiLoginForm jdiLoginForm;

    public void login(User user) {
        userIcon.click();
        jdiLoginForm.login(user);
    }
}

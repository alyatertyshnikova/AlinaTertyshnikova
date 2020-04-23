package hw6.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LogComponent extends AbstractPageComposite {
    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> logs;

    public LogComponent(WebDriver driver) {
        super(driver);
    }

    public List<String> getLogsText() {
        return waitForAllElements(logs).stream()
                .map((WebElement log) -> log.getText().substring(9))
                .collect(Collectors.toList());
    }
}

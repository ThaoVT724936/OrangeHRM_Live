package commons;

import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.thread.ThreadExecutionException;
import org.testng.internal.thread.ThreadTimeoutException;
import pageUIs.CommonUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String dynamicValue){
        getElement(driver,getDynamicLocator(locator,dynamicValue)).click();
    }


    public String getTextElement(WebDriver driver, String locator){
        return getElement(driver,locator).getText();
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName){
        return getElement(driver,locator).getAttribute(attributeName);
    }
    public void sendkeyToElement(WebDriver driver, String locator, String keyToSend){
        getElement(driver,locator).sendKeys(keyToSend);
    }

    public boolean elementIsSelected(WebDriver driver, String locator){
        return getElement(driver,locator).isSelected();
    }

    public boolean elementIsDisplayed(WebDriver driver, String locator){
        return getElement(driver,locator).isDisplayed();
    }

    public boolean elementIsDisplayed(WebDriver driver, String locator, String dynamicValue){
        return getElement(driver,getDynamicLocator(locator,dynamicValue)).isDisplayed();
    }

    public boolean elementIsEnabled(WebDriver driver, String locator){
        return getElement(driver,locator).isEnabled();
    }

    public void checkToCheckboxAndRadio(WebDriver driver, String locator){
        if(!getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public void uncheckToCheckboxRadio(WebDriver driver, String locator){
        if(getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public boolean checkboxRadioIsSelected(WebDriver driver, String locator){
        return getElement(driver,locator).isSelected();
    }

    public boolean checkboxRadioIsNotSelected(WebDriver driver, String locator){
        return !getElement(driver,locator).isSelected();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String Item){
        new Select(getElement(driver,locator)).selectByVisibleText(Item);
    }

    public void selectItemInCustomDropdown(WebDriver driver, String locator, String optionSelect){
        List<WebElement> listOptions = getElements(driver,locator);
        for (WebElement option:listOptions){
            if(option.getText().equals(optionSelect)){
                option.click();
                break;
            }
        }
    }

    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String dynamicValue){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator,dynamicValue))));
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByLocator(locator));
    }
    public List<WebElement> getElements(WebDriver driver, String locator){
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator, String dynamicValue){
        return driver.findElements(getByLocator(getDynamicLocator(locator,dynamicValue)));
    }

    public String getDynamicLocator(String locator, String... dynamicValue){
        return String.format(locator,(Object[]) dynamicValue);
    }
    public By getByLocator(String typeLocator){
        By by = null;
        if (typeLocator.toLowerCase().startsWith("css")){
            by = By.cssSelector(typeLocator.substring(4));
        }
        else if (typeLocator.toLowerCase().startsWith("xpath")){
            by = By.xpath(typeLocator.substring(6));
        }
        else if (typeLocator.toLowerCase().startsWith("name")){
            by = By.name(typeLocator.substring(5));
        }
        else if (typeLocator.toLowerCase().startsWith("class")){
            by = By.className(typeLocator.substring(6));
        }
        else if (typeLocator.toLowerCase().startsWith("id")){
            by = By.id(typeLocator.substring(3));
        }
        else {
            throw new RuntimeException("Locator is invalid");
        }
        return by;
    }
    public Dimension getDimensionOfFile(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);
        int width = image.getWidth();
        int height = image.getHeight();
        return new Dimension(width,height);
    }
    public Dimension getDimensionOfAvatarIcon(WebDriver driver, String locator){
        return getElement(driver,locator).getSize();
    }


    //success message
    public void waitForSuccessMessageDisplayed(WebDriver driver){
        waitForElementVisible(driver,CommonUI.SUCCESS_MESSAGE);
    }
    public String getSuccessMessage(WebDriver driver){
        return getElement(driver, CommonUI.SUCCESS_MESSAGE).getText();
    }
    public void waitForAllIconLoadingDisappear(WebDriver driver){
/*        List<WebElement> elements = getElements(driver,CommonUI.LOADING_ICON);
        System.out.println("Số icon loading tìm thấy: " + elements.size());*/

        new WebDriverWait(driver , Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(driver1 ->
                        {
                            List<WebElement> elements = getElements(driver1,CommonUI.LOADING_ICON);
                            for (WebElement iconLoading: elements){
                                if (iconLoading.isDisplayed()){
                                    return false;
                                }
                            }
                            return true;
                        }
                );
    }

    public void waitForIconLoadingDisappear(WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(CommonUI.LOADING_ICON)));
    }

    public void sleepInSeconds(long timeOfSleep){
        try {
            Thread.sleep(timeOfSleep * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void clearValueInTextbox(WebDriver driver, String locator){
        waitForElementClickable(driver,locator);
        if(GlobalConstants.OS_NAME.toUpperCase().startsWith("WINDOW")){
            getElement(driver,locator).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        }
        if(GlobalConstants.OS_NAME.toUpperCase().startsWith("MAC")){
            getElement(driver,locator).sendKeys(Keys.COMMAND + "a" + Keys.DELETE);
        }
    }

    public String randomNumber(){
        return RandomStringUtils.randomNumeric(5);
    }
}

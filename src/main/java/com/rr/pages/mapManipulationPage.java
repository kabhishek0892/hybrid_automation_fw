package com.rr.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class mapManipulationPage  {

   private WebDriver driver;

    public mapManipulationPage(WebDriver driver)
    {
        this.driver=driver;
    }


    private By Id = By.xpath("//input[@data-id='username']");
    private By password = By.xpath("//input[@data-id='password']");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By settingIcon=By.xpath("//img[@alt='settings icon not selected']");
    private By selectMap=By.xpath("//*[text()='Maps']");
    private By rightArrow=By.xpath("//*[@class='rramr-list-card__footer']/button[2]");
    private By editMap=By.xpath("//*[text()='Edit map']");
    private By selectNode=By.xpath("//img[@alt='NODE icon not selected']");
    private By selectEdge=By.xpath("//img[@alt='EDGE icon not selected']");
    private By selectRegion=By.xpath("//img[@alt='REGION icon not selected']");
    private  By selectedRegionName = By.xpath("//*[@id='root_name']");
    private  By save=By.xpath("//*[text()='Save changes']");







    public String getManipulationPageTitle() {
        return driver.getTitle();
    }


    public void doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(Id).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
        driver.findElement(signInButton).click();
    }

    public void selectMaptoEdit() throws InterruptedException {
        sleep(3);
        driver.findElement(settingIcon).click();
        driver.findElement(selectMap).click();
        driver.findElement(rightArrow).click();
    }

    public void clickonEditButtoninMap() throws InterruptedException {
        sleep(3);
        driver.findElement(editMap).click();

    }

    public void selectNodeAndDraginMap() throws InterruptedException {
        WebElement canavas= driver.findElement(By.xpath("//div[@class='konvajs-content']"));
       driver.findElement(selectNode).click();
        Actions vertex1 = new Actions(driver);
        vertex1.moveToElement(canavas).moveByOffset(100, 100).click();
        Action clickNextPoint = vertex1.build();
        clickNextPoint.perform();
        System.out.println("Selected first node");
        Thread.sleep(5);
        Actions vertex2 = new Actions(driver);
        vertex2.moveToElement(canavas).moveByOffset(10, 100).click();
        Action clickNextPoint1 = vertex1.build();
        clickNextPoint1.perform();
        System.out.println("Selected second node");
        Thread.sleep(5);
    }
    public void joinNodesUsingEdge()
    {
        WebElement canavas= driver.findElement(By.xpath("//div[@class='konvajs-content']"));
        driver.findElement(selectEdge).click();
        Actions joinnode = new Actions(driver);
        joinnode.moveToElement(canavas).moveByOffset(0,50).click().moveByOffset(50,100).click().build().perform();
        System.out.println("Two nodes joined by Edge using maps");
    }

    public void createRegioninMap() throws InterruptedException {
        WebElement canavas= driver.findElement(By.xpath("//div[@class='konvajs-content']"));
        driver.findElement(selectRegion).click();
        Actions createRegion = new Actions(driver);
        createRegion.moveToElement(canavas).moveByOffset(-50,0).clickAndHold().moveToElement(canavas).moveByOffset(75,175).release().build().perform();
        Thread.sleep(5);
        System.out.println("Region Created in Map");

    }

    public void editAndSaveRegionInMap()
    {
        WebElement canavas= driver.findElement(By.xpath("//div[@class='konvajs-content']"));
        Actions clickInselectedRegion = new Actions(driver);
        clickInselectedRegion.moveToElement(canavas).moveByOffset(50,50).click().build().perform();
        driver.findElement(selectedRegionName).sendKeys("Test_1");
        driver.findElement(save).click();
        System.out.println("Region Edit and Saved in Map");
    }

    public void editAndChangeNewLocation() throws InterruptedException {
        driver.findElement(editMap).click();
        WebElement rootPositionX = driver.findElement(By.id("root_pos_x"));
        Thread.sleep(3);
        rootPositionX.clear();
        rootPositionX.sendKeys("05");
        Thread.sleep(3);
        Thread.sleep(3);
        driver.findElement(signInButton).click();
        driver.findElement(save).click();
        driver.navigate().refresh();
        System.out.println("Region X coordinated edited and changed to different value in Map");

    }
}

package ru.SuperMath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GameObjectImpl extends GameObject{
    By taskDiv = By.id("mo_task_id");
    private By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");
    private By keys = By.id("keys_wrapper");
    private By indicators = By.id("statistics");
    private By moreLess = By.id("comps_div");
    private By firstNumberWithKeys = By.id("mo_number_1");
    private By firstNumberWithMoreLessButtons = By.id("co_number_1");
    private By secondNumberWithKeys = By.id("mo_number_2");
    private By secondNumberWithMoreLessButtons = By.id("co_number_2");
    private By operation = By.id("mo_operation");
    private By operationResultWithKeys = By.id("mo_result");
    private By operationResultWithMoreLessBattons = By.id("co_result");
    By tasks_remain = By.id("tasks_remain");
    By tasks_all = By.id("tasks_all");
    By tasks_passed = By.id("tasks_passed");
    By tasks_failed = By.id("tasks_failed");
    private By button0 = By.id("key_0");
    private By button1 = By.id("key_1");
    private By button2 = By.id("key_2");
    private By button3 = By.id("key_3");
    private By button4 = By.id("key_4");
    private By button5 = By.id("key_5");
    private By button6 = By.id("key_6");
    private By button7 = By.id("key_7");
    private By button8 = By.id("key_8");
    private By button9 = By.id("key_9");
    private By buttonMore = By.id("more");
    private By buttonLess = By.id("less");
    private By buttonEquel = By.id("equl");
    private By clock_for_time_out = By.id("mo_smile_img_id");
    private By clock_img = By.id("time_icon");
    private By clock = By.id("circles");
    private By keys_img = By.id("kbrd_icon");
    private By image_img = By.id("hero_icon");
    private By image = By.id("hero_img");
    WebDriver driver;
    WebDriverWait driverWait;

 // объяви WebDriverWait  в одном месте.
    public GameObjectImpl(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }
    public void clickCloseGame(){
        driver.findElement(win_close).click();
    }
    public boolean[] checkGameResult() {
        //(new WebDriverWait(driver, 180)).until(ExpectedConditions.visibilityOfElementLocated(taskDiv));
        boolean isKeys = false;
        boolean isMoreLessButtons = false;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.findElement(keys).isDisplayed()) {
            isKeys = true;
        } else if (driver.findElement(moreLess).isDisplayed()) {
            isMoreLessButtons = true;
        }
        boolean[] results = {isKeys, isMoreLessButtons};
        return results;
    }

    public int[] checkResultWithKeys() {
        String firstNumberVar = getElementContent(firstNumberWithKeys);
        String secondNumberVar = getElementContent(secondNumberWithKeys);
        String operationVar = getElementContent(operation);
        int actualResult = getResultWithKeys(firstNumberVar , secondNumberVar, operationVar);
        enterResult(actualResult + 1);
        String operationResultVar = getElementContent(operationResultWithKeys);
        int[] localResults = {Integer.parseInt(operationResultVar), actualResult};

        return localResults;
    }

    public String[] getPartsOfTask() {
        String[] result = {driver.findElement(firstNumberWithKeys).getText(),
                driver.findElement(secondNumberWithKeys).getText(),
                driver.findElement(operation).getText()};

        return result;
    }

    public int[] getIndicators(){
        int[] result = {(Integer.parseInt(getElementContent(tasks_passed))),
                (Integer.parseInt(getElementContent(tasks_failed))),
                (Integer.parseInt(getElementContent(tasks_remain))),
                (Integer.parseInt(getElementContent(tasks_all)))};
        return result;
    }

    public String getElementContent(By link){
        String result = driver.findElement(link).getText();
        return result;
    }

    public void enterResult(int result) {
        String strResult = String.valueOf(result);
        for(int i = 0; i < strResult.length(); i++){
            String subStr = strResult.substring(i, i + 1);
            pressButton(subStr);
        }
    }

    public void waitIndicatorsLoad() {
        //(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(indicators));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(indicators));
    }

    public void waitTaskBegin() {
        //(new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(taskDiv));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(taskDiv));
    }

    public void watTimeOut(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(clock_for_time_out));
    }

    public void pressButton(String number) {
        By buttonLink = By.id("");
        switch (number.charAt(0)){
            case '0' :
                buttonLink = button0;
                break;
            case '1' :
                buttonLink = button1;
                break;
            case '2' :
                buttonLink = button2;
                break;
            case '3' :
                buttonLink = button3;
                break;
            case '4' :
                buttonLink = button4;
                break;
            case '5' :
                buttonLink = button5;
                break;
            case '6' :
                buttonLink = button6;
                break;
            case '7' :
                buttonLink = button7;
                break;
            case '8' :
                buttonLink = button8;
                break;
            case '9' :
                buttonLink = button9;
                break;
            case '<' :
                buttonLink = buttonLess;
                break;
            case '>' :
                buttonLink = buttonMore;
                break;
            case '=' :
                buttonLink = buttonEquel;
                break;
            default:
                System.out.println("invalid char");
                break;
        }
        driver.findElement(buttonLink).click();
    }

    public int getResultWithKeys(String firstNumber , String secondNumber, String operationVar) {
        int localResult;
        switch (operationVar.charAt(0)){
            case '+' :
                localResult = Integer.parseInt(firstNumber.trim()) + Integer.parseInt(secondNumber.trim());
                break;
            case '-' :
                localResult = Integer.parseInt(firstNumber.trim()) - Integer.parseInt(secondNumber.trim());
                break;
            case 'x' :
                localResult = Integer.parseInt(firstNumber.trim()) * Integer.parseInt(secondNumber.trim());
                break;
            case '/' :
                localResult = Integer.parseInt(firstNumber.trim()) / Integer.parseInt(secondNumber.trim());
                break;
            default:
                localResult = 0;
                System.out.println("incorrect operator");
        }
        return localResult;
    }

    public String[] checkResultWithMoreLessButtons() {
        String firstNumberVar = driver.findElement(firstNumberWithMoreLessButtons).getText();
        String secondNumberVar = driver.findElement(secondNumberWithMoreLessButtons).getText();
        int resultButtonId = getResultWithMoreLessButtons(Integer.parseInt(firstNumberVar), Integer.parseInt(secondNumberVar));
        String resultButton = getResultButtonById(resultButtonId);
        pressButton(getResultButtonById(resultButtonId + 1));
        String operationResultVar = driver.findElement(operationResultWithMoreLessBattons).getText();
        String[] localResults = {operationResultVar, resultButton};
        //assert operationResultVar.equals(resultButton) : "Wrong expected result";

        return localResults;
    }

    public String getResultButtonById(int buttonId) {
        String resultButton = "";
        switch (buttonId){
            case 1 :
                resultButton = "<";
                break;
            case 2 :
                resultButton = "=";
                break;
            case 3 :
                resultButton = ">";
                break;
            case 4 :
                resultButton = "<";
                break;
        }

        return resultButton;
    }

    public int getResultWithMoreLessButtons(int firstNumber, int secondNumber) {
        int resultButtonId;
        if (firstNumber < secondNumber){
            resultButtonId = 1;
        } else if(firstNumber > secondNumber){
            resultButtonId = 3;
        } else {
            resultButtonId = 2;
        }

        return resultButtonId;

    }

    public void timeOutTest(int summ){}//rename waitGameTimeOut
    public void timeOutTest(){}//rename waitGameTimeOut
    public void incorrectAnswersTest(int summ){}//rename enterIncorrectResult
    public void incorrectAnswersTest(){}
    public void correctAnswersTest(int breakpoint){}
    public void correctAnswersTest(){}
}

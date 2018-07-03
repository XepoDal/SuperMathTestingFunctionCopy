package ru.SuperMath;

public class TestGame1EmulateTimeOut extends InvisibleRun {
    //WebDriver driver = getDriver();

    public void testGame1EmulateTimeOut() {
        int[] indicators;
        MainPage mainPage = getMainPage();
        GameObjectImpl game1 = mainPage.gameOpen(1);
        game1.waitIndicatorsLoad();
        indicators = game1.getIndicators();
        int qtyTasksBeforeCycle = indicators[3];
        int tasksFailedBeforeCycle = indicators[1];
        for(int iter = 0; iter < qtyTasksBeforeCycle - 1; iter++)  {
            game1.waitTaskBegin();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            indicators = game1.getIndicators();
            int varTasksPassedBegin = indicators[0];
            int varTasksFailedBegin = indicators[1];
            int varTasksRemainBegin = indicators[2];
            int qtyTasksInLoopBegin = indicators[3];

            String[] partsOfTask = game1.getPartsOfTask();
            String firstNumberVar = partsOfTask[0];
            String secondNumberVar = partsOfTask[1];
            String operationVar = partsOfTask[2];
            int actualResult = game1.getResultWithKeys(firstNumberVar, secondNumberVar, operationVar);
            // press wrong button
            game1.watTimeOut();
            //press correct button
            String strActualResult = Integer.toString(actualResult);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                game1.pressButton((subStr));
            }
            indicators = game1.getIndicators();
            int varTasksPassedEnd = indicators[0];
            int varTasksFailedEnd = indicators[1];
            int varTasksRemainEnd = indicators[2];
            int qtyTasksInLoopEnd = indicators[3];

            assert varTasksRemainEnd == varTasksRemainBegin : "positiveTestCorrectAnswers: tasks remain";//
            assert varTasksFailedEnd == (varTasksFailedBegin + 1) : "positiveTestCorrectAnswers: tasks failed";
            assert varTasksPassedEnd == varTasksPassedBegin : "positiveTestCorrectAnswers: tasks passed";
            assert qtyTasksInLoopEnd == qtyTasksInLoopBegin + 1 : "negativeTestWrongAnswers: tasks all";
        }
        indicators = game1.getIndicators();
        int varTasksFailedAfterCycle = indicators[1];
        int qtyTasksAfterCycle = indicators[3];
        assert varTasksFailedAfterCycle - tasksFailedBeforeCycle == qtyTasksAfterCycle - qtyTasksBeforeCycle
                : "positiveTestCorrectAnswers: tasks summ" ;//
        game1.clickCloseGame();

    }


}


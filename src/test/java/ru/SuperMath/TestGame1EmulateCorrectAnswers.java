package ru.SuperMath;

public class TestGame1EmulateCorrectAnswers extends InvisibleRun {
    //WebDriver driver = getDriver();

    public void testGame1EmulateCorrectAnswers() {
        int[] indicators;
        MainPage mainPage = getMainPage();
        GameObjectImpl game1 = mainPage.gameOpen(1);
        game1.waitIndicatorsLoad();
        indicators = game1.getIndicators();
        int qtyTasks = indicators[3];
        for(int iter = 0; iter < qtyTasks - 1; iter++)  {
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

            String[] partsOfTask = game1.getPartsOfTask();
            String firstNumberVar = partsOfTask[0];
            String secondNumberVar = partsOfTask[1];
            String operationVar = partsOfTask[2];
            int actualResult = game1.getResultWithKeys(firstNumberVar, secondNumberVar, operationVar);
            String strActualResult = Integer.toString(actualResult);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                game1.pressButton(subStr);
            }
            indicators = game1.getIndicators();
            int varTasksPassedEnd = indicators[0];
            int varTasksFailedEnd = indicators[1];
            int varTasksRemainEnd = indicators[2];

            assert varTasksRemainEnd == varTasksRemainBegin - 1 : "positiveTestCorrectAnswers: tasks remain";//
            assert varTasksFailedBegin == varTasksFailedEnd : "positiveTestCorrectAnswers: tasks failed";
            assert varTasksPassedEnd == varTasksPassedBegin + 1 : "positiveTestCorrectAnswers: tasks passed";
        }
        indicators = game1.getIndicators();
        int varTasksPassedAfterCycle = indicators[0];
        int varTasksFailedAfterCycle = indicators[1];
        int varTasksRemainAfterCycle = indicators[2];

        assert (varTasksPassedAfterCycle + varTasksFailedAfterCycle + varTasksRemainAfterCycle) == qtyTasks
                : "positiveTestCorrectAnswers: tasks summ" ;//
        game1.clickCloseGame();

    }


}


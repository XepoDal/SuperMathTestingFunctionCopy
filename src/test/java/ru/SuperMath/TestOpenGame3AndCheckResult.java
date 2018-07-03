package ru.SuperMath;
public class TestOpenGame3AndCheckResult extends InvisibleRun {

    public void testOpenGame3AndCheckResult() {
        MainPage mainPage = getMainPage();
        GameObjectImpl game1 = mainPage.gameOpen(3);
        boolean[] typeCheck = game1.checkGameResult();
        boolean isKeys = typeCheck[0];
        boolean isMoreLessButtons = typeCheck[1];
        if (isKeys){
           int[] resultWithKeys = game1.checkResultWithKeys();
            assert resultWithKeys[0] == resultWithKeys[1] : "Wrong expected result";
        } else if(isMoreLessButtons){
            String[] resultsWithMoreLessButtons = game1.checkResultWithMoreLessButtons();
            assert resultsWithMoreLessButtons[0].equals(resultsWithMoreLessButtons[1]) : "Wrong expected result";
        }

        game1.clickCloseGame();

    }


}


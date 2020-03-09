package kozlov.homework.service;

import java.text.DecimalFormat;
import java.util.Collection;

public class SimpleBenchmark implements BenchmarkService<String> {

    @Override
    public void executeBenchmark(Collection<String> firstList, Collection<String> secondList) throws InterruptedException {

        printHeadOfTheFight(firstList, secondList);

        addElementsBenchmark(firstList, secondList);

        removeElementsBenchmark(firstList, secondList);
    }

    private void addElementsBenchmark(Collection<String> firstList, Collection<String> secondList) {

        DecimalFormat formatter = new DecimalFormat("###,###.###");

        int winsOfFirstListAttempt = 0;
        int winsOfSecondListAttempt = 0;

        // Attempt 1
        long timeForFirstListAttempt1 = measureAddingOperationTime(firstList);
        long timeForSecondListAttempt1 = measureAddingOperationTime(secondList);

        if(timeForFirstListAttempt1 < timeForSecondListAttempt1){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt1 > timeForSecondListAttempt1){
            ++winsOfSecondListAttempt;
        }

        // Attempt 2
        long timeForFirstListAttempt2 = measureAddingOperationTime(firstList);
        long timeForSecondListAttempt2 = measureAddingOperationTime(secondList);

        if(timeForFirstListAttempt2 < timeForSecondListAttempt2){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt2 > timeForSecondListAttempt2){
            ++winsOfSecondListAttempt;
        }

        // Attempt 3
        long timeForFirstListAttempt3 = measureAddingOperationTime(firstList);
        long timeForSecondListAttempt3 = measureAddingOperationTime(secondList);

        if(timeForFirstListAttempt3 < timeForSecondListAttempt3){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt3 > timeForSecondListAttempt3){
            ++winsOfSecondListAttempt;
        }

        // Attempt 4
        long timeForFirstListAttempt4 = measureAddingOperationTime(firstList);
        long timeForSecondListAttempt4 = measureAddingOperationTime(secondList);

        if(timeForFirstListAttempt4 < timeForSecondListAttempt4){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt4 > timeForSecondListAttempt4){
            ++winsOfSecondListAttempt;
        }

        // Attempt 5
        long timeForFirstListAttempt5 = measureAddingOperationTime(firstList);
        long timeForSecondListAttempt5 = measureAddingOperationTime(secondList);

        if(timeForFirstListAttempt5 < timeForSecondListAttempt5){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt5 > timeForSecondListAttempt5){
            ++winsOfSecondListAttempt;
        }

        System.out.printf("%n%50sADDING 1000 ELEMENTS INTO COLLECTION%n%n", "");

        System.out.printf("%34s%18s%18s%18s%18s%10s%n",
                "attempt 1", "attempt 2", "attempt 3", "attempt 4", "attempt 5", "score");

        System.out.printf("%15s:%15s ns%15s ns%15s ns%15s ns%15s ns%10d%n",
                firstList.getClass().getSimpleName(),
                formatter.format(timeForFirstListAttempt1),
                formatter.format(timeForFirstListAttempt2),
                formatter.format(timeForFirstListAttempt3),
                formatter.format(timeForFirstListAttempt4),
                formatter.format(timeForFirstListAttempt5),
                winsOfFirstListAttempt);

        System.out.printf("%15s:%15s ns%15s ns%15s ns%15s ns%15s ns%10d%n",
                secondList.getClass().getSimpleName(),
                formatter.format(timeForSecondListAttempt1),
                formatter.format(timeForSecondListAttempt2),
                formatter.format(timeForSecondListAttempt3),
                formatter.format(timeForSecondListAttempt4),
                formatter.format(timeForSecondListAttempt5),
                winsOfSecondListAttempt);

        System.out.printf("%n%15s: ", "ADDING");
        announceTheWinner(firstList, secondList, winsOfFirstListAttempt, winsOfSecondListAttempt);
    }

    private void removeElementsBenchmark(Collection<String> firstList, Collection<String> secondList) {

        DecimalFormat formatter = new DecimalFormat("###,###.###");

        int winsOfFirstListAttempt = 0;
        int winsOfSecondListAttempt = 0;

        // Attempt 1
        long timeForFirstListAttempt1 = measureRemovingOperationTime(firstList);
        long timeForSecondListAttempt1 = measureRemovingOperationTime(secondList);

        if(timeForFirstListAttempt1 < timeForSecondListAttempt1){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt1 > timeForSecondListAttempt1){
            ++winsOfSecondListAttempt;
        }

        // Attempt 2
        long timeForFirstListAttempt2 = measureRemovingOperationTime(firstList);
        long timeForSecondListAttempt2 = measureRemovingOperationTime(secondList);

        if(timeForFirstListAttempt2 < timeForSecondListAttempt2){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt2 > timeForSecondListAttempt2){
            ++winsOfSecondListAttempt;
        }

        // Attempt 3
        long timeForFirstListAttempt3 = measureRemovingOperationTime(firstList);
        long timeForSecondListAttempt3 = measureRemovingOperationTime(secondList);

        if(timeForFirstListAttempt3 < timeForSecondListAttempt3){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt3 > timeForSecondListAttempt3){
            ++winsOfSecondListAttempt;
        }

        // Attempt 4
        long timeForFirstListAttempt4 = measureRemovingOperationTime(firstList);
        long timeForSecondListAttempt4 = measureRemovingOperationTime(secondList);

        if(timeForFirstListAttempt4 < timeForSecondListAttempt4){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt4 > timeForSecondListAttempt4){
            ++winsOfSecondListAttempt;
        }

        // Attempt 5
        long timeForFirstListAttempt5 = measureRemovingOperationTime(firstList);
        long timeForSecondListAttempt5 = measureRemovingOperationTime(secondList);

        if(timeForFirstListAttempt5 < timeForSecondListAttempt5){
            ++winsOfFirstListAttempt;
        } else if(timeForFirstListAttempt5 > timeForSecondListAttempt5){
            ++winsOfSecondListAttempt;
        }

        System.out.printf("%n%50sREMOVING 1000 ELEMENTS FROM COLLECTION%n%n", "");

        System.out.printf("%34s%18s%18s%18s%18s%10s%n",
                "attempt 1", "attempt 2", "attempt 3", "attempt 4", "attempt 5", "score");

        System.out.printf("%15s:%15s ns%15s ns%15s ns%15s ns%15s ns%10d%n",
                firstList.getClass().getSimpleName(),
                formatter.format(timeForFirstListAttempt1),
                formatter.format(timeForFirstListAttempt2),
                formatter.format(timeForFirstListAttempt3),
                formatter.format(timeForFirstListAttempt4),
                formatter.format(timeForFirstListAttempt5),
                winsOfFirstListAttempt);

        System.out.printf("%15s:%15s ns%15s ns%15s ns%15s ns%15s ns%10d%n",
                secondList.getClass().getSimpleName(),
                formatter.format(timeForSecondListAttempt1),
                formatter.format(timeForSecondListAttempt2),
                formatter.format(timeForSecondListAttempt3),
                formatter.format(timeForSecondListAttempt4),
                formatter.format(timeForSecondListAttempt5),
                winsOfSecondListAttempt);

        System.out.printf("%n%15s: ", "REMOVING");
        announceTheWinner(firstList, secondList, winsOfFirstListAttempt, winsOfSecondListAttempt);

    }

    private long measureAddingOperationTime(Collection<String> list){

        String testString = "test string";

        list.clear();

        long startTime;
        long endTime;

        pauseMilliseconds(500);

        startTime = System.nanoTime();

        for(int i = 0; i < 1000; i++){
            list.add(testString);
        }

        endTime = System.nanoTime();

        return endTime - startTime;
    }

    private long measureRemovingOperationTime(Collection<String> list){

        String testString = "test string";

        long startTime;
        long endTime;

        pauseMilliseconds(500);

        startTime = System.nanoTime();

        while(list.size() > 0){
            list.remove(testString);
        }

        endTime = System.nanoTime();

        return endTime - startTime;
    }

    private void printHeadOfTheFight(Collection<String> firstList, Collection<String> secondList){

        System.out.printf("%n%n%55s[ %s vs %s ]%n",
                "",
                firstList.getClass().getSimpleName(),
                secondList.getClass().getSimpleName());
    }

    private  void pauseMilliseconds(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void announceTheWinner(Collection<String> firstList, Collection<String> secondList,
                                  long winsForFirstList, long winsForSecondList){

        if(winsForFirstList > winsForSecondList){

            System.out.printf("The %s beats the %s (%d : %d).%n",
                    firstList.getClass().getSimpleName(),
                    secondList.getClass().getSimpleName(),
                    winsForFirstList,
                    winsForSecondList);

        } else if(winsForFirstList < winsForSecondList){

            System.out.printf("The %s beats the %s (%d : %d).%n",
                    secondList.getClass().getSimpleName(),
                    firstList.getClass().getSimpleName(),
                    winsForSecondList,
                    winsForFirstList);

        } else {

            System.out.printf("Draw! The %s is as fast as the %s (%d : %d).%n",
                    secondList.getClass().getSimpleName(),
                    firstList.getClass().getSimpleName(),
                    winsForSecondList,
                    winsForFirstList);

        }
    }

}

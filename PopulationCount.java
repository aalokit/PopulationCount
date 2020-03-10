import java.util.*;

class PopulationCount {

    public static void main(String[] args) {

        // Run test cases
        runAllTestCases();
    }

    public static HashSet<Integer> getLowPopulationYears(ArrayList<LifeSpan> lifeSpans) {
        HashSet<Integer> lowPopulationYears = new HashSet<Integer>();

        // Build map for population per year, which will contain the change in population 
        //   as compared to previous year
        HashMap<Integer, Integer> populationYearMap = new HashMap<>();
        for (int i = 0; i < lifeSpans.size(); i++) {
            int birthYear = lifeSpans.get(i).birthYear;
            int deathYear = lifeSpans.get(i).deathYear;


            if (populationYearMap.containsKey(birthYear)) {
                populationYearMap.put(birthYear, populationYearMap.get(birthYear) + 1);
            } else {
                populationYearMap.put(birthYear, 1);
            }
            if (deathYear > 0) {
                if (populationYearMap.containsKey(deathYear + 1)) {
                    populationYearMap.put(deathYear + 1, populationYearMap.get(deathYear + 1) - 1);
                } else {
                    populationYearMap.put(deathYear + 1, -1);
                }
            }
        }

        // For each deathYear, check whether the overall change in population is positive or not .
        // If positive add it to the set of low population years.
        for (int i = 0; i < lifeSpans.size(); i++) {
            int deathYear = lifeSpans.get(i).deathYear;

            if (deathYear > 0) {
                if (populationYearMap.get(deathYear + 1) < 0) {
                    lowPopulationYears.add(deathYear + 1);
                }
            }
        }

        return lowPopulationYears;
    }


    public static class LifeSpan {
        int birthYear;
        int deathYear;

        LifeSpan(int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }
    }

    public static void runAllTestCases() {
        runTestCase1();
        runTestCase2();
        runTestCase3();
        runTestCase4();
    }

    public static void runTestCase1() {
        ArrayList<LifeSpan> lifeSpans = new ArrayList<>();
        lifeSpans.add(new LifeSpan(1902, 1991));
        lifeSpans.add(new LifeSpan(1941, 1978));
        lifeSpans.add(new LifeSpan(2004, -1));
        lifeSpans.add(new LifeSpan(1957, -1));
        lifeSpans.add(new LifeSpan(1989, 2008));
        lifeSpans.add(new LifeSpan(1909, 2005));
        lifeSpans.add(new LifeSpan(1918, -1));
        lifeSpans.add(new LifeSpan(1913, 2010));
        lifeSpans.add(new LifeSpan(1979, -1));
        lifeSpans.add(new LifeSpan(1961, 2002));
        lifeSpans.add(new LifeSpan(1977, 2003));
        lifeSpans.add(new LifeSpan(1909, 1991));


        HashSet<Integer> actualLowPopulationYears = getLowPopulationYears(lifeSpans);
        HashSet<Integer> expectedLowPopulationYears = new HashSet<>(Arrays.asList(new Integer[]{1992, 2003, 2006, 2009, 2011}));
        if (expectedLowPopulationYears.size() != actualLowPopulationYears.size()) {
            System.out.println("Test 3 failed: Unequal size : Actual Size = " + actualLowPopulationYears.size() + ", Expected Size : " + expectedLowPopulationYears.size());
            return;
        }

        final boolean[] testPass = {true};
        expectedLowPopulationYears.forEach((expectedYear) -> {
            if (!actualLowPopulationYears.contains(expectedYear)) {
                System.out.println("Test 1 failed: Not found expectedYear= " + expectedYear);
                testPass[0] = false;
            }
        });
        if (testPass[0]) {
            System.out.println("Test case 1 has passed");
        }
    }

    public static void runTestCase2() {

        ArrayList<LifeSpan> lifeSpans = new ArrayList<>();
        lifeSpans.add(new LifeSpan(1902, 1991));
        lifeSpans.add(new LifeSpan(1941, 1978));
        lifeSpans.add(new LifeSpan(2004, -1));
        lifeSpans.add(new LifeSpan(1957, -1));
        lifeSpans.add(new LifeSpan(1989, 2008));
        lifeSpans.add(new LifeSpan(1909, 2005));
        lifeSpans.add(new LifeSpan(1918, -1));
        lifeSpans.add(new LifeSpan(1913, 2010));
        lifeSpans.add(new LifeSpan(1979, -1));
        lifeSpans.add(new LifeSpan(1961, 2002));
        lifeSpans.add(new LifeSpan(1977, 2003));
        lifeSpans.add(new LifeSpan(2003, -1));
        lifeSpans.add(new LifeSpan(1909, 1991));


        HashSet<Integer> actualLowPopulationYears = getLowPopulationYears(lifeSpans);
        HashSet<Integer> expectedLowPopulationYears = new HashSet<>(Arrays.asList(new Integer[]{1992, 2006, 2009, 2011}));
        if (expectedLowPopulationYears.size() != actualLowPopulationYears.size()) {
            System.out.println("Test 3 failed: Unequal size : Actual Size = " + actualLowPopulationYears.size() + ", Expected Size : " + expectedLowPopulationYears.size());
            return;
        }

        final boolean[] testPass = {true};
        expectedLowPopulationYears.forEach((expectedYear) -> {
            if (!actualLowPopulationYears.contains(expectedYear)) {
                System.out.println("Test 2 failed: Not found expectedYear= " + expectedYear);
                testPass[0] = false;
            }
        });
        if (testPass[0]) {
            System.out.println("Test case 2 has passed");
        }
    }

    public static void runTestCase3() {

        ArrayList<LifeSpan> lifeSpans = new ArrayList<>();
        lifeSpans.add(new LifeSpan(1902, 1991));
        lifeSpans.add(new LifeSpan(1941, 1978));
        lifeSpans.add(new LifeSpan(2004, -1));
        lifeSpans.add(new LifeSpan(1957, 2003));
        lifeSpans.add(new LifeSpan(1957, -1));
        lifeSpans.add(new LifeSpan(1989, 2008));
        lifeSpans.add(new LifeSpan(1909, 2005));
        lifeSpans.add(new LifeSpan(1918, -1));
        lifeSpans.add(new LifeSpan(1913, 2010));
        lifeSpans.add(new LifeSpan(1979, -1));
        lifeSpans.add(new LifeSpan(1961, 2002));
        lifeSpans.add(new LifeSpan(1977, 2003));
        lifeSpans.add(new LifeSpan(2003, -1));
        lifeSpans.add(new LifeSpan(1909, 1991));


        HashSet<Integer> actualLowPopulationYears = getLowPopulationYears(lifeSpans);
        HashSet<Integer> expectedLowPopulationYears = new HashSet<>(Arrays.asList(new Integer[]{1992, 2006, 2009, 2011, 2004}));
        if (expectedLowPopulationYears.size() != actualLowPopulationYears.size()) {
            System.out.println("Test 3 failed: Unequal size : Actual Size = " + actualLowPopulationYears.size() + ", Expected Size : " + expectedLowPopulationYears.size());
            return;
        }

        final boolean[] testPass = {true};
        expectedLowPopulationYears.forEach((expectedYear) -> {
            if (!actualLowPopulationYears.contains(expectedYear)) {
                System.out.println("Test 3 failed: Not found expectedYear= " + expectedYear);
                testPass[0] = false;
            }
        });
        if (testPass[0]) {
            System.out.println("Test case 3 has passed");
        }
    }

    public static void runTestCase4() {

        ArrayList<LifeSpan> lifeSpans = new ArrayList<>();
        lifeSpans.add(new LifeSpan(1902, 1991));
        lifeSpans.add(new LifeSpan(1941, 1978));
        lifeSpans.add(new LifeSpan(2004, -1));
        lifeSpans.add(new LifeSpan(1957, 2003));
        lifeSpans.add(new LifeSpan(1957, -1));
        lifeSpans.add(new LifeSpan(1989, 2008));
        lifeSpans.add(new LifeSpan(1909, 2005));
        lifeSpans.add(new LifeSpan(1918, -1));
        lifeSpans.add(new LifeSpan(1913, 2010));
        lifeSpans.add(new LifeSpan(1979, -1));
        lifeSpans.add(new LifeSpan(1961, 2002));
        lifeSpans.add(new LifeSpan(1977, 2003));
        lifeSpans.add(new LifeSpan(2003, -1));
        lifeSpans.add(new LifeSpan(1909, 1991));
        lifeSpans.add(new LifeSpan(2004, -1));


        HashSet<Integer> actualLowPopulationYears = getLowPopulationYears(lifeSpans);
        HashSet<Integer> expectedLowPopulationYears = new HashSet<>(Arrays.asList(new Integer[]{1992, 2006, 2009, 2011}));
        if (expectedLowPopulationYears.size() != actualLowPopulationYears.size()) {
            System.out.println("Test 4 failed: Unequal size : Actual Size = " + actualLowPopulationYears.size() + ", Expected Size : " + expectedLowPopulationYears.size());
            return;
        }

        final boolean[] testPass = {true};
        expectedLowPopulationYears.forEach((expectedYear) -> {
            if (!actualLowPopulationYears.contains(expectedYear)) {
                System.out.println("Test 4 failed: Not found expectedYear= " + expectedYear);
                testPass[0] = false;
            }
        });
        if (testPass[0]) {
            System.out.println("Test case 4 has passed");
        }
    }
}
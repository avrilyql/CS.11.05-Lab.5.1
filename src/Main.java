public class Main {

    public static int getCountryTotalWastePerYear(String country, String[] countries, int[] totalWasteKgPerCapitaPerYear)
    {
        int totalWaste = 0;
        for(int i = 0; i<countries.length; i++){
            if(countries[i].equals(country)){
                totalWaste = totalWasteKgPerCapitaPerYear[i];

            }
        }
        return totalWaste;
    }

    public static String getCountryWithMostWastePerCapita(String[] countries, int[] totalWasteKgPerCapitaPerYear)
    {
        String finalWaste = "";
        int mostWaste = 0;
        int currentWaste = 0;
        for(int i = 0; i<countries.length; i++){
            currentWaste = totalWasteKgPerCapitaPerYear[i];
            if(currentWaste > mostWaste){
                mostWaste = currentWaste;
                finalWaste = countries[i];
            }
        }
        return finalWaste;
    }

    public static String[] getCountriesWithHighestPovertyPercentage(String[] countries, double[] percentagesShareInPoverty)
    {
        String[] highPoverty = new String[4];
        double[] highestPercentages = new double[4];
        int n = 0;

        for (int i = 0; i < countries.length; i++) {
            double currentPoverty = percentagesShareInPoverty[i];
            if (n < 4) {
                highPoverty[n] = countries[i];
                highestPercentages[n] = currentPoverty;
                n++;
            } else {
                double minPercentage = highestPercentages[0];
                int minIndex = 0;
                for (int j = 1; j < highestPercentages.length; j++) {
                    if (highestPercentages[j] < minPercentage) {
                        minPercentage = highestPercentages[j];
                        minIndex = j;
                    }
                }
                if (currentPoverty > minPercentage) {
                    highPoverty[minIndex] = countries[i];
                    highestPercentages[minIndex] = currentPoverty;
                }
            }
        }
        return Arrays.copyOf(highPoverty, n);
    }

    public static String[] getCountriesWithHighConfidence(String[] countries, String[] confidences) {
        int count = 0;
        for (int i = 0; i < confidences.length; i++) {
            if (confidences[i].equals("High Confidence")) {
                count++;
            }
        }
        String[] highConfidenceCountries = new String[count];
        int index = 0;
        for (int i = 0; i < countries.length; i++) {
            if (confidences[i].equals("High Confidence")) {
                highConfidenceCountries[index] = countries[i];
                index++;
            }
        }
        return highConfidenceCountries;
    }

}

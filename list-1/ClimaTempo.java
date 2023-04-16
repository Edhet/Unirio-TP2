
public class Main {
    public static void main(String[] args)
    {
        double[] rain = { 5.34, 2.34, 0.0, 0.0, 3.23, 0.0, 2.42 };
        double[] pressure = { 99.3, 95.34, 101.3, 98.42, 103.4, 100.0, 102.87 };

        ClimateInfo ct = new ClimateInfo();
        ct.setRainfall(rain);
        ct.setPressure(pressure);

        System.out.println("Máxima pluvial: " + ct.maxRainfall());
        System.out.println("Média pluvial: " + ct.averageRainfall());
        System.out.println("Pressão mínima: " + ct.minPressure());
    }
}

class ClimateInfo {
    private double[] rainfall;
    private double[] pressure;

    public boolean setRainfall(double[] rainfall) {
        if (rainfall.length != 7)
            return false;
        this.rainfall = rainfall;
        return true;
    }

    public boolean setPressure(double[] pressure) {
        if (pressure.length != 7)
            return false;
        this.pressure = pressure;
        return true;
    }

    public double averageRainfall() {
        double sum = 0;
        for (double val : this.rainfall) {
            sum += val;
        }
        return sum / this.rainfall.length;
    }

    public double maxRainfall() {
        double highest = 0;
        for (double val : this.rainfall) {
            if (val > highest)
                highest = val;
        }
        return highest;
    }

    public double minPressure() {
        double lowest = Double.MAX_VALUE;
        for (double val : this.pressure) {
            if (val < lowest)
                lowest = val;
        }
        return lowest;
    }
}
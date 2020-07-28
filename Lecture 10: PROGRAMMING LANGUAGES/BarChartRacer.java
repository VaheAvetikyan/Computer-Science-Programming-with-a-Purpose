import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdAudio.loop("soundtrackE.wav");
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In chart = new In(filename);

        String title = chart.readLine();
        String xAxisLabel = chart.readLine();
        String dataSource = chart.readLine();
        BarChart mainChart = new BarChart(title, xAxisLabel, dataSource);

        while (chart.hasNextLine()) {
            String headerLine = chart.readLine();
            if (headerLine.isEmpty()) {
                continue;
            }
            int n = Integer.parseInt(headerLine);
            Bar[] bars = new Bar[n];

            for (int i = 0; i < n; i++) {
                String line = chart.readLine();
                String[] splitLine = line.split(",");

                String caption = splitLine[0];
                mainChart.setCaption(caption);

                String name = splitLine[1];
                // String country = splitLine[2];
                int value = Integer.parseInt(splitLine[3]);
                String category = splitLine[4];

                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars);
            for (int i = bars.length - 1; i >= bars.length - k; i--) {
                if (bars[i].getValue() == 0) continue;
                mainChart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            mainChart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
            mainChart.reset();
        }

        StdAudio.close();
    }
}
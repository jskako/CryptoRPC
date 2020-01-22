/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoseminar;

/**
 *
 * @author josips
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Chart extends JFrame {
    
    String titleNew;
    ArrayList<String> listChartShow;
    public Chart(String title, ArrayList<String> listChart) {
        super(title);
        this.titleNew = title;    
        this.listChartShow = listChart;
        // Create dataset
        PieDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createPieChart(
                titleNew,
                dataset,
                true,
                true,
                false);
        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(String lst : listChartShow){
            int countElements = Collections.frequency(listChartShow,lst);
            dataset.setValue(lst, countElements);
        }
        return dataset;
    }

    public void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Chart example = new Chart(titleNew, listChartShow);
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            example.setVisible(true);
        });
    }

}

package com.seip;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.*;
import java.util.ArrayList;

/***
 *
 * @author chrisfaltsetas, antonisgkortzis The purpose of this class is to generate a simple
 *         histogram of values using a JFreeChart XYLine chart.
 */
public class HistogramGenerator {
	public static void main(String[] args) {
		try {
			// Open and read file given from execution arguments
			File file = new File(args[0]);
			String encoding = "UTF8";
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), encoding));
			
			// Create an ArrayList with the given values from the file
			int[] grades = new int[11];
			String value = reader.readLine();
			while (value != null) {
				grades[Integer.parseInt(value)]++;
				value = reader.readLine();
			}
			
			// Call method to generate histogram with given values
			HistogramGenerator histoGen = new HistogramGenerator();
			histoGen.generateChart(grades);
			
			// Close resources
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file \"" + args[0] + "\" was not found.");
			e.getMessage();
		} catch (UnsupportedEncodingException e) {
			System.out.println("The encoding provided is not supported.");
			e.getMessage();
		} catch (Exception e) {
			System.out.println("There was a problem reading the file.");
			System.out.println("Please make sure the data is in the right format and try again.");
			e.getMessage();
		}
	}
	
	/***
	 *
	 * @author  Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 *
	 * @param dataValues Single dimension integer array
	 */
	public void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("grades");
		
		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}
		
		// add the series to the dataset
		dataset.addSeries(data);
		
		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls
		
		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Frequency of grades", "Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("Grade Frequency histogram", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
	
}
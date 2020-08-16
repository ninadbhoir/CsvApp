package com.base.codingtask;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvReaderAppFinalBuild
{
	public static final String filePath1 = "C:\\Users\\Ninad\\Desktop\\InputFiles\\cm29JAN2020bhav.csv";
	public static final String filePath2 = "C:\\Users\\Ninad\\Desktop\\InputFiles\\cm30JAN2020bhav.csv";
	public static final String filePath3 = "C:\\Users\\Ninad\\Desktop\\InputFiles\\cm31JAN2020bhav.csv";
	public static final String outPutFile = "C:\\Users\\Ninad\\Desktop\\OutputFile\\Result.csv";

	public static void main(String[] args) throws IOException {

		readDataLineByLine(filePath1, filePath2, filePath3, outPutFile);
	}
	public static void readDataLineByLine(String File1, String File2, String File3, String outPutFile)
			throws IOException {
		double highValue;
		double lowValue;
		double prevCLOSE;
		double dailyRange;
		double dAtr;
		String symbol;
		String date;
		FileReader filereader;
		CSVReader csvReader;
		CSVWriter writer;
		PrintWriter pw;
		try {
			StringBuffer csvHeader = new StringBuffer("");
			csvHeader.append("Symbol,TIMESTAMP,Daily Range,DATR\n");
			filereader = new FileReader(File1);
			csvReader = new CSVReader(filereader);
			System.out.println("--------------Reading Data From CSV Files--------------------------------------");
			System.out.println();
			pw = new PrintWriter(new FileWriter(outPutFile));
			pw.write(csvHeader.toString());
			String[] record1;
			csvReader.readNext();
			System.out.println("--------------Processing File--------------------------------------");
			System.out.println();
			while ((record1 = csvReader.readNext()) != null) {
				symbol = record1[0];
				date = record1[10];
				highValue = Double.parseDouble(record1[3]);
				lowValue = Double.parseDouble(record1[4]);
				prevCLOSE =Double.parseDouble(record1[7]);
				dailyRange = highValue - lowValue;
				dAtr= Math.abs(highValue-prevCLOSE);
				pw.print(symbol);
				pw.print(","+date);
				pw.print(","+dailyRange);
				pw.println(","+dAtr);
			}
			filereader = new FileReader(File2);
			csvReader = new CSVReader(filereader);
			String[] record2;
			csvReader.readNext();
			while ((record2 = csvReader.readNext()) != null) {
				symbol = record2[0];
				date = record2[10];
				highValue = Double.parseDouble(record2[3]);
				lowValue = Double.parseDouble(record2[4]);
				dailyRange = highValue - lowValue;
				prevCLOSE =Double.parseDouble(record2[7]);
				dAtr= Math.abs(highValue-prevCLOSE);
				pw.print(symbol);
				pw.print("," + date);
				pw.print("," + dailyRange);
				pw.println(","+dAtr);
			}
			filereader = new FileReader(File3);
			csvReader = new CSVReader(filereader);
			String[] record3;
			csvReader.readNext();
			while ((record3 = csvReader.readNext()) != null) {
				symbol = record3[0];
				date = record3[10];
				highValue = Double.parseDouble(record3[3]);
				lowValue = Double.parseDouble(record3[4]);
				dailyRange = highValue - lowValue;
				prevCLOSE =Double.parseDouble(record3[7]);
				dAtr= Math.abs(highValue-prevCLOSE);
				pw.print(symbol);
				pw.print("," + date);
				pw.print("," + dailyRange);
				pw.println(","+dAtr);
			}
			System.out.println("--------------CSV file was created successfully--------------------------------------");
			csvReader.close();
			filereader.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
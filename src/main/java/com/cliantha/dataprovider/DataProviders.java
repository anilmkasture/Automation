/**
 * 
 */
package com.cliantha.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.cliantha.utility.NewExcelLibrary;

/**
 * @author Octalsoft-86
 *
 */
public class DataProviders {
	NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet1");
			// Total Columns
			int column = obj.getColumnCount("Sheet1");
			int actRows = rows;
			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet1", j, i + 2);
					System.out.println("Anil : " + data[i][j]);
				}
			}
			return data;
			
		}

	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "anil")
		public Object[][] getEmail() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet2");
			// Total Columns
			int column = obj.getColumnCount("Sheet2");
			int actRows = rows ;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet2", j, i + 2);
					System.out.println("Current working directory in Java : " + data[i][j]);
				}
			}
			return data;
		}

	//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
		@DataProvider(name = "anil1")
		public Object[][] getProduct() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet3");
			// Total Columns
			int column = obj.getColumnCount("Sheet3");
			int actRows = rows;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet3", j, i + 2);
				}
			}
			return data;
		}

		// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		@DataProvider(name = "searchProduct")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = obj.getRowCount("SearchProduct");
			// Total Columns
			int column = obj.getColumnCount("SearchProduct");
			int actRows = rows;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "newAcountDetailsData")
		public Object[][] accountCreation() {

			// Totals rows count
			int rows = obj.getRowCount("AccountCreationData");
			// Total Columns
			int column = obj.getColumnCount("AccountCreationData");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("AccountCreationData", j, 1),
							obj.getCellData("AccountCreationData", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}

}

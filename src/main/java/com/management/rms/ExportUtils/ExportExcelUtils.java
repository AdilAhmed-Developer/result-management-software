package com.management.rms.ExportUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.management.rms.entity.Marks;
import com.management.rms.entity.Subject;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;


public class ExportExcelUtils {
 private XSSFWorkbook workbook;
 private XSSFSheet sheet;
 private List<Marks> marksList;
 private List<Subject> subjectList;
 
 
public ExportExcelUtils(List<Marks> marksList, List<Subject> subjectList) {
	super();
	this.marksList = marksList;
	this.subjectList = subjectList;
	workbook = new XSSFWorkbook();
}

private void  createCell(Row row,int columnCount,Object value,CellStyle style) {
	sheet.autoSizeColumn(columnCount);
	Cell cell = row.createCell(columnCount);
	if(value instanceof Integer) {
		cell.setCellValue((Integer) value);
		
	}else if(value instanceof Double) {
		cell.setCellValue((Double) value);
		
	}else if(value instanceof Boolean) {
		cell.setCellValue((Boolean) value);
		
	}else if(value instanceof Long) {
		cell.setCellValue((Long) value);
	}else {
		cell.setCellValue((String) value);
	}
	cell.setCellStyle(style);
	
}
 

private void createHeaderRow() {
	sheet = workbook.createSheet("Student Information");
	Row row = sheet.createRow(0);
	CellStyle style = workbook.createCellStyle();
	XSSFFont font = workbook.createFont();
	font.setBold(true);
	font.setFontHeight(20);
	style.setFont(font);
	style.setAlignment(HorizontalAlignment.CENTER);
	createCell(row,0,"Student Information",style);
	sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
	font.setFontHeightInPoints((short)10);
	
	row = sheet.createRow(1);
	font.setBold(true);
	font.setFontHeight(16);
	style.setFont(font);
//	createCell(row,0,"Sr. No",style);
	createCell(row,0,"Appeared",style);
	createCell(row,1,"passed",style);
	createCell(row,2,"Passed %",style);
	createCell(row,3,"Distinction",style);
	createCell(row,4,"First Class",style);
	createCell(row,5,"Second Class",style);
	createCell(row,6,"Fail",style);
	
}

private void writeResultData(int count,int appeared) {
	int rowCount = 2;
	CellStyle style = workbook.createCellStyle();
	XSSFFont font = workbook.createFont();
	font.setFontHeight(14);
	style.setFont(font);
	
	float passPercent = (float) (count * 100)/appeared;
	 DecimalFormat f = new DecimalFormat("##.00");
	 
	 int counter = 1;
	 
	 int distinctionCount = 0;
	 int firstClassCount = 0;
	 int secondClassCount = 0;
	 int failCount = 0;
	


	 
	for(Marks marks : marksList) {
		Row row = sheet.createRow(2);
		int columnCount = 0;
//		createCell(row,columnCount++,counter,style);
		createCell(row,columnCount++,appeared,style);
		createCell(row,columnCount++,count,style);
		createCell(row,columnCount++,f.format(passPercent),style);
		
		float distinction = marks.getPercentage();
		 if(distinction >= 75.00f) {
			 distinctionCount++;
		 }
		 createCell(row,columnCount++,distinctionCount,style);
		 
		 
			float firstclass = marks.getPercentage();
			 if(firstclass >= 60.00f && firstclass <75.00f) {
				 firstClassCount++;
			 }
			 createCell(row,columnCount++,firstClassCount,style);
			 
			 float secondclass = marks.getPercentage();
			 if(secondclass  >= 45.00f && secondclass <60.00f) {
				 secondClassCount++;
			 }
			createCell(row,columnCount++,secondClassCount,style);
			
			 float fail = marks.getPercentage();
			 if(fail  <= 35.00f) {
				 failCount++;
			 }
			createCell(row,columnCount++,failCount,style);
			
			counter++;
		}
		
	
	
	
	
}



public void exportDataToExcel(HttpServletResponse response,int count,int appeared) throws IOException {
	createHeaderRow();
	writeResultData(count,appeared);
	ServletOutputStream outputStream = response.getOutputStream();
	workbook.write(outputStream);
	workbook.close();
	outputStream.close();
	


}










 
}

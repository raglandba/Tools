/*
 * Copyright (C) Brandon Alexander Ragland - All Rights Reserved
 * Unauthorized viewing of this file, via any medium is strictly prohibited
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Unauthorized editing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Brandon Alexander Ragland <host@raglandba.com>
 */
package com.raglandba.tools.poi;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author Brandon Alexander Ragland
 */
public class POIWorkbookTools{
	public static Cell getCell(Sheet sheet, int row, int column){
		if(sheet == null)return null;
		if(row < 0 || column < 0)return null;

		Row r = sheet.getRow(row);
		if(r != null){
			Cell c = r.getCell(column);
			if(c != null){
				return c;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	public static Cell getCell(Row row, int column){
		if(column < 0)return null;

		if(row != null){
			Cell c = row.getCell(column);
			if(c != null){
				return c;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	public static Cell getACell(Sheet sheet, int row, int column){
		if(sheet == null)return null;
		if(row < 0 || column < 0)return null;

		Row r = sheet.getRow(row);
		if(r != null){
			Cell c = r.getCell(column);
			if(c != null){
				return c;
			}else{
				return r.createCell(column);
			}
		}else{
			return null;
		}
	}

	public static Cell getACell(Row row, int column){
		if(column < 0)return null;

		if(row != null){
			Cell c = row.getCell(column);
			if(c != null){
				return c;
			}else{
				return row.createCell(column);
			}
		}else{
			return null;
		}
	}

	public static String getCellString(Sheet sheet, int row, int column){
		Cell cell = getCell(sheet, row, column);

		if(cell != null && cell.getCellTypeEnum() == CellType.STRING){
			return cell.getStringCellValue();
		}else{
			return null;
		}
	}

	public static String getCellString(Row row, int column){
		Cell cell = getCell(row, column);

		if(cell != null && cell.getCellTypeEnum() == CellType.STRING){
			return cell.getStringCellValue();
		}else{
			return null;
		}
	}

	public static double getCellDouble(Sheet sheet, int row, int column){
		Cell cell = getCell(sheet, row, column);
		return cell.getNumericCellValue();
	}

	public static double getCellDouble(Row row, int column){
		Cell cell = getCell(row, column);
		return cell.getNumericCellValue();
	}

	public static Row copyRow(Sheet dest, Row source){
		Row row = dest.createRow(dest.getLastRowNum() + 1);

		for(Iterator<Cell> it = source.cellIterator(); it.hasNext();){
			Cell cell = it.next();
			Cell copy = row.createCell(cell.getColumnIndex());

			switch(cell.getCellTypeEnum()){
				case STRING:
					copy.setCellValue(cell.getStringCellValue());
					break;
				case NUMERIC:
					copy.setCellValue(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					copy.setCellValue(cell.getBooleanCellValue());
					break;
			}
		}

		return row;
	}

	public static Cell copyCell(Row dest, int destColumn, Cell source){
		if(dest == null || source == null){
			return null;
		}

		Cell destCell = dest.createCell(destColumn);
		switch(source.getCellTypeEnum()){
			case STRING:
				destCell.setCellValue(source.getStringCellValue());
				break;
			case NUMERIC:
				destCell.setCellValue(source.getNumericCellValue());
				break;
			case BOOLEAN:
				destCell.setCellValue(source.getBooleanCellValue());
				break;
		}
		
		return destCell;
	}

	/**
	 * Creates a cell using the supplied object at the index in the supplied row. This method is safe in that it checks for nulls, index out
	 * of bounds, and type.
	 *
	 * @param row The row to create the cell on
	 * @param index WHere we should create the cell
	 * @param content The content of the new cell
	 * @return true if successful
	 */
	public static boolean createCell(Row row, int index, Object content){
		if(row == null || index < 0 || index > 1048576 || content == null){
			return false;
		}

		//Cell already exists??
		if(row.getCell(index) != null){
			return false;
		}

		if(content instanceof Double){
			Double d = (Double) content;
			row.createCell(index).setCellValue(d);
			return true;
		}

		if(content instanceof Long){
			Long i = (Long) content;
			row.createCell(index).setCellValue(i);
			return true;
		}

		if(content instanceof Integer){
			Integer i = (Integer) content;
			row.createCell(index).setCellValue(i);
			return true;
		}

		if(content instanceof String){
			String s = (String) content;
			row.createCell(index).setCellValue(s);
			return true;
		}

		return false;
	}
}

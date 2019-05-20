package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcel{
	
	private String GetCells(List cell_data) {
		String result="";
		for(int i=0; i<cell_data.size(); i++)
		{
			List cell_tmp=(List) cell_data.get(i);
			for(int j=0; j<cell_tmp.size(); j++)
			{
				XSSFCell cell=(XSSFCell) cell_tmp.get(j);
				result+=cell.toString()+ '/';
			}
			result+='&';
		}
		return result;
	}

	public String ReadStringFromExcelFile(File location)throws IOException,FileNotFoundException{
		List CellData=new ArrayList();
		FileInputStream fileinputstream=new FileInputStream(location);
		XSSFWorkbook workbook=new XSSFWorkbook(fileinputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		Iterator row=sheet.rowIterator();
		while(row.hasNext())
		{
			if((row.hasNext() + "").equals("")) {
				
			}else{
				XSSFRow row2=(XSSFRow) row.next();
				Iterator ite=row2.cellIterator();
				List cell_tmp=new ArrayList();
				while(ite.hasNext())
				{
					 XSSFCell cell=(XSSFCell)ite.next();
					 cell_tmp.add(cell);	 
				}
				CellData.add(cell_tmp);	
			}
		}
		return GetCells(CellData);
	}
	
}

import java.util.Date;

public class Util {

    public static String generateGmail(){
        Date date = new Date();
        String email=  date.toString().replace(" ","_").replace(":","_");
        return "Fake_" + email + "@gmail.com";
    }

//    public static Object[][] getDataFromExcel(String sheetName){
//        XSSFWorkbook workbook = null;
//        File excelFile = new File(System.getProperty("user.dir") +"src/main/java/TestData/TestData.xlsx");
//        try {
//            FileInputStream fisExcel = new FileInputStream(excelFile);
//
//             workbook = new XSSFWorkbook(fisExcel);
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
//        XSSFSheet sheet = workbook.getSheet(sheetName);
//
//        int rows = sheet.getLastRowNum();
//        int cols = sheet.getRow(0).getLastCellNum();
//
//        Object [][] data = new Object[rows][cols];
//        for (int i = 0;i<rows;i++){
//            XSSFRow row = sheet.getRow(i+1);
//
//            for (int j = 0; j<cols;j++){
//                XSSFCell cell = row.getCell(j);
//                CellType cellType = cell.getCellType();
//
//                switch(cellType){
//                    case STRING:
//                        data[i][j] = cell.getStringCellValue();
//                        break;
//                    case NUMERIC:
//                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
//                        break;
//                    case BOOLEAN:
//                        data[i][j] = cell.getBooleanCellValue();
//                        break;
//                 }
//
//            }
//        }
//        return data;
//    }
}

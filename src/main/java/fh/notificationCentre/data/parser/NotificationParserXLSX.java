package fh.notificationCentre.data.parser;

import fh.notificationCentre.data.entities.Notification;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by filip on 26.6.15.
 */
public class NotificationParserXLSX implements NotificationParser {

    //Singleton
    private static NotificationParserXLSX instance = new NotificationParserXLSX();

    private NotificationParserXLSX(){

    };

    public static synchronized NotificationParserXLSX getInstance() {
            return instance;
    }

    @Override
    public List<Notification> parse(String filepath) {
        List<Notification> notifications = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filepath);
            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            // Return first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = mySheet.iterator();
            // Traversing over each row of XLSX file
            rowIterator.next(); // skip table headers
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through each columns
                Notification notification = new Notification();
                if (row.getCell(0) != null) {
                    notification.setNotificationGuid(row.getCell(0).getStringCellValue());
                }
                if (row.getCell(1) != null) {
                    notification.setDeviceGuid(row.getCell(1).getStringCellValue());
                }
                if (row.getCell(2) != null) {
                    notification.setUserGuid(row.getCell(2).getStringCellValue());
                }
                if (row.getCell(3) != null) {
                    notification.setEventType(row.getCell(3).getStringCellValue());
                }
                if (row.getCell(4) != null) {
                    notification.setEventSubtype(row.getCell(4).getStringCellValue());
                }
                if (row.getCell(5) != null) {
                    notification.setGeoferenceLat(row.getCell(5).getNumericCellValue());
                }
                if (row.getCell(6) != null) {
                    notification.setGeoferenceLon(row.getCell(6).getNumericCellValue());
                }
                if (row.getCell(7) != null) {
                    notification.setGeoferenceRadiusMetres(new Float(row.getCell(7).getNumericCellValue()));
                }
                if (row.getCell(8) != null) {
                    notification.setTitle(row.getCell(8).getStringCellValue());
                }
                if (row.getCell(9) != null) {
                    notification.setContent(row.getCell(9).getStringCellValue());
                }
                if (row.getCell(10) != null) {
                    notification.setEventTimestamp(row.getCell(10).getNumericCellValue());
                }
                if (row.getCell(11) != null) {
                    notification.setSentTimestamp(row.getCell(11).getNumericCellValue());
                }
                notification.setReadByUserGuid(new HashMap<>());
                notifications.add(notification);
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return notifications;
    }
}

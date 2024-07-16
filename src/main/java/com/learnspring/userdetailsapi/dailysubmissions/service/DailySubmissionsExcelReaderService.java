//package com.learnspring.userdetailsapi.dailysubmissions.service;
//
//import com.learnspring.userdetailsapi.dailysubmissions.model.DailySubmissionsInfo;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import static com.learnspring.userdetailsapi.common.ExcelUtil.*;
//
//@Service
//public class DailySubmissionsExcelReaderService {
//
//    @Value("${daily-submissions-excel-sheet-index}")
//    private int sheetIndex;
//
//    public List<DailySubmissionsInfo> readExcelFile(MultipartFile file) throws Exception {
//        try (var workbook = new XSSFWorkbook(file.getInputStream())) {
//            var sheet = workbook.getSheetAt(sheetIndex);
//
//            return StreamSupport.stream(sheet.spliterator(), false)
//                    .skip(1) // Skip the header row
//                    .filter(row -> !isEmptyRow(row))
//                    .map(row -> {
//                        var user = new DailySubmissionsInfo();
//                        user.setDateOfEntry(getDateCellValue(row, 0));
//                        user.setRecruiterName(getStringCellValue(row, 1));
//                        user.setConsultantName(getStringCellValue(row, 2));
//                        user.setTechnology(getStringCellValue(row, 3));
//                        user.setPriority(getStringCellValue(row, 4));
//                        user.setSkill(getStringCellValue(row, 5));
//                        user.setAllocatedStatus(getStringCellValue(row, 6));
//                        user.setClientType(getStringCellValue(row, 7));
//                        user.setClientName(getStringCellValue(row, 8));
//                        user.setRequirementSource(getStringCellValue(row, 9));
//                        user.setFeedback(getStringCellValue(row, 10));
//                        user.setComments(getStringCellValue(row, 24));
//                        return user;
//                    })
//                    .collect(Collectors.toList());
//        }
//    }
//}

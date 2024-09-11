package com.consultingfirm.userdetails.common;

import com.consultingfirm.userdetails.benchprofiles.model.BenchProfilesInfo;
import com.consultingfirm.userdetails.dailysubmissions.model.DailySubmissionsInfo;
import com.consultingfirm.userdetails.interviews.model.InterviewInfo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CommonExcelReaderService {
    @Value("${bench-profiles-excel-sheet-index}")
    private int benchProfilesSheetIndex;

    @Value("${daily-submissions-excel-sheet-index}")
    private int dailySubmissionsSheetIndex;

    @Value("${interviews-excel-sheet-index}")
    private int interviewsSheetIndex;

    public List<BenchProfilesInfo> readBenchProfilesExcelFile(MultipartFile file) throws Exception {
        try (var workbook = new XSSFWorkbook(file.getInputStream())) {
            var sheet = workbook.getSheetAt(benchProfilesSheetIndex);

            return StreamSupport.stream(sheet.spliterator(), false)
                    .skip(1) // Skip the header row
                    .filter(row -> !ExcelUtil.isEmptyRow(row))
                    .map(row -> {
                        var user = new BenchProfilesInfo();
                        user.setRecruiterName(ExcelUtil.getStringCellValue(row, 0));
                        user.setConsultantName(ExcelUtil.getStringCellValue(row, 1));
                        user.setAllocatedStatus(ExcelUtil.getStringCellValue(row, 2));
                        user.setStatus(ExcelUtil.getStringCellValue(row, 3));
                        user.setTurboCheck(ExcelUtil.getIntegerCellValue(row, 4));
                        user.setPriority(ExcelUtil.getStringCellValue(row, 5));
                        user.setTechnology(ExcelUtil.getStringCellValue(row, 6));
                        user.setOrganization(ExcelUtil.getStringCellValue(row, 7));
                        user.setExperience(ExcelUtil.getStringCellValue(row, 8));
                        user.setLocation(ExcelUtil.getStringCellValue(row, 9));
                        user.setRelocation(ExcelUtil.getStringCellValue(row, 10));
                        user.setModeOfStaying(ExcelUtil.getStringCellValue(row, 11));
                        user.setNewOrExisting(ExcelUtil.getStringCellValue(row, 12));
                        user.setSourcedBy(ExcelUtil.getStringCellValue(row, 13));
                        user.setVisaStatus(ExcelUtil.getStringCellValue(row, 14));
                        user.setMarketingVisaStatus(ExcelUtil.getStringCellValue(row, 15));
                        user.setContactNumber(ExcelUtil.getStringCellValue(row, 16));
                        user.setEmailId(ExcelUtil.getStringCellValue(row, 17));
                        user.setOriginalDob(ExcelUtil.getDateCellValue(row, 19));
                        user.setMarketingDob(ExcelUtil.getDateCellValue(row, 20));
                        user.setWhatsappNumber(ExcelUtil.getStringCellValue(row, 21));
                        user.setMarketingStartDate(ExcelUtil.getDateCellValue(row, 22));
                        user.setMarketingEndDate(ExcelUtil.getDateCellValue(row, 23));
                        user.setComments(ExcelUtil.getStringCellValue(row, 24));
                        return user;
                    })
                    .collect(Collectors.toList());
        }
    }

    public List<DailySubmissionsInfo> readDailySubmissionsExcelFile(MultipartFile file) throws Exception {
        try (var workbook = new XSSFWorkbook(file.getInputStream())) {
            var sheet = workbook.getSheetAt(dailySubmissionsSheetIndex);

            return StreamSupport.stream(sheet.spliterator(), false)
                    .skip(1) // Skip the header row
                    .filter(row -> !ExcelUtil.isEmptyRow(row))
                    .map(row -> {
                        var user = new DailySubmissionsInfo();
                        user.setDateOfEntry(ExcelUtil.getDateCellValue(row, 0));
                        user.setRecruiterName(ExcelUtil.getStringCellValue(row, 1));
                        user.setConsultantName(ExcelUtil.getStringCellValue(row, 2));
                        user.setTechnology(ExcelUtil.getStringCellValue(row, 3));
                        user.setPriority(ExcelUtil.getStringCellValue(row, 4));
                        user.setSkill(ExcelUtil.getStringCellValue(row, 5));
                        user.setAllocatedStatus(ExcelUtil.getStringCellValue(row, 6));
                        user.setClientType(ExcelUtil.getStringCellValue(row, 7));
                        user.setClientName(ExcelUtil.getStringCellValue(row, 8));
                        user.setRequirementSource(ExcelUtil.getStringCellValue(row, 9));
                        user.setFeedback(ExcelUtil.getStringCellValue(row, 10));
                        user.setComments(ExcelUtil.getStringCellValue(row, 24));
                        return user;
                    })
                    .collect(Collectors.toList());
        }
    }

    public List<InterviewInfo> readInterviewsExcelFile(MultipartFile file) throws Exception {
        try (var workbook = new XSSFWorkbook(file.getInputStream())) {
            var sheet = workbook.getSheetAt(interviewsSheetIndex);
            return StreamSupport.stream(sheet.spliterator(), false)
                    .skip(1) // Skip the header row
                    .filter(row -> !ExcelUtil.isEmptyRow(row))
                    .map(row -> {
                        var interview = new InterviewInfo();
                        interview.setRecruiterName(ExcelUtil.getStringCellValue(row, 0));
                        interview.setRound(ExcelUtil.getStringCellValue(row, 1));
                        interview.setInterviewDate(ExcelUtil.getDateCellValue(row, 2));
                        interview.setInterviewTime(row.getCell(3).toString()); // Changed to use .toString()
                        interview.setConsultantName(ExcelUtil.getStringCellValue(row, 5));
                        interview.setOwnSupport(row.getCell(6).toString()); // Changed to use .toString()
                        interview.setTechnology(ExcelUtil.getStringCellValue(row, 7));
                        interview.setClientType(ExcelUtil.getStringCellValue(row, 9));
                        interview.setClientName(ExcelUtil.getStringCellValue(row, 10));
                        interview.setLocation(ExcelUtil.getStringCellValue(row, 11));
                        interview.setRate(ExcelUtil.getStringCellValue(row, 12));
                        interview.setVendor(ExcelUtil.getStringCellValue(row, 13));
                        interview.setFeedback(ExcelUtil.getStringCellValue(row, 14));
                        interview.setComments(ExcelUtil.getStringCellValue(row, 15));
                        return interview;
                    })
                    .collect(Collectors.toList());
        }
    }
}

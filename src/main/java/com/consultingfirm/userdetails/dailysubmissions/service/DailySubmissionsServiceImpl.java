package com.consultingfirm.userdetails.dailysubmissions.service;

import com.consultingfirm.userdetails.common.CommonExcelReaderService;
import com.consultingfirm.userdetails.dailysubmissions.dto.DailySubmissions;
import com.consultingfirm.userdetails.dailysubmissions.repository.DailySubmissionsRepository;
import com.consultingfirm.userdetails.exception.UserNotFoundException;
import com.consultingfirm.userdetails.dailysubmissions.model.DailySubmissionsInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class DailySubmissionsServiceImpl implements DailySubmissionsService {

    private final DailySubmissionsRepository dailySubmissionsRepository;
    private final CommonExcelReaderService dailySubmissionsExcelReaderService;

    public DailySubmissionsServiceImpl(DailySubmissionsRepository dailySubmissionsRepository, CommonExcelReaderService dailySubmissionsExcelReaderService) {
        this.dailySubmissionsRepository = dailySubmissionsRepository;
        this.dailySubmissionsExcelReaderService = dailySubmissionsExcelReaderService;
    }

    @Override
    public void uploadSubmissionDetails(MultipartFile file) throws Exception {
//        List<DailySubmissionsInfo> d = dailySubmissionsExcelReaderService.readExcelFile(file);
        List<DailySubmissionsInfo> dailySubmissionsInfo = dailySubmissionsExcelReaderService.readDailySubmissionsExcelFile(file);
        dailySubmissionsRepository.saveAll(dailySubmissionsInfo);
    }

    @Override
    public DailySubmissionsInfo createSubmissionInfoDetails(DailySubmissions dailySubmissions) {
        DailySubmissionsInfo dailySubmissionsInfo = DailySubmissionsInfo.builder()
                .dateOfEntry(dailySubmissions.dateOfEntry())
                .recruiterName(dailySubmissions.recruiterName())
                .consultantName(dailySubmissions.consultantName())
                .technology(dailySubmissions.technology())
                .priority(dailySubmissions.priority())
                .skill(dailySubmissions.skill())
                .allocatedStatus(dailySubmissions.allocatedStatus())
                .clientType(dailySubmissions.clientType())
                .clientName(dailySubmissions.clientName())
                .requirementSource(dailySubmissions.requirementSource())
                .feedback(dailySubmissions.feedback())
                .comments(dailySubmissions.comments())
                .build();

        return dailySubmissionsRepository.save(dailySubmissionsInfo);
    }

    public void updateSubmissionDetails(Long id, DailySubmissionsInfo dailySubmissionsInfo) throws UserNotFoundException {
        DailySubmissionsInfo existingUser = dailySubmissionsRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        existingUser.setDateOfEntry(dailySubmissionsInfo.getDateOfEntry());
        existingUser.setRecruiterName(dailySubmissionsInfo.getRecruiterName());
        existingUser.setConsultantName(dailySubmissionsInfo.getConsultantName());
        existingUser.setTechnology(dailySubmissionsInfo.getTechnology());
        existingUser.setPriority(dailySubmissionsInfo.getPriority());
        existingUser.setSkill(dailySubmissionsInfo.getSkill());
        existingUser.setAllocatedStatus(dailySubmissionsInfo.getAllocatedStatus());
        existingUser.setClientType(dailySubmissionsInfo.getClientType());
        existingUser.setClientName(dailySubmissionsInfo.getClientName());
        existingUser.setRequirementSource(dailySubmissionsInfo.getRequirementSource());
        existingUser.setFeedback(dailySubmissionsInfo.getFeedback());
        existingUser.setComments(dailySubmissionsInfo.getComments());

        dailySubmissionsRepository.save(existingUser);
    }

    @Override
    public Optional<List<DailySubmissionsInfo>> getSubmissionDetails() {
        return Optional.of(dailySubmissionsRepository.findAll());
    }

    @Override
    public Optional<Optional<DailySubmissionsInfo>> getSubmissionDetailsByID(Long id) {
        return Optional.of(dailySubmissionsRepository.findById(id));
    }

    @Override
    public void deleteAllSubmissionDetails() {
        dailySubmissionsRepository.deleteAll();
    }

    @Override
    public void deleteSubmissionInfoById(long id) {
        dailySubmissionsRepository.deleteById(id);
    }
}
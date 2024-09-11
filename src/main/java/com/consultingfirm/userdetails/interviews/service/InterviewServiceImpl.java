package com.consultingfirm.userdetails.interviews.service;

import com.consultingfirm.userdetails.common.CommonExcelReaderService;
import com.consultingfirm.userdetails.exception.UserNotFoundException;
import com.consultingfirm.userdetails.interviews.dto.Interview;
import com.consultingfirm.userdetails.interviews.model.InterviewInfo;
import com.consultingfirm.userdetails.interviews.repository.InterviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final CommonExcelReaderService interviewExcelReaderService;

    public InterviewServiceImpl(InterviewRepository interviewRepository, CommonExcelReaderService interviewExcelReaderService) {
        this.interviewRepository = interviewRepository;
        this.interviewExcelReaderService = interviewExcelReaderService;
    }

    @Override
    public void createInterviewDetails(MultipartFile file) throws Exception {
        List<InterviewInfo> interviewInfoList = interviewExcelReaderService.readInterviewsExcelFile(file);
        interviewRepository.saveAll(interviewInfoList);
    }

    @Override
    public InterviewInfo createInterviewInfoDetails(Interview interview) {
        var interviewInfo = InterviewInfo.builder()
                .recruiterName(interview.recruiterName())
                .round(interview.round())
                .interviewDate(interview.interviewDate())
                .interviewTime(String.valueOf(interview.interviewTime()))
                .consultantName(interview.consultantName())
                .ownSupport(interview.ownSupport())
                .technology(interview.technology())
                .clientType(interview.clientType())
                .clientName(interview.clientName())
                .location(interview.location())
                .rate(String.valueOf(interview.rate()))
                .vendor(interview.vendor())
                .feedback(interview.feedback())
                .comments(interview.comments())
                .build();

        return interviewRepository.save(interviewInfo);
    }

    @Override
    public void updateInterviewDetails(Long id, InterviewInfo interviewInfo) throws UserNotFoundException {
        var existingInterview = interviewRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Interview not found with id: " + id));

        existingInterview.setRecruiterName(interviewInfo.getRecruiterName());
        existingInterview.setRound(interviewInfo.getRound());
        existingInterview.setInterviewDate(interviewInfo.getInterviewDate());
        existingInterview.setInterviewTime(interviewInfo.getInterviewTime());
        existingInterview.setConsultantName(interviewInfo.getConsultantName());
        existingInterview.setOwnSupport(interviewInfo.getOwnSupport());
        existingInterview.setTechnology(interviewInfo.getTechnology());
        existingInterview.setClientType(interviewInfo.getClientType());
        existingInterview.setClientName(interviewInfo.getClientName());
        existingInterview.setLocation(interviewInfo.getLocation());
        existingInterview.setRate(interviewInfo.getRate());
        existingInterview.setVendor(interviewInfo.getVendor());
        existingInterview.setFeedback(interviewInfo.getFeedback());
        existingInterview.setComments(interviewInfo.getComments());

        interviewRepository.save(existingInterview);
    }

    @Override
    public Optional<List<InterviewInfo>> getInterviewDetails() {
        return Optional.of(interviewRepository.findAll());
    }

    @Override
    public Optional<InterviewInfo> getInterviewDetailsByID(Long id) {
        return interviewRepository.findById(id);
    }

    @Override
    public void deleteInterviewInfoById(long id) {
        interviewRepository.deleteById(id);
    }

    @Override
    public void deleteAllInterviewInfo() {
        interviewRepository.deleteAll();
    }
}

package com.consultingfirm.userdetails.dailysubmissions.controller;

import com.consultingfirm.userdetails.exception.UserNotFoundException;
import com.consultingfirm.userdetails.dailysubmissions.dto.DailySubmissions;
import com.consultingfirm.userdetails.dailysubmissions.model.DailySubmissionsInfo;
import com.consultingfirm.userdetails.dailysubmissions.service.DailySubmissionsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class DailySubmissionsController {
    private final DailySubmissionsService dailySubmissionsService;

    public DailySubmissionsController(DailySubmissionsService dailySubmissionsService) {
        this.dailySubmissionsService = dailySubmissionsService;
    }

    @PostMapping(value = "/upload-daily-submissions-excel", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception {
        dailySubmissionsService.uploadSubmissionDetails(file);
        return new ResponseEntity<>("Excel data uploaded and inserted into database successfully.", HttpStatus.OK);
    }

    @PostMapping("/create-daily-submissions")
    public ResponseEntity<DailySubmissionsInfo> createSubmissionInfo(@Valid @RequestBody DailySubmissions dailySubmissions) {
        var newDailySubmissionInfo = dailySubmissionsService.createSubmissionInfoDetails(dailySubmissions);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDailySubmissionInfo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/daily-submissions/{id}")
    @Operation(summary = "Update daily submissions User Details")
    public ResponseEntity<String> updateSubmissionInfo(@PathVariable Long id, @RequestBody DailySubmissionsInfo dailySubmissionsInfo) {
        dailySubmissionsService.updateSubmissionDetails(id, dailySubmissionsInfo);
        return new ResponseEntity<>("User details updated successfully.", HttpStatus.OK);
    }

    @GetMapping("/fetch-daily-submissions")
    @Operation(summary = "Fetch daily submissions User Details")
    public ResponseEntity<List<DailySubmissionsInfo>> fetchSubmissionDetails() {
        Optional<List<DailySubmissionsInfo>> users = dailySubmissionsService.getSubmissionDetails();

        if (users.isEmpty() || users.get().isEmpty()) {
            throw new UserNotFoundException("No users found.");
        }

        return new ResponseEntity<>(users.get(), HttpStatus.OK);
    }

    @GetMapping("/fetch-submissions/{id}")
    @Operation(summary = "Fetch daily submissions User Details by ID")
    public ResponseEntity<Optional<DailySubmissionsInfo>> fetchSubmissionDetailsByID(@PathVariable Long id) {
        Optional<Optional<DailySubmissionsInfo>> users = dailySubmissionsService.getSubmissionDetailsByID(id);

        return users.map(userDetails -> new ResponseEntity<>(userDetails, HttpStatus.OK))
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @DeleteMapping("delete-all-submissions")
    @Operation(summary = "Delete All Submissions")
    public ResponseEntity<HttpStatus> deleteAllUserInfo() {
        dailySubmissionsService.deleteAllSubmissionDetails();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete-submission/{id}")
    @Operation(summary = "Delete Submission By Id")
    public ResponseEntity<HttpStatus> deleteUserInfoById(@PathVariable("id") long id) {
        dailySubmissionsService.deleteSubmissionInfoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

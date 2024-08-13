package com.learnspring.userdetailsapi.benchprofiles.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BenchProfilesInfoTest {

    @Test
    public void testBenchProfilesInfoGettersAndSetters() {
        // Arrange
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        BenchProfilesInfo benchProfilesInfo = BenchProfilesInfo.builder()
                .id(1L)
                .recruiterName("John Doe")
                .consultantName("Jane Smith")
                .allocatedStatus("Allocated")
                .status("Active")
                .turboCheck(5)
                .priority("High")
                .technology("Java")
                .organization("TechCorp")
                .experience("8+")
                .location("New York")
                .relocation("Yes")
                .modeOfStaying("Remote")
                .newOrExisting("New")
                .sourcedBy("Referral")
                .visaStatus("H1B")
                .marketingVisaStatus("Active")
                .contactNumber("1234567890")
                .emailId("example@example.com")
                .originalDob(date)
                .marketingDob(date)
                .whatsappNumber("0987654321")
                .marketingStartDate(date)
                .marketingEndDate(date)
                .comments("No comments")
                .dateCreated(dateTime)
                .lastUpdated(dateTime)
                .build();

        // Act & Assert
        assertThat(benchProfilesInfo.getId()).isEqualTo(1L);
        assertThat(benchProfilesInfo.getRecruiterName()).isEqualTo("John Doe");
        assertThat(benchProfilesInfo.getConsultantName()).isEqualTo("Jane Smith");
        assertThat(benchProfilesInfo.getAllocatedStatus()).isEqualTo("Allocated");
        assertThat(benchProfilesInfo.getStatus()).isEqualTo("Active");
        assertThat(benchProfilesInfo.getTurboCheck()).isEqualTo(5);
        assertThat(benchProfilesInfo.getPriority()).isEqualTo("High");
        assertThat(benchProfilesInfo.getTechnology()).isEqualTo("Java");
        assertThat(benchProfilesInfo.getOrganization()).isEqualTo("TechCorp");
        assertThat(benchProfilesInfo.getExperience()).isEqualTo("8+");
        assertThat(benchProfilesInfo.getLocation()).isEqualTo("New York");
        assertThat(benchProfilesInfo.getRelocation()).isEqualTo("Yes");
        assertThat(benchProfilesInfo.getModeOfStaying()).isEqualTo("Remote");
        assertThat(benchProfilesInfo.getNewOrExisting()).isEqualTo("New");
        assertThat(benchProfilesInfo.getSourcedBy()).isEqualTo("Referral");
        assertThat(benchProfilesInfo.getVisaStatus()).isEqualTo("H1B");
        assertThat(benchProfilesInfo.getMarketingVisaStatus()).isEqualTo("Active");
        assertThat(benchProfilesInfo.getContactNumber()).isEqualTo("1234567890");
        assertThat(benchProfilesInfo.getEmailId()).isEqualTo("example@example.com");
        assertThat(benchProfilesInfo.getOriginalDob()).isEqualTo(date);
        assertThat(benchProfilesInfo.getMarketingDob()).isEqualTo(date);
        assertThat(benchProfilesInfo.getWhatsappNumber()).isEqualTo("0987654321");
        assertThat(benchProfilesInfo.getMarketingStartDate()).isEqualTo(date);
        assertThat(benchProfilesInfo.getMarketingEndDate()).isEqualTo(date);
        assertThat(benchProfilesInfo.getComments()).isEqualTo("No comments");
        assertThat(benchProfilesInfo.getDateCreated()).isEqualTo(dateTime);
        assertThat(benchProfilesInfo.getLastUpdated()).isEqualTo(dateTime);
    }

    @Test
    public void testBenchProfilesInfoNoArgsConstructor() {
        // Act
        BenchProfilesInfo benchProfilesInfo = new BenchProfilesInfo();

        // Assert
        assertThat(benchProfilesInfo).isNotNull();
    }

    @Test
    public void testBenchProfilesInfoAllArgsConstructor() {
        // Arrange
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // Act
        BenchProfilesInfo benchProfilesInfo = new BenchProfilesInfo(
                1L, "John Doe", "Jane Smith", "Allocated", "Active", 5, "High",
                "Java", "TechCorp", "8+", "New York", "Yes", "Remote", "New",
                "Referral", "H1B", "Active", "1234567890", "example@example.com",
                date, date, "0987654321", date, date, "No comments",
                dateTime, dateTime
        );

        // Assert
        assertThat(benchProfilesInfo.getId()).isEqualTo(1L);
        assertThat(benchProfilesInfo.getRecruiterName()).isEqualTo("John Doe");
        assertThat(benchProfilesInfo.getConsultantName()).isEqualTo("Jane Smith");
        assertThat(benchProfilesInfo.getAllocatedStatus()).isEqualTo("Allocated");
        assertThat(benchProfilesInfo.getStatus()).isEqualTo("Active");
        assertThat(benchProfilesInfo.getTurboCheck()).isEqualTo(5);
        assertThat(benchProfilesInfo.getPriority()).isEqualTo("High");
        assertThat(benchProfilesInfo.getTechnology()).isEqualTo("Java");
        assertThat(benchProfilesInfo.getOrganization()).isEqualTo("TechCorp");
        assertThat(benchProfilesInfo.getExperience()).isEqualTo("8+");
        assertThat(benchProfilesInfo.getLocation()).isEqualTo("New York");
        assertThat(benchProfilesInfo.getRelocation()).isEqualTo("Yes");
        assertThat(benchProfilesInfo.getModeOfStaying()).isEqualTo("Remote");
        assertThat(benchProfilesInfo.getNewOrExisting()).isEqualTo("New");
        assertThat(benchProfilesInfo.getSourcedBy()).isEqualTo("Referral");
        assertThat(benchProfilesInfo.getVisaStatus()).isEqualTo("H1B");
        assertThat(benchProfilesInfo.getMarketingVisaStatus()).isEqualTo("Active");
        assertThat(benchProfilesInfo.getContactNumber()).isEqualTo("1234567890");
        assertThat(benchProfilesInfo.getEmailId()).isEqualTo("example@example.com");
        assertThat(benchProfilesInfo.getOriginalDob()).isEqualTo(date);
        assertThat(benchProfilesInfo.getMarketingDob()).isEqualTo(date);
        assertThat(benchProfilesInfo.getWhatsappNumber()).isEqualTo("0987654321");
        assertThat(benchProfilesInfo.getMarketingStartDate()).isEqualTo(date);
        assertThat(benchProfilesInfo.getMarketingEndDate()).isEqualTo(date);
        assertThat(benchProfilesInfo.getComments()).isEqualTo("No comments");
        assertThat(benchProfilesInfo.getDateCreated()).isEqualTo(dateTime);
        assertThat(benchProfilesInfo.getLastUpdated()).isEqualTo(dateTime);
    }

    @Test
    public void testBenchProfilesInfoEqualsAndHashCode() {
        // Arrange
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        BenchProfilesInfo benchProfilesInfo1 = BenchProfilesInfo.builder()
                .id(1L)
                .recruiterName("John Doe")
                .consultantName("Jane Smith")
                .allocatedStatus("Allocated")
                .status("Active")
                .turboCheck(5)
                .priority("High")
                .technology("Java")
                .organization("TechCorp")
                .experience("8+")
                .location("New York")
                .relocation("Yes")
                .modeOfStaying("Remote")
                .newOrExisting("New")
                .sourcedBy("Referral")
                .visaStatus("H1B")
                .marketingVisaStatus("Active")
                .contactNumber("1234567890")
                .emailId("example@example.com")
                .originalDob(date)
                .marketingDob(date)
                .whatsappNumber("0987654321")
                .marketingStartDate(date)
                .marketingEndDate(date)
                .comments("No comments")
                .dateCreated(dateTime)
                .lastUpdated(dateTime)
                .build();

        BenchProfilesInfo benchProfilesInfo2 = BenchProfilesInfo.builder()
                .id(1L)
                .recruiterName("John Doe")
                .consultantName("Jane Smith")
                .allocatedStatus("Allocated")
                .status("Active")
                .turboCheck(5)
                .priority("High")
                .technology("Java")
                .organization("TechCorp")
                .experience("8+")
                .location("New York")
                .relocation("Yes")
                .modeOfStaying("Remote")
                .newOrExisting("New")
                .sourcedBy("Referral")
                .visaStatus("H1B")
                .marketingVisaStatus("Active")
                .contactNumber("1234567890")
                .emailId("example@example.com")
                .originalDob(date)
                .marketingDob(date)
                .whatsappNumber("0987654321")
                .marketingStartDate(date)
                .marketingEndDate(date)
                .comments("No comments")
                .dateCreated(dateTime)
                .lastUpdated(dateTime)
                .build();

        // Act & Assert
        assertThat(benchProfilesInfo1).isEqualTo(benchProfilesInfo2);
        assertThat(benchProfilesInfo1.hashCode()).isEqualTo(benchProfilesInfo2.hashCode());
    }

    @Test
    public void testBenchProfilesInfoToString() {
        // Arrange
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        BenchProfilesInfo benchProfilesInfo = BenchProfilesInfo.builder()
                .id(1L)
                .recruiterName("John Doe")
                .consultantName("Jane Smith")
                .allocatedStatus("Allocated")
                .status("Active")
                .turboCheck(5)
                .priority("High")
                .technology("Java")
                .organization("TechCorp")
                .experience("8+")
                .location("New York")
                .relocation("Yes")
                .modeOfStaying("Remote")
                .newOrExisting("New")
                .sourcedBy("Referral")
                .visaStatus("H1B")
                .marketingVisaStatus("Active")
                .contactNumber("1234567890")
                .emailId("example@example.com")
                .originalDob(date)
                .marketingDob(date)
                .whatsappNumber("0987654321")
                .marketingStartDate(date)
                .marketingEndDate(date)
                .comments("No comments")
                .dateCreated(dateTime)
                .lastUpdated(dateTime)
                .build();

        // Act
        String result = benchProfilesInfo.toString();

        // Assert
        assertThat(result).contains("BenchProfilesInfo");
        assertThat(result).contains("id=1");
        assertThat(result).contains("recruiterName=John Doe");
        assertThat(result).contains("consultantName=Jane Smith");
        assertThat(result).contains("allocatedStatus=Allocated");
        assertThat(result).contains("status=Active");
        assertThat(result).contains("turboCheck=5");
        assertThat(result).contains("priority=High");
        assertThat(result).contains("technology=Java");
        assertThat(result).contains("organization=TechCorp");
        assertThat(result).contains("experience=8+");
        assertThat(result).contains("location=New York");
        assertThat(result).contains("relocation=Yes");
        assertThat(result).contains("modeOfStaying=Remote");
        assertThat(result).contains("newOrExisting=New");
        assertThat(result).contains("sourcedBy=Referral");
        assertThat(result).contains("visaStatus=H1B");
        assertThat(result).contains("marketingVisaStatus=Active");
        assertThat(result).contains("contactNumber=1234567890");
        assertThat(result).contains("emailId=example@example.com");
        assertThat(result).contains("originalDob=" + date.toString());
        assertThat(result).contains("marketingDob=" + date.toString());
        assertThat(result).contains("whatsappNumber=0987654321");
        assertThat(result).contains("marketingStartDate=" + date.toString());
        assertThat(result).contains("marketingEndDate=" + date.toString());
        assertThat(result).contains("comments=No comments");
        assertThat(result).contains("dateCreated=" + dateTime.toString());
        assertThat(result).contains("lastUpdated=" + dateTime.toString());
    }

    @Test
    public void testBuilder() {

        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // Use the builder to create an instance
        BenchProfilesInfo info = BenchProfilesInfo.builder()
                .id(1L)
                .recruiterName("John Doe")
                .consultantName("Jane Smith")
                .allocatedStatus("Allocated")
                .status("Active")
                .turboCheck(5)
                .priority("High")
                .technology("Java")
                .organization("TechCorp")
                .experience("8+")
                .location("New York")
                .relocation("Yes")
                .modeOfStaying("Remote")
                .newOrExisting("New")
                .sourcedBy("Referral")
                .visaStatus("H1B")
                .marketingVisaStatus("Active")
                .contactNumber("1234567890")
                .emailId("example@example.com")
                .originalDob(date)
                .marketingDob(date)
                .whatsappNumber("0987654321")
                .marketingStartDate(date)
                .marketingEndDate(date)
                .comments("No comments")
                .dateCreated(dateTime)
                .lastUpdated(dateTime)
                .build();

        // Verify the properties set through the builder
        assertThat(info.getId()).isEqualTo(1L);
        assertThat(info.getTurboCheck()).isEqualTo(5);
        assertThat(info.getPriority()).isEqualTo("High");
        assertThat(info.getTechnology()).isEqualTo("Java");
        assertThat(info.getOrganization()).isEqualTo("TechCorp");
        assertThat(info.getExperience()).isEqualTo("8+");
        assertThat(info.getLocation()).isEqualTo("New York");
        assertThat(info.getRelocation()).isEqualTo("Yes");
        assertThat(info.getModeOfStaying()).isEqualTo("Remote");
        assertThat(info.getNewOrExisting()).isEqualTo("New");
        assertThat(info.getSourcedBy()).isEqualTo("Referral");
        assertThat(info.getVisaStatus()).isEqualTo("H1B");
        assertThat(info.getMarketingVisaStatus()).isEqualTo("Active");
        assertThat(info.getContactNumber()).isEqualTo("1234567890");
        assertThat(info.getEmailId()).isEqualTo("example@example.com");
        assertThat(info.getOriginalDob()).isEqualTo(date);
        assertThat(info.getMarketingDob()).isEqualTo(date);
        assertThat(info.getRecruiterName()).isEqualTo("John Doe");
        assertThat(info.getConsultantName()).isEqualTo("Jane Smith");
        assertThat(info.getAllocatedStatus()).isEqualTo("Allocated");
        assertThat(info.getStatus()).isEqualTo("Active");
        assertThat(info.getWhatsappNumber()).isEqualTo("0987654321");
        assertThat(info.getMarketingStartDate()).isEqualTo(date);
        assertThat(info.getMarketingEndDate()).isEqualTo(date);
        assertThat(info.getComments()).isEqualTo("No comments");
        assertThat(info.getDateCreated()).isEqualTo(dateTime);
        assertThat(info.getLastUpdated()).isEqualTo(dateTime);
    }
}

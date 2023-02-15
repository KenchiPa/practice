package com.practice.hrp.dto;

import com.practice.hrp.type.DeveloperLevel;
import com.practice.hrp.type.DeveloperSkillType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

public class CreateDeveloper {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NonNull
        private DeveloperLevel developerLevel;
        @NonNull
        private DeveloperSkillType developerSkillType;
        @NonNull
        @Min(1)
        @Max(30)
        private Integer experienceYears;

        @NonNull
        @Size(min = 3, max = 50, message = "memberId size must 3~50")
        private String memberId;
        @NonNull
        @Size(min = 2, max = 20, message = "name size must 3~50")
        private String name;
        @Min(18)
        private Integer age;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private DeveloperLevel developerLevel;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;

        private String memberId;
        private String name;
        private Integer age;
    }
}

package com.practice.hrp.service;

import com.practice.hrp.dto.CreateDeveloper;
import com.practice.hrp.entity.Developer;
import com.practice.hrp.exception.DMakerErrorCode;
import com.practice.hrp.exception.DMakerException;
import com.practice.hrp.repository.DeveloperRepository;
import com.practice.hrp.type.DeveloperLevel;
import com.practice.hrp.type.DeveloperSkillType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor  // @Autowired 생략가능
public class DMakerService {

//  @Autowired
//  클래스에@RequiredArgsConstructor 해주면 자동으로 주입해준다
    private final DeveloperRepository developerRepository;

    // ACID
    // Atomic 모두 성공 또는 모두 실패
    // Consistency 일관성: 트랜잭션 종료되는 지점에서는 일관성이 있어야 한다
    // Isolation 고립성
    // Durability  지속성: commit된 이력은 무조건 남아있어야 한다
    @Transactional
    public void createDeveloper(CreateDeveloper.@Valid Request request){

        validateCreateDeveloperRequest(request);

        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("olaf")
                .age(5)
                .build();

        developerRepository.save(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
    //  business validation
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
        if(developerLevel == DeveloperLevel.SENIOR
            && experienceYears < 10) {
            throw new DMakerException(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if(developerLevel == DeveloperLevel.JUNIOR
            && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if(developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        developerRepository.findByMemberId(request.getMemberId());

    }
}

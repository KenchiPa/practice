package com.practice.hrp.service;

import com.practice.hrp.entity.Developer;
import com.practice.hrp.repository.DeveloperRepository;
import com.practice.hrp.type.DeveloperLevel;
import com.practice.hrp.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor  // @Autowired 생략가능
public class DMakerService {

//  @Autowired
//  클래스에@RequiredArgsConstructor 해주면 자동으로 주입해준다
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(){
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("olaf")
                .age(5)
                .build();

        developerRepository.save(developer);
    }
}

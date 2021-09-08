package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SocialMediaAccountService;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SocialMediaAccountForCurriculumVitaeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/social-media-accounts")
public class SocialMediaAccountsController {

    private final SocialMediaAccountService socialMediaAccountService;

    public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
        this.socialMediaAccountService = socialMediaAccountService;
    }

    @PostMapping("/add-social-media-account-for-job-seeker")
    public ResponseEntity<Result> addSocialMediaAccountForJobSeeker(@Valid @RequestBody SocialMediaAccountForCurriculumVitaeDto socialMediaAccountForCurriculumVitaeDto) {
        var result = this.socialMediaAccountService.addSocialMediaAccountForJobSeeker(socialMediaAccountForCurriculumVitaeDto);

        if (result.isSuccess()) {
            log.info("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.OK.value(), result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            log.error("MESSAGE : {}. STATUS : {}. HTTP CODE : {}. DATA :{}", result.getMessage(), result.isSuccess(), HttpStatus.BAD_REQUEST.value(), result);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}

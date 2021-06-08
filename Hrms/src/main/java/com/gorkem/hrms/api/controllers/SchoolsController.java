package com.gorkem.hrms.api.controllers;

import com.gorkem.hrms.business.abstracts.SchoolService;
import com.gorkem.hrms.core.utilities.results.DataResult;
import com.gorkem.hrms.core.utilities.results.Result;
import com.gorkem.hrms.entities.concretes.School;
import com.gorkem.hrms.entities.dtos.curriculumVitaeDtos.SchoolForCurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getAll")
    public DataResult<List<School>> getAll() {
        return this.schoolService.getAll();
    }

    @PostMapping("/add")//Useless
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @PostMapping("/addSchoolForJobSeeker")
    public Result addSchoolForJobSeeker(@Valid @RequestBody SchoolForCurriculumVitaeDto schoolForCurriculumVitaeDto) {
        return this.schoolService.addSchoolForJobSeeker(schoolForCurriculumVitaeDto);
    }

    @GetMapping("/findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc")
    public DataResult<List<School>> findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(@RequestParam int id) {
        return this.schoolService.findByCurriculumVitae_JobSeeker_IdOrderByGraduationDescriptionAscFinishedDateDesc(id);
    }
}

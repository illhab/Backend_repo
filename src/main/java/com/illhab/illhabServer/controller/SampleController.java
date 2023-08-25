package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.entity.Sample;
import com.illhab.illhabServer.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SampleController {

    private SampleService sampleService;

    @GetMapping(value = "/sample")
    public Sample getSample() {
        return sampleService.getSample();
    }
}

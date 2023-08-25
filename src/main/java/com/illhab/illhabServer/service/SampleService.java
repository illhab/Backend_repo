package com.illhab.illhabServer.service;

import com.illhab.illhabServer.entity.Sample;
import java.sql.Timestamp;
import java.util.Random;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private static final Logger log = LoggerFactory.getLogger(SampleService.class);

    public Sample getSample() {
        try {
            Sample sample = new Sample();
            sample.setSample_String("This is Sample Response.");
            sample.setSample_Integer((new Random().nextInt()));
            sample.setSample_Double((new Random().nextDouble()));
            sample.setSample_Timestamp(new Timestamp(System.currentTimeMillis()));

            return sample;
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return new Sample();
        }
    }

}

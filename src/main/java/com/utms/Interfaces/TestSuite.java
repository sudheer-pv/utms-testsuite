package com.utms.Interfaces;

import com.utms.resources.Report;
import org.springframework.stereotype.Component;

/**
 * Created by sudheer on 29/5/15.
 */
@Component
public interface TestSuite {
    Report executeTestCase(TestCase testCase);
}

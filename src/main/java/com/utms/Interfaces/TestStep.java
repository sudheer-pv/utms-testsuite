package com.utms.Interfaces;

import com.utms.exceptions.TestStepFailedException;
import org.springframework.stereotype.Component;

/**
 * Created by sudheer on 30/5/15.
 */
@Component
public interface TestStep {
    String execute() throws TestStepFailedException;
}

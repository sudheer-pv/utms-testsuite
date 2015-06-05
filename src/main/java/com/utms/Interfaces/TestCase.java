package com.utms.Interfaces;

import com.utms.resources.Result;

import org.springframework.stereotype.Component;

/**
 * Created by sudheer on 29/5/15.
 */
@Component
public interface TestCase {
    Result execute();
}

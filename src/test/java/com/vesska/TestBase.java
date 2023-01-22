package com.vesska;

import com.vesska.config.WebDriverProvider;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();

    }
}

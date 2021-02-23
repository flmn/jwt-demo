package tech.jitao.jwtdemo;

import org.apache.commons.lang3.RandomStringUtils;

public interface Constants {
    String SECRET = RandomStringUtils.randomAlphabetic(16);
}

/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models;

import java.util.*;

import org.fest.assertions.*;
import org.junit.*;

/**
 * {@link EntrySheetOptionalV1}のテストクラス.
 * @author A13413
 */
public class EntrySheetOptionalV1Test {
    @Test
    public void testGetProgrammingLevel() {
        EntrySheetOptionalV1 optional = new EntrySheetOptionalV1();
        optional.programmingLevel = "ruby:1,python:2,c:3,perl:4";
        Map<String, Integer> result1 = optional.getProgrammingLevel();
        Assertions.assertThat(result1.size()).isEqualTo(4);
        Assertions.assertThat(result1.get("ruby")).isEqualTo(1);
        Assertions.assertThat(result1.get("python")).isEqualTo(2);
        Assertions.assertThat(result1.get("c")).isEqualTo(3);
        Assertions.assertThat(result1.get("perl")).isEqualTo(4);

        optional.programmingLevel = "";
        Map<String, Integer> result2 = optional.getProgrammingLevel();
        Assertions.assertThat(result2.size()).isZero();

        optional.programmingLevel = ":";
        Map<String, Integer> result3 = optional.getProgrammingLevel();
        Assertions.assertThat(result3.size()).isZero();

        optional.programmingLevel = "ruby:,python:1";
        Map<String, Integer> result4 = optional.getProgrammingLevel();
        Assertions.assertThat(result4.size()).isEqualTo(1);
        Assertions.assertThat(result4.get("python")).isEqualTo(1);

        optional.programmingLevel = "python:1,";
        Map<String, Integer> result5 = optional.getProgrammingLevel();
        Assertions.assertThat(result5.size()).isEqualTo(1);
        Assertions.assertThat(result5.get("python")).isEqualTo(1);

        optional.programmingLevel = "ruby:a,python:1";
        Map<String, Integer> result6 = optional.getProgrammingLevel();
        Assertions.assertThat(result6.size()).isEqualTo(1);
        Assertions.assertThat(result6.get("python")).isEqualTo(1);
    }
}

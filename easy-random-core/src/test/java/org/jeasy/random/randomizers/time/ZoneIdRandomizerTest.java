/*
 * The MIT License
 *
 *   Copyright (c) 2020, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package org.jeasy.random.randomizers.time;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZoneId;
import org.jeasy.random.randomizers.AbstractRandomizerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZoneIdRandomizerTest extends AbstractRandomizerTest<ZoneId> {

    @BeforeEach
    void setUp() {
        randomizer = new ZoneIdRandomizer(SEED);
    }

    @Test
    void generatedValueShouldNotBeNull() {
        assertThat(randomizer.getRandomValue()).isNotNull();
    }

    @Test
    void shouldGenerateTheSameValueForTheSameSeed() {
        // we cannot use a canned value, because values returned by the randomizer differ between locales/jdks
        ZoneId firstZoneId = new ZoneIdRandomizer(SEED).getRandomValue();
        ZoneId secondZoneId = new ZoneIdRandomizer(SEED).getRandomValue();

        assertThat(firstZoneId).isNotNull();
        assertThat(secondZoneId).isNotNull();
        assertThat(firstZoneId).isEqualTo(secondZoneId);
    }
}

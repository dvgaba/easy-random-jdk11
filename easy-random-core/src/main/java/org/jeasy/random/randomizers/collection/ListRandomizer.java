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
package org.jeasy.random.randomizers.collection;

import java.util.ArrayList;
import java.util.List;
import org.jeasy.random.api.Randomizer;

/**
 * A custom {@link Randomizer} that generates a list of random values using a delegate {@link Randomizer}.
 *
 * @param <T> the type of elements generated by this {@link Randomizer}
 * @author Eric Taix (eric.taix@gmail.com)
 */
public class ListRandomizer<T> extends CollectionRandomizer<T> {

    /**
     * Create a new {@link ListRandomizer} that will generate a list with a random number of elements.
     * Each element is generated by the {@link Randomizer} parameter
     *
     * @param elementRandomizer the {@link Randomizer} to use to generate elements
     */
    public ListRandomizer(final Randomizer<T> elementRandomizer) {
        super(elementRandomizer);
    }

    /**
     * Create a new {@link ListRandomizer} that will generate a list with a fixed number of elements.
     * Each element is generated by the {@link Randomizer} parameter
     *
     * @param elementRandomizer The {@link Randomizer} used to generate each element
     * @param nbElements        The number of elements to generate
     */
    public ListRandomizer(final Randomizer<T> elementRandomizer, final int nbElements) {
        super(elementRandomizer, nbElements);
    }

    @Override
    public List<T> getRandomValue() {
        List<T> result = new ArrayList<>(nbElements);
        for (int i = 0; i < nbElements; i++) {
            result.add(getRandomElement());
        }
        return result;
    }

    @Override
    public String toString() {
        return "ListRandomizer [delegate=" + delegate + ", nbElements=" + nbElements + "]";
    }
}

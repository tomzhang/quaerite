/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mitre.quaerite.core.scorers;


import org.mitre.quaerite.core.Judgments;
import org.mitre.quaerite.core.ResultSet;

/**
 * Highest single rank; {@link #NOT_FOUND} if not found
 */
public class HighestRank extends AbstractRankScorer {
    public final static int NOT_FOUND = -1;
    public HighestRank(int atN) {
        super(atN);
    }

    @Override
    public double score(Judgments judgments, ResultSet resultSet) {

        for (int i = 0; i < getAtN() && i < resultSet.size(); i++) {
            if (judgments.containsJudgment(resultSet.get(i))) {
                return i+1;
            }
        }
        return NOT_FOUND;
    }

    @Override
    String _getName() {
        return "HighestRank";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HighestRank)) return false;
        return super.equals(o);
    }
}

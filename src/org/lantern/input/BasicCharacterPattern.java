/*
 * This file is part of lanterna (http://code.google.com/p/lanterna/).
 * 
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2010-2011 mabe02
 */

package org.lantern.input;

import java.util.Arrays;
import java.util.List;

class BasicCharacterPattern implements CharacterPattern
{
    private Key result;
    private char[] pattern;

    BasicCharacterPattern(Key result, char[] pattern)
    {
        this.result = result;
        this.pattern = pattern;
    }

    public boolean matches(List currentMatching)
    {
        int minSize = Math.min(currentMatching.size(), pattern.length);
        for (int i = 0; i < minSize; i++)
        {
            if (pattern[i] != ((Character)currentMatching.get(i)).charValue())
            {
                return false;
            }
        }
        return true;
    }

    public Key getResult()
    {
        return result;
    }

    public boolean isCompleteMatch(List currentMatching)
    {
        return pattern.length == currentMatching.size();
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof BasicCharacterPattern == false)
            return false;

        BasicCharacterPattern other = (BasicCharacterPattern)obj;
        return Arrays.equals(pattern, other.pattern);
    }

    public int hashCode()
    {
        int hash = 3;
        hash = 53 * hash + hashCode(this.pattern);
        return hash;
    }
    
    /**
     * Copied from Arrays.hashCode in Java 6
     */
    private static int hashCode(char a[]) {
        if (a == null)
            return 0;

        int result = 1;
        for (int i = 0; i < a.length; i++) {
            char element = a[i];
            result = 31 * result + element;
        }
        return result;
    }
}

/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.common;

import org.drools.FactHandle;
import org.drools.reteoo.LeftTuple;
import org.drools.reteoo.RightTuple;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;

public interface InternalFactHandle
    extends
    FactHandle, Cloneable {
    int getId();

    long getRecency();

    Object getObject();

    void setObject(Object object);

    void setEqualityKey(EqualityKey key);

    EqualityKey getEqualityKey();

    void setRecency(long recency);

    void invalidate();
    
    boolean isValid();
    
    int getIdentityHashCode();

    int getObjectHashCode();
    
    boolean isDisconnected();
    
    /**
     * Returns true if this FactHandle represents
     * and Event or false if this FactHandle represents
     * a regular Fact
     * 
     * @return
     */
    boolean isEvent();

    boolean isTrait();
    
    RightTuple getFirstRightTuple();

    RightTuple getLastRightTuple();

    LeftTuple getFirstLeftTuple();
    
    LeftTuple getLastLeftTuple();
    
    WorkingMemoryEntryPoint getEntryPoint();
    
    void setEntryPoint( WorkingMemoryEntryPoint ep );

    InternalFactHandle clone();
    
    String toExternalForm();
    
    String toTupleTree( int indent );
    
    void disconnect();

    void addLastLeftTuple( LeftTuple leftTuple );

    void addLeftTupleInPosition( LeftTuple leftTuple );

    void removeLeftTuple( LeftTuple leftTuple );

    void clearLeftTuples();

    void clearRightTuples();

    void addFirstRightTuple( RightTuple rightTuple );

    void addLastRightTuple( RightTuple rightTuple );

    void addRightTupleInPosition( RightTuple rightTuple );

    void removeRightTuple( RightTuple rightTuple );
    
}

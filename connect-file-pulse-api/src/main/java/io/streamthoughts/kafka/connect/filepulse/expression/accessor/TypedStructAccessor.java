/*
 * Copyright 2019-2020 StreamThoughts.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamthoughts.kafka.connect.filepulse.expression.accessor;

import io.streamthoughts.kafka.connect.filepulse.data.TypedStruct;
import io.streamthoughts.kafka.connect.filepulse.data.TypedValue;
import io.streamthoughts.kafka.connect.filepulse.expression.EvaluationContext;

import java.util.Objects;

public class TypedStructAccessor implements PropertyAccessor {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?>[] getSpecificTargetClasses() {
        return new Class[]{TypedStruct.class};
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canRead(final EvaluationContext context,
                           final Object target,
                           final String name) throws AccessException {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypedValue read(final EvaluationContext context,
                           final Object target,
                           final String name) throws AccessException {
        Objects.requireNonNull(target, "target cannot be null");
        Objects.requireNonNull(name, "name cannot be null");

        final TypedStruct struct = (TypedStruct)target;

        if (struct.has(name)) {
            return struct.get(name);
        }

        if (isDotPropertyAccessPath(name)) {
            String[] split = name.split("\\.", 2);
            Object rootObject = read(context, target, split[0]);
            if (rootObject != null) {
                return read(context, rootObject, split[1]);
            }
        }

        throw new AccessException("Cannot access to field '" + name + "'");
    }

    private boolean isDotPropertyAccessPath(final String name) {
        return name.contains(".");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final EvaluationContext context,
                      final Object target,
                      final String name,
                      final Object newValue) throws AccessException {

        Objects.requireNonNull(target, "target cannot be null");
        Objects.requireNonNull(name, "name cannot be null");

        final TypedStruct struct = (TypedStruct)target;

        if (isDotPropertyAccessPath(name)) {
            String[] split = name.split("\\.", 2);
            final String field = split[0];
            final String remaining = split[1];

            TypedStruct child;
            if (struct.has(field)) {
                child = struct.getStruct(field);
            } else {
                child = TypedStruct.create();
            }
            write(context, child, remaining, newValue);

        } else if (newValue instanceof TypedValue) {
            struct.put(name, (TypedValue)newValue);
        } else {
            struct.put(name, TypedValue.any(newValue));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canWrite(final EvaluationContext context,
                            final Object target,
                            final String name) throws AccessException {
        return true;
    }
}

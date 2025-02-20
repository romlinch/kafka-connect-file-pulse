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
package io.streamthoughts.kafka.connect.filepulse.expression;

import io.streamthoughts.kafka.connect.filepulse.data.Type;
import io.streamthoughts.kafka.connect.filepulse.data.TypedValue;
import io.streamthoughts.kafka.connect.filepulse.expression.converter.Converters;
import io.streamthoughts.kafka.connect.filepulse.expression.converter.PropertyConverter;

import java.util.List;
import java.util.Objects;

public class ValueExpression implements Expression {

    private final String value;

    /**
     * Creates a new {@link ValueExpression} instance.
     * @param value the static value.
     */
    public ValueExpression(final String value) {
        Objects.requireNonNull(value, "value cannot be null");
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypedValue readValue(final EvaluationContext context) {
        return TypedValue.of(value, Type.STRING);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T readValue(final EvaluationContext context, final Class<T> expectedType) {
        if (expectedType == String.class) {
            return (T) value;
        }
        final List<PropertyConverter> converters = context.getPropertyConverter();
        return Converters.converts(converters, value, expectedType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeValue(final Object value, final EvaluationContext context) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String originalExpression() {
        return value;
    }
}

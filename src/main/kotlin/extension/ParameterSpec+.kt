/*
 * Copyright (C) 2017 Atsushi Miyake.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package extension

import builderkit.ClassInformation
import builderkit.PropertyType
import com.squareup.kotlinpoet.ParameterSpec

/**
 * Define parameters from classInformation
 * @param classInformation Result of class analysis
 */
internal fun ParameterSpec.Companion.defines(classInformation: ClassInformation): List<ParameterSpec> {
    return classInformation.properties.map { (name, property) ->

        val parameterSpec = when (property) {
            is PropertyType.Normal  -> ParameterSpec.builder(name, property.rawType)
            is PropertyType.Generic -> ParameterSpec.builder(name, property.typeVariableName)
        }

        parameterSpec.build()
    }
}
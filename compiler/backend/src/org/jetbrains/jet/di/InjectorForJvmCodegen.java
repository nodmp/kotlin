/*
 * Copyright 2010-2012 JetBrains s.r.o.
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


package org.jetbrains.jet.di;

import org.jetbrains.jet.lang.types.lang.JetStandardLibrary;
import org.jetbrains.jet.lang.resolve.BindingContext;
import java.util.List;
import org.jetbrains.jet.lang.psi.JetFile;
import com.intellij.openapi.project.Project;
import org.jetbrains.jet.codegen.GenerationState;
import org.jetbrains.jet.codegen.ClassBuilderFactory;
import org.jetbrains.jet.codegen.JetTypeMapper;
import org.jetbrains.jet.codegen.intrinsics.IntrinsicMethods;
import org.jetbrains.jet.codegen.ClassFileFactory;
import org.jetbrains.jet.codegen.ClosureAnnotator;
import org.jetbrains.jet.lang.types.lang.JetStandardLibrary;
import org.jetbrains.jet.lang.resolve.BindingContext;
import java.util.List;
import org.jetbrains.jet.lang.psi.JetFile;
import com.intellij.openapi.project.Project;
import org.jetbrains.jet.codegen.GenerationState;
import org.jetbrains.jet.codegen.ClassBuilderFactory;
import org.jetbrains.annotations.NotNull;

/* This file is generated by org.jetbrains.jet.di.AllInjectorsGenerator. DO NOT EDIT! */
public class InjectorForJvmCodegen {

    private final JetStandardLibrary jetStandardLibrary;
    private final GenerationState generationState;
    private JetTypeMapper jetTypeMapper;
    private IntrinsicMethods intrinsics;
    private ClassFileFactory classFileFactory;

    public InjectorForJvmCodegen(
        @NotNull JetStandardLibrary jetStandardLibrary,
        @NotNull BindingContext bindingContext,
        @NotNull List<JetFile> listOfJetFile,
        @NotNull Project project,
        @NotNull GenerationState generationState,
        @NotNull ClassBuilderFactory classBuilderFactory
    ) {
        this.jetStandardLibrary = jetStandardLibrary;
        this.generationState = generationState;
        this.jetTypeMapper = new JetTypeMapper();
        this.intrinsics = new IntrinsicMethods();
        this.classFileFactory = new ClassFileFactory();
        ClosureAnnotator closureAnnotator = new ClosureAnnotator();

        this.jetTypeMapper.setBindingContext(bindingContext);
        this.jetTypeMapper.setClosureAnnotator(closureAnnotator);
        this.jetTypeMapper.setStandardLibrary(jetStandardLibrary);

        this.intrinsics.setMyProject(project);
        this.intrinsics.setMyStdLib(jetStandardLibrary);

        this.classFileFactory.setBuilderFactory(classBuilderFactory);
        this.classFileFactory.setState(generationState);

        closureAnnotator.setBindingContext(bindingContext);
        closureAnnotator.setFiles(listOfJetFile);

        jetTypeMapper.init();

        intrinsics.init();

        closureAnnotator.init();

    }

    public JetStandardLibrary getJetStandardLibrary() {
        return this.jetStandardLibrary;
    }

    public GenerationState getGenerationState() {
        return this.generationState;
    }

    public JetTypeMapper getJetTypeMapper() {
        return this.jetTypeMapper;
    }

    public IntrinsicMethods getIntrinsics() {
        return this.intrinsics;
    }

    public ClassFileFactory getClassFileFactory() {
        return this.classFileFactory;
    }

}

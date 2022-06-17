package com.project.lowcode.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.project.lowcode")
public class ArchUnitTest {

  @ArchTest
  ArchRule controllers_should_be_suffixed =
      classes()
          .that()
          .resideInAPackage("..adapter.in.rest")
          .should()
          .haveSimpleNameEndingWith("Controller");
}

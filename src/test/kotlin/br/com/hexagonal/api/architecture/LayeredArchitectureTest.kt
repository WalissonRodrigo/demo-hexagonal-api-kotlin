package br.com.hexagonal.api.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture

@AnalyzeClasses(packages = ["br.com.hexagonal.api"])
class LayeredArchitectureTest {
    @ArchTest
    val `layered architecture test` = layeredArchitecture()
        .consideringAllDependencies()
        .layer("AdaptersIn").definedBy("..adapters.in..")
        .layer("AdaptersOut").definedBy("..adapters.out..")
        .layer("UseCase").definedBy("..application.core.useCase..")
        .layer("PortsIn").definedBy("..application.ports.in..")
        .layer("PortsOut").definedBy("..application.ports.out..")
        .layer("Config").definedBy("..config..")
        .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("Config", "UseCase", "AdaptersIn")
        .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("Config", "UseCase", "AdaptersOut")
        .whereLayer("Config").mayNotBeAccessedByAnyLayer()
}
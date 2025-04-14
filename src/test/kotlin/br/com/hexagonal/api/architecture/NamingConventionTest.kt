package br.com.hexagonal.api.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["br.com.hexagonal.api"])
class NamingConventionTest {
    @ArchTest
    val `consumer reside only consumer package` = classes()
        .that()
        .haveNameMatching(".*Consumer")
        .should()
        .resideInAPackage("..adapters.in.consumer")
        .`as`("Consumer classes should reside inside consumer package in adapters.in package")

    @ArchTest
    val `message reside only message package` = classes()
        .that()
        .haveNameMatching(".*Message")
        .should()
        .resideInAPackage("..adapters.in.consumer.message")
        .`as`("Messages classes should reside inside message package in adapters.in.consumer package")

    @ArchTest
    val `controller reside only controller package` = classes()
        .that()
        .haveNameMatching(".*Controller")
        .should()
        .resideInAPackage("..adapters.in.controller")
        .`as`("Controllers classes should reside inside controller package in adapters.in package")

    @ArchTest
    val `request reside only request package` = classes()
        .that()
        .haveNameMatching(".*Request")
        .should()
        .resideInAnyPackage("..adapters.in.controller.request", "..adapters.out.client.request")
        .`as`("Requests classes should reside inside request package in controller or client packages")

    @ArchTest
    val `response reside only response package` = classes()
        .that()
        .haveNameMatching(".*Response")
        .should()
        .resideInAnyPackage("..adapters.in.controller.response", "..adapters.out.client.response")
        .`as`("Responses classes should reside inside response package in controller or client packages")

    @ArchTest
    val `adapters reside only adapter package` = classes()
        .that()
        .haveNameMatching(".*Adapter")
        .should()
        .resideInAPackage("..adapters.out")
        .`as`("Adapters classes should reside inside out package in adapters package")

    @ArchTest
    val `client reside only client package` = classes()
        .that()
        .haveNameMatching(".*Client")
        .should()
        .resideInAPackage("..adapters.out.client")
        .`as`("Clients classes should reside client out package in adapters.out package")

    @ArchTest
    val `repository reside only repository package` = classes()
        .that()
        .haveNameMatching(".*Repository")
        .should()
        .resideInAPackage("..adapters.out.repository")
        .`as`("Repositories classes should reside inside repository package in adapters.out package")

    @ArchTest
    val `entity reside only entity package` = classes()
        .that()
        .haveNameMatching(".*Entity")
        .should()
        .resideInAPackage("..adapters.out.repository.entity")
        .`as`("Entities classes should reside inside entity package in adapters.out.repository package")

    @ArchTest
    val `exceptions reside only exceptions package` = classes()
        .that()
        .haveNameMatching(".*Exception")
        .should()
        .resideInAPackage("..application.core.exceptions")
        .`as`("Exceptions classes should reside inside out package exceptions application.core package")

    @ArchTest
    val `useCase reside only useCase package` = classes()
        .that()
        .haveNameMatching(".*UseCase")
        .should()
        .resideInAPackage("..application.core.useCase")
        .`as`("UseCases classes should reside inside useCase package in application.core package")

    @ArchTest
    val `input reside only input package` = classes()
        .that()
        .haveNameMatching(".*InputPort")
        .should()
        .resideInAPackage("..application.ports.in")
        .`as`("InputPorts classes should reside inside `in` package in application.ports package")

    @ArchTest
    val `output reside only output package` = classes()
        .that()
        .haveNameMatching(".*OutputPort")
        .should()
        .resideInAPackage("..application.ports.out")
        .`as`("OutputPorts classes should reside inside out package in application.ports package")

    @ArchTest
    val `config reside only config package` = classes()
        .that()
        .haveNameMatching(".*Config")
        .should()
        .resideInAPackage("..hexagonal.api.config")
        .`as`("Configs classes should reside inside config package")

    // suffixed names validations

    @ArchTest
    val `should be suffixed consumer` = classes()
        .that()
        .resideInAPackage("..consumer")
        .should()
        .haveSimpleNameEndingWith("Consumer")
        .`as`("Consumers classes should be suffixed Consumer in class name")

    @ArchTest
    val `should be suffixed message` = classes()
        .that()
        .resideInAPackage("..message")
        .should()
        .haveSimpleNameEndingWith("Message")
        .`as`("Messages classes should be suffixed Message in class name")

    @ArchTest
    val `should be suffixed controller` = classes()
        .that()
        .resideInAPackage("..controller")
        .should()
        .haveSimpleNameEndingWith("Controller")
        .`as`("Controllers classes should be suffixed Controller in class name")

    @ArchTest
    val `should be suffixed request` = classes()
        .that()
        .resideInAPackage("..request")
        .should()
        .haveSimpleNameEndingWith("Request")
        .`as`("Requests classes should be suffixed Request in class name")

    @ArchTest
    val `should be suffixed response` = classes()
        .that()
        .resideInAPackage("..response")
        .should()
        .haveSimpleNameEndingWith("Response")
        .`as`("Responses classes should be suffixed Response in class name")

    @ArchTest
    val `should be suffixed client` = classes()
        .that()
        .resideInAPackage("..client")
        .should()
        .haveSimpleNameEndingWith("Client")
        .`as`("Clients classes should be suffixed Client in class name")

    @ArchTest
    val `should be suffixed repository` = classes()
        .that()
        .resideInAPackage("..repository")
        .should()
        .haveSimpleNameEndingWith("Repository")
        .`as`("Repositories classes should be suffixed Repository in class name")

    @ArchTest
    val `should be suffixed entity` = classes()
        .that()
        .resideInAPackage("..entity")
        .should()
        .haveSimpleNameEndingWith("Entity")
        .`as`("Entities classes should be suffixed Entity in class name")

    @ArchTest
    val `should be suffixed adapter` = classes()
        .that()
        .resideInAPackage("..adapters.out")
        .should()
        .haveSimpleNameEndingWith("Adapter")
        .`as`("Adapters classes should be suffixed Adapter in class name")

    @ArchTest
    val `should be suffixed exception` = classes()
        .that()
        .resideInAPackage("..exceptions")
        .should()
        .haveSimpleNameEndingWith("Exception")
        .`as`("Exceptions classes should be suffixed Exception in class name")

    @ArchTest
    val `should be suffixed useCase` = classes()
        .that()
        .resideInAPackage("..useCase")
        .should()
        .haveSimpleNameEndingWith("UseCase")
        .`as`("UseCases classes should be suffixed UseCase in class name")

    @ArchTest
    val `should be suffixed config` = classes()
        .that()
        .resideInAPackage("..config")
        .should()
        .haveSimpleNameEndingWith("Config")
        .`as`("Configs classes should be suffixed Config in class name")

    @ArchTest
    val `should be suffixed input` = classes()
        .that()
        .resideInAPackage("..ports.in")
        .should()
        .haveSimpleNameEndingWith("InputPort")
        .`as`("InputPorts classes should be suffixed InputPort in class name")

    @ArchTest
    val `should be suffixed output` = classes()
        .that()
        .resideInAPackage("..ports.out")
        .should()
        .haveSimpleNameEndingWith("OutputPort")
        .`as`("OutputPorts classes should be suffixed OutputPort in class name")
}
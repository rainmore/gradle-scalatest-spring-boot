package com.example

import org.scalatest._
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, ComponentScan, Configuration}
import org.springframework.context.support.AbstractApplicationContext

trait Spec extends FunSpec
    with Matchers
    with GivenWhenThen
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with TestAppCtx


object TestAppCtx {
    def apply(): AbstractApplicationContext = new AnnotationConfigApplicationContext(
        getClass.getPackage.getName
    )
}

trait TestAppCtx {
    protected val ctx: ApplicationContext
}

@Configuration
@ComponentScan(Array("com.example"))
class TestConfig {}

class ApplicationSpec(val ctx: ApplicationContext) extends Spec {

    def this() = this(TestAppCtx())

    describe("Main") {
        it("should work") {
            true shouldBe true
        }
    }

}
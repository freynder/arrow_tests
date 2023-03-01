/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package my.kotlin.tests

import arrow.core.Either
import arrow.core.raise.*
import arrow.core.right

suspend fun main() {


    val result1 = Either.catch {
        "Test"
    }.also { println("result1: $it") }

    val result2 = either<Throwable, String> {
        "Test"
    }.also { println("result2: $it") }

    val result3 = effect<Throwable, String> {
        // We can use the Raise DSL here
        // catch runs an action and catches any exception with an error handler
        val result3_1 = catch({
            // Some action here
            println("Raise context for 3_1 action: $this")

            // If we call raise, it will be raised within the this@effect Raise context
            // raise(error("Raise in result3 catch action")), effectively short circuiting the effect block

            // If we throw an exception, it will be caught and handled by our error handling function (next lambda parameter in catch)
            error("test")

            // We can just return an action
            "Action result"


        }) { e ->
            println("Raise context for 3_1 error handler: $this")
            raise(error("Raise in 3_1 error handler"))
            "Encountered error: $e"
        }
        "Test result 3_1: $result3_1"
    }.toEither().also { println("result3: $it") }


    val result4 = eagerEffect<Throwable, String> {
        "Test"
    }.toEither().also { println("result4: $it") }

    val result5: Either<Throwable, String> = "Test".right().also { println("result5: $it") }


}

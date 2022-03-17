import java.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class SuspendFunctionTest {

    suspend fun helloWorld() {
        println("Hello : ${Date()} : ${Thread.currentThread().name}")
        delay(2_000)
        println("World : ${Date()} : ${Thread.currentThread().name}")
    }

    @Test
    fun testSuspendFunction() {
        runBlocking {
            helloWorld()
        }
    }

}
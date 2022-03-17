import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class ExecutorServiceTest {

    @Test
    fun testSingleThreadPool() {
        val executorService = Executors.newSingleThreadExecutor()
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
            println("Selesai memasukan runnable $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }

    @Test
    fun testFixThreadPool() {
        val executorService = Executors.newFixedThreadPool(3)
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
            println("Selesai memasukan runnable $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }

    @Test
    fun testCacheThreadPool() {
        val executorServices = Executors.newCachedThreadPool()
        repeat(100) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorServices.execute(runnable)
            println("Selesai memasukan runnable $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }
}
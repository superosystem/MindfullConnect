import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.concurrent.thread

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class ThreadTest {

    @Test
    fun testMainThread() {
        val threadName = Thread.currentThread().name
        println("Thread Name: $threadName")
    }

    @Test
    fun testNewThread() {
        thread(start = true) {
            println(Date())
            Thread.sleep(2000)
            println("Finish : ${Date()}")
        }

        println("Menunggu Selesai")
        Thread.sleep(3000)
        println("Selesai")
    }

    fun testMultipleThread() {
        val thread1 = Thread(Runnable {
            println(Date())
            Thread.sleep(2000)
            println("Finish Thread 1 : ${Thread.currentThread().name} : ${Date()}")
        })

        val thread2 = Thread(Runnable {
            println(Date())
            Thread.sleep(2000)
            println("Finish Thread 2 : ${Thread.currentThread().name} : ${Date()}")
        })

        thread1.start()
        thread2.start()

        println("Menunggu Selesai")
        Thread.sleep(3000)
        println("Selesai")
    }
}
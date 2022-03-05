import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class NestedTest {

    @Test
    fun test1(){

    }

    @Nested
    inner class MyNestedTest {

        @Test
        fun test1(){

        }

    }

}
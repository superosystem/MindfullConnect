import org.mockito.Mockito
import kotlin.test.assertEquals

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class MockTest {

    fun testMock() {
        val list: List<String> = Mockito.mock(List::class.java) as List<String>

        Mockito.`when`(list.get(0)).thenReturn("Gusryl")
        Mockito.`when`(list.get(1)).thenReturn("Mubarok")

        assertEquals("Gusryl", list.get(0))
        assertEquals("Gusryl", list.get(0))
        assertEquals("Mubarok", list.get(1))

        Mockito.verify(list, Mockito.times(2)).get(0)
        Mockito.verify(list).get(1)
    }

}
import org.junit.jupiter.api.*

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

@DisplayName("Test with TestInfo")
class InformationTest {

    @Test
    @Tags(value = [
        Tag("contoh1"),
        Tag("contoh2")
    ])
    @DisplayName("sample test one")
    fun sampleTest(testInfo: TestInfo){
        println(testInfo.displayName)
        println(testInfo.tags)
        println(testInfo.testClass)
        println(testInfo.testMethod)
    }
}
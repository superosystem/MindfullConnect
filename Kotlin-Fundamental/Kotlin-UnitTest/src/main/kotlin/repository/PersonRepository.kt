package repository

import model.Person

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

interface PersonRepository {
    fun selectById(id: String): Person?

    fun insert(person: Person)
}
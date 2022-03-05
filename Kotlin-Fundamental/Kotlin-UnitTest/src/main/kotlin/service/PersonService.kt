package service

import model.Person
import repository.PersonRepository
import java.util.*

/**
 * @author  Gusryl Mubarok
 * @email   gusrylmubarok@gmail.com
 */

class PersonService(private val personRepository: PersonRepository) {
    fun get(id: String): Person {
        if (id.isBlank()) {
            throw IllegalArgumentException("Person id is not valid")
        }

        val person = personRepository.selectById(id)
        if (person != null) {
            return person
        } else {
            throw Exception("Person not found")
        }
    }

    fun register(name: String): Person {
        if (name.isBlank()) {
            throw IllegalArgumentException("Person name is blank")
        }

        val id = UUID.randomUUID().toString()
        val person = Person(id, name)

        personRepository.insert(person)

        return person
    }
}
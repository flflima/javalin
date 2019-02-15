package dev.kotlin.javalin.dao

import dev.kotlin.javalin.model.User

class UserDao {

    val users = hashMapOf(
        1 to User("Joao", "joao@email.com", 1),
        2 to User("Maria", "maria@email.com", 2),
        3 to User("Ana", "ana@email.com", 3)
    )

    var lastId = users.size + 1

    fun saveUser(user: User) {
        users[lastId] = User(user.name, user.email, lastId++)
    }

    fun findUserById(id: Int): User? {
        return users[id]
    }

    fun findUserByEmail(email: String): User? {
        return users.values.find { it.email == email }
    }

    fun update(id: Int, user: User) {
        users[id] = User(user.name, user.email, id)
    }

    fun delete(id: Int) {
        users.remove(id)
    }

}
package dev.kotlin.javalin.api

import dev.kotlin.javalin.dao.UserDao
import dev.kotlin.javalin.model.User
import io.javalin.Javalin

fun main() {
    val userDao = UserDao()

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start(7000)

    app.routes {

        app.get("/users") { ctx ->
            ctx.json(userDao.users)
        }

        app.get("users/:id") { ctx ->
            ctx.json(userDao.findUserById(ctx.pathParam("id").toInt())!!)
        }

        app.get("users/email/:email") { ctx ->
            ctx.json(userDao.findUserByEmail(ctx.pathParam("email"))!!)
        }

        app.post("/users") { ctx ->
            val user = ctx.body<User>()
            userDao.saveUser(user)
            ctx.status(201)
        }

        app.patch("/users/:id") { ctx ->
            val user = ctx.body<User>()
            userDao.update(ctx.pathParam("id").toInt(), user)
            ctx.status(204)
        }

        app.delete("/users/:id") { ctx ->
            userDao.delete(ctx.pathParam("id").toInt())
            ctx.status(204)
        }
    }
}
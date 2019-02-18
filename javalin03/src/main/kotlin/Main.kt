package main

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import main.controllers.FoodItemController
import main.models.foodItems

// Main.kt
fun main() {
    JavalinApp(8000).init()
}

class JavalinApp(private val port: Int) {

    fun init(): Javalin {

        val app = Javalin.create().apply {
            port(port)
            exception(Exception::class.java) { e, _ -> e.printStackTrace() }
        }.start()

        app.routes {
            app.get("/") { ctx -> ctx.result("Hello World") }
        }

        val controller = FoodItemController(foodItems)

        app.routes {
            path("api") {
                path("food") {
                    path(":id") {
                        get { ctx -> controller.getFoodItem(ctx) }
                    }
                }
            }
        }

        return app
    }
}
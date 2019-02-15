import io.javalin.Javalin

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

        return app
    }
}
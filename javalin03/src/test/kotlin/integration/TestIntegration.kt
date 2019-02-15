package integration

import io.javalin.Javalin
import junit.framework.TestCase

class TestIntegration : TestCase() {

    private lateinit var app: Javalin
    private val url = "http://localhost:8000/"

    override fun setUp() {
        TODO("https://javalin.io/tutorials/integration-testing-kotlin")
//        app = JavalinApp(8000).init()
    }

    override fun tearDown() {
        app.stop()
    }

    fun testDummy() {
        assertEquals(1, 1)
    }
}
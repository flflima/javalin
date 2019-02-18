package integration

import io.javalin.Javalin
import junit.framework.TestCase
import main.JavalinApp
import main.models.FoodItem
import main.models.foodItems
import util.deserialize

class TestIntegration : TestCase() {

    private lateinit var app: Javalin
    private val url = "http://localhost:8000/"

    override fun setUp() {
        app = JavalinApp(8000).init()
    }

    override fun tearDown() {
        app.stop()
    }

//    fun testDummy() {
//        assertEquals(1, 1)
//    }

    fun testGetFoodItemExists() {
        val response = khttp.get(url = url + "api/food/0")
        val food = response.text.deserialize<FoodItem>()
        assertEquals(foodItems[0], food)
        assertEquals(200, response.statusCode)
    }

    fun testGetFoodItemNotExist() {
        val response = khttp.get(url = url + "api/food/-1")
        assertEquals(404, response.statusCode)
    }
}
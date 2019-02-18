package main.controllers

import io.javalin.Context
import main.models.FoodItem

class FoodItemController(private val data: Map<Int, FoodItem>) {

    fun getFoodItem(ctx: Context) {
        ctx.pathParam("id")?.toInt().let {
            data[it]?.let { item ->
                ctx.json(item)
                return
            }
            ctx.status(404)
        }
    }
}
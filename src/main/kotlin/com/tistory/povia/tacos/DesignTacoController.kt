package com.tistory.povia.tacos

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("design")
class DesignTacoController {
    @GetMapping
    fun showDesignForm(model: Model):String{
        val ingredients = arrayListOf<Ingredient>(
          Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
          Ingredient("COTO", "Corn Tortilla", Type.WRAP),
          Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
          Ingredient("CARN", "Carnitas", Type.PROTEIN),
          Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
          Ingredient("LETC", "Lettuce", Type.VEGGIES),
          Ingredient("CHED", "Cheddar", Type.CHEESE),
          Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
          Ingredient("SLSA", "Salsa", Type.SAUCE),
          Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        )

        val types:Array<Type> = Type.values()
        for(type in types){
            model.addAttribute(type.toString().toLowerCase(), ingredients.filter { it.type.equals(type) })
        }

        model.addAttribute("taco", Taco())
        return "design"
    }
}
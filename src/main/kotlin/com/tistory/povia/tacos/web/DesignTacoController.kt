package com.tistory.povia.tacos.web

import com.tistory.povia.tacos.Ingredient
import com.tistory.povia.tacos.Taco
import com.tistory.povia.tacos.Type
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("design")
class DesignTacoController{
    val log:Logger = LoggerFactory.getLogger(this.javaClass)
    @GetMapping
    fun showDesignForm(model: Model): String {
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

        val types: Array<Type> = Type.values()
        for (type in types) {
            model.addAttribute(type.toString().toLowerCase(), ingredients.filter { it.type.equals(type) })
        }

        model.addAttribute("taco", Taco())
        return "design"
    }
    @PostMapping
    fun processDesign(@Valid design: Taco, errors:Errors):String{
        log.info("Processing design: $design")

        if(errors.hasErrors()) return "design"

        return "redirect:/orders/current"
    }

}
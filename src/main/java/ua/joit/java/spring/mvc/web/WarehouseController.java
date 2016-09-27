package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.joit.java.spring.mvc.model.Ingredient;
import ua.joit.java.spring.mvc.model.Measures;
import ua.joit.java.spring.mvc.model.Warehouse;
import ua.joit.java.spring.mvc.service.IngredientService;
import ua.joit.java.spring.mvc.service.WarehouseService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseController {
    private WarehouseService warehouseService;
    private IngredientService ingredientService;


    @RequestMapping(value = "/admin/store", method = RequestMethod.GET) // show all
    public String showAllIngredients(Model model) {
        model.addAttribute("warehouses", warehouseService.findAll());
        return "admin/warehouse/ingredients";
    }


    @RequestMapping(value = "/admin/store", method = RequestMethod.POST) // add menu
    public String saveOrUpdateIngredient(@ModelAttribute("ingredientForm") @Validated Warehouse warehouse, BindingResult result){
        if(result.hasErrors()) {
            return "admin/warehouse/form";
        }

        String ingredientName = warehouse.getIngredient().getName();
        Ingredient ingr = ingredientService.getIngredientByName(ingredientName);
        warehouse.setIngredient(ingr);
        warehouseService.create(warehouse);

        return "redirect:/admin/store";
    }
    @RequestMapping(value = "/admin/store/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {

        Warehouse warehouse = new Warehouse();

        model.addAttribute("ingredientForm", warehouse);

        return "admin/warehouse/form";

    }

    @RequestMapping(value = "/admin/store/{id}/delete", method = RequestMethod.GET)
    public String deleteIngredient(@PathVariable("id") Long id){
        warehouseService.remove(warehouseService.getById(id));
        return "redirect:/admin/store";
    }

    @RequestMapping(value = "/admin/store/{id}/update", method = RequestMethod.GET)
    public String updateQuantity(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("measures", Measures.values());
        Warehouse warehouse = warehouseService.getById(id);
        modelMap.addAttribute("quantityForm", warehouse);
        return "admin/warehouse/quantityForm";
    }

    @ModelAttribute("ingredients")
    public List<String> getIngredientNames() {
        List<String> ingredients = new ArrayList<>();
        for (Ingredient ingr : ingredientService.getIngredients()) {
            ingredients.add(ingr.getName());
        }
        return ingredients;
    }

    @RequestMapping(value = "/admin/store/find", method = RequestMethod.GET)
    public String finfByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name==null || name=="") {
            return "redirect:/admin/store";
        } else {
            Warehouse warehouse = warehouseService.findByName(name);
            modelMap.addAttribute("warehouse", warehouse);
            return "/admin/warehouse/findByName";
        }
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Autowired
    public void setWarehouseService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
}
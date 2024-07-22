package pizzashop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import ingredients.Food;
import ingredients.FoodSet;
import ingredients.Pizza;
import ingredients.PizzaBase;
import pizzashop.PizzaMenu;
import pizzashop.PizzaShop;

public class PizzaShopTest {

    private PizzaShop pizzaShop;

    //Test #1
    @Test
    public void testBase(){
        pizzaShop = new PizzaShop();
        // Test pizza with base
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that base is correct
        assertEquals("thin crust", pizza.getBase().getName());
    }

    //Test #2
    @Test
    public void testWrongBase(){
        pizzaShop = new PizzaShop();
        // Test pizza with base
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that base is correct
        assertEquals(pizza.getBase().getName(), "deep crust");
    }

    //Test #3
    @Test
    public void testSize(){
        pizzaShop = new PizzaShop();
        //Test pizza with size
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that size is correct
        assertEquals("large", pizza.getBase().getSizeString());
    }

    //Test #4
    @Test
    public void testWrongSize(){
        pizzaShop = new PizzaShop();
        //Test pizza with size
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that size is correct
        assertEquals(pizza.getBase().getSizeString(), "small");
    }

    //Test #5
    @Test
    public void testName(){
        pizzaShop = new PizzaShop();
        //Test pizza with name
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that name is correct
        assertEquals("Margherita Pizza", pizza.getName());
    }

    //Test #6
    @Test
    public void testWrongName(){
        pizzaShop = new PizzaShop();
        //Test pizza with name
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that name is correct
        assertEquals(pizza.getName(), "Chicken and Prawn Pizza");
    }

    //Test #7
    @Test
    public void testPrice() {
        pizzaShop = new PizzaShop();
        //Test pizza with price
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that price is correct
        assertEquals(pizza.getPrice(),10.0, 10.0);
    }

    //Test #8
    @Test
    public void testWrongPrice() {
        pizzaShop = new PizzaShop();
        //Test pizza with price
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        Pizza pizza = new Pizza("Margherita Pizza", 10.0, new FoodSet(), initialBase);

        //Test that price is correct

    }

    //Test #9
    @Test
    public void testAddTopping() {
        // Test pizza
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        FoodSet toppings = new FoodSet();
        Food tomato = new Food("tomato", 1.0);
        toppings.add(tomato);
        Pizza pizza = new Pizza("Margherita", 10.0, toppings, initialBase);

        // Test adding a topping
        assertTrue(pizza.getToppings().contains(tomato));

    }

    //Test #10
    @Test
    public void testRemoveTopping() {
        // Test pizza
        PizzaBase initialBase = new PizzaBase("thin crust", 3.0, "large");
        FoodSet toppings = new FoodSet();
        Food tomato = new Food("tomato", 1.0);
        toppings.add(tomato);
        Pizza pizza = new Pizza("Margherita", 10.0, toppings, initialBase);
 
        toppings.remove("tomato");
    
        // Assert that the topping is removed successfully
        assertTrue(pizza.getToppings().contains(tomato));
    
        }

    //Test #11
    @Test
    public void testAddingToMenu() {
        PizzaMenu menu = new PizzaMenu();
        PizzaBase initialBase = new PizzaBase("Thin Crust", 10, "small");
        FoodSet toppings = new FoodSet();
        Pizza pizza = new Pizza("Margherita", 10.0, toppings, initialBase);
        boolean isAdded = menu.add(pizza);
        // Assert that pizza is added successfully
        assertTrue(isAdded);        
        }

    //Test #12
    @Test
    public void testGetPizzaIndex(){
        PizzaMenu menu = new PizzaMenu();
        PizzaBase initialBase = new PizzaBase("Thin Crust", 10, "medium");
        FoodSet toppings = new FoodSet();
        Pizza pizza1 = new Pizza("Margherita", 10.0, toppings, initialBase);
        Pizza pizza2 = new Pizza("Hawaiian", 10.0, toppings, initialBase);
        menu.add(pizza1);
        menu.add(pizza2);
    
        Pizza retrievedPizza = menu.get(1);

        assertEquals("Hawaiian", retrievedPizza.getName());
    }

    //Test #13
    @Test
    public void testPrintMenu() {
        PizzaMenu menu = new PizzaMenu();
        PizzaBase initialBase1 = new PizzaBase("Thin Crust", 10.0, "medium");
        PizzaBase intitialBase2 = new PizzaBase("Thick Crust", 10.0, "medium");
        FoodSet toppings = new FoodSet();
        toppings.add(new Food("Tomato", 1.0));
        toppings.add(new Food("Ham", 1.5));
        Pizza pizza1 = new Pizza("Margherita", 10.0, toppings, initialBase1);
        Pizza pizza2 = new Pizza("Hawaiian", 10.0, toppings, intitialBase2);
        menu.add(pizza1);
        menu.add(pizza2);

        String expectedOutput = "Menu: \n" +
                            "Margherita, medium Thin Crust $10.00: \n \tTomato, Ham\n" +
                            "Hawaiian, medium Thick Crust $10.00: \n \tTomato, Ham\n";

    assertEquals(expectedOutput, menu.toString());
}

    //Test #14
    @Test
    public void testMenuIsEmpty() {
        PizzaMenu testMenu = new PizzaMenu();

        // Check menu is initially empty
        assertEquals(0, testMenu.count()); // Ensure menu is initially empty

        // Attempt to get a pizza from menu
        Pizza retrievedPizza = testMenu.get("Margherita");

        assertNull(retrievedPizza); // Ensure retrieving from empty menu returns null
}

    //Test #15
    @Test
    public void testInitializationOfPizza() {
        PizzaBase testBase = new PizzaBase("Thick Crust", 10.0, "medium");
        FoodSet toppings = new FoodSet();
        Food cheese = new Food("Cheese", 5);
        toppings.add(cheese);

        Pizza pizza = new Pizza("Margherita Pizza", 10, toppings, testBase);

        assertEquals("Margherita Pizza", pizza.getName());
        assertEquals(10.0, pizza.getPrice(), 0.001);
        assertEquals("Thick Crust", pizza.getBase().getName());
        assertEquals(12, pizza.getBase().getDiameter());
        assertEquals(1, pizza.getToppings().count());
        assertEquals("Cheese", pizza.getToppings().get(0).getName());
    }

    //Test #16
    @Test
    public void testConvertToDiameter() {
        //Convert diameters to correct sizes
        assertEquals(14, PizzaBase.convertToDiameter("large"));
        assertEquals(12, PizzaBase.convertToDiameter("medium"));
        assertEquals(10, PizzaBase.convertToDiameter("small"));
    }

    //Test #17
    @Test
    public void testIncorrectConvertToDiameter(){
        //Convert incorrect diamater to size
        assertEquals(0, PizzaBase.convertToDiameter("extra large"));
    }

    //Test #18
    @Test
    public void testPizzaBaseEquals(){
        PizzaBase testBase1 = new PizzaBase("Thick crust", 10.0, "large");
        PizzaBase testBase2 = new PizzaBase("Thick crust", 10.0, "large");

        assertTrue(testBase1.equals(testBase2));
    }

    //Test #19
    @Test
    public void testIncorrectPizzaBaseEquals(){
        PizzaBase testBase1 = new PizzaBase("Thick crust", 10.0, "large");
        PizzaBase testBase2 = new PizzaBase("Thin crust", 10.0, "large");

        assertFalse(testBase1.equals(testBase2));
    }

    //Test #20
    @Test
    public void testFoodEquals(){
        Food testFood1 = new Food("Pizza", 10.0);
        Food testFood2 = new Food("Pizza", 10.0);

        assertTrue(testFood1.equals(testFood2));
    }

    //Test #21
    @Test
    public void testIncorrectFoodEquals(){
        Food testFood1 = new Food("Pizza", 10.0);
        Food testFood2 = new Food("Cheese", 10.0);

        assertFalse(testFood1.equals(testFood2));
    }

    //Test #22
    @Test
    public void testFoodSetAdd(){
        Food pizza = new Food("Pizza", 10.0);
        FoodSet foodSet = new FoodSet();

        assertTrue(foodSet.add(pizza));
    }

    //Test #23
    @Test
    public void testFoodSetRemove(){
        Food pizza = new Food("Pizza", 10.0);
        FoodSet foodSet = new FoodSet();
        foodSet.add(pizza);

        assertTrue(foodSet.remove("Pizza"));
    }

    //Test #24
    @Test
    public void testFoodToString(){
        Food pizza = new Food("Pizza", 10.0);

        assertEquals("Pizza $10.00",pizza.toString());
    }

    //Test #25
    @Test
    public void testPizzaToString(){
        Food pizza = new Food("Pizza", 10.0);
        FoodSet toppings = new FoodSet();
        toppings.add(pizza);
        PizzaBase base = new PizzaBase("Thick crust", 5.0, "medium");

        Pizza testPizza = new Pizza("Test pizza", 10.0, toppings, base);

        assertEquals("Test pizza, medium Thick crust $10.00: \n \tPizza", testPizza.toString());
    }

    //Test #26
    @Test
    public void testPizzaBaseToString(){
        PizzaBase testBase = new PizzaBase("Thick crust", 5.0, "medium");

        assertEquals("medium Thick crust pizza base", testBase.toString());
    }

    //Test #27
    @Test
    public void testPizzaSetBase(){

        PizzaBase testBase = new PizzaBase("Thick Crust", 6.0, "medium");
        FoodSet toppings = new FoodSet();
        Food tomato = new Food("tomato", 1.0);
        toppings.add(tomato);
        Pizza pizzaInstance = new Pizza("Large Pizza", 10.00, toppings, testBase);
        pizzaInstance.setBase(testBase);
        
        assertEquals(testBase, pizzaInstance.getBase());
    }

    //Test #28
    @Test
    public void testPizzaBaseConstructorAndGetters() {
        PizzaBase base = new PizzaBase("Thick Crust", 6.0, "medium");

        assertEquals("Thick Crust", base.getName());
        assertEquals(6.0, base.getPrice(), 0.001);
        assertEquals("medium", base.getSizeString());
        assertEquals(12, base.getDiameter());
    }

    //Test #29
    @Test
    public void testPizzaConstructorAndGetters(){
        PizzaBase testBase = new PizzaBase("Thick Crust", 6.0, "medium");
        FoodSet toppings = new FoodSet();
        Pizza pizzaInstance = new Pizza("Large Pizza", 10.00, toppings, testBase);
        pizzaInstance.setBase(testBase);

        assertEquals("Large Pizza", pizzaInstance.getName());
        assertEquals(10.0, pizzaInstance.getPrice(), 0.001);
        assertEquals(testBase, pizzaInstance.getBase());
    }

    //Test #30
    @Test
    public void testFoodConstructorAndGetters() {
        Food food = new Food("Pizza", 10.0);
        
        assertEquals("Pizza", food.getName());
        assertEquals(10.0, food.getPrice(), 0.001);
    }


}

package com.cg.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTest {
private Menu f;
@BeforeEach
public void preConfig() {
f = new Menu();
f.setId("1");
f.setName("Biryani");
f.setCategory("Non-Veg");
f.setPrice(399);

}
@Test
public void FavTest() {
	Menu a = Mockito.mock(Menu.class);
assertNotNull(a);
}
@Test
public void FavModelTestSuccess() {
assertEquals(f.getId(),"1");
assertEquals(f.getName(),"Biryani");
assertEquals(f.getCategory(),"Non-Veg");
assertEquals(f.getPrice(),399);

}
@Test
public void FavModelTestFailure() {
assertNotEquals(f.getId(),"");
assertNotEquals(f.getName(),"");
assertNotEquals(f.getPrice(),"");
assertNotEquals(f.getPrice(),"");

}

}


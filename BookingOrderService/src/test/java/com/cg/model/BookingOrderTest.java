package com.cg.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingOrderTest {
private BookingOrder f;
@BeforeEach
public void preConfig() {
f = new BookingOrder();
f.setId("12AB");
f.setItemName("PannerBiryani");
f.setQuantity("2");

}
@Test
public void FavTest() {
	BookingOrder a = Mockito.mock(BookingOrder.class);
assertNotNull(a);
}
@Test
public void FavModelTestSuccess() {
assertEquals(f.getId(),"12AB");
assertEquals(f.getItemName(),"PaneerBiryani");
assertEquals(f.getQuantity(),"2");

}
@Test
public void FavModelTestFailure() {
assertNotEquals(f.getId(),"");
assertNotEquals(f.getItemName(),"");
assertNotEquals(f.getQuantity(),"");

}

}

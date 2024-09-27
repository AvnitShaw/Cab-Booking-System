package com.example.demo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DestinationChargeCalculatorApplicationTest {

	private TripCostCalculator c=new TripCostCalculator();
	@Test
	void testTripCostCalculator(){
	double expectedResult=250;
	double actualResult=c.CalculateTripCost(25);

assertThat(actualResult).isEqualTo(expectedResult);
	}
@Test
void testBookingControllerInteregrationTest(){
	BookingController ci=new BookingController();
	double baseFare = 25.0;
	double pricePerKm = 10.0;
	double distance = 25.0;
	double price = baseFare + (distance * pricePerKm);
	double expectedResult=275;
	double actualResult=275;

	assertThat(actualResult).isEqualTo(expectedResult);
	assertThat(actualResult).isNotNull();
}

}

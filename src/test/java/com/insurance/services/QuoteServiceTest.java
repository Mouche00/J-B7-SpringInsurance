//package com.insurance.services;
//
//import com.insurance.factories.InsuranceCalculatorFactory;
//import com.insurance.models.HealthInsurance;
//import com.insurance.models.HomeInsurance;
//import com.insurance.models.User;
//import com.insurance.models.VehicleInsurance;
//import com.insurance.strategies.implementations.HealthInsuranceCalculator;
//import com.insurance.strategies.implementations.HomeInsuranceCalculator;
//import com.insurance.strategies.implementations.VehicleInsuranceCalculator;
//import com.insurance.utils.enums.SecurityType;
//import com.insurance.utils.enums.UsageType;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class QuoteServiceTest {
//    @Mock
//    private InsuranceCalculatorFactory calculatorFactory;
//
//    @Mock
//    private HealthInsuranceCalculator healthInsuranceCalculator;
//
//    @Mock
//    private HomeInsuranceCalculator homeInsuranceCalculator;
//
//    @Mock
//    private VehicleInsuranceCalculator vehicleInsuranceCalculator;
//
//    @InjectMocks
//    private QuoteService quoteService;
//
//    @BeforeEach
//    public void setUp() {
//        User youngUser = new User();
//        youngUser.setAge(20);
//
//        VehicleInsurance vehicleInsurance = new VehicleInsurance();
//        vehicleInsurance.setUser(youngUser);
//        vehicleInsurance.setAssetType("luxury");
//        vehicleInsurance.setRiskFactor(true);
//        vehicleInsurance.setUsageType(UsageType.PROFESSIONAL);
//
//        HomeInsurance homeInsurance = new HomeInsurance();
//        homeInsurance.setAssetType("house");
//        homeInsurance.setAssetValue(300_000);
//        homeInsurance.setRiskFactor(true);
//        homeInsurance.setSecurityType(SecurityType.NONE);
//    }
//
//    @Test
//    public void calculateHealthInsurance_shouldReturnHealthInsuranceQuote(){
//        User oldUser = new User();
//        oldUser.setAge(70);
//
//        HealthInsurance healthInsurance = new HealthInsurance();
//        healthInsurance.setUser(oldUser);
//        healthInsurance.setAssetType("premium");
//        healthInsurance.setRiskFactor(true);
//
//        double expectedQuote = 345.0;
//        doReturn(healthInsuranceCalculator).when(calculatorFactory).getStrategy("HealthInsurance");
//        when(healthInsuranceCalculator.calculate(healthInsurance)).thenReturn(expectedQuote);
//
//        double quote = quoteService.calculateQuote(healthInsurance);
//
//        assertEquals(quote, expectedQuote);
//        verify(calculatorFactory.getStrategy("HealthInsurance"), times(1));
//        verify(healthInsuranceCalculator.calculate(healthInsurance), times(1));
//    }
//
//}

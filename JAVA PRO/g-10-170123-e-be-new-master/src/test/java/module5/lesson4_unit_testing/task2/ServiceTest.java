package module5.lesson4_unit_testing.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private Service service;
    OuterService outerService;

    @BeforeEach
    public void init() {
        service = new Service();
        outerService = Mockito.mock(OuterService.class);
        service.setOuterService(outerService);
    }

    @Test
    public void checkCorrectValue() {
        int expected = 7;
        int actual = service.calculate(0);
        assertEquals(expected, actual);
    }

    @Test
    public void checkCorrectValueInElseBranch() {
        Mockito.when(outerService.getNumber()).thenReturn(5);
        int expected = 8;
        int actual = service.calculate(3);
        assertEquals(expected, actual);
    }
}
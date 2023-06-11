package ht.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ht.backend.enums.ShipmentStatus;
import ht.backend.model.ShipmentTracking;
import ht.backend.repository.ShipmentTrackingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ShipmentTrackingServiceTest {

    private ShipmentTrackingService shipmentTrackingService;

    @Mock
    private ShipmentTrackingRepository shipmentTrackingRepository;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        shipmentTrackingService = new ShipmentTrackingService(shipmentTrackingRepository, objectMapper);
    }

    @Test
    void testGetAllShipmentTracking() {
        // Arrange
        List<ShipmentTracking> expectedShipmentTrackingList = new ArrayList<>();
        when(shipmentTrackingRepository.findAll()).thenReturn(expectedShipmentTrackingList);

        // Act
        List<ShipmentTracking> result = shipmentTrackingService.getAllShipmentTracking();

        // Assert
        assertEquals(expectedShipmentTrackingList, result);
        verify(shipmentTrackingRepository, times(1)).findAll();
    }

    @Test
    void testAddNewShipmentTracking() {
        // Arrange
        ShipmentTracking shipmentTracking = new ShipmentTracking();
        when(shipmentTrackingRepository.save(shipmentTracking)).thenReturn(shipmentTracking);

        // Act
        ShipmentTracking result = shipmentTrackingService.addNewShipmentTracking(shipmentTracking);

        // Assert
        assertEquals(shipmentTracking, result);
        verify(shipmentTrackingRepository, times(1)).save(shipmentTracking);
    }

    @Test
    void testGetShipmentTrackingById_WhenIdExists() {
        // Arrange
        Long id = 1L;
        ShipmentTracking expectedShipmentTracking = new ShipmentTracking();
        Optional<ShipmentTracking> optionalShipmentTracking = Optional.of(expectedShipmentTracking);
        when(shipmentTrackingRepository.findById(id)).thenReturn(optionalShipmentTracking);

        // Act
        ShipmentTracking result = shipmentTrackingService.getShipmentTrackingById(id);

        // Assert
        assertEquals(expectedShipmentTracking, result);
        verify(shipmentTrackingRepository, times(1)).findById(id);
    }

    @Test
    void testGetShipmentTrackingById_WhenIdDoesNotExist() {
        // Arrange
        Long id = 1L;
        Optional<ShipmentTracking> optionalShipmentTracking = Optional.empty();
        when(shipmentTrackingRepository.findById(id)).thenReturn(optionalShipmentTracking);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> shipmentTrackingService.getShipmentTrackingById(id));
        verify(shipmentTrackingRepository, times(1)).findById(id);
    }

    // Additional unit tests for the other methods in the service...

    @Test
    void testGetAllShipmentTrackingByStatus_WhenStatusExists() {
        // Arrange
        ShipmentStatus shipmentStatus = ShipmentStatus.SHIPPED;
        List<ShipmentTracking> expectedList = new ArrayList<>();
        expectedList.add(new ShipmentTracking());
        when(shipmentTrackingRepository.findAllByStatus(shipmentStatus)).thenReturn(Optional.of(expectedList));

        // Act
        List<ShipmentTracking> result = shipmentTrackingService.getAllShipmentTrackingByStatus(shipmentStatus);

        // Assert
        assertEquals(expectedList, result);
        verify(shipmentTrackingRepository, times(1)).findAllByStatus(shipmentStatus);
    }

    @Test
    void testGetAllShipmentTrackingByStatus_WhenStatusDoesNotExist() {
        // Arrange
        ShipmentStatus shipmentStatus = ShipmentStatus.SHIPPED;
        when(shipmentTrackingRepository.findAllByStatus(shipmentStatus)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> shipmentTrackingService.getAllShipmentTrackingByStatus(shipmentStatus));
        verify(shipmentTrackingRepository, times(1)).findAllByStatus(shipmentStatus);
    }

}


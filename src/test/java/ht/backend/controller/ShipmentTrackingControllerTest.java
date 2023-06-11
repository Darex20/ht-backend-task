package ht.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ht.backend.enums.ErrorSeverity;
import ht.backend.model.CustomError;
import ht.backend.model.ShipmentTracking;
import ht.backend.service.ShipmentTrackingService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ShipmentTrackingControllerTest {

    private ShipmentTrackingController shipmentTrackingController;

    @Mock
    private ShipmentTrackingService shipmentTrackingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        shipmentTrackingController = new ShipmentTrackingController(shipmentTrackingService);
    }

    @Test
    void testGetShipmentTracking() {
        // Arrange
        List<ShipmentTracking> expectedShipmentTrackingList = new ArrayList<>();
        when(shipmentTrackingService.getAllShipmentTracking()).thenReturn(expectedShipmentTrackingList);

        // Act
        List<ShipmentTracking> result = shipmentTrackingController.getShipmentTracking();

        // Assert
        assertEquals(expectedShipmentTrackingList, result);
        verify(shipmentTrackingService, times(1)).getAllShipmentTracking();
    }

    @Test
    void testGetShipmentTrackingById_WhenIdExists() {
        // Arrange
        Long id = 1L;
        ShipmentTracking expectedShipmentTracking = new ShipmentTracking();
        when(shipmentTrackingService.getShipmentTrackingById(id)).thenReturn(expectedShipmentTracking);

        // Act
        ResponseEntity<?> responseEntity = shipmentTrackingController.getShipmentTrackingById(id);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedShipmentTracking, responseEntity.getBody());
        verify(shipmentTrackingService, times(1)).getShipmentTrackingById(id);
    }

    @Test
    void testGetShipmentTrackingById_WhenIdDoesNotExist() {
        // Arrange
        Long id = 1L;
        EntityNotFoundException exception = new EntityNotFoundException("ShipmentTracking not found");
        when(shipmentTrackingService.getShipmentTrackingById(id)).thenThrow(exception);

        // Act
        ResponseEntity<?> responseEntity = shipmentTrackingController.getShipmentTrackingById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof CustomError);
        assertEquals(ErrorSeverity.FATAL, ((CustomError) responseEntity.getBody()).getSeverity());
        verify(shipmentTrackingService, times(1)).getShipmentTrackingById(id);
    }

    // Additional unit tests for the other methods in the controller...

    @Test
    void testAddShipmentTracking() {
        // Arrange
        ShipmentTracking shipmentTracking = new ShipmentTracking();
        ShipmentTracking savedShipmentTracking = new ShipmentTracking();
        when(shipmentTrackingService.addNewShipmentTracking(shipmentTracking)).thenReturn(savedShipmentTracking);

        // Act
        ResponseEntity<ShipmentTracking> responseEntity = shipmentTrackingController.addShipmentTracking(shipmentTracking);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedShipmentTracking, responseEntity.getBody());
        assertEquals(URI.create("/" + savedShipmentTracking.getId()), responseEntity.getHeaders().getLocation());
        verify(shipmentTrackingService, times(1)).addNewShipmentTracking(shipmentTracking);
    }

    @Test
    void testUpdateShipment_WhenSuccessful() throws JsonPatchException, JsonProcessingException {
        // Arrange
        Long id = 1L;
        ShipmentTracking shipmentTracking = new ShipmentTracking();
        JsonMergePatch patch = mock(JsonMergePatch.class); // Mocking the JsonMergePatch object
        ShipmentTracking patchedShipmentTracking = new ShipmentTracking();
        when(shipmentTrackingService.getShipmentTrackingById(id)).thenReturn(shipmentTracking);
        when(shipmentTrackingService.applyPatchToShipmentTracking(any(), eq(shipmentTracking))).thenReturn(patchedShipmentTracking);

        // Act
        ResponseEntity<?> responseEntity = shipmentTrackingController.updateShipment(id, patch);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(patchedShipmentTracking, responseEntity.getBody());
        verify(shipmentTrackingService, times(1)).getShipmentTrackingById(id);
        verify(shipmentTrackingService, times(1)).applyPatchToShipmentTracking(any(), eq(shipmentTracking));
        verify(shipmentTrackingService, times(1)).updateShipmentTracking(patchedShipmentTracking);
    }

    @Test
    void testUpdateShipment_WhenJsonPatchExceptionOccurs() throws JsonPatchException, JsonProcessingException {
        // Arrange
        Long id = 1L;
        ShipmentTracking shipmentTracking = new ShipmentTracking();
        JsonMergePatch patch = mock(JsonMergePatch.class); // Mocking the JsonMergePatch object
        JsonPatchException exception = new JsonPatchException("Error applying patch");
        when(shipmentTrackingService.getShipmentTrackingById(id)).thenReturn(shipmentTracking);
        doThrow(exception).when(shipmentTrackingService).applyPatchToShipmentTracking(any(), eq(shipmentTracking));

        // Act
        ResponseEntity<?> responseEntity = shipmentTrackingController.updateShipment(id, patch);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof CustomError);
        assertEquals(ErrorSeverity.FATAL, ((CustomError) responseEntity.getBody()).getSeverity());
        verify(shipmentTrackingService, times(1)).getShipmentTrackingById(id);
        verify(shipmentTrackingService, times(1)).applyPatchToShipmentTracking(any(), eq(shipmentTracking));
    }

    @Test
    void testUpdateShipment_WhenEntityNotFoundExceptionOccurs() throws JsonPatchException, JsonProcessingException {
        // Arrange
        Long id = 1L;
        ShipmentTracking shipmentTracking = new ShipmentTracking();
        JsonMergePatch patch = mock(JsonMergePatch.class); // Mocking the JsonMergePatch object
        EntityNotFoundException exception = new EntityNotFoundException("ShipmentTracking not found");
        when(shipmentTrackingService.getShipmentTrackingById(id)).thenThrow(exception);

        // Act
        ResponseEntity<?> responseEntity = shipmentTrackingController.updateShipment(id, patch);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof CustomError);
        assertEquals(ErrorSeverity.FATAL, ((CustomError) responseEntity.getBody()).getSeverity());
        verify(shipmentTrackingService, times(1)).getShipmentTrackingById(id);
        // Verify that the applyPatchToShipmentTracking method is not invoked
        verify(shipmentTrackingService, never()).applyPatchToShipmentTracking(any(), any());
    }
}
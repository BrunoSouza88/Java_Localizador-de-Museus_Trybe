package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * javadoc.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CollectionTypeService collectionTypeService;

  public CollectionTypeControllerTest() {
  }

  @DisplayName("Test if countByCollectionTypes returns OK status when called with a single collection type.")
  @Test
  public void testCountSingleCollectionTypeReturnsOkStatus() throws Exception {
    Mockito.when(collectionTypeService.countByCollectionTypes(Mockito.any()))
            .thenReturn(new CollectionTypeCount(new String[]{"hist"}, 492));

    mockMvc.perform(
                    MockMvcRequestBuilders.get("/collections/count/hist"))
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @DisplayName("Test if countByCollectionTypes returns NOT_FOUND status when called with a single collection type and no results are found.")
  @Test
  public void testCountSingleCollectionTypeReturnsNotFoundStatus() throws Exception {
    Mockito.when(collectionTypeService.countByCollectionTypes(Mockito.any()))
            .thenReturn(new CollectionTypeCount(new String[]{"hist"}, 0));

    mockMvc.perform(
                    MockMvcRequestBuilders.get("/collections/count/hist"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @DisplayName("Test if countByCollectionTypes returns OK status when called with multiple collection types.")
  @Test
  public void testCountMultipleCollectionTypesReturnsOkStatus() throws Exception {
    Mockito.when(collectionTypeService.countByCollectionTypes(Mockito.any()))
            .thenReturn(new CollectionTypeCount(new String[]{"hist", "arte"}, 492));

    mockMvc.perform(
                    MockMvcRequestBuilders.get("/collections/count/hist,arte"))
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @DisplayName("Test if countByCollectionTypes returns NOT_FOUND status when called with multiple collection types and no results are found.")
  @Test
  public void testCountMultipleCollectionTypesReturnsNotFoundStatus() throws Exception {
    Mockito.when(collectionTypeService.countByCollectionTypes(Mockito.any()))
            .thenReturn(new CollectionTypeCount(new String[]{"hist", "arte"}, 0));

    mockMvc.perform(
                    MockMvcRequestBuilders.get("/collections/count/hist,arte"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

}
